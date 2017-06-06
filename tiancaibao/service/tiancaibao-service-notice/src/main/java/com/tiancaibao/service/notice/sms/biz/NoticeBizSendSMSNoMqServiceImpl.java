package com.tiancaibao.service.notice.sms.biz;

import java.util.Date;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.notice.INoticeSendSMSService;
import com.tiancaibao.service.interfaces.notice.INoticeSmsSaveService;
import com.tiancaibao.service.interfaces.notice.biz.INoticeBizSendSMSNoMqService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.JedisUtil;
import com.tiancaibao.utils.RandomUtil;
import com.tiancaibao.validate.Validate;

import redis.clients.jedis.Jedis;

@Service("sendSmsNoMqService")
public class NoticeBizSendSMSNoMqServiceImpl implements INoticeBizSendSMSNoMqService {


	@Resource
	private IUserService userService;


	@Resource
	private INoticeSmsSaveService smsSaveService;
	@Resource
	private INoticeSendSMSService sendSmsService;
	
	private static Logger logger = Logger.getLogger(NoticeBizSendSMSNoMqServiceImpl.class);


	/**
	 * 发送短信处理程序
	 * 
	 * @param phone
	 * @param type
	 * @return
	 */

	public String sendSmsProcessing(final String phone, Integer type) {
		JSONObject json = new JSONObject();
		try {
			if (type>2) {
				json.put("success", false);
				json.put("error", "请求参数错误");
				return json.toString();
			}
			Users user = userService.selectUserByPhone(phone);
			// 校验phone
			Validate.validatePhone(phone);
			if (0 == type) {
				if (user != null) {
					json.put("success", false);
					json.put("error", "用户已存在");
					return json.toString();
				}
			} else {
				if (user == null) {
					json.put("success", false);
					json.put("error", "用户不存在");
					return json.toString();
				}
			}
			// 有关jedis可以抽取出来 设置值 取值
			String time = JedisUtil.getJedis().get("sendSmsTimeLife" + phone);
			if(time==null){
				time="2017-6-01 00:00:00";
			}
			if (DateUtil.nSecondBetweenTwoDate(DateUtil.formatDateTOyMdHms(new Date()), time) > 60) {
				
				// 获得随机四位code,放入缓存中
				int code = RandomUtil.getRandomFourNumber();
				
				JedisUtil.getJedis().set("smsPhoneAndCode" + phone, code + "");
				JedisUtil.getJedis().expire("smsPhoneAndCode" + phone,120);
				
				String content = "您的验证码为 " + code + "天财宝官方平台验证码，两分钟内有效【天财宝】";
				
				Long smsId = smsSaveService.saveSmsToSmsTable(phone, content);
				
				Boolean smsStatus = sendSmsService.sendSMS(phone, content);
				
				smsSaveService.updateSmsStatusToSmsTable(smsId, smsStatus);
				
				JedisUtil.getJedis().set("sendSmsTimeLife" + phone, DateUtil.formatDateTOyMdHms(new Date()));
//				JedisUtil.getJedis().expire("sendSmsTimeLife" + phone,60);
				json.put("success", true);
				
			} else {
				json.put("success", false);
				json.put("error", "获取短信验证码操作过于频繁");
			}
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			logger.error("发送短信处理程序:" + e.getMessage());
		}
		return json.toString();
	}
}
