package com.tiancaibao.service.interfaces.system;

import com.tiancaibao.pojo.system.SystemPayTimeLimits;

public interface ISystemPayTimeLimitsService {

	/**
	 * 根据type查询当日不能充值时间段
	 * 
	 * @param Type
	 * @return
	 */

	public SystemPayTimeLimits selectSystemPayTimeLimitsByType(String Type);
}
