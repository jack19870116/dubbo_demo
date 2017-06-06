package com.tiancaibao.service.interfaces.debt;

public interface DebtBuyService {
	/**
	 * 用户购买活期的债券的分配
	 */
	public String TransferDeliver(Long userId,Long amount,String sinNo);
}
