package com.tiancaibao.controller.trade;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.trade.invest.biz.ITradeInvestService;

@Controller
@RequestMapping("/invest")
public class InvestController {
	
	@Resource
	ITradeInvestService tradeInvestBizService;
	
	
	
	
	@RequestMapping(value = "/limitClass.do", method = { RequestMethod.POST })
	@ResponseBody
	public String limit(String token,Integer type, Integer month){
		
		return tradeInvestBizService.LimitClass(token, type,  month);
		
	}
	@RequestMapping(value = "/confirmClass.do", method = { RequestMethod.POST })
	@ResponseBody
	public String confirm(String token, Integer days, Long amount, Integer coupon, Integer is_auto_invest, String ip,
			String client, String host, String plat){
		
		return tradeInvestBizService.confirm(token, days,  amount,coupon,is_auto_invest,ip,client,host,plat);
		
	}

}
