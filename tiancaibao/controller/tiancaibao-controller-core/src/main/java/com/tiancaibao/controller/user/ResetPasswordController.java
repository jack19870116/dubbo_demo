package com.tiancaibao.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.user.biz.IUserBizResetPasswordService;

@Controller
@RequestMapping("/user")
public class ResetPasswordController {
	@Resource
	private IUserBizResetPasswordService userResetPasswordService;
	/**
	 * 用户登录修改密码
	 */
	@RequestMapping(value="/resetpwd.do" ,method = RequestMethod.POST)
	@ResponseBody
	public String resetPassword(String token, String old_password, String new_password, String repeat_password, String is_encryption) {
		return userResetPasswordService.resetPassword(token, old_password, new_password, repeat_password, is_encryption);
	}
}
