package com.tiancaibao.service.trade.recharge.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pojo.pay.PayBankLimits;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBankCardResponseParam;
import com.tiancaibao.pojo.system.SystemAmountLimits;
import com.tiancaibao.pojo.system.SystemPayTimeLimits;
import com.tiancaibao.pojo.trade.TradeRechargeBills;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.pay.IPayBankLimitsService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.system.ISystemAmountLimitsService;
import com.tiancaibao.service.interfaces.system.ISystemPayTimeLimitsService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeBillService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeRecodeService;
import com.tiancaibao.service.interfaces.trade.recharge.biz.ITradeRechargeService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.utils.OrderUtil;
import com.tiancaibao.validate.Validate;

@Service("tradeRechargeService")
public class TradeRechargeServiceImpl implements ITradeRechargeService {

	@Resource
	private IUserService userService;

	@Resource
	private IPaySinaPayService paySinaPayService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	private ISystemAmountLimitsService systemAmountLimitsService;

	@Resource
	private ISystemPayTimeLimitsService systemPayTimeLimitsService;

	@Resource
	private ITradeRechargeBillService tradeRechargeBillService;

	@Resource
	private ITradeRechargeRecodeService tradeRechargeRecodeService;

	@Resource
	private IPayBankLimitsService payBankLimitsService;

	private Long todayRechangeLimitAmout = 5000000L;

	private Long todayEveryRechangeLimitAmout = 50000L;

	private static Logger logger = Logger.getLogger(TradeRechargeServiceImpl.class);

	@Override
	public String RechargeIndex(String token, String plat) {

		JSONObject json = new JSONObject();

		if (token == null || (token != null && "".equals(token))) {
			json.put("success", false);
			json.put("error", "logout");
			json.put("message", "请重新登录");
			return json.toString();
		}

		boolean isABC = false;
		Long account_amoun = 0L;

		Users users = userService.selectUserByToken(token);
		if (users == null) {
			json.put("success", false);
			json.put("error", "logout");
			json.put("status", "1");
			return json.toString();

		}
		String idcard_name = users.getIdcardName();

		if (idcard_name == null || (idcard_name != null && "".equals(idcard_name))) {
			json.put("success", false);
			json.put("error", "没有实名认证");
			json.put("status", "1");
			return json.toString();

		}

		QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(users.getId());

		if (query_balance != null
				&& (query_balance.getResponse_code() == null || query_balance.getResponse_message() == null)) {
			json.put("success", false);
			json.put("error", "新浪接口错误");
			return json.toString();
		}

		PaySinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(users.getId());

		if (sinaUserInfo != null) {

			sinaUserInfo.setSinapayAmount(
					(query_balance.getBalance() != null && query_balance.getResponse_code().equals("APPLY_SUCCESS")
							? query_balance.getBalance().longValue() : 0L));
			sinaUserInfoService.updateByUserId(sinaUserInfo);

		}
		if (sinaUserInfo.getSinapayBankCard() == null
				|| (sinaUserInfo.getSinapayBankCard() != null && sinaUserInfo.equals(""))) {
			json.put("success", false);
			json.put("error", "还未绑卡");
			json.put("status", "2");
			return json.toString();
		}

		account_amoun = users.getAmount() + sinaUserInfo.getSinapayAmount();

		json.put("success", true);
		json.put("account_amount", account_amoun);
		json.put("plat", plat);
		// json.put("login_error", "还未绑卡");
		json.put("isABC", isABC);
		json.put("status", "0");
		return json.toString();
	}

