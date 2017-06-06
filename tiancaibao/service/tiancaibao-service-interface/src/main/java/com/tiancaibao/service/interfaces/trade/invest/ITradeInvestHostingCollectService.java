package com.tiancaibao.service.interfaces.trade.invest;

import com.tiancaibao.pojo.trade.TradeInvestHostingCollect;

public interface ITradeInvestHostingCollectService {
	/**
	 * 
	 * @param userId
	 * @param amount
	 * @param days
	 * @param ip
	 * @param client
	 * @param orderCode
	 * @param investBillId
	 * @return
	 */
	public Integer insertInvestHostingCollect(Long userId, Long amount, Integer days, String ip, String client,String orderCode,Long investBillId);

	
	 /**
	  * 插入一条数据
	  * @param userId
	  * @param amount
	  * @param status
	  * @param invest_order_id
	  * @param orderCode
	  * @param ip
	  * @return
	  */
	public TradeInvestHostingCollect  saveInvestHostingCollect(Long userId, Long amount, String status,Integer invest_order_id,String orderCode,String ip);
	
	/**
	 * 查询记录
	 * @param OrederCode
	 * @return
	 */
	public TradeInvestHostingCollect selectTradeInvestHostingCollectByOrederCode(String OrederCode);
	
	
	
	public int updateTradeInvestHostingCollectById(TradeInvestHostingCollect tradeInvestHostingCollect);
	 
	
	
	
	
}
