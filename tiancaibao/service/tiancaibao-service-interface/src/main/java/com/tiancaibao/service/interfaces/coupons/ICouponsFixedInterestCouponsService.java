package com.tiancaibao.service.interfaces.coupons;

import com.tiancaibao.pojo.coupons.CouponsFixedInterestCoupons;

public interface ICouponsFixedInterestCouponsService {
	/**
	 * 获取加息券实体
	 * 
	 * @param id
	 *            红包加息券id
	 * @return
	 */
	public CouponsFixedInterestCoupons getCouponsFixedInterestCouponsById(long id);
	
	
	
	
	/**
	 * 更新加息券
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateaddFixedInterestStates(long id, String status);
	
	
	
	/**
	 * 查找
	 * @param id
	 * @param user_id
	 * @return
	 */
	
	public CouponsFixedInterestCoupons getCouponsFixedInterestCouponsByIdAndUserId(Long id,Long user_id);
	
	/**
	 * 更新
	 */
	public int updataCouponsFixedInterestCouponsByByIdAndUserId(Long id,Long user_id,String status);
	
}