	@Override
	public String RechargeConfirmClass(String token, String plat, String ip, String client, Double amount,
			String source, String host) {
		JSONObject json = new JSONObject();

		if (token == null || (token != null && "".equals(token))) {
			json.put("success", false);
			json.put("error", "logout");
			json.put("status", "1");
			return json.toString();
		}
		Users users = userService.selectUserByToken(token);
		if (users == null) {
			json.put("success", false);
			json.put("error", "logout");
			json.put("status", "1");
			return json.toString();

		}

		SystemAmountLimits todayRechangeLimit = systemAmountLimitsService.selectSystemAmountLimitsByType("rechange_limit");// 充值限额

		SystemPayTimeLimits rechangeTimeLimit = systemPayTimeLimitsService.selectSystemPayTimeLimitsByType("rechange_time_limit");// 充值时间

		if (rechangeTimeLimit.getStartTime() != null && rechangeTimeLimit.getEndTime() != null
				&& (rechangeTimeLimit.getStartTime().compareTo(rechangeTimeLimit.getEndTime()) < 0)
				&& (new Date().compareTo(rechangeTimeLimit.getStartTime()) > 0)
				&& (new Date().compareTo(rechangeTimeLimit.getEndTime()) < 0)) {// 当前时间是不是在无法充值时间段

			json.put("success", false);
			json.put("error", rechangeTimeLimit.getMessage());
			return json.toString();

		}
		if (users.getIsLocking() != null && users.getIsLocking() == 1) {
			json.put("success", false);
			json.put("error", "您可能存在异常投资行为，系统暂将您的账户锁定，您将无法继续投资等操作，请联系客服400-803-1206恢复账户正常状态。");
			return json.toString();
		}
		Long sumAmounts = tradeRechargeBillService.sumAmounts(users.getId(), "CANCELLED");

		sumAmounts = sumAmounts == null ? 0L : sumAmounts;

		if (todayRechangeLimit.getStartTime() != null && todayRechangeLimit.getEndTime() != null
				&& (todayRechangeLimit.getStartTime().compareTo(todayRechangeLimit.getEndTime()) < 0)
				&& (new Date().compareTo(todayRechangeLimit.getStartTime()) > 0)
				&& (new Date().compareTo(todayRechangeLimit.getEndTime()) < 0)) {
			if ((sumAmounts / 10000 + amount) > todayRechangeLimit.getAmount()
					|| amount > todayRechangeLimit.getEveryAmount()) {// 超过总额或者超过单笔限制
				json.put("success", false);
				json.put("error", todayRechangeLimit.getMessage());
				return json.toString();

			}
		}

		if (amount > 50000) {
			json.put("success", false);
			json.put("error", "单笔充值金额不可超过" + todayEveryRechangeLimitAmout + "元");
			return json.toString();
		}
		if ((sumAmounts / 10000 + amount) > todayRechangeLimitAmout) {
			json.put("success", false);
			json.put("error", "提现提示：您今日已充值" + sumAmounts / 10000 + "元，最多不能超过" + todayRechangeLimitAmout + "元哦！");
			return json.toString();

		}
		PaySinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(users.getId());

		if (sinaUserInfo == null || sinaUserInfo.getSinapayBankCard() == null) {

			QueryBankCardResponseParam query_bank_card = paySinaPayService.query_bank_card(users.getId());

			if (query_bank_card.getCard_list() != null) {
				String[] isHave = query_bank_card.getCard_list().split("\\^");
				if (isHave[2] == null || isHave[2].equals("")) {
					json.put("success", false);
					json.put("error", "请先绑卡");
					return json.toString();
				}
				sinaUserInfoService.insertoSinaUserInfo(users.getId(), users.getPhone(), isHave[2], null);
			}

		}
		try {
			Validate.amount(amount);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			return json.toString();
		}
		Integer recharge_limit = tradeRechargeRecodeService.selectCountRechargeRecordForLimit(users.getId(), 1000000L,new Date());

		if (recharge_limit > 2) {

			json.put("success", false);
			json.put("error", "当日充值超出限制,请联系客服");
			json.put("status", "3");
			return json.toString();

		}
		amount = NumberFormat.doubleSplitTwoDecimal(amount);
		Long insertRechargeBill = tradeRechargeBillService.insertRechargeBill(users.getId(), amount.longValue(), "2",
				OrderUtil.createOrderId("REC", "BIL", users.getId()), "WAITING_CONFIRM", ip, client);

		TradeRechargeBills selectRechargeBillById = tradeRechargeBillService.selectRechargeBillById(insertRechargeBill);
		//amount = selectRechargeBillById.getAmount().doubleValue();
		String fcallbackurl = "";
		if ("weixin".equals(source)) {
			fcallbackurl = "http://" + host + "/recharge/notify/" + selectRechargeBillById.getId() + "/" + plat;
		}
		if ("app".equals(source)) {
			fcallbackurl = "http://" + host + "/jump/app-recharge-result?orderid=" + selectRechargeBillById.getId()
					+ "&amount=" + amount;
		}
		String sinaUrl = paySinaPayService.create_hosting_deposit(selectRechargeBillById.getOrderCode(), amount, fcallbackurl,
				users.getId(), PropertiesUtil.getValue("RECHARGE_CALL_BACK_URL"), ip);
		
		json.put("orderid", selectRechargeBillById.getId());
		json.put("sinaURL", sinaUrl);
		json.put("success", true);

		return json.toString();
	}

	@Override
	public String notifys(String token, Long billId, String plat, String host) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			TradeRechargeBills rec = tradeRechargeBillService.selectRechargeBillById(billId);
			if (rec != null) {
				String orderCode = rec.getOrderCode();
				if (StringUtils.isNotBlank(orderCode)) {

					paySinaPayService.query_hosting_deposit(userid, orderCode, null, null);

				}
				String fcallbackurl = "http://" + host;
				if ("app".equals(plat) || "weixin".equals(plat)) {
					fcallbackurl += "/jump/recharge-processing/?orderid=" + billId + "&amount=" + rec.getAmount()
							+ "&plat=" + plat;
				} else if ("PC_WEB".equals(plat)) {
					fcallbackurl += "/recharge?orderid=" + billId + "&amount=" + rec.getAmount() + "&plat=" + plat;
				} else {
					fcallbackurl += "/jump/recharge-processing/?orderid=" + billId + "&amount=" + rec.getAmount()
							+ "&plat=" + plat;
				}

				success = true;
				json.put("backurl", fcallbackurl);
			}
		} catch (ServiceException e) {
			json.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (ControllerException e) {
			json.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("接收充值同步通知:" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		//json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	@Override
	public String bankLimitClass() {
		JSONObject json = new JSONObject();
		List<PayBankLimits> selectGetAll = payBankLimitsService.selectGetAll();
		if (selectGetAll == null) {

			json.put("success", true);
			json.put("error", "暂无限额信息");
			json.put("data", "");
			return json.toString();
		}

		json.put("success", true);
		json.put("error", "");
		json.put("data", selectGetAll);
		return json.toString();

	}

}

