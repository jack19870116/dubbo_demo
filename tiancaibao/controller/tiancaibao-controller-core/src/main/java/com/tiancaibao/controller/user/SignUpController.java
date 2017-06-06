package com.tiancaibao.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.user.biz.IUserBizRegisterService;

@Controller
@RequestMapping("/user")
public class SignUpController {

	@Resource
	private IUserBizRegisterService userRegisterService;

	@RequestMapping(value = "/SignUp.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postRegist(HttpServletRequest request, String is_encryption, String agent_num, String ip,
			String phone, String password, String invited_by_phone, String phone_code, String channel_name) {

		return userRegisterService.postRegist(is_encryption, agent_num, ip, phone, password, invited_by_phone,
				phone_code, channel_name);
	}

	@RequestMapping(value = "/verify.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postverify(String phone) {
		return userRegisterService.verifyPhone(phone);
	}
}
