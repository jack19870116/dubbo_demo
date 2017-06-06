package com.tiancaibao.service.trade.invest.biz;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.coupons.CouponsFixedInterestCoupons;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.system.SystemAssets;
import com.tiancaibao.pojo.trade.TradeInvestBills;
import com.tiancaibao.pojo.trade.TradeInvestHostingCollect;
import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedInterestCouponsService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.system.ISystemAssetsService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestBillsService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestHostingCollectService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;
import com.tiancaibao.service.interfaces.trade.invest.biz.ITradeInvestCallBackService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.ValidateUtil;

@Service("tradeInvestCallBackService")
public class TradeInvestCallBackServiceImpl implements ITradeInvestCallBackService {

	@Resource
	private ITradeInvestBillsService tradeInvestBillsService;

	@Resource
	private ISystemAssetsService systemService;

	@Resource
	private ICouponsFixedInterestCouponsService couponsFixedInterestCouponsService;

	@Resource
	private ITradeInvestHostingCollectService tradeInvestHostingCollectService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	private ITradeInvestRecordsService tradeInvestRecordsService;

	@Resource
	private IPaySinaPayService paySinaPayService;

	@Resource
	IMqMessageService mqMessageSender;
	/**
	 * 调用用户接口
	 */
	@Resource
	private IUserService userService;

	private static Logger logger = Logger.getLogger(TradeInvestCallBackServiceImpl.class);

