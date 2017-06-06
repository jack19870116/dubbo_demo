package com.tiancaibao.service.interfaces.trade.recharge;

import java.util.Date;

import com.tiancaibao.pojo.trade.TradeRechargeRecords;

public interface ITradeRechargeRecodeService {

	/**
	 * 根据用户ID取回充值记录的条数
	 * 
	 * @param userid
	 * @param amount
	 * @param dayStartDate
	 * @return
	 */
	Integer selectCountRechargeRecordForLimit(Long userid, Long amount, Date dayStartDate);

	/**
	 * 根据用户ID取出用户所有的充值总额
	 * 
	 * @param userId
	 * @return
	 */
	Long selectRechargeSumAmountByUserId(Long userId);

	/**
	 * 插入一条数据
	 * 
	 * @param tradeRechargeRecords
	 * @return
	 */
	int insertintoRechargeRecord(TradeRechargeRecords tradeRechargeRecords);

	
	
	
	Long rechargeAmount(Long userId ,Date start,Date end); 
	
	
	
	
	
}
