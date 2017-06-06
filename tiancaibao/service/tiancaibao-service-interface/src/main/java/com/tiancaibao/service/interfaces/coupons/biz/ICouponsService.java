package com.tiancaibao.service.interfaces.coupons.biz;

public interface ICouponsService {

	/**
	 * 实名之后发放加息券
	 * @param userId
	 */
	public void realNameVerifySuccessGrantCurrentInterestCoupons(Long userId);
	/**
	 * 实名认证之后发放定期红包
	 * @param userId
	 */
	public void realNameVerifySuccessGrantFixedCashCoupons(Long userId);
	
	/**
	 * 绑卡之后给邀请人发放加息券
	 * @param userId
	 */
	public void bindBankCardSuccessGrantFixedCashCoupons(Long userId);
	
	/**
	 * 首投之后送给邀请人加息券
	 */
	public void firstInvestAddInterestCoupon(Long userId,String remark);
	
}
