package com.tiancaibao.controller.withdraw.sub;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.tiancaibao.addrate.service.AddRateService;
import com.tiancaibao.bbin.service.BbinService;
import com.tiancaibao.blacklist.service.BlackListService;
import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.constants.SinaPay;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.invest.service.InvestService;
import com.tiancaibao.pojo.SinaUserInfo;
import com.tiancaibao.pojo.WithdrawBills;
import com.tiancaibao.recharge.service.RechargeService;
import com.tiancaibao.sinapay.service.SinaPayService;
import com.tiancaibao.sinauserinfo.service.SinaUserInfoService;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.utils.NumberUtil;
import com.tiancaibao.withdraw.service.WithdrawService;
import com.tiancaibao.yibao.service.YiBaoService;

@Controller
public class WithdrawSub {

	@Resource
	private SinaUserInfoService sinaUserInfoService;
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
	private BbinService bbinService;
	@Resource
	private BlackListService blackListService;
	@Resource
	private SinaPayService sinaPayService;

	public void validateSingleLimit(Long amount) {
		if (amount > TCB.SINGLEWITHDRAWLIMIT) { // 可以从数据库中读取
			throw new ControllerException(TCB.SINGLEWITHDRAWLIMIT_MSG);
		}
	}

	

	public void withDrawWarn(Long amount, Integer fee, Long sinaBalance) {
		if (amount <= ServiceConstants.NOTFIRSTWITHDRAWFEE) {
			throw new ControllerException(TCB.FEE_MSG);
		}
		if ((amount + fee) > sinaBalance) {
			throw new ControllerException(TCB.LESSBALANCE);
		}
	}

	public String findAccountAbnormal(Long userId, Long amount,String withdraw) {
		// 易宝个人账户
		Long yiBaoAmount = yiBaoService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间的充值总额
		Long rechargeAmount = rechargeService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间投资总利息
		Long rateAdd = investService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间的提现总额
		Long withDrawAmount = withdrawService.selectSumAmountByUserId(userId);
		// 9月30 现加的
		String currentCycle = "T0";
		if (((withDrawAmount +0.0) / 10000 + amount) > TCB.SYSTEMWITHDRAWLIMIT && "yes".equals(withdraw)) {
			currentCycle = "T2";
			Long excess = withdrawService.selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(userId,"WAITING_WITHDRAW",currentCycle);
			withDrawAmount += excess;
		}
		// 查询出投资定期的累计收益
		Long investFixAmount = investService.selectFixIncome(userId);
		// 红包
		Long cashCouponValue = addRateService.selectCashCouponUsedValue(userId);
		// 体验金赎回金额
		Long bbinAmount = bbinService.selectSumAmountByUserId(userId);
		// 现金券
		Float cashBenefit = addRateService.selectUsedCashBenefits(userId);
		Double redeemAmount = NumberFormat.doubleSplitTwoDecimal(
				((yiBaoAmount + rechargeAmount + rateAdd + investFixAmount - withDrawAmount + 0.0) / 10000) + 20
						+ cashCouponValue + cashBenefit);// 取小数点后两位
		// 公司借款人ＩＤ号
		if (userId != SinaPay.SINAPAY_BORROWER_ID && userId != SinaPay.SINAPAY_BORROWER_USER) {
			if (amount > redeemAmount) {
				throw new ServiceException("您的账户异常,请联系客服!");
			}
		}
		// 1.6.2 用户为黑名单 blacklist_type 为2 提现金额不能超过 '用户以往投资金额' 与 'lock_amount
		// (锁定金额)' 之差
		Long lockAmount = blackListService.selectUserLockAmount(userId.intValue(), (byte)2);
		//用户可提现金额
		Double canWithDraw = redeemAmount - lockAmount;
		if (amount > canWithDraw) {
			throw new ServiceException("账户异常,您的提现金额不能大于" + canWithDraw + "请联系客服!");
		}
		return currentCycle;
	}

	public Long saveWithdrawBill(Long userId, Long amount, Integer fee, String orderCode, String paytypeid, String ip,
			String client, String currentCycle) {
		WithdrawBills wb = new WithdrawBills();
		wb.setUserId(userId);
		wb.setAmount(amount);
		wb.setPayFee(fee.floatValue());
		wb.setOrderCode(orderCode);
		wb.setPaytypeid(paytypeid);
		wb.setIp(ip);
		wb.setClient(client);
		wb.setCurrentCycle(currentCycle);
		return withdrawService.insertWithdrawBillsSelectiveReturnId(wb);
	}

	public String selectFcallbackurl(String plat, String host, Long amount) {
		String fcallbackurl = "http://" + host + "/";
		switch (plat) {
		case "app":
			fcallbackurl += "jump/withdraw-processing?plat=" + plat + "&amount=" + amount;
			break;
		case "PC_WEB":
			fcallbackurl += "withdraw?plat=" + plat + "&amount=" + amount;
			break;
		case "weixin":
			fcallbackurl += "jump/withdraw-processing?plat=" + plat + "&amount=" + amount;
			break;
		default:
			fcallbackurl += "jump/withdraw-processing?plat=" + plat + "&amount=" + amount;
			break;
		}
		return fcallbackurl;
	}

	public String selectSinaUrl(Long userId, String orderCode, Double amount, Float fee, String account_type, String fcallbackurl,
			String ip) {
		String sinaUrl = sinaPayService.create_hosting_withdraw(userId, orderCode, amount, fee, account_type, SinaPay.WITHDRAW_CALL_BACK_URL, fcallbackurl, "app", ip);
		if(sinaUrl==null){
			throw new ControllerException(TCB.WITHDRAW_FAIL);
		}
		return sinaUrl;
	}

	public Long findSinaBalance(Long userId) {
		Double query_balance = sinaPayService.query_balance(userId);
		return NumberUtil.double2long(query_balance);
	}

}
