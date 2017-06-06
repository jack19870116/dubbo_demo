package com.tiancaibao.service.interfaces.trade.redeem;

import com.tiancaibao.pojo.trade.TenderRepaymentHostingCollect;

public interface ITenderRepaymentHostingCollectService {
	/**
	 * 根据订单号获取代收实体
	 * 
	 * @param orderCode
	 * @return
	 */
	public TenderRepaymentHostingCollect getTenderRepaymentHostingCollectByOrderCode(String orderCode);

	/**
	 * 根据订单号更新代收记录表
	 * 
	 * @param orderCode
	 * @param status
	 * @return
	 */
	public int updateStatus(String orderCode, String status);
}
