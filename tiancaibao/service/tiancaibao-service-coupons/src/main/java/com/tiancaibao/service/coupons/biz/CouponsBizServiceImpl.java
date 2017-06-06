package com.tiancaibao.service.coupons.biz;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.service.interfaces.coupons.ICouponsCurrentInterestCouponsService;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedCashCouponsService;
import com.tiancaibao.service.interfaces.coupons.biz.ICouponsService;

@Service("couponsService")
public class CouponsBizServiceImpl implements ICouponsService {

	@Resource
	ICouponsCurrentInterestCouponsService couponsCurrentInterestservice; // 活期加息券

	@Resource
	ICouponsFixedCashCouponsService couponsFixedCashCouponService; // 定期红包

	@Override
	public void realNameVerifySuccessGrantCurrentInterestCoupons(Long userId) {
		Calendar c = Calendar.getInstance();
		Date startline = new Date();
		c.setTime(startline);
		c.add(Calendar.DATE, 15); // 加息券发放之后十五天到期
		Date endline = c.getTime();
		couponsCurrentInterestservice.insertAddInterestCouponForAnswer(userId, Long.parseLong("20"), "AVAILABLE", 1,
				startline, endline, userId.toString());

	}

	@Override
	public void realNameVerifySuccessGrantFixedCashCoupons(Long userId) {
		Calendar c = Calendar.getInstance();
		Date startline = new Date();
		c.setTime(startline);
		c.add(Calendar.DATE, 60); // 红包发放之日60天之后失效
		couponsFixedCashCouponService.insertIntoCouponsFixedCashCoupons(userId, Long.parseLong("50"), 0, "AVAILABLE",
				"1", 0, startline, c.getTime(), "实名认证");
		couponsFixedCashCouponService.insertIntoCouponsFixedCashCoupons(userId, Long.parseLong("20"), 0, "AVAILABLE",
				"1", 0, startline, c.getTime(), "实名认证");
		couponsFixedCashCouponService.insertIntoCouponsFixedCashCoupons(userId, Long.parseLong("10"), 0, "AVAILABLE",
				"1", 0, startline, c.getTime(), "实名认证");
	}

	@Override
	public void bindBankCardSuccessGrantFixedCashCoupons(Long userId) {

		Calendar c = Calendar.getInstance();
		Date startline = new Date();
		c.setTime(startline);
		c.add(Calendar.DATE, 60); // 加息券发放之后60天到期
		Date endline = c.getTime();
		couponsCurrentInterestservice.insertAddInterestCouponForAnswer(userId, Long.parseLong("5"), "AVAILABLE", 2,
				startline, endline, userId.toString() + "绑卡");

	}

	@Override
	public void firstInvestAddInterestCoupon(Long userId,String remark) {
		Calendar c = Calendar.getInstance();
		Date startline = new Date();
		c.setTime(startline);
		c.add(Calendar.DATE, 60); // 加息券发放之后60天到期
		Date endline = c.getTime();
		couponsCurrentInterestservice.insertAddInterestCouponForAnswer(userId, Long.parseLong("5"), "AVAILABLE", 3,
				startline, endline, remark);
		
	}

}
