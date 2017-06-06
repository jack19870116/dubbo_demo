package com.tiancaibao.service.trade.withdraw.biz;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.coupons.ICouponsCurrentCashBenefitsService;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedCashCouponsService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.system.ISystemAssetIncreaseRecordsService;
import com.tiancaibao.service.interfaces.trade.ITradeYiBaoService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeRecodeService;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawBillService;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawRecodeService;
import com.tiancaibao.service.interfaces.trade.withdraw.TradeBbinRedeemRecordsService;
import com.tiancaibao.service.interfaces.trade.withdraw.biz.ITradeWithdrawBizService;
import com.tiancaibao.service.interfaces.user.IUserBlackListService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.utils.NumberUtil;
import com.tiancaibao.utils.OrderUtil;
import com.tiancaibao.validate.Validate;

@Service("tradeWithdrawBizService")
public class TradeWithdrawBizServiceImpl implements ITradeWithdrawBizService {

	private static Logger log = LoggerFactory.getLogger(TradeWithdrawBizServiceImpl.class);

	@Resource
	private IUserService userService; // 用户服务
	@Resource
	private IPaySinaUserInfoService sinaUserInfoService; // 新浪用户信息
	@Resource
	private IUserBlackListService userBlackListService; // 黑名单
	@Resource
	private ITradeWithdrawBillService withdrawBillService; // 提现订单
	@Resource
	private ITradeWithdrawRecodeService withdrawRecodeService; // 提现成功
	@Resource
	private IPaySinaPayService sinaPayService; // 新浪支付
	@Resource
	private ITradeYiBaoService yiBaoService; // 易宝
	@Resource
	private ITradeRechargeRecodeService rechargeRecodeService; // 充值
	@Resource
	private ISystemAssetIncreaseRecordsService systemAssetIncreaseRecordsService; // 每日利息表
	@Resource
	private ITradeInvestRecordsService investRecordsService; // 投资成功表
	@Resource
	private ICouponsFixedCashCouponsService couponsFixedCashCouponsService; // 定期红包服务

	@Resource
	TradeBbinRedeemRecordsService tradeBbinRedeemRecordsService;

	@Resource
	ICouponsCurrentCashBenefitsService couponsCurrentCashBenefitsService;

	@Override
	public String ready(String token) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				// 验证用户是否实名认证 绑卡
				Integer realnamecode = sinaUserInfoService.isRealName(user.getId());
				if (ServiceConstants.CODE_REALNAME_ALREADY.equals(realnamecode)) {
					success = true;
					Long lockAmount = userBlackListService.selectUserLockAmount(user.getId(), (byte) 1);
					Integer fee = withdrawRecodeService.selectWithdrawFee(user.getId());
					Long sinapayAmount = sinaUserInfoService.selectSinapayAmountByUserId(user.getId());
					Long amount = user.getAccountAmount() + sinapayAmount - fee - lockAmount;
					if (amount < 0L) {
						amount = 0L;
					}
					json.put("amount", NumberUtil.long2double(amount));
					json.put("fee", fee);
				} else {
					json.put(TCB.RETURN_ERROR, TCB.NOT_REAL_NAME);
					json.put(TCB.RETURN_ERRNO, realnamecode);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("提现准备:" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
//		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	@Override
	public String confirm(String token, Long amount, String trading_password, String withdraw, String ip, String client,
			String plat, String host) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			//提现时间限制
			
			//用户每日提现金额限制
			
			// 单笔提现限制
			validateSingleLimit(amount);
			Long withdrawSumAmount = withdrawBillService.selectSystemWithDrawSumAmountCurrentDay();
			// 提现金额超出本日T+0金额的80%时，发送短信通知财务，客服
			if (((withdrawSumAmount + 0.0) / 10000 + amount) / TCB.SYSTEMWITHDRAWLIMIT > 0.8) {
				// 发送短信的电话号数组 朱艳 李婷 孟倩 余丹丹 张腾 赵国强
				String[] phoneArray = { "15311601876", "13810230289", "18811041717", "15212901293", "18811496100",
						"18500988114" }; // 最好从数据库中读出
				for (String phone : phoneArray) {
					// 统一调用短信服务

					// 判断是否发送过短信，今日已发送过就不再发
					/*
					 * String sessionSendWarningTime =
					 * jedis.get(DateUtil.formatDate(new Date()) + phone); if
					 * (sessionSendWarningTime == null || sessionSendWarningTime
					 * != DateUtil.formatDate(new Date())) { // 发信息 // 'phone'
					 * // content' => '目前提现金额为' . ($withdraw_amount / 10000 + //
					 * $drawAmount) . ',已超过今日T+0限额' . //
					 * $this->withdrawLimitAmout . '的80%，请及时补充和提醒客户。', // 插入缓存
					 * jedis.set(DateUtil.formatDate(new Date()) + phone,
					 * DateUtil.formatDate(new Date()));
					 * jedis.expire(DateUtil.formatDate(new Date()) + phone, 60
					 * * 24 * 30 * 12); }
					 */
				}
			}
			if (((withdrawSumAmount + 0.0) / 10000 + amount) > TCB.SYSTEMWITHDRAWLIMIT && !"yes".equals(withdraw)) {
				json.put(TCB.RETURN_ERROR, TCB.OVERSYSTEMLIMIT_MSG);
				json.put(TCB.RETURN_ERRNO, TCB.OVERSYSTEMLIMIT_CODE);
				json.put("amount", amount);
				json.put(TCB.RETURN_SUCCESS, false);
				return json.toString();
			}
			// ----------- 2016-06-28 提现提醒 end--------//
			sinaUserInfoService.isRealName(user.getId());
			Validate.amount(amount + 0.0); // 检查用户输入的提现金额
			// throw 查询余额错误,无法提现
			Long sinaBalance = findSinaBalance(user.getId()); // 查询新浪存钱罐余额
			sinaUserInfoService.updateSinaUserInfoById(sinaBalance, user.getId()); // 更新sina_user_info表余额
			Integer fee = withdrawRecodeService.selectWithdrawFee(user.getId()); // 查询提现手续费
			withDrawWarn(amount, fee, sinaBalance); // 查询用户帐户余额是否足够提现
			String currentCycle = findAccountAbnormal(user.getId(), amount, withdraw); // 检查用户帐户是否异常
			String orderCode = OrderUtil.createOrderId("WIT", "PAY", user.getId()); // 生成订单号
			// 所有验证通过 写入了bill,再请求提现接口订单
			Long withdrawBillId = withdrawBillService.insertWithdrawBillsSelectiveReturnId(user.getId(), amount, fee,
					orderCode, "2", ip, client, currentCycle);
			String fcallbackurl = selectFcallbackurl(plat, host, amount); // 生成同步返回地址
			String sinaUrl = selectSinaUrl(user.getId(), orderCode, amount.doubleValue(), fee.floatValue(),
					"SAVING_POT", fcallbackurl, ip); // 提交新浪支付，返回存钱罐地址到前台
			json.put("orderid", withdrawBillId);
			json.put("sinaURL", sinaUrl);
			json.put(TCB.RETURN_SUCCESS, true);
		} catch (ServiceException e) {
			json.put(TCB.RETURN_ERROR, e.getMessage());
			json.put(TCB.RETURN_SUCCESS, false);
		} catch (ControllerException e) {
			json.put(TCB.RETURN_ERROR, e.getMessage());
			json.put(TCB.RETURN_SUCCESS, false);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("提现确认(处理程序):" + e.getMessage());
			json.put(TCB.RETURN_ERROR, e.getMessage());
			json.put(TCB.RETURN_SUCCESS, false);
		}
		//json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	@Override
	public void validateSingleLimit(Long amount) {
		if (amount > TCB.SINGLEWITHDRAWLIMIT) { // 可以从数据库中读取
			throw new ControllerException(TCB.SINGLEWITHDRAWLIMIT_MSG);
		}
	}

	@Override
	public void withDrawWarn(Long amount, Integer fee, Long sinaBalance) {
		if (amount <= ServiceConstants.NOTFIRSTWITHDRAWFEE) {
			throw new ControllerException(TCB.FEE_MSG);
		}
		if ((amount + fee) > sinaBalance) {
			throw new ControllerException(TCB.LESSBALANCE);
		}
	}

	@Override
	public String findAccountAbnormal(Long userId, Long amount, String withdraw) {
		// 易宝个人账户
		Long yiBaoAmount = yiBaoService.selectSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间的充值总额
		Long rechargeAmount = rechargeRecodeService.selectRechargeSumAmountByUserId(userId);
		// 查询出用户在1月7日到当前时间活期投资总利息 从system_asset_add_records表中取
		Date parseDate = DateUtil.parseDate("2016-01-07");
		Long rateAdd = systemAssetIncreaseRecordsService.selectSumAmountByUserId(userId,parseDate,new Date());
		// 查询出用户在1月7日到当前时间的提现总额
		Long withDrawAmount = withdrawRecodeService.selectSumAmountByUserId(userId);
		//用于在数据表显示是T+0还是T+2到帐
		String currentCycle = "T0";
		if (((withDrawAmount + 0.0) / 10000 + amount) > TCB.SYSTEMWITHDRAWLIMIT && "yes".equals(withdraw)) {
			currentCycle = "T2";
			Long excess = withdrawRecodeService.selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(userId,
					"WAITING_WITHDRAW", currentCycle);
			withDrawAmount += excess;
		}
		Long investFixAmount = investRecordsService.selectFixedIncomeByUserId(userId); // 查询出投资定期的累计收益
		Long cashCouponValue = couponsFixedCashCouponsService.selectSumUsedCashCouponAmountByUserId(userId); // 查询用户所有使用过的定期红包的总额
		// // 体验金赎回金额
		Long bbinAmount = tradeBbinRedeemRecordsService.sumAmount(userId);
		// // 现金券总额
		Float cashBenefit = couponsCurrentCashBenefitsService.sumValueByuserID(userId, "USED");
	
		Double redeemAmount = NumberFormat.doubleSplitTwoDecimal(
				((yiBaoAmount + rechargeAmount + rateAdd + investFixAmount - withDrawAmount + bbinAmount + 0.0) / 10000)
						+ 20 + cashCouponValue + cashBenefit);// 取小数点后两位
		// 公司借款人ＩＤ号
		if (userId != Long.parseLong(PropertiesUtil.getValue("SINAPAY_BORROWER_ID"))
				&& userId != Long.parseLong(PropertiesUtil.getValue("SINAPAY_BORROWER_USER"))) {
			if (amount > redeemAmount) {
				throw new ServiceException("您的账户异常,请联系客服!");
			}
		}
		// 1.6.2 用户为黑名单 blacklist_type 为2 提现金额不能超过 '用户以往投资金额' 与 'lock_amount (锁定金额)' 之差
		Long lockAmount = userBlackListService.selectUserLockAmount(userId, (byte) 2);
		// 用户可提现金额
		Double canWithDraw = redeemAmount - lockAmount;
		if (amount > canWithDraw) {
			throw new ServiceException("账户异常,您的提现金额不能大于" + canWithDraw + "请联系客服!");
		}
		return currentCycle;
	}

	@Override
	public String selectFcallbackurl(String plat, String host, Long amount) {
		String fcallbackurl = "http://" + host + "/";
		switch (plat==null?"":plat) {
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
		log.info("生成同步返回地址 url = " + fcallbackurl + "; \n");
		return fcallbackurl;
	}

	@Override
	public String selectSinaUrl(Long userId, String orderCode, Double amount, Float fee, String account_type,
			String fcallbackurl, String ip) {
		String sinaUrl = sinaPayService.create_hosting_withdraw(userId, orderCode, amount, fee, account_type,
				PropertiesUtil.getValue("WITHDRAW_CALL_BACK_URL"), fcallbackurl, "app", ip);
		if (sinaUrl == null) {
			throw new ControllerException(TCB.WITHDRAW_FAIL);
		}
		log.info("新浪生成的跳转地址为 sinaUrl" + sinaUrl + "; \n");
		return sinaUrl;
	}

	@Override
	public Long findSinaBalance(Long userId) {
		QueryBalanceResponseParam query_balance = sinaPayService.query_balance(userId);
		return NumberUtil.double2long(query_balance.getBalance());
	}

}
