package com.tiancaibao.controller.trade;

import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.service.interfaces.trade.invest.biz.ITradeInvestCallBackService;
import com.tiancaibao.utils.ValidateUtil;

@Controller
@RequestMapping("/investCallBack")
public class CallBackInvestController {
	
	@Resource
	ITradeInvestCallBackService tradeInvestCallBackService;
	
	@RequestMapping(value = "/indexNotify.do", method = { RequestMethod.POST })
	@ResponseBody
	public void investNotify(HttpServletRequest  request,HttpServletResponse response){
		Map<String, String> map = ValidateUtil.getMap(request);
		 String investNotify = tradeInvestCallBackService.investNotify(map);
		if (investNotify != null) {
			try {
				JSONObject json = JSONObject.parseObject(investNotify);

				if (json.get("SUCCESS").equals("SUCCESS")) {
					PrintWriter writer = response.getWriter();
					writer.println(json.get("SUCCESS").toString());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	

}
