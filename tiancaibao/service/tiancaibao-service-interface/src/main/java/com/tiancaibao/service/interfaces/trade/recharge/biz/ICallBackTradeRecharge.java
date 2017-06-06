package com.tiancaibao.service.interfaces.trade.recharge.biz;

import java.util.Map;

public interface ICallBackTradeRecharge {
	
	/**
	 * 新浪充值回调
	 * @param request
	 * @return
	 */
	public String RechargeNotify(Map<String, String> map);
	
	

}
