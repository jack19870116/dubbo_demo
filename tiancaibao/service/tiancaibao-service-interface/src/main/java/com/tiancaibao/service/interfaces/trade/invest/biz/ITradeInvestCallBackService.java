package com.tiancaibao.service.interfaces.trade.invest.biz;

import java.util.Map;

/** 
* @author zhozhihang
* @version 创建时间：2017年5月26日 下午2:05:03 
* 类说明 
*/
public interface ITradeInvestCallBackService {
	
	
	/**
	 * 投资回调
	 * @param map
	 * @return
	 */
	public  String  investNotify(Map<String, String> map);
	
	

}
