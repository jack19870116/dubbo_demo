package com.tiancaibao.service.interfaces.coupons;

public interface ICouponsCurrentCashBenefitsService {

	
	/**
	 * 查询value之总和
	 * @param userId
	 * @param status
	 * @return
	 */
	public Float sumValueByuserID(Long userId,String status);
	
	
}
