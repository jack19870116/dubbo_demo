package com.tiancaibao.service.interfaces.system;

import com.tiancaibao.pojo.system.SystemAmountLimits;

public interface ISystemAmountLimitsService {

	
	/**
	 * 用户今日能充值的金额
	 */
	
	public SystemAmountLimits selectSystemAmountLimitsByType(String type);
	
	
	
	
	
}
