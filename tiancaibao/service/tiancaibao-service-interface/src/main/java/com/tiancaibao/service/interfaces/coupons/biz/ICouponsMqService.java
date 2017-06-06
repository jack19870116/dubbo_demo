package com.tiancaibao.service.interfaces.coupons.biz;

import com.alibaba.fastjson.JSONObject;

public interface ICouponsMqService {
	/**
	 * 发放入口
	 * 
	 * @param userId
	 * @param serviceName
	 */
	public boolean grantCoupons(Long userId, String  serviceName,JSONObject jsonMessage);

}
