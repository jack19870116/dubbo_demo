package com.tiancaibao.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.wechat.biz.IWechatBizService;

@Controller
@RequestMapping("/user")
public class WechatController {

	@Resource
	private IWechatBizService wechatBizService;

	@RequestMapping(value = "/wechatBind.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postWechatBind(HttpServletRequest request, String phone, String open_id, String password, String is_encryption,
			String agent_num, String source, String system) {

		return wechatBizService.wechatBind(phone, open_id, password, is_encryption, agent_num, source, system);
	}

	@RequestMapping(value = "/openId.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postOpenIdLogin(String openId) {
		return wechatBizService.openIdLogin(openId);
	}
}