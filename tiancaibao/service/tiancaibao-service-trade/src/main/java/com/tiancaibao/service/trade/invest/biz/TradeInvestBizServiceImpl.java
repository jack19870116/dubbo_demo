package com.tiancaibao.service.trade.invest.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCoupons;
import com.tiancaibao.pojo.coupons.CouponsFixedCashCoupons;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.CreateHostingCollectTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.system.SystemAmountLimits;
import com.tiancaibao.pojo.system.SystemAssetAddRecords;
import com.tiancaibao.pojo.system.SystemAssets;
import com.tiancaibao.pojo.system.SystemPayTimeLimits;
import com.tiancaibao.pojo.trade.TradeInvestBills;
import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecordsExample;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.coupons.ICouponsCurrentInterestCouponsService;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedCashCouponsService;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedInterestCouponsService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.notice.INoticeSendSMSService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.system.ISystemAmountLimitsService;
import com.tiancaibao.service.interfaces.system.ISystemAssetAddRecordsService;
import com.tiancaibao.service.interfaces.system.ISystemAssetsService;
import com.tiancaibao.service.interfaces.system.ISystemPayTimeLimitsService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestBillsService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestHostingCollectService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;
import com.tiancaibao.service.interfaces.trade.invest.biz.ITradeInvestService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.utils.StringUtil;

@Service("tradeInvestBizService")
public class TradeInvestBizServiceImpl implements ITradeInvestService {

	/**
	 * 调用用户接口
	 */
	@Resource
	private IUserService userService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	private ICouponsFixedCashCouponsService couponsFixedCashCouponsService;

	@Resource
	private ICouponsFixedInterestCouponsService couponsFixedInterestCouponsService;

	@Resource
	private ISystemAssetsService systemService;

	@Resource
	private IPaySinaPayService paySinaPayService;

	@Resource
	private ITradeInvestBillsService tradeInvestBillsService;

	@Resource
	private ITradeInvestHostingCollectService tradeInvestHostingCollectService;

	@Resource
	private ITradeInvestRecordsService tradeInvestRecordsService;

	@Resource
	private ICouponsCurrentInterestCouponsService couponsCurrentInterestservice;

	@Resource
	private ISystemAssetAddRecordsService systemAssetAddRecordsService;

	@Resource
	private ISystemAmountLimitsService systemAmountLimitsService;

	@Resource
	private ISystemPayTimeLimitsService systemPayTimeLimitsService;

	@Resource
	IMqMessageService mqMessageSender;

	@Resource
	private INoticeSendSMSService sendSmsService;

	private static Logger logger = Logger.getLogger(TradeInvestBizServiceImpl.class);

