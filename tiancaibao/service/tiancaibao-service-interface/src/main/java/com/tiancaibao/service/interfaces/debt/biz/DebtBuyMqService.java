package com.tiancaibao.service.interfaces.debt.biz;

public interface DebtBuyMqService {
	/**
	 * 用户购买活期的债券的分配
	 */
	public String TransferDeliverMq(Long userId,Long amount,String sinNo);
}
