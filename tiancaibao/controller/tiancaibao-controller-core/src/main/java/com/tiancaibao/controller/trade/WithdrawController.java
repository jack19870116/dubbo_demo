package com.tiancaibao.controller.trade;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.trade.withdraw.biz.ITradeWithdrawBizService;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {
	
	
	@Resource
	ITradeWithdrawBizService tradeWithdrawBizService;
	/**
	 * 提现准备
	 * @param token
	 * @return
	 */
	@RequestMapping(value="/index.do",method = { RequestMethod.POST})
	@ResponseBody
	public String rechargeVerify(String token) {
		return tradeWithdrawBizService.ready(token);
	}
	/**
	 * 提现确认
	 * @param token
	 * @param amount
	 * @param trading_password
	 * @param withdraw
	 * @param ip
	 * @param client
	 * @param plat
	 * @param host
	 * @return
	 */
	@RequestMapping(value="/confirm.do",method = { RequestMethod.POST})
	@ResponseBody
	public String confirm(String token, Long amount, String trading_password, String withdraw, String ip, String client,
			String plat, String host) {
		return tradeWithdrawBizService.confirm(token, amount, trading_password, withdraw, ip, client, plat, host);
	}

	
	
	
	
	
	
	
	
	
	
	
}
