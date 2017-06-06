package com.tiancaibao.service.user.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.user.UserChannels;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.user.IUserChannelService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.user.biz.IUserBizRegisterService;
import com.tiancaibao.utils.BCrypt;
import com.tiancaibao.utils.MD5Util;
import com.tiancaibao.validate.Validate;

@Service("userRegisterService")
public class UserBizRegisterServiceImpl implements IUserBizRegisterService {
	@Resource
	private IUserService userService;

	@Resource
	private IUserChannelService channelService;
	private static final Logger log = LoggerFactory.getLogger(UserBizRegisterServiceImpl.class);

	@Resource
	private IMqMessageService mqMessageSender;

	@Override
	public String postRegist(String is_encryption, String agent_num, String ip, String phone, String password,
			String invited_by_phone, String phone_code, String channel_name) {

		JSONObject json = new JSONObject();

		Users users = new Users();

		// 基础验证
		String validates = Validate.validates(phone, password, phone_code);

		if (validates != null) {
			return validates;
		}

		// 验证手机号在数据库中是否存在
		Long selectUserIdByPhone = userService.selectUserIdByPhone(phone);
		if (selectUserIdByPhone != null) {// 如存在返回错误
			json.put("success", false);
			json.put("error", "手机号已注册");
			log.info("用户使用手机号: " + phone + "注册失败：手机号已注册");
			return json.toString();
		}
		users.setPhone(phone);// 添加手机号
		// 推荐人处理
		if (invited_by_phone != null && !invited_by_phone.equals("")) {
			Long invited_by = userService.selectUserIdByPhone(invited_by_phone);
			if (invited_by == null || invited_by.equals("")) {
				json.put("success", false);
				json.put("error", "邀请人不存在");
				log.info("用户使用手机号: " + phone + "注册失败：邀请人不存在");
				return json.toString();
			}
			users.setInvitedByUserId(invited_by);// 添加邀请人ID
		} else {
			users.setInvitedByUserId(Long.parseLong("0"));// 没有填写默认为0
		}
		// 渠道数据写入
		if (channel_name != null && !channel_name.equals("")) {
			UserChannels selectChannelByName = channelService.selectChannelByName(channel_name);
			if (selectChannelByName != null) {
				users.setChannelId(selectChannelByName.getId());
			} else {
				users.setChannelId(0);
			}
		} else {
			users.setChannelId(0);
		}
		// 密码加密处理
		if (is_encryption.equals("is_false")) {
			users.setPassword(BCrypt.hashpw(MD5Util.md5(password), BCrypt.gensalt()));
		} else {
			users.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		}
		// 写入用户表
		users.setTalentValue(Long.parseLong("60"));
		users.setOneThousandAt(new Date());
		users.setTwoThousandAt(new Date());
		users.setFiveThousandAt(new Date());
		users.setAgentNum(agent_num);
		users.setIp(ip == null ? "" : ip);
		userService.saveToUsers(users);
		// 生成token
		if (users.getId() != null) {
			users.setRememberToken(MD5Util.md5(users.getId() + users.getPhone() + Math.random() * 10000));
			userService.updateUsersById(users);
		} else {
			json.put("success", false);
			json.put("error", "注册用户失败，请联系客服。");
			log.info("用户使用手机号: " + phone + "注册失败,未成功写入数据库");
			return json.toString();
		}

		/**
		 * 做消息队列业务 发送加息券,推送消息等
		 * 
		 * 
		 * 
		 */
		// 发送注册成功信息
		JSONObject msg = new JSONObject();
		msg.put("phone", phone);
		msg.put("userId", users.getId());
		msg.put("type", 1);
		msg.put("serviceName", "registerService");
		mqMessageSender.sendMessage("smsQueue", msg.toString());
		// 变更天财值
		JSONObject talentValue = new JSONObject();
		talentValue.put("userId", users.getId());
		talentValue.put("sourceId", 2);
		talentValue.put("oldTalentValue", 0);
		talentValue.put("type", 1);
		talentValue.put("serviceName", "registerService");
		
		mqMessageSender.sendMessage("talentValuequeue", talentValue.toString());
		// 红包发放

		json.put("success", true);
		return json.toString();
	}

	@Override
	public String verifyPhone(String phone) {
		JSONObject json = new JSONObject();
		try {
			// 基础验证
			Validate.validatePhone(phone);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("msg", e.getMessage());

		}
		// 验证手机号在数据库中是否存在
		Long selectUserIdByPhone = userService.selectUserIdByPhone(phone);
		if (selectUserIdByPhone != null) {// 如存在返回错误
			json.put("success", false);
			json.put("error", "手机号已注册");
			json.put("msg", "手机已注册");
			log.info("用户使用手机号: " + phone + "注册失败：手机号已注册");
			return json.toString();
		}
		json.put("success", true);
		json.put("msg", "手机号可以注册");
		json.put("error", "手机可以注册");

		return json.toString();
	}

}
