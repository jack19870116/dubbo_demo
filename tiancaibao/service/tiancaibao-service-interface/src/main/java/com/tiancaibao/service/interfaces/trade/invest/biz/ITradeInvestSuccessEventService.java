package com.tiancaibao.service.interfaces.trade.invest.biz;

import com.tiancaibao.pojo.trade.TradeInvestRecords;

/** 
* @author zhozhihang
* @version 创建时间：2017年6月1日 上午9:56:43 
* 类说明 
*/
public interface ITradeInvestSuccessEventService {
	
	/**
	 * 投资成功异步业务处理
	 * @param investRecords
	 */
	void investSuccess(TradeInvestRecords investRecords );
	
	

}