	@Override
	public String investNotify(Map<String, String> map) {
		JSONObject json = new JSONObject();
		boolean checkSignMsg = ValidateUtil.checkSignMsg(map, map.get("sign_type"));
		if (!checkSignMsg) {
			String msg = "签名错误 or 非法请求";
			map.put("status", msg);
			logger.error("验证失败,invest:" + map.toString());
			return "sign error";
		}
		logger.info("验证成功,invest:" + map.toString());

		TradeInvestBills innvestBills = tradeInvestBillsService.selectInvestBillsByOrderCode(map.get("outer_trade_no"));
		SystemAssets systemAssets = systemService.selectSystemAssetByDay(innvestBills.getDays().intValue());

		Users users = userService.selectUserById(innvestBills.getUserId());
		Users interestUser = new Users();
		if (users != null && users.getInvitedByUserId() != null) {
			interestUser = userService.selectUserById(users.getInvitedByUserId());
		}
		Long rate = systemAssets.getRate();
		Double interest = 0.00;

		if (innvestBills.getDays() != 1L) {
			if (innvestBills.getInterestId() != null) {
				CouponsFixedInterestCoupons coupon = couponsFixedInterestCouponsService
						.getCouponsFixedInterestCouponsByIdAndUserId(innvestBills.getInterestId().longValue(),
								users.getId());
				rate += coupon.getValue().longValue();
			}

		} else {
			BigDecimal brate = new BigDecimal(rate);

			BigDecimal add = brate.divide(new BigDecimal(100)).add(new BigDecimal(1));

			double pow = Math.pow(add.doubleValue(),
					new BigDecimal(1).divide(new BigDecimal(356), 10, BigDecimal.ROUND_HALF_UP).doubleValue());
			interest = new BigDecimal(innvestBills.getAmount().doubleValue() * pow)
					.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		TradeInvestHostingCollect investHostingCollect = tradeInvestHostingCollectService
				.selectTradeInvestHostingCollectByOrederCode(innvestBills.getOrderCode());

		if (map.get("trade_status").equals("PAY_FINISHED")) {

			map.put("status", "PAY_FINISHED");
			return "SUCCESS";

		} else if (map.get("trade_status").equals("TRADE_FINISHED")) {

			if (innvestBills.getStatus().equals("CONFIRMED")) {

				json.put("success", false);
				json.put("error", "订单已确认");

			}
			//
			investHostingCollect.setHostingCollectOrderId(map.get("inner_trade_no"));
			investHostingCollect.setStatus("trade_status");
			tradeInvestHostingCollectService.updateTradeInvestHostingCollectById(investHostingCollect);

			// 更新投资表
			innvestBills.setStatus("CONFIRMED");
			innvestBills.setYborderid(map.get("inner_trade_no"));
			innvestBills.setConfirmedAt(new Date());
			tradeInvestBillsService.updateTradeInvestBills(innvestBills);
			// 最后记录成功数据表
			TradeInvestRecords tradeInvestRecords = new TradeInvestRecords();
			tradeInvestRecords.setUserId(users.getId());

			tradeInvestRecords.setInvitedByUserId(users.getInvitedByUserId());
			tradeInvestRecords.setCouponId(innvestBills.getCouponId() != null ? innvestBills.getCouponId() : 0);
			tradeInvestRecords.setInterestId(innvestBills.getInterestId() != null ? innvestBills.getInterestId() : 0);
			tradeInvestRecords.setAmount(innvestBills.getAmount());
			tradeInvestRecords.setDays(systemAssets.getDays());
			tradeInvestRecords.setRate(rate);
			tradeInvestRecords.setInvestBillId(innvestBills.getId());
			tradeInvestRecords.setExpireDate(DateUtil.afterNDay(new Date(), systemAssets.getDays()));
			tradeInvestRecords.setInterest(interest.longValue());
			tradeInvestRecords.setProductSign(systemAssets.getProductSign());
			tradeInvestRecords.setOrderCode(innvestBills.getOrderCode());
			tradeInvestRecords.setIsAutoInvest(innvestBills.getIsAutoInvest());
			tradeInvestRecordsService.saveTradeInvestRecords(tradeInvestRecords);
			PaySinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(users.getId());
			QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(users.getId());
			if (query_balance.getResponse_code() == null || query_balance.getResponse_message() == null) {
				map.put("tempArray", "新浪返回错误");
			}
			// 更新余额
			Long sina_account_amount = query_balance.getBalance() != null
					&& query_balance.getResponse_code().equals("APPLY_SUCCESS") ? query_balance.getBalance().longValue()
							: 0L;
			sinaUserInfo.setSinapayAmount(sina_account_amount);
			sinaUserInfoService.updateByUserId(sinaUserInfo);
			// 首投改动天财值
			JSONObject talentValuequeue = new JSONObject();
			talentValuequeue.put("userId", users.getId());
			talentValuequeue.put("sourceId", 6);
			talentValuequeue.put("oldTalentValue", users.getTalentValue());
			talentValuequeue.put("type", 2);
			talentValuequeue.put("serviceName", "investService");
			mqMessageSender.sendMessage("talentValuequeue", talentValuequeue.toString());
			if (innvestBills.getDays() != 1L) {
				int counts = tradeInvestRecordsService.selectTradeInvestRecords(users.getId(), 1);
				if (counts == 1 && innvestBills.getAmount() > 5000L) {

					// 首投给加息券
					JSONObject couponsGrant = new JSONObject();
					couponsGrant.put("userId", users.getId());
					couponsGrant.put("type", "Invest");
					couponsGrant.put("serviceName", "investService");

					mqMessageSender.sendMessage("couponsGrant", couponsGrant.toString());

					// 站内信
					JSONObject noticeQueue = new JSONObject();
					noticeQueue.put("userId", users.getId());
					noticeQueue.put("title", "首投定期产品");
					noticeQueue.put("info", 1);
					noticeQueue.put("status", 0);
					noticeQueue.put("remark", "'ID:" + tradeInvestRecords.getId() + "首投定期产品");
					noticeQueue.put("serviceName", "investService");
					mqMessageSender.sendMessage("noticeQueue", noticeQueue.toString());

				}

				userService.updateUserTenderAmountById(users.getId(),
						users.getFixedAmount() + tradeInvestRecords.getAmount());

			} else {
				userService.updateUserTenderAmountById(users.getId(),
						users.getFixedAmount() + tradeInvestRecords.getAmount());

			}

		}else{
			//投资失败使用事务回滚暂时空缺
			
			
			
			
			
		}

		return null;
	}

}
