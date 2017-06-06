package com.tiancaibao.service.interfaces.trade.withdraw;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.trade.TradeWithdrawRecords;

public interface ITradeWithdrawRecodeService {

	/**
	 * 根据用户ＩＤ查询充值费用
	 * @param userID
	 * @return
	 */
	Integer selectWithdrawFee(Long userID);

	/**
	 * 根据用户ID返回某一天的提现金额
	 * @param userid
	 * @param date
	 * @return
	 */
	Long selectWithdrawRecordByUserIdAndDateCount(Long userid, Date date);

	/**
	 * 根据用户ＩＤ和日期返回用户的提现成功记录
	 * @param user_id
	 * @param date
	 * @return
	 */
	List<TradeWithdrawRecords> selectWithdrawRecordByUserIdAndDate(Long userId, Date date);

	/**
	 * 返回总的提现金额
	 * @return
	 */
	Long selectSumAmountWithdrawRecodeWithAllUsers();

	/**
	 * 根据用户ID返回该用户总提现金额
	 * @param userId
	 * @return
	 */
	public Long selectSumAmountByUserId(Long userId);

	/**
	 * 返回当天的总提现金额
	 * @return
	 */
	Long selectWithDrawSumAmountCurrentDay();

	/**
	 * 频繁操作限制
	 * @param userId
	 * @param string
	 * @param currentCycle
	 * @return
	 */
	Long selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(Long userId, String string, String currentCycle);

	/**
	 * 根据withdraw_bill_id查询记录
	 */
	
	TradeWithdrawRecords  selectWithdrawRecordsByWithdrawBillId(Long withdraw_bill_id);
	
	/**
	 * 插入一条记录
	 */
	int insetintoWithdrawRecords(TradeWithdrawRecords tradeWithdrawRecords);
	
}