	@Override
	public String limit(String token) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				// 验证用户是否实名认证 绑卡
				Integer realnamecode = sinaUserInfoService.isRealName(user.getId());
				if (ServiceConstants.CODE_REALNAME_ALREADY == realnamecode) {
					success = true;
					// 红包详情记录

					Long userid = user.getId();
					// 获取可使用的定期红包
					List<CouponsFixedCashCoupons> coupons = couponsFixedCashCouponsService
							.selectAvailableCashCouponByUserIdAndStatus(userid, "AVAILABLE");
					List<SystemAssets> salist = systemService.selectSystemAssetByNotDay(1);

					for (SystemAssets asset : salist) {
						// 关闭购买
						if (DateUtil.isBetweenNHourWithMHour(0, 2)) {
							asset.setRemainAmount(0L);
						}
						switch (asset.getDays()) {
						case 30:
							asset.setWithdraw_day(DateUtil.formatDate(DateUtil.afterNDay(new Date(), 30)));
							break;
						case 90:
							asset.setWithdraw_day(DateUtil.formatDate(DateUtil.afterNDay(new Date(), 90)));
							break;
						case 180:
							asset.setWithdraw_day(DateUtil.formatDate(DateUtil.afterNDay(new Date(), 180)));
							break;
						default:
							asset.setWithdraw_day("");
							break;
						}

					}
					Map<String, Object> current = new HashMap<String, Object>();
					current.put("days", 1);
					current.put("amount-limit", user.credit()); // 此处待修改
					data.put("1", current);
					json.put("success", true);
					json.put("system_asset", data);
					json.put("coupon_data", coupons);
					// json.put("amount_limit", "$this->user->credit()"); //
					// 此处待修改
				} else {
					data.put(TCB.RETURN_ERROR, TCB.NOT_REAL_NAME);
					data.put(TCB.RETURN_ERRNO, realnamecode);
				}
			}
		} catch (Exception e) {
			logger.error("返回您的购买份额、定期可用红包:" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	@Override
	public String LimitClass(String token, Integer type, Integer month) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			PaySinaUserInfo sinauserinfo = sinaUserInfoService.selectByUserId(userid);
			// 验证是否绑定卡
			if (sinauserinfo == null || sinauserinfo.getSinapayBankCard() == null) {
				json.put("success", false);
				json.put("error", "未绑定银行卡");
				return json.toString();
			}
			Double fixed_doing_amount = 0.00;
			SystemAssets systemAsset = new SystemAssets();
			switch (type) {
			case 0:
				systemAsset = systemService.selectSystemAssetByDay(1);
				break;
			default:
				systemAsset = systemService.selectSystemAssetByDay(month * 30);
				TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
				ire.createCriteria().andUserIdEqualTo(userid).andDaysNotEqualTo(1)
						.andExpireDateGreaterThanOrEqualTo(new Date()).andStatusEqualTo("DOING");
				Long selectSumAmountInvestRecord = tradeInvestRecordsService.selectSumAmountInvestRecord(ire);

				fixed_doing_amount = NumberFormat
						.outDataMoney(selectSumAmountInvestRecord == null ? 0L : selectSumAmountInvestRecord);
				break;
			}
			if (StringUtil.empty(systemAsset)) {
				json.put("success", "false");
				json.put("error", "您投资的产品已下架或者不存在");
				return json.toString();
			}
			CouponsCurrentInterestratesCoupons add_rate = null;
			systemAsset.setExtra_rate(0.0);
			System.out.println("systemAsset:" + systemAsset.getExtra_rate());
			if (systemAsset.getDays() == 1) {
				add_rate = couponsCurrentInterestservice.selectAddInterestCouponByUserIdAndUsedAtToday(userid,
						DateUtil.getDayStartDate());
				if (add_rate != null) {
					systemAsset.setExtra_rate(add_rate.getValue().doubleValue());
				}
			}
			SystemAssetAddRecords record = new SystemAssetAddRecords();
			record.setDays(month * 30);
			Long total_amounts = systemAssetAddRecordsService.sumAmountBySystemAssetAddRecords(record);

			systemAsset.setTotal_amount(total_amounts / 10000);

			json.put("success", true);
			json.put("system_asset", systemAsset);
			json.put("fixed_doing_amount", fixed_doing_amount);
			json.put("amount_limit", user.credit());
			json.put("sinapay_amount", NumberFormat.doubleSplitTwoDecimal(
					sinauserinfo.getSinapayAmount() == null ? 0.00 : sinauserinfo.getSinapayAmount().doubleValue())); // 此处待修改
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("返回您的购买份额、定期可用红包class:" + e.getMessage());
		}
		return json.toString();

	}

	@Override
	public String confirm(String token, Integer days, Long amount, Integer couponId, Integer is_auto_invest, String ip,
			String client, String host, String plat) {
		JSONObject json = new JSONObject();
		Long todayInvestLimitAmout = 5000000L; // 用户今日默认投资最大金额
		Long todayEveryInvestLimitAmout = 1000000L; // 用户今日默认每笔投资最大金额
		// 金额限制
		SystemAmountLimits todayInvestLimit = systemAmountLimitsService.selectSystemAmountLimitsByType("invest_limit");
		// 该时间段不能投资
		SystemPayTimeLimits investTimeLimit = systemPayTimeLimitsService
				.selectSystemPayTimeLimitsByType("invest_time_limit");

		if (investTimeLimit.getStartTime() != null && investTimeLimit.getEndTime() != null
				&& (investTimeLimit.getStartTime().compareTo(investTimeLimit.getEndTime())) < 0
				&& investTimeLimit.getStartTime().compareTo(new Date()) < 0
				&& investTimeLimit.getEndTime().compareTo(new Date()) > 0) {//

			json.put("success", false);
			json.put("error", investTimeLimit.getMessage());
			return json.toString();
		}
		Users user = userService.selectUserByToken(token);
		Long userid = user.getId();
		// 查询用户是否1分钟内是否平凡操作 界定一分钟内有三笔非成功订单
		int conut = tradeInvestBillsService.countTradeInvestBillsByUserId(user.getId(), "CONFIRMED",
				DateUtil.addMinuteTime(-1));
		if (conut >= 4) {
			Users newuser = new Users();
			newuser.setId(user.getId());
			newuser.setIsLocking(Byte.parseByte("1"));
			;
			userService.updateUsersById(newuser);
			String[] phone_array = { "18811041717", "13521313630", "17191099595", "18896827912" };
			for (String phone : phone_array) {

				sendSmsService.sendSMS(phone, user.getPhone() + "有异常投资行为 账户已被锁定 请尽快核实处理!!!【天财宝】");

			}

		}
		if (user.getIsLocking() == 1) {
			json.put("success", false);
			json.put("error", "您可能存在异常投资行为，系统暂将您的账户锁定，您将无法继续投资等操作，请联系客服400-803-1206恢复账户正常状态。");
			return json.toString();
		}
		Long todayInvestAmount = tradeInvestBillsService.sumAoment(userid, "CANCELLED", DateUtil.getDayStartDate());

		if (todayInvestLimit.getStartTime() != null && todayInvestLimit.getEndTime() != null
				&& (todayInvestLimit.getStartTime().compareTo(todayInvestLimit.getEndTime())) < 0
				&& todayInvestLimit.getStartTime().compareTo(new Date()) < 0
				&& todayInvestLimit.getEndTime().compareTo(new Date()) > 0) {
			if ((todayInvestAmount / 10000 + amount) > todayInvestLimit.getAmount()
					|| amount > todayInvestLimit.getEveryAmount()) {
				json.put("success", false);
				json.put("error", todayInvestLimit.getMessage());
				return json.toString();
			}
		}
		// 单笔投资限制
		if (amount > todayEveryInvestLimitAmout) {

			json.put("success", false);
			json.put("error", "单笔投资金额不可超过" + todayEveryInvestLimitAmout + "元");
			return json.toString();
		}

		if ((todayInvestAmount / 10000 + amount) > todayInvestLimitAmout) {

			json.put("success", false);
			json.put("error", "提现提示：您今日已投资" + todayInvestAmount / 10000 + "元，最多不能超过" + todayInvestLimitAmout + "元哦");
			return json.toString();
		}

		PaySinaUserInfo sinauserinfo = sinaUserInfoService.selectByUserId(userid);
		// 验证是否绑定卡
		if (sinauserinfo == null || sinauserinfo.getSinapayBankCard() == null) {
			json.put("success", false);
			json.put("error", "未绑定银行卡");
			return json.toString();
		}
		try {
			// 关闭购买提示
			if (DateUtil.isBetweenNHourWithMHour(0, 2)) {
				json.put("success", false);
				json.put("error", "每日00:00至02:00为系统结算时间，暂停投资");
				return json.toString();
			}
			SystemAssets systemAsset = systemService.selectSystemAssetByDay(days);
			// 查询用户存钱罐余额
			QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(userid);
			if (sinauserinfo != null) {
				sinauserinfo.setSinapayAmount(query_balance.getBalance().longValue());
				sinaUserInfoService.updateSinaUserInfoById(sinauserinfo.getSinapayAmount(), sinauserinfo.getId());
			}

			String type = "";
			Long rate = 0L;
			Long couponValue = 0L;
			Double interest = 0.0;
			// 活期 额度 验证
			if (1 == days) {
				if (user.getTalentValue() <= 99) {
					json.put("success", false);
					json.put("error", "您的天才值低于100，暂时不可购买活期产品。投资定期产品可提升天才值哦~！");
					json.put("status", 3);
					return json.toString();
				}
				type = "天财宝活期";
				if (systemAsset == null || systemAsset.getRemainAmount() <= 0) {
					json.put("success", false);
					json.put("error", "今日剩余可购买金额不足!");
					return json.toString();
				}
				// $user->credit() 替换0L
				Long limit = 0L <= systemAsset.getRemainAmount() ? 0L : systemAsset.getRemainAmount();
				// 校验amount

				if (amount > sinauserinfo.getSinapayAmount()) {
					json.put("success", false);
					json.put("status", "0");
					json.put("rechargeAmount", amount - sinauserinfo.getSinapayAmount());
					json.put("error", "您的账户余额不足，请充值");
					return json.toString();
				}
				interest = NumberFormat.doubleSplitFourDecimal(
						amount * (Math.pow((systemAsset.getRate() + 0.0) / 100 + 1, 1.0 / 365 - 1)));
				rate = systemAsset.getRate();
			} else if (days == 30 || days == 90 || days == 180) {
				type = "天财宝定期";
				// 判断今日可购买份额
				if (systemAsset == null || systemAsset.getRemainAmount() <= 0) {
					json.put("success", false);
					json.put("error", "今日剩余可购买金额不足！");
					return json.toString();
				}
				// 投资准备验证规则
				// 验证amount 和活期重复

				// 判断账户余额
				if (amount > systemAsset.getRemainAmount()) {
					json.put("success", false);
					json.put("status", "0");
					json.put("rechargeAmount", amount - systemAsset.getRemainAmount());
					json.put("error", "您的可购买份额不足");
				}
				if (amount > sinauserinfo.getSinapayAmount()) {
					json.put("success", false);
					json.put("status", "0");
					json.put("rechargeAmount", amount - sinauserinfo.getSinapayAmount());
					json.put("error", "您的账户余额不足，请充值");
					return json.toString();
				}
				// 判断是否使用红包
				if (couponId != null) {
					CouponsFixedCashCoupons coupon = couponsFixedCashCouponsService
							.selectCashCouponByIdAndUserId(couponId, userid);
					if (coupon != null) {
						if (coupon.getConditions() > amount || (coupon.getDays() != 0 && days != coupon.getDays())) {
							json.put("success", false);
							json.put("error", "此红包不能满足使用条件!");
							return json.toString();
						}
					}
				}
				rate = systemAsset.getRate();
				// 到期收益 interest
				interest = NumberFormat
						.doubleSplitTwoDecimal(amount * ((rate + 0.0) / 100 * ((systemAsset.getDays() + 0.0) / 360)));
				CouponsFixedCashCoupons availableCoupon = couponsFixedCashCouponsService
						.selectCashCouponsByIdUserIdAndLessThanConditionOrderByDeadline(couponId, userid, amount,
								"ASC");
				couponValue = availableCoupon == null ? 0 : availableCoupon.getValue();
			} else {
				json.put("success", false);
				json.put("error", "请先选择投资产品");
				return json.toString();
			}
			// 构造订单数据
			Map<String, Object> data = new HashMap<>();
			data.put("type", type);
			data.put("days", days);
			data.put("amount", amount);
			data.put("rate", rate);
			data.put("coupon", couponId);
			data.put("coupon_value", couponValue);
			data.put("interest", interest);

			return investHostingCollect(token, null, null, type, days, amount, rate, couponId, couponValue, interest,
					is_auto_invest, ip, client, host, plat);

			// String orderid = MD5Util.md5(String.valueOf(new
			// Date().getTime()));
			// Jedis jedis = JedisUtil.getJedis();
			// jedis.set(orderid, JSONObject.toJSONString(data));
			// jedis.expire(orderid, 30);// 30s
			// json.put("success", true);
			// json.put("orderid", orderid);
			// json.put("interest", interest);
			// json.put("wxdata", data);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			logger.error("投资确认:" + e.getMessage());
		}
		return json.toString();
	}

	@Override
	public String investHostingCollect(String token, String source, String orderid, String type, Integer days,
			Long amount, Long rate, Integer couponId, Long coupon_value, Double interest, Integer is_auto_invest,
			String ip, String client, String host, String plat) {
		JSONObject json = new JSONObject();
		try {
			Map<String, Object> data = new HashMap<>();
			// 判断订单号
			// if ("weixin".equals(source)) {
			// Jedis jedis = JedisUtil.getJedis();
			// String datajson = jedis.get(orderid);
			// data = JSONObject.parseObject(datajson, Map.class);
			// if (data == null) {
			// json.put("success", false);
			// json.put("error", "订单号不存在");
			// return json.toString();
			// }
			// } else {
			data.put("type", type);
			data.put("days", days);
			data.put("amount", amount);
			data.put("rate", rate);
			data.put("coupon", couponId);
			data.put("coupon_value", coupon_value);
			data.put("interest", interest);
			// }
			data.put("is_auto_invest", is_auto_invest == null ? 1 : is_auto_invest);
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			PaySinaUserInfo sinauserinfo = sinaUserInfoService.selectByUserId(userid);
			SystemAssets systemAsset = systemService.selectSystemAssetByDay(days);
			if (1 == days) {
				couponId = 0;
				data.put("is_auto_invest", 0);
			}
			QueryBalanceResponseParam sina_account_amount = paySinaPayService.query_balance(userid);

			Long amount_coupon = amount - coupon_value;

			// 更新产品表
			Long systemAssetId = systemAsset.getId();
			Long systemAssetRemainAmount = systemAsset.getRemainAmount() - amount;
			systemService.updateRemainAmountByid(systemAssetId, systemAssetRemainAmount);
			Integer systemAssetdays = systemAsset.getDays();
			String order_code = paySinaPayService.create_order_id("INV", "COL", userid);

			// 更新使用状态
			if (type != null && type.equals("interest")) {
				couponsFixedInterestCouponsService
						.updataCouponsFixedInterestCouponsByByIdAndUserId(couponId.longValue(), userid, "USED");
			} else {
				couponsFixedCashCouponsService.updateCouponsFixedCashCouponsByidAndUserId(couponId.longValue(), userid,
						"USED");
			}

			// 写入投资表
			TradeInvestBills saveInvestBills = tradeInvestBillsService.saveInvestBills(userid, amount,
					"WAITING_CONFIRM", systemAssetdays, order_code, is_auto_invest.byteValue(),
					(type != null && type.equals("coupon") ? couponId : 0),
					(type != null && type.equals("interest") ? couponId : 0), ip, client);

			// 写入代收表
			tradeInvestHostingCollectService.saveInvestHostingCollect(userid, amount_coupon, "WAIT_PAY",
					saveInvestBills.getId().intValue(), order_code, ip);

			// 更新用户余额
			sinaUserInfoService.updateSinapayAmountById(sina_account_amount.getBalance().longValue(),
					sinauserinfo.getId());
			Integer cp_type = 0;
			if (1 == days) {
				cp_type = 1;
			}
			String finishUrl = "";
			if ("app".equals(plat)) {
				finishUrl = "https://" + host + "/jump/payprocessing/?orderid=" + saveInvestBills.getId() + "&amount="
						+ amount + "&type=" + days + "&plat=" + plat;
			} else if ("PC_WEB".equals(plat)) {
				// 待确认
				if (days == 1) {
					finishUrl = "https://" + host + "/current?orderid=" + saveInvestBills.getId() + "&amount=" + amount
							+ "&plat=" + amount;
				} else {
					finishUrl = "https://" + host + "/fixed?orderid=" + saveInvestBills.getId() + "&amount=" + amount
							+ "&plat=" + amount;
				}
			} else if ("weixin".equals(plat)) {
				finishUrl = "https://" + host + "/jump/payprocessing?orderid=" + saveInvestBills.getId() + "&amount="
						+ amount + "&type=" + days + "&plat=" + plat;

			} else {

				finishUrl = "https://" + host + "/jump/payprocessing?orderid=" + saveInvestBills.getId() + "&amount="
						+ amount + "&type=" + days + "&plat=" + plat;
			}
			// 暂时未知
			String notify_url = "";
			CreateHostingCollectTradeResponseParam create_hosting_collect_trade = paySinaPayService
					.create_hosting_collect_trade(saveInvestBills.getOrderCode(), "1001", "我来投资",
							user.getId().toString(), ip, "UID", notify_url, finishUrl, amount.doubleValue(), "BASIC");

			if (create_hosting_collect_trade == null) {
				json.put("success", false);
				json.put("error", "投资产品失败");
				return json.toString();
			} else {
				json.put("success", true);
				json.put("orderid", saveInvestBills.getId());
				json.put("sinaURL", create_hosting_collect_trade);

				return json.toString();
			}
		} catch (Exception e) {
			logger.error("买入确认:" + e.getMessage());
			json.put("success", false);
			json.put("error", "投资产品失败");
		}
		return json.toString();
	}

	@Override
	public String queryInvestOrder(String token, Long order_id) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			TradeInvestBills ib = tradeInvestBillsService.selectInvestBillByIdAndUserId(order_id, userid);
			if (ib != null && "CONFIRMED".equals(ib.getStatus())) {
				json.put("success", true);
				json.put("error", "投资订单处理成功");
			} else if ("WAITING_CONFIRM".equals(ib.getStatus())) {
				json.put("success", false);
				json.put("error", "投资订单处理中");
			} else if ("CANCELLED".equals(ib.getStatus())) {
				json.put("success", false);
				json.put("error", "投资订单处理失败");
			} else {
				json.put("success", false);
				json.put("error", "没有这个订单号");
			}
		} catch (Exception e) {
			logger.error("查询投资订单:" + e.getMessage());
		}
		return json.toString();
	}

	@Override
	public String changeInvestStatus(String token, Long invest_records_id, Integer is_auto_invest) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			TradeInvestRecords fetureRecord = tradeInvestRecordsService
					.selectInvestRecordByIdAndUserIdAndGreatThanExpireDate(invest_records_id, userid, new Date());
			if (fetureRecord == null) {
				json.put("success", false);
				json.put("error", "此订单不符合修改条件");
				return json.toString();
			}
			// 是否在到期四天之内
			if (DateUtil.afterNDay(new Date(), 4).compareTo(fetureRecord.getExpireDate()) >= 0) {
				json.put("success", false);
				json.put("error", "此订单不符合修改条件");
				return json.toString();
			}
			// 是否需要修改
			if (fetureRecord.getIsAutoInvest() == is_auto_invest.byteValue()) {
				json.put("success", false);
				json.put("error", "此状态无需修改");
				return json.toString();
			}
			if (is_auto_invest.intValue() != 1 || is_auto_invest.intValue() != 2) {
				json.put("success", false);
				json.put("error", "此参数不合法");
				return json.toString();
			}
			TradeInvestBills fetureBill = tradeInvestBillsService.selectInvestBillById(fetureRecord.getInvestBillId());
			// 修改状态
			tradeInvestRecordsService.updateInvestRecordsSetIsAutoInvest(fetureRecord.getId(), is_auto_invest);
			tradeInvestBillsService.updateInvestBillsSetIsAutoInvest(fetureBill.getId(), is_auto_invest);

			json.put("success", true);
			json.put("error", "修改成功");

		} catch (Exception e) {
			logger.error("用户执行替换复投 自动赎回 状态:" + e.getMessage());
		}
		return json.toString();

	}

}
