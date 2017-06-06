package com.tiancaibao.service.interfaces.trade.redeem;

public interface ITenderRepaymentRecordsService {
	/**
	 * 添加记录
	 * 
	 * @param userId
	 * @param amount
	 * @param sinaOrderId
	 * @param days
	 * @param productSign
	 * @param status
	 * @param orderCode
	 * @param ip
	 * @param reinvest
	 * @return
	 */
	public int addTenderRepaymentRecords(long userId, long amount, String sinaOrderId, int days, String productSign,
			String status, String orderCode, String ip, int reinvest);
}
