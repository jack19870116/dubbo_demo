package com.tiancaibao.service.user.biz;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.user.biz.IUserBizGetLoginPasswordService;
import com.tiancaibao.utils.BCrypt;
import com.tiancaibao.utils.JedisUtil;
import com.tiancaibao.utils.MD5Util;
import com.tiancaibao.validate.Validate;

import redis.clients.jedis.Jedis;

import com.tiancaibao.pojo.user.Users;

@Service("userGetLoginPasswordService")
public class UserBizGetLoginPasswordServiceImpl   implements IUserBizGetLoginPasswordService   {
	/**
	 * 找回登陆密码
	 */
	@Resource
	private IUserService userService;
	
	private Jedis jedis;
	
	private static Logger log = Logger.getLogger(UserBizGetLoginPasswordServiceImpl.class);
	
	public String getLoginPassword(String phone, String password,String is_encryption,String phone_code) {
		JSONObject json = new JSONObject();
		try {

			// ========================参数验证start===============================//
			String validates = Validate.validates(phone, password, phone_code);
			if(!phone_code.equals(JedisUtil.getJedis().get("smsPhoneAndCode"+phone))){
				json.put("success", false);
				json.put("error", "验证码错误");
				return json.toString();
			}
			// ========================参数验证end=================================//
			if(validates!=null){
				return validates;
			}
			// 根据phone查询用户
			Users user = userService.selectUserByPhone(phone);
			if("is_false".equals(is_encryption) || "0".equals(is_encryption)){
				password = BCrypt.hashpw(MD5Util.md5(password), BCrypt.gensalt());
			}else{
				password = BCrypt.hashpw(password, BCrypt.gensalt());
			}
			if (user == null) {
				json.put("success", false);
				json.put("error", "手机号输入错误");
			} else {
				
				//清除缓存
				userService.clearUserCache(user);
				
				// 更新用户密码
				Boolean result = userService.updateUserPasswordById(user.getId(),password,user.getPassword());
				if (result == true) {
					json.put("success", true);
					log.error("用户使用手机号" + phone + "找回登陆密码成功");
				} else {
					json.put("success", false);
					json.put("error", "登陆密码重置失败");
				}
			}
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			
		} catch (Exception e) {
			json.put("success", false);
			json.put("error", "数据库连接异常");
			e.printStackTrace();
			log.error("用户使用手机号" + phone +"找回登陆密码失败\n" + e.getMessage());
		}
		return json.toString();
	}
}
