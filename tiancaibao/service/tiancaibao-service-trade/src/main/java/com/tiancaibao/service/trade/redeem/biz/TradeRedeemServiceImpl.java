package com.tiancaibao.service.trade.redeem.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.CreateHostingCollectTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.system.SystemAmountLimits;
import com.tiancaibao.pojo.system.SystemPayTimeLimits;
import com.tiancaibao.pojo.trade.TradeRedeemBills;
import com.tiancaibao.pojo.trade.TradeRedeemHostingCollect;
import com.tiancaibao.pojo.user.UserBlackLists;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.coupons.ICouponsCurrentCashBenefitsService;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedCashCouponsService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.system.ISystemAmountLimitsService;
import com.tiancaibao.service.interfaces.system.ISystemAssetIncreaseRecordsService;
import com.tiancaibao.service.interfaces.system.ISystemPayTimeLimitsService;
import com.tiancaibao.service.interfaces.trade.ITradeYiBaoService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestBillsService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeRecodeService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemBillsService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemHostingCollectService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemRecordsService;
import com.tiancaibao.service.interfaces.trade.redeem.biz.ITradeRedeemService;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawRecodeService;
import com.tiancaibao.service.interfaces.user.IUserBlackListService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.JedisUtil;
import com.tiancaibao.utils.MoneyUtil;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.utils.StringUtil;
import com.tiancaibao.validate.Validate;

import redis.clients.jedis.Jedis;

@Service("tradeRedeemService")
public class TradeRedeemServiceImpl implements ITradeRedeemService {

	@Resource
	private IUserService userService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	private IUserBlackListService userBlackListService;

	@Resource
	private ITradeInvestBillsService tradeInvestBillsService;

	@Resource
	private ITradeInvestRecordsService tradeInvestRecordsService;

	@Resource
	private ISystemAmountLimitsService systemAmountLimitsService;

	@Resource
	private ISystemPayTimeLimitsService systemPayTimeLimitsService;

	@Resource
	private ITradeRedeemBillsService tradeRedeemBillsService;

	@Resource
	private ITradeYiBaoService yiBaoService;

	@Resource
	private ITradeRechargeRecodeService tradeRechargeRecodeService;

	@Resource
	private ISystemAssetIncreaseRecordsService systemAssetIncreaseRecordsService; // 每日利息表

	@Resource
	private ITradeWithdrawRecodeService withdrawRecodeService;

	@Resource
	private ITradeInvestRecordsService investRecordsService;

	@Resource
	private ICouponsFixedCashCouponsService couponsFixedCashCouponsService;

	@Resource
	ICouponsCurrentCashBenefitsService couponsCurrentCashBenefitsService;
	@Resource
	ITradeRedeemRecordsService tradeRedeemRecordsService;
	@Resource
	ITradeRedeemHostingCollectService tradeRedeemHostingCollectService;

	@Resource
	private IPaySinaPayService sinaPayService;

	private static Logger logger = Logger.getLogger(TradeRedeemServiceImpl.class);

