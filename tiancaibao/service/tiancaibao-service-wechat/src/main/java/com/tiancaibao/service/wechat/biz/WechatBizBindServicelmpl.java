package com.tiancaibao.service.wechat.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.user.UserLoginLogs;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.user.IUserLoginLogsService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.wechat.biz.IWechatBizService;
import com.tiancaibao.utils.BCrypt;
import com.tiancaibao.utils.JedisUtil;
import com.tiancaibao.utils.MD5Util;
import com.tiancaibao.utils.ValidateUtil;
import com.tiancaibao.validate.Validate;

@Service("wechatBizBindService")
public class WechatBizBindServicelmpl implements IWechatBizService {

	@Resource
	IUserService userService;

	@Resource
	IUserLoginLogsService loginLogService;
	/**
	 * 用户微信绑定提交处理
	 */
	@Override
	public String wechatBind(String phone, String open_id, String password, String is_encryption,
				String agent_num, String source, String system) {
		
		JSONObject json = new JSONObject();
		Users user = userService.selectUserByPhone(phone);
		
		if (user == null || user.equals("")) {
			json.put("success", false);
			json.put("error", "用户不存在");
			return json.toString();
		}
		//初步验证手机号密码 
		try {
			Validate.validatePhone(phone);
			if ("is_false".equals(is_encryption) || "0".equals(is_encryption)) {
				if (!ValidateUtil.isAlphaNum(password)) {
					json.put("success", false);
					json.put("error", "密码输入有误!");
					json.put("message", "密码输入有误!");
					return json.toString();
				}
			} else {
				Validate.validatePasswordMd5(password);
			}

		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			return json.toString();
		}
			
		int errorBindCount = 0;
		// 限制密码错误次数从redis中获取error次数 
		String errorStr = JedisUtil.getJedis().get(phone + "errorBindCount");
			
		if (!BCrypt.checkpw(password, user.getPassword())) {
			if (errorStr == null) {
				JedisUtil.setString(phone + "errorBindCount", JedisUtil.EXRP_HALF_HOUR, "1");
				json.put("success", false);
				json.put("error", "登录密码错误!对不起，您还有" + (3 - errorBindCount) + "次登录机会!");
				json.put("message", "登录密码错误!对不起，您还有" + (3 - errorBindCount) + "次登录机会!");
			} else {
				errorBindCount = Integer.parseInt(errorStr);
				if (errorBindCount == 3) {
					json.put("success", false);
					json.put("error", "登录错误次数超3次!对不起，请您在半小时之后登录!");
					json.put("message", "登录错误次数超3次!对不起，请您在半小时之后登录!");
				} else if (errorBindCount < 3) {
					json.put("success", false);
					json.put("error", "登录密码错误!对不起，您还有" + (3 - errorBindCount) + "次登录机会!");
					json.put("message", "登录密码错误!对不起，您还有" + (3 - errorBindCount) + "次登录机会!");
					JedisUtil.setString(phone + "errorBindCount", JedisUtil.EXRP_HALF_HOUR,
							String.valueOf(errorBindCount + 1));
				}
			}
			return json.toString();
		}
		//token
		String token = MD5Util.md5(user.getId() + user.getPhone() + Math.random() * 10000);
		
		if (user.getRememberToken() == null || user.getRememberToken().equals("")) {
			//若没有token记录则加入user表token记录 
			userService.updateUserRememberTokenById(user.getId(), token, user.getRememberToken());
		}
		
		/**
		 * 查询更新之后的数据
		 */
		user = userService.selectUserByPhone(phone);

		UserLoginLogs UserLoginLogs = loginLogService.selectUserLoginLogsByuserIdAndAgentNum(user.getId(),
				agent_num);

		if (UserLoginLogs == null) {
			// 没有记录就创建
			loginLogService.saveUserLoginLogs(user.getId(), agent_num, source, system, token);
		} else {
			// 有记录也创建新的记录 待定
			loginLogService.saveUserLoginLogs(user.getId(), agent_num, source, system, token);
		}
		
		userService.updateOpenIdById(user.getId(), open_id, user.getOpenId());//更新openid 待定

		json.put("success", true);
		json.put("phone", user.getPhone());
		json.put("token", user.getRememberToken());
		return json.toString();				
		
	}
	
	/**
	 * 通过openId查询出用户返回token
	 */
	@Override
	public String openIdLogin(String openId) {
		
		JSONObject json = new JSONObject();
		Users user = userService.selectUserByOpenId(openId);
		
		if (user == null || user.equals("")) {
			json.put("success", true);
			json.put("phone", user.getPhone());
			json.put("token", user.getRememberToken());
			return json.toString();
		}
		
		json.put("success", false);
		json.put("error", "logout");
		return json.toString();	
		
	}

}
	
	