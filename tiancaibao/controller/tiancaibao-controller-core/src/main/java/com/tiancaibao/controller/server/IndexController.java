package com.tiancaibao.controller.server;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.pay.biz.IPayBizBindBankCardServiceImpl;

/**
 * 
 * @author Mack
 *
 */
@Controller
@RequestMapping("/server")
public class IndexController {

	@Resource
	IPayBizBindBankCardServiceImpl bindBankCardService;

	@Resource
	private IMqMessageService mqMessageSender;
	
	

	
	
	
	
	@RequestMapping("/Index.do")
	@ResponseBody
	public String Index(String token, String ip, String phone) {
		
		
		
		
		
		
		/// return bindBankCardService.verifyUser(token, ip);
		JSONObject json = new JSONObject();
		try {
			json.put("success", true);
			json.put("true", "Service Server Ready!");
		} catch (Exception e) {
			json.put("success", true);
			json.put("error", "Service Server down!");
		}
		return json.toString();

	}
}
