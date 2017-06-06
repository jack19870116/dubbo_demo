package com.tiancaibao.service.trade.recharge.biz;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.mq.MqMessage;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.trade.TradeRechargeBills;
import com.tiancaibao.pojo.trade.TradeRechargeRecords;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeBillService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeRecodeService;
import com.tiancaibao.service.interfaces.trade.recharge.biz.ICallBackTradeRecharge;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.ValidateUtil;

@Service("callBackTradeRecharge")
public class CallBackTradeRechargeServiceImpl implements ICallBackTradeRecharge {
	@Resource
	ITradeRechargeBillService tradeRechargeBillService;

	@Resource
	private IUserService userService;

	@Resource
	private IPaySinaPayService paySinaPayService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	private ITradeRechargeRecodeService tradeRechargeRecodeService;

	@Resource
	private IMqMessageService mqMessageSender;

	private static Logger logger = Logger.getLogger(CallBackTradeRechargeServiceImpl.class);

	@Override
	public String RechargeNotify(Map<String, String> map) {

		boolean checkSignMsg = ValidateUtil.checkSignMsg(map, map.get("sign_type"));
		if (!checkSignMsg) {
			String msg = "签名错误 or 非法请求" + map.toString() + "\n";
			map.put("status", msg);
			logger.error("验证失败,Recharge:" + map.toString() + "\n");
			return "sign error";
		}
		logger.info("验证成功,Recharge:" + map.toString() + "\n");

		JSONObject json = new JSONObject();
		
		TradeRechargeBills rechargeBill = tradeRechargeBillService.selectRechargeBillByOrderCode(map.get("outer_trade_no"));
		Users users = userService.selectUserById(rechargeBill.getUserId());

		//TODO 加上检查rechangeRecode的方法，同提现，重要
		if (map.get("deposit_status").equals("SUCCESS")) {

			if (rechargeBill != null && rechargeBill.getStatus().equals("WAITING_CONFIRM")) {
				rechargeBill.setConfirmedAt(new Date());
				rechargeBill.setStatus("CONFIRMED");
				rechargeBill.setOrderid(map.get("inner_trade_no"));
				rechargeBill.setIsHuifuChecked(99);

				tradeRechargeBillService.updateRechargeBill(rechargeBill);

				TradeRechargeRecords rechargeRecords = new TradeRechargeRecords();
				rechargeRecords.setUserId(users.getId());
				rechargeRecords.setRechargeBillId(rechargeBill.getId());
				rechargeRecords.setAmount(rechargeBill.getAmount());
				rechargeRecords.setIsHuifu(99);
				rechargeRecords.setOrderCode(rechargeBill.getOrderCode());
				tradeRechargeRecodeService.insertintoRechargeRecord(rechargeRecords);

				// 首次充值更改天财值
				JSONObject talentValuequeue = new JSONObject();
				talentValuequeue.put("userId", users.getId());
				talentValuequeue.put("title", "充值");
				talentValuequeue.put("sourceId", 5);
				talentValuequeue.put("sourceService", "rechangeService");
				talentValuequeue.put("oldTalentValue", users.getTalentValue());
				talentValuequeue.put("amount", String.valueOf(rechargeBill.getAmount()/10000));
				talentValuequeue.put("remark", "'ID:" + users.getId() + "充值成功");
				talentValuequeue.put("rechargeRecordsId", rechargeRecords.getId());
				talentValuequeue.put("rechargeBillId", rechargeBill.getId());
				talentValuequeue.put("serviceName", "rechangeService");
				talentValuequeue.put("targetServiceName", "talentValueService");
				MqMessage mmTalentValuequeue = mqMessageSender.saveMqMessageToTable(talentValuequeue.toString(),users.getId(), "talentValuequeue","rechangeService");
				
				talentValuequeue.put("messageId", mmTalentValuequeue.getId());
				
				mqMessageSender.sendMessage("talentValuequeue", talentValuequeue.toString());

				// 发送站内信
				JSONObject noticeQueue = new JSONObject();
				noticeQueue.put("userId", users.getId());
				noticeQueue.put("title", "充值");
				noticeQueue.put("info", 3);
				noticeQueue.put("status", 0);
				noticeQueue.put("phone", users.getPhone());
				noticeQueue.put("sourceService", "rechangeService");
				noticeQueue.put("amount", String.valueOf(rechargeBill.getAmount()/10000));
				noticeQueue.put("remark", "'ID:" + users.getId() + "充值成功");
				noticeQueue.put("rechargeRecordsId", rechargeRecords.getId());
				noticeQueue.put("rechargeBillId", rechargeBill.getId());
				noticeQueue.put("serviceName", "rechangeService");
				noticeQueue.put("targetServiceName", "noticeService");
				
				MqMessage mmNoticeQueue = mqMessageSender.saveMqMessageToTable(noticeQueue.toString(),users.getId(), "noticeQueue","rechangeService");
				
				noticeQueue.put("messageId", mmNoticeQueue.getId());
				
				mqMessageSender.sendMessage("noticeQueue", noticeQueue.toString());

				QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(users.getId());

				Double sina_account_amount = (query_balance.getBalance() != null
						&& query_balance.getResponse_code().equals("APPLY_SUCCESS")) ? query_balance.getBalance() : 0L;

				sinaUserInfoService.updateSinapayAmountById(Math.round(sina_account_amount * 10000L),users.getId());
				
				json.put("SUCCESS", "SUCCESS");
				
				return json.toString();

				// PrintWriter out = new PrintWriter();
				// JSONObject json = new JSONObject();
				// json.put("success", false);
				// json.put("error", "访问频率过快!");
				// out.println(json.toString());
			}

		} else if (map.get("deposit_status").equals("FAILED")) {

			rechargeBill.setConfirmedAt(new Date());
			rechargeBill.setStatus("CANCELLED");
			rechargeBill.setOrderid(map.get("innerId"));
			rechargeBill.setIsHuifuChecked(99);

			tradeRechargeBillService.updateRechargeBill(rechargeBill);
			
			json.put("SUCCESS", "SUCCESS");

			return json.toString();

		} else {
			json.put("SUCCESS", "SUCCESS");

			return json.toString();

		}

		return null;
	}

}
