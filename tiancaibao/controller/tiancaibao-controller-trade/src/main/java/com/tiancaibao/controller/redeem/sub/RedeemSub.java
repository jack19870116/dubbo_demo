package com.tiancaibao.controller.redeem.sub;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.addrate.service.AddRateService;
import com.tiancaibao.collection.service.CollectionService;
import com.tiancaibao.constants.SinaPay;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.invest.service.InvestService;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.recharge.service.RechargeService;
import com.tiancaibao.redeem.service.RedeemService;
import com.tiancaibao.sinapay.service.SinaPayService;
import com.tiancaibao.user.service.UserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.withdraw.service.WithdrawService;
import com.tiancaibao.yibao.service.YiBaoService;

@Controller
public class RedeemSub {

	@Resource
	private YiBaoService yiBaoService;
	@Resource
	private RechargeService rechargeService;
	@Resource
	private InvestService investService;
	@Resource
	private WithdrawService withdrawService;
	@Resource
	private AddRateService addRateService;
	@Resource
	private RedeemService redeemService;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private UserService userService;
	@Resource
	private CollectionService collectionService;

	public void selectValidateUserRedeemAmount(Double amount, Long userAmount, Long lockAmount,
			Long redeemCurrentLimit) {
		if (userAmount <= 0) {
			throw new ControllerException("没有可赎回金额");
		}
		Double redeemAmount = userAmount - lockAmount - (redeemCurrentLimit + 0.0) / 10000;
		if (amount > redeemAmount) {
			throw new ControllerException("您的可赎回金额为 " + redeemAmount + "元!，请联系客服");
		}

	}

	public void validateAccountRedeem(Long userId, Double amount, Long lockAmount) {
		// 易宝个人账户
		Long yiBaoAmount = yiBaoService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间的充值总额
		Long rechargeAmount = rechargeService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间投资总利息
		Long rateAdd = investService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间的提现总额
		Long withDrawAmount = withdrawService.selectSumAmountByUserId(userId);
		// 查询出投资定期的累计收益
		Long investFixAmount = investService.selectFixIncome(userId);
		// 红包
		Long cashCouponValue = addRateService.selectCashCouponUsedValue(userId);
		// 现金券
		Float cashBenefit = addRateService.selectUsedCashBenefits(userId);
		Double redeemAmount = NumberFormat.doubleSplitTwoDecimal(
				((yiBaoAmount + rechargeAmount + rateAdd + investFixAmount - withDrawAmount + 0.0) / 10000) + 20
						+ cashCouponValue + cashBenefit);

		// 9月30 现加的
		Long redeemRecordAmount = redeemService.selectRedeemSumAmount(userId);
		Long investRecords = investService.selectInvestSumAmount(userId);
		Double canRedeem = NumberFormat.doubleSplitTwoDecimal(
				((yiBaoAmount + investRecords + rateAdd + investFixAmount - redeemRecordAmount + 0.0) / 10000) + 10
						+ cashCouponValue + cashBenefit);
		// 公司借款人ＩＤ号
		if (userId != SinaPay.SINAPAY_BORROWER_ID && userId != SinaPay.SINAPAY_BORROWER_USER) {
			if (amount > redeemAmount) {
				throw new ControllerException("您的账户异常,请联系客服!");
			}
			if (amount > canRedeem) {
				throw new ControllerException("您的账户异常,请联系客服!");
			}
		}
		Double canWithDraw = redeemAmount - lockAmount;
		if (amount > canWithDraw) {
			throw new ControllerException("账户异常,您的提现金额不能大于" + canWithDraw + "请联系客服!");
		}
	}

	public void isSetPayPassword(Long userId) {
		Boolean succ = sinaPayService.query_is_set_pay_password(userId);
		if (succ != true) {
			throw new ControllerException("您还没有设置交易支付密码,当前操作不允许,请您小投一笔来初始化交易密码,谢谢!");
		}
	}

	public void isTimeCanRedeem() {
		// 关闭赎回提示
		if (DateUtil.isBetweenNHourWithMHour(0, 4)) {
			throw new ControllerException("每日00:00至04:00为系统结算时间，暂停赎回");
		}

		if (DateUtil.isWeekendToday()) {
			throw new ControllerException("您好,周六周日暂停赎回");
		}

		if (DateUtil.isNowDateBetween(TCB.HOLIDAYSTART, TCB.HOLIDAYEND)) {
			throw new ControllerException("您好,节假日暂停赎回");
		}
	}

	/**
	 * 每月活期赎回超过限额
	 * 
	 * @author Mack 2017年2月13日 上午10:02:10
	 * @param userId
	 * @param amount
	 * @return
	 */
	public Double redeemAmountOutCurrentMonth(Long userId, Double amount) {
		Long redeemAmountOutCurrentMonth = redeemService.selectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM(
				userId, 1, DateUtil.formatDateByFormat(new Date(), "yyyy_MM"));
		if (redeemAmountOutCurrentMonth < 150000) {
			return (redeemAmountOutCurrentMonth + 0.0) / 10000 + amount - 150000; // 数据单位需要确认
		} else {
			return amount;
		}
	}

	public Long reduceUserAmountAndSaveCollectionRecord(Users user, Long amount, int days, String ip,
			String client) {
		userService.updateUserAmountById(user.getAmount(), user.getId());
		Long redeemBillId = collectionService.redeemCollectionRecord(user.getId(),amount,days,ip,client);
		return redeemBillId;
	}

}
