package com.tiancaibao.controller.pay;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.pay.biz.IPayBizBindBankCardServiceImpl;

@Controller
@RequestMapping("/pay")
public class BindBankCardController {
	
	@Resource
	IPayBizBindBankCardServiceImpl bindBankCardService;
	
	@RequestMapping(value="/verifyUser.do",method = { RequestMethod.POST})
	@ResponseBody
	public String  verifyUser(String token, String ip) {
		return bindBankCardService.verifyUser(token, ip);
	}
}
