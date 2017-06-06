package com.tiancaibao.service.interfaces.trade.redeem;

import java.util.Date;

import com.tiancaibao.pojo.trade.TradeRedeemBills;

/**
 * @author zhozhihang
 * @version 创建时间：2017年5月27日 下午4:31:34 类说明
 */
public interface ITradeRedeemBillsService {

	/**
	 * 查询出用户今日的赎回总额
	 * 
	 * @param user_id
	 * @param status
	 * @param created_at
	 * @return
	 */
	public Long todayRedeemAmount(Long user_id, String status, Date created_at);

	
	/**
	 * 插入一条记录
	 */
	public int saveTradeRedeemBills(TradeRedeemBills tradeRedeemBills);
	
	
	/**
	 * 查询一条记录
	 */
	
	public TradeRedeemBills selectTradeRedeemBillsById(Long Id);
	
}
