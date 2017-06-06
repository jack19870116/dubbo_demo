package com.tiancaibao.service.interfaces.trade.redeem;

import java.util.Date;

public interface ITradeRedeemRecordsService {

	/**
	 * 查询用户的赎回金额总和
	 */

	public Long sumAmountFromRedeemByUserId(Long user_id);
	
	public Long selectSumAmountOfRedeemRecordsByUserIdAndcreated_at(Long user_id);
	
	
	public Long sumAmountFromRedeem();


	public Long selectRedeemAmountByUserId(long l);


	public Long selectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM(long l, int i, String string);
	
	public Long selectSameMonth(Long userId,Date startTime,Date endTime);
	
	
	
	
	
}
