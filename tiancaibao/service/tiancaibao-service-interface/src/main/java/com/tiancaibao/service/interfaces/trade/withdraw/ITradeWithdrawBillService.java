package com.tiancaibao.service.interfaces.trade.withdraw;

import java.util.Date;

import com.tiancaibao.pojo.trade.TradeWithdrawBills;

public interface ITradeWithdrawBillService {

	/**
	 * 查询当前日期总的成功提取金额
	 * 
	 * @return
	 */
	Long selectSystemWithDrawSumAmountCurrentDay();

	/**
	 * 
	 * @param status
	 * @param created_at
	 * @return
	 */
	Long selectWithdrawBillByNotStatusAndCreateAtGreaterThanDayForAmountTotal(String status, Date created_at);

	/**
	 * 插入一条记录到充值bill表
	 * 
	 * @param userid
	 * @param amount
	 * @param withdraw_amount
	 * @param withdrawLimitAmout
	 * @param withdraw
	 * @param ip
	 * @param client
	 * @return
	 */
	TradeWithdrawBills insertWithdrawBill(Long userid, Long amount, Long withdraw_amount, Long withdrawLimitAmout,
			String withdraw, String ip, String client);

	/**
	 * 
	 * @param userId
	 * @param status
	 * @param currentCycle
	 * @return
	 */
	public Long selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(Long userId, String status,
			String currentCycle);

	/**
	 * 向充值记录列插入一条记录并返回充值记录ID
	 * 
	 * @param withdrawBills
	 * @return
	 */
	public Long insertWithdrawBillsSelectiveReturnId(TradeWithdrawBills withdrawBills);

	Long insertWithdrawBillsSelectiveReturnId(Long id, Long amount, Integer fee, String orderCode, String string,
			String ip, String client, String currentCycle);

	/**
	 * 根据order_code查询一条记录
	 */

	TradeWithdrawBills selectTradeWithdrawBillsByOrderCode(String order_code);
	
	/**
	 * 更新数据
	 */

	int updateTradeWithdrawBills(TradeWithdrawBills tradeWithdrawBills);
	
	
	
	
}
