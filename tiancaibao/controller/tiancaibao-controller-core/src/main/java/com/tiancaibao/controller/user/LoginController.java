package com.tiancaibao.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.user.biz.IUserBizLoginService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Resource
	private IUserBizLoginService userBizLoginService;

	@RequestMapping(value = "/Login.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postLoginer(HttpServletRequest request, String phone, String password, String source, String agent_num,
			String system, String app_version, String is_encryption) {
		return userBizLoginService.Login(phone, password, agent_num, source, system, app_version, is_encryption);
	}
	

}
