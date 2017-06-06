package com.tiancaibao.controller.trade;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.trade.recharge.biz.ITradeRechargeService;

@Controller
@RequestMapping("/recharge")
public class RechargeController {
	
	@Resource
	ITradeRechargeService tradeRechargeService;
	/**
	 * 进入充值页
	 * @param token
	 * @param plat
	 * @return
	 */
	@RequestMapping(value="/index.do",method = { RequestMethod.POST})
	@ResponseBody
	public String rechargeVerify(String token, String plat) {
		return tradeRechargeService.RechargeIndex(token, plat);
	}
	/**
	 * 充值确认
	 * @param token
	 * @param plat
	 * @param ip
	 * @param client
	 * @param amount
	 * @param source
	 * @param host
	 * @return
	 */
	@RequestMapping(value="/confirm.do",method = { RequestMethod.POST})
	@ResponseBody
	public String ConfirmClass(String token, String plat, String ip, String client, Double amount,
			String source, String host) {
		return tradeRechargeService.RechargeConfirmClass(token, plat, ip, client, amount, source, host);
	}
	/**
	 * 接受同步消息
	 * @param token
	 * @param billId
	 * @param plat
	 * @param host
	 * @return
	 */
	@RequestMapping(value="/notifys.do",method = { RequestMethod.POST})
	@ResponseBody
	public String notifys(String token, Long billId, String plat, String host) {
		return tradeRechargeService.notifys(token, billId, plat, host);
	}
	/**
	 * 银行限额
	 * @return
	 */
	@RequestMapping(value="/bankLimit.do",method = { RequestMethod.POST})
	@ResponseBody
	public String bankLimit() {
		return tradeRechargeService.bankLimitClass();
	}
	
	
	
	
	
	
	
	
	
	

}