	@Override
	public String limit(String token) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				// 验证用户是否实名认证 绑卡
				Integer realnamecode = sinaUserInfoService.isRealName(user.getId());
				if (ServiceConstants.CODE_REALNAME_ALREADY.equals(realnamecode)) {
					Long lockAmount = userBlackListService.selectUserLockAmount(user.getId(), (byte) 1);
					// 活期未满赎回时间24h的总金额
					Long redeemCurrentLimit = tradeInvestRecordsService.selectCurrentSumAmountNotWithDraw(user.getId());
					Double redeemNotSumAmount = NumberFormat.doubleSplitTwoDecimal((redeemCurrentLimit + 0.0) / 10000);
					success = true;
					data.put("limit", user.getAmount() - lockAmount - redeemNotSumAmount);
					if (redeemNotSumAmount == 0) {
						data.put("info", "");
					} else {
						data.put("limit", "小主，您有￥" + redeemNotSumAmount + "元活期投资未满24小时赎回时间哦~");
					}
					success = true;
				} else {
					data.put(TCB.RETURN_ERROR, TCB.NOT_REAL_NAME);
					data.put(TCB.RETURN_ERRNO, realnamecode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("提现准备:" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	@Override
	public String confirmClass(String token, Double amount, String ip, String redeem, String client) {
		JSONObject json = new JSONObject();
		
		try {
			
		
		try {
			Validate.amount(amount);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			return json.toString();
		}
		// 用户今日赎回金额限制
		SystemAmountLimits systemAmountLimits = systemAmountLimitsService
				.selectSystemAmountLimitsByType("redeem_limit");
		// 用户不能赎回时间
		SystemPayTimeLimits systemPayTimeLimits = systemPayTimeLimitsService
				.selectSystemPayTimeLimitsByType("redeem_time_limit");

		if (systemPayTimeLimits.getStartTime() != null && systemPayTimeLimits.getEndTime() != null
				&& (systemPayTimeLimits.getStartTime().compareTo(systemPayTimeLimits.getEndTime())) < 0
				&& systemPayTimeLimits.getStartTime().compareTo(new Date()) < 0
				&& systemPayTimeLimits.getEndTime().compareTo(new Date()) > 0) {// 在不能赎回时间段内

			json.put("success", false);
			json.put("error", systemPayTimeLimits.getMessage());
			return json.toString();
		}
		Users user = userService.selectUserByToken(token);

		if (user.getIsLocking() == 1) {
			json.put("success", false);
			json.put("error", "您可能存在异常投资行为，系统暂将您的账户锁定，您将无法继续投资等操作，请联系客服400-803-1206恢复账户正常状态。");
			return json.toString();
		}
		Long todayRedeemAmount = tradeRedeemBillsService.todayRedeemAmount(user.getId(), "CANCELLED", new Date());

		if (systemAmountLimits.getStartTime() != null && systemAmountLimits.getEndTime() != null
				&& (systemAmountLimits.getStartTime().compareTo(systemAmountLimits.getEndTime())) < 0
				&& systemAmountLimits.getStartTime().compareTo(new Date()) < 0
				&& systemAmountLimits.getEndTime().compareTo(new Date()) > 0) {// 在不能赎回时间段内

			if ((todayRedeemAmount / 10000 + amount) > systemAmountLimits.getAmount()
					|| amount > systemAmountLimits.getEveryAmount()) {
				json.put("success", false);
				json.put("error", systemAmountLimits.getMessage());
				return json.toString();
			}
		}
		// 单笔赎回限制
		if (amount > 10000000) {
			json.put("success", false);
			json.put("error", "单笔赎回金额不可超过" + 10000000 + "元");
			return json.toString();
		}
		// 今日最多赎回
		if ((todayRedeemAmount / 10000 + amount) > 500000) {
			json.put("success", false);
			json.put("error", "提现提示：您今日已赎回" + todayRedeemAmount / 10000 + "元，最多不能超过500000元哦！");
			return json.toString();
		}

		UserBlackLists blackLists = userBlackListService.selectBlackListsByUserIdAndBlacklistType(user.getId(), 1);

		Long blackList_amount = blackLists.getLockAmount() != null ? blackLists.getLockAmount() : 0L;
		// 赎回24小时限制
		Long redeem_time_limit = tradeInvestRecordsService.selectCurrentSumAmountNotWithDraw(user.getId());
		if (amount > user.getAmount() - blackList_amount - redeem_time_limit / 10000) {

			Long redeem_amount = user.getAmount() - blackList_amount - redeem_time_limit / 10000;
			json.put("success", false);
			json.put("error", "您的可赎回金额为" + redeem_amount + "元!，请联系客服");
			return json.toString();

		}
		Jedis jedis = JedisUtil.getJedis();
		String redeemTimeLife = jedis.get("redeemTimeLife" + user.getId());
		if (redeemTimeLife != null) {
			json.put("success", false);
			json.put("error", "两次操作间隔需要大于1分钟");
			return json.toString();
		}
		if (user.getAmount() <= 0L) {
			json.put("success", false);
			json.put("error", "没有可赎回金额");
			return json.toString();
		}
		// 判断用户以往的投资总额

		// 易宝个人账户
		Long yiBaoAmount = yiBaoService.selectSumAmountByUserId(user.getId());
		// 查询出用户在1月7日到当前时间的充值总额
		Long rechargeAmount = tradeRechargeRecodeService.selectRechargeSumAmountByUserId(user.getId());
		// 查询出用户在1月7日到当前时间投资总利息
		Date parseDate = DateUtil.parseDate("2016-01-07");
		Long rateAdd = systemAssetIncreaseRecordsService.selectSumAmountByUserId(user.getId(), parseDate, new Date());
		// 查询出用户在1月7日到当前时间的体现总额
		Long withDrawAmount = withdrawRecodeService.selectSumAmountByUserId(user.getId());
		// 查询出投资定期的累计收益
		Long investFixAmount = investRecordsService.selectFixedIncomeByUserId(user.getId());
		// 红包
		Long cashCouponValue = couponsFixedCashCouponsService.selectSumUsedCashCouponAmountByUserId(user.getId());
		// 现金券
		Float cashBenefit = couponsCurrentCashBenefitsService.sumValueByuserID(user.getId(), "USED");

		QueryBalanceResponseParam query_balance = sinaPayService.query_balance(user.getId());

		if (StringUtil.isEmpty(query_balance.getResponse_code())
				|| StringUtil.isEmpty(query_balance.getResponse_message())) {
			json.put("success", false);
			json.put("error", "新浪支付出错!");
			return json.toString();

		}
		Double redeemAmount = NumberFormat.doubleSplitTwoDecimal(
				((yiBaoAmount + rechargeAmount + rateAdd + investFixAmount - withDrawAmount + 0.0) / 10000) + 20
						+ cashCouponValue + cashBenefit);// 取小数点后两位
		if (!user.getId().toString().equals(PropertiesUtil.getValue("SINAPAY_BORROWER_ID"))
				&& !user.getId().toString().equals(PropertiesUtil.getValue("SINAPAY_BORROWER_USER"))) {
			if (amount > redeemAmount) {
				// 赎回金额如果大于可赎回金额加上存钱罐收益---账户异常
				String[] temp_bonus = query_balance.getBonus().split("^");
				if (amount > (redeemAmount + Double.parseDouble(temp_bonus[2]))) {
					json.put("success", false);
					json.put("error", "您的账户异常,请联系客服!");
					return json.toString();
				}
			}

		}
		Long redeemRecordAmount = tradeRedeemRecordsService
				.selectSumAmountOfRedeemRecordsByUserIdAndcreated_at(user.getId());

		Long investRecords = investRecordsService.selectSumAmountByUserIdAndCreatedAt(user.getId());

		Double canRedeem = NumberFormat.doubleSplitTwoDecimal(
				((yiBaoAmount + investRecords + rateAdd + investFixAmount - redeemRecordAmount + 0.0) / 10000) + 20
						+ cashCouponValue + cashBenefit);// 取小数点后两位

		if (!user.getId().toString().equals(PropertiesUtil.getValue("SINAPAY_BORROWER_ID"))
				&& !user.getId().toString().equals(PropertiesUtil.getValue("SINAPAY_BORROWER_USER"))) {
			if (amount > canRedeem) {
				// 赎回金额如果大于可赎回金额加上存钱罐收益---账户异常
				String[] temp_bonus = query_balance.getBonus().split("^");
				if (amount > (canRedeem + Double.parseDouble(temp_bonus[2]))) {
					json.put("success", false);
					json.put("error", "您的账户异常,请联系客服!");
					return json.toString();
				}
			}

		}
		// 用户为黑名单 blacklist_type 为2 赎回金额不能超过 '用户以往投资金额' 与 'lock_amount (锁定金额)'
		// 之差
		UserBlackLists blackList = userBlackListService.selectBlackListsByUserIdAndBlacklistType(user.getId(), 1);
		if (blackList != null) {

			// 取出此用户的锁定金额
			Long lockAmount = blackList.getLockAmount();
			// 用户可提现金额
			Double canWithDraw = redeemAmount - lockAmount;
			if (amount > canWithDraw) {
				json.put("success", false);
				json.put("error", "账户异常,您的提现金额不能大于" + canWithDraw + "请联系客服!");
				return json.toString();

			}

		}
		Boolean query_is_set_pay_password = sinaPayService.query_is_set_pay_password(user.getId());

		if (!query_is_set_pay_password) {
			json.put("success", false);
			json.put("error", "还未设置支付密码!");
			return json.toString();
		}

		// 验证是否绑定卡
		PaySinaUserInfo sina_user_info = sinaUserInfoService.selectByUserId(user.getId());
		if (sina_user_info.getSinaidcardnumber() == null) {
			json.put("success", false);
			json.put("error", "还没绑定银行卡");
			return json.toString();
		}

		if (DateUtil.isNowDateBetween("2016-12-31 00:00:00", "2017-01-03 09:00:00")) {

			json.put("success", false);
			json.put("error", "您好,节假日暂停赎回");
			return json.toString();

		}
		if (DateUtil.isWeekendToday()) {

			json.put("success", false);
			json.put("error", "您好,周六周日暂停赎回");
			return json.toString();
		}

		if (DateUtil.betweenDate(4)) {
			json.put("success", false);
			json.put("error", "每日00:00至04:00为系统结算时间，暂停赎回");
			return json.toString();
		}
		if (amount < 0.01) {
			json.put("success", false);
			json.put("error", "至少赎回金额为￥0.01");
			return json.toString();
		}
		if (amount > user.getAmount().doubleValue()) {
			json.put("success", false);
			json.put("error", "本次最多可转出￥" + user.getAmount().doubleValue());
			return json.toString();
		}

		Long redeem_amount = tradeRedeemRecordsService.selectSameMonth(user.getId(), DateUtil.getMonthStartDate(),
				DateUtil.getMonthEndDate());
		Double amount_overflow = 0.00;
		if (redeem_amount == null) {
			amount_overflow = amount - userLevelRedeemAmount(user.getTalentValue()).doubleValue();
		} else {
			double div = MoneyUtil.div(redeem_amount.doubleValue(), 10000, 4);
			if (div < userLevelRedeemAmount(user.getTalentValue()).doubleValue()) {
				amount_overflow = div + amount - userLevelRedeemAmount(user.getTalentValue()).doubleValue();
			} else {
				amount_overflow = amount;
			}
		}

		if (amount_overflow > 0 && !redeem.equals("yes")) {
			String err = "您当月赎回额度超过天才值免扣减标准\n本次超出金额:" + NumberFormat.doubleSplitTwoDecimal(amount_overflow)
					+ "元\n本次扣除天才值:'.(int)ceil($amount_overflow/1000).'\n是否继续？";
			if ((user.getTalentValue() - (int) (amount_overflow / 1000)) <= 99) {
				err = "您当月赎回额度超过天才值免扣减标准\n本次超出金额:" + NumberFormat.doubleSplitTwoDecimal(amount_overflow)
						+ "元\n本次扣除天才值:'.(int)ceil($amount_overflow/1000).'\n您继续进行赎回操作将不满足投资活期的等级条件哦\n是否继续？";
			}
			json.put("success", false);
			json.put("error", err);
			json.put("errno", 20001);
			return json.toString();
		}

		Boolean updateUserCurrentAmountById = userService.updateUserCurrentAmountById(user.getId(),
				user.getAmount() - amount.longValue(), user.getAmount());

		if (updateUserCurrentAmountById) {

			jedis.set("redeemTimeLife" + user.getId(), "redeemTimeLife" + user.getId());
			jedis.expire("redeemTimeLife" + user.getId(), 60);
			TradeRedeemBills redeemBills = new TradeRedeemBills();

			redeemBills.setUserId(user.getId());
			redeemBills.setAmount(amount.longValue());
			redeemBills.setStatus("WAITING_CONFIRM");
			redeemBills.setDays(1L);
			redeemBills.setIp(ip);
			redeemBills.setClient(client);
			tradeRedeemBillsService.saveTradeRedeemBills(redeemBills);

			String order_code = sinaPayService.create_order_id("RED", "COL", user.getId());

			TradeRedeemHostingCollect redeemHostingCollect = new TradeRedeemHostingCollect();

			redeemHostingCollect.setUserId(user.getId());
			redeemHostingCollect.setAmount(amount.longValue());
			redeemHostingCollect.setOrderCode(order_code);
			redeemHostingCollect.setRedeemOrderId(redeemBills.getId().toString());
			redeemHostingCollect.setStatus("WAIT_PAY");
			redeemHostingCollect.setIp(ip);
			tradeRedeemHostingCollectService.saveRedeemHostingCollect(redeemHostingCollect);
			String notify_url = "";// 异步回调
			CreateHostingCollectTradeResponseParam create_hosting_collect_trade = sinaPayService.create_hosting_collect_trade(order_code, "1002", "赎回代收",
					PropertiesUtil.getValue("DEBUG_COMPANY_ACCOUNT_EMAIL"), ip, "EMAIL", notify_url, "", amount,
					"RESERVE");
			if(create_hosting_collect_trade==null){
				json.put("success", false);
				json.put("error","出现错误!");
			
				return json.toString();
				
			}
			json.put("success", true);
			json.put("orderid",redeemBills.getId() );
			json.put("amount", amount);
			return json.toString();

		}
		} catch (Exception e) {
			json.put("success",false);
			json.put("error",e.getMessage() );
			return json.toString();
		}
		return null;
	}

	public Long userLevelRedeemAmount(Long tanlen_value) {

		if (tanlen_value <= 99) {
			return 0L;
		} else if (tanlen_value > 99 && tanlen_value <= 299) {
			return 50000L;
		} else if (tanlen_value > 299 && tanlen_value <= 599) {
			return 100000L;
		} else if (tanlen_value > 599 && tanlen_value <= 899) {
			return 15000L;
		} else {
			return 200000L;
		}

	}

	public static void main(String[] args) {
		System.out.println(MoneyUtil.div(123456, 10000, 4));
		;
	}

}
