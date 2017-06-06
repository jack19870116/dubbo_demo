package com.tiancaibao.service.interfaces.trade.redeem;

import com.tiancaibao.pojo.trade.TenderRepaymentHostingPay;

public interface ITenderRepaymentHostingPayService {
	/**
	 * 添加记录
	 * 
	 * @param userId
	 * @param amount
	 * @param redeemOrderId
	 * @param hostingPayOrderId
	 * @param status
	 * @param orderCode
	 * @param ip
	 * @return
	 */
	public int addTenderRepaymentHostingPay(long userId, long amount, long redeemOrderId, long hostingPayOrderId,
			String status, String orderCode, String ip);

	/**
	 * 根据订单号获取代付实体
	 * 
	 * @param orderCode
	 * @return
	 */
	public TenderRepaymentHostingPay getTenderRepaymentHostingPayByOrderCode(String orderCode);

	/**
	 * 更新赎回代付
	 * 
	 * @param id
	 * @param hostingPayOrderId
	 * @param status
	 * @return
	 */
	public int updateTenderRepaymentHostingPay(long id, String hostingPayOrderId, String status);

}
