package com.tiancaibao.service.user.biz;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.user.biz.IUserBizResetPasswordService;
import com.tiancaibao.utils.BCrypt;
import com.tiancaibao.utils.MD5Util;
import com.tiancaibao.utils.ValidateUtil;
import com.tiancaibao.validate.Validate;

@Service("userResetPasswordService")
public class UserBizResetPasswordServiceImpl implements IUserBizResetPasswordService{
	
	@Resource
	private IUserService userService;
	
	private static Logger log = Logger.getLogger(UserBizResetPasswordServiceImpl.class);
	
	
	/**
	 * 用户修改登录密码
	 * @param token
	 * @param old_password
	 * @param new_password
	 * @param repeat_password
	 * @param is_encryption
	 * @return
	 */
	public String resetPassword(String token, String old_password, String new_password, String repeat_password, String is_encryption) {
		JSONObject json = new JSONObject();
		
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				//前端未加密
				if ( "is_false".equals(is_encryption) && user.getIsEncryption() ) {
					// 判断user密码和old_password是否匹配
					if (!BCrypt.checkpw(MD5Util.md5(old_password), user.getPassword())) {
						json.put("success", false);
						json.put("error", "旧密码输入错误");
						log.error("用户使用token" + token  +"修改密码失败，原因：旧密码不匹配");
						return json.toString();
					}
				//前端已加密
				} else {
					// 判断user密码和old_password是否匹配
					if (!BCrypt.checkpw(old_password, user.getPassword())) {
						json.put("success", false);
						json.put("error", "旧密码输入错误");
						log.error("用户使用token" + token  +"修改密码失败，原因：旧密码不匹配");
						return json.toString();
					}
				}				
				
			//用户不存在	
			} else {
				json.put("success", false);
				json.put("error", "用户不存在");
				log.error("用户使用token" + token  +"修改密码失败，原因：用户不存在");
				return json.toString();
			}
			
			if (old_password.equals(new_password)) {
				json.put("success", false);
				json.put("error", "新密码和旧密码不能一致");
				return json.toString();
			}
			
			if (!new_password.equals(repeat_password)) {
				json.put("success", false);
				json.put("error", "新密码和重复新密码不一致");
				return json.toString();
			}
			
			//新密码初步验证合法性
			try {
				
				if ( "is_false".equals(is_encryption) || "0".equals(is_encryption) ) {
					if (!ValidateUtil.isAlphaNum(new_password)) {
						json.put("success", false);
						json.put("error", "密码输入有误!");
						return json.toString();
					}
				} else {
					Validate.validatePasswordMd5(new_password);
				}

			} catch (ServiceException e) {
				json.put("success", false);
				json.put("error", e.getMessage());
				return json.toString();
			}												
			
			userService.clearUserCache(user);
			
			
			//执行修改密码动作 1前端未加密 2前端已加密 
			if ( "is_false".equals(is_encryption) || "0".equals(is_encryption) ) {
				userService.updateUserPasswordByIdMD5(user.getId(),BCrypt.hashpw(MD5Util.md5(new_password), BCrypt.gensalt()),
						user.getPassword(), true);
				json.put("success", true);
				json.put("error", "登录密码修改成功");
			} else {
				userService.updateUserPasswordByIdMD5(user.getId(),BCrypt.hashpw(new_password, BCrypt.gensalt()),
						user.getPassword(), true);
				json.put("success", true);
				json.put("error", "登录密码修改成功");
			}
			
		//捕捉异常	
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			json.put("success", false);
			json.put("error", "数据库连接异常");
			e.printStackTrace();
			log.error("用户使用token" + token  +"修改密码失败" + e.getMessage());
		}
		return json.toString();
	}
	
	
}
