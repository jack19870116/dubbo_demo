package com.tiancaibao.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.TianCaiBaoConstans;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.utils.ValidateUtil;
import com.tiancaibao.utils.VersionNum;

import redis.clients.jedis.Jedis;

public class Validate {
	
	private Jedis jedis;
	private static Logger logger = Logger.getLogger(Validate.class);

	
	public static void validateString(String stringName,String stringValue) {
		if (StringUtils.isBlank(stringValue)) {
			throw new ServiceException(stringName + "不能为空");
		}

	}

	public static Boolean validatePassword(String password) {
		if (StringUtils.isBlank(password)) {
			throw new ServiceException("请输入密码");
		}
//		if (password.length() != 32) {
//			throw new ServiceException("密码加密不正确");
//		}
		if (!ValidateUtil.isAlphaNum(password)) {
			throw new ServiceException("密码必须由字母和数字构成");
		}
		return null;
	}
	
	public static Boolean validatePasswordMd5(String password) {
		if (StringUtils.isBlank(password)) {
			throw new ServiceException("请输入密码");
		}
		if (password.length() != 32) {
			throw new ServiceException("密码加密不正确");
		}

		return null;
	}

	public static Boolean validateEquipment(String agent_num, String source, String system) {
		if (StringUtils.isBlank(agent_num) || StringUtils.isBlank(source) || StringUtils.isBlank(system)) {
			throw new ServiceException("获取设备信息失败");
		}
		return null; // 对返回结构不做处理, 返回null
	}

	public static Boolean validateAppVersion(String app_version) {
		if (StringUtils.isBlank(app_version) || VersionNum.isSmall(app_version, TianCaiBaoConstans.APPVERSION)) {
			throw new ServiceException("您的版本过低,请升级到最新版本!");
		}
		return null;
	}

	public static void validatePhone(String phone) {
		if (StringUtils.isBlank(phone)) {
			throw new ServiceException("请输入手机号");
		}
		if (!ValidateUtil.isNumDigit(phone, 11)) {
			throw new ServiceException("请输入正确的手机号");
		}
		Pattern p = Pattern.compile("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$");  	  
		Matcher m = p.matcher(phone);  
		if(!m.matches()){
			throw new ServiceException("请输入正确的手机号");
		}
	}

	public static void validatePhoneCode(String phone_code) {
		if (phone_code == null) {
			throw new ServiceException("请输入短信验证码");
		}
		if (!ValidateUtil.isNumDigit(phone_code, 4)) {
			throw new ServiceException("请输入正确的短信验证码");
		}

	}

	public static void validateUserFeedBackContent(String content) {
		if (StringUtils.isBlank(content)) {
			throw new ServiceException("信息不能为空");
		}

	}

	public static void amount(Double amount) {
		if (amount == null) {
			throw new ServiceException("金额不能为空");
		}
		if (amount < 0.01) {
			throw new ServiceException("最小金额0.01元");
		}

	}

	public static void validateIdCardName(String idcard_name) {
		if (StringUtils.isBlank(idcard_name)) {
			throw new ServiceException("idcard_name不能为空");
		}
		if (idcard_name.length() < 2 || idcard_name.length() > 4) {
			throw new ServiceException("idcard_name不正确");
		}

	}
	
	public String checkCode(String phone, String phone_code) {
		JSONObject json = new JSONObject();
		try {
			// 校验参数
			Validate.validatePhone(phone);
			Validate.validatePhoneCode(phone_code);
			String code = jedis.get("smsPhoneAndCode" + phone);
			if (phone_code != null) {
				if (!phone_code.equals(code)) {
					json.put("success",false);
					json.put("error","您输入的短信验证码不正确");
					return json.toString();
				}
			}
			json.put("success",true);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("短信验证码校验处理程序:" + e.getMessage());
		}
		return json.toString();
	}

	public static String validates(String phone, String password,String phone_code) {
		
		JSONObject json = new JSONObject();
		try{
			validatePhone(phone);
			validatePasswordMd5(password);
			validatePhoneCode(phone_code);
		} catch (ServiceException e) {
			json.put("success",false);
			json.put("error",e.getMessage());
			return json.toString();
		}catch (Exception e) {
			json.put("success",false);
			json.put("error",e.getMessage());
		}
		return null;
		
	}

	public static void validateIdCard(String idcard_number) {
		IdcardValidator iv = new IdcardValidator(); 
		if (!iv.isValidatedAllIdcard(idcard_number)) {
			throw new ServiceException("idcard_number不合法");
		}
	}

	public static void main(String[] args) {
	try {
		Validate.validateIdCardName("种族值航多发点什么");
	} catch (ServiceException e) {
		System.out.println(e.getMessage());
	}

	}

}
