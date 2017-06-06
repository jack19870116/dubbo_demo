package com.tiancaibao.controller.pay;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.pay.biz.IPayBizVerifyIdCardService;

@Controller
@RequestMapping("/pay")
public class VerifyController {
	@Resource
	IPayBizVerifyIdCardService verifyIdCard;

	@RequestMapping(value="/realname.do",method = { RequestMethod.POST})
	@ResponseBody
	public String realNameVerify(String token, String ip, String idcard_number, String idcard_name) {
		return verifyIdCard.setRealName(token, ip, idcard_number, idcard_name);
	}

}
