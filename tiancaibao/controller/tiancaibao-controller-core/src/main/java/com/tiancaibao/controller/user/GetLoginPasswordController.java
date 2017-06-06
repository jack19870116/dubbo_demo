package com.tiancaibao.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.user.biz.IUserBizGetLoginPasswordService;

@Controller
@RequestMapping("/user")
public class GetLoginPasswordController {
	/**
	 * 找回登陆密码
	 */
	@Resource
	private IUserBizGetLoginPasswordService  userGetLoginPasswordService;
	
	@RequestMapping(value="/getloginpwd.do", method = RequestMethod.POST)
	@ResponseBody
	public String userGetLoginPasswrod(String phone, String password,String is_encryption, String phone_code) {
		return userGetLoginPasswordService.getLoginPassword(phone, password,is_encryption, phone_code);
	}
}
