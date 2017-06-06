package com.tiancaibao.service.interfaces.trade.redeem;

import com.tiancaibao.pojo.trade.TenderRepaymentBills;

public interface ITenderRepaymentBillsService {
	/**
	 * 根据Id更新赎回订单表
	 * 
	 * @param id
	 * @param yborderid
	 * @return
	 */
	public int updateTenderRepaymentBills(long id, String yborderid, String status);

	/**
	 * 根据id获取实体
	 * 
	 * @param id
	 * @return
	 */
	public TenderRepaymentBills getTenderRepaymentBillsById(long id);

}
