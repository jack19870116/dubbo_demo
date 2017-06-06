package com.tiancaibao.service.trade.withdraw.biz;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.mq.MqMessage;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.trade.TradeWithdrawBills;
import com.tiancaibao.pojo.trade.TradeWithdrawRecords;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawBillService;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawRecodeService;
import com.tiancaibao.service.interfaces.trade.withdraw.biz.ICallBackTradeWithdraw;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.ValidateUtil;

@Service("callBackTradeWithdraw")
public class CallBackTradeWithdrawServiceImpl implements ICallBackTradeWithdraw {
	@Resource
	ITradeWithdrawRecodeService tradeWithdrawRecodeService;

	@Resource
	ITradeWithdrawBillService tradeWithdrawBillService;

	@Resource
	private IUserService userService;

	@Resource
	private IMqMessageService mqMessageSender;

	@Resource
	private IPaySinaPayService paySinaPayService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	private static Logger logger = Logger.getLogger(CallBackTradeWithdrawServiceImpl.class);

	@Override
	public String withdrawNotify(Map<String, String> map) {

		boolean checkSignMsg = ValidateUtil.checkSignMsg(map, map.get("sign_type"));
		if (!checkSignMsg) {
			String msg = "签名错误 or 非法请求!Withdraw:" + map.toString() + "\n";
			map.put("status", msg);
			logger.error("验签失败,Withdraw:" + map.toString() + "\n");
			return "sign error";
		}
		logger.info("验签成功,Withdraw:" + map.toString() + "\n");


		TradeWithdrawBills withdrawBills = tradeWithdrawBillService
				.selectTradeWithdrawBillsByOrderCode(map.get("outer_trade_no"));

		TradeWithdrawRecords withdrawRecords = tradeWithdrawRecodeService
				.selectWithdrawRecordsByWithdrawBillId(withdrawBills.getId());


		Users users = userService.selectUserById(withdrawBills.getUserId());

		if (map.get("withdraw_status").equals("SUCCESS")) {
			if (withdrawBills != null && withdrawBills.getStatus().equals("WAITING_WITHDRAW") && withdrawRecords == null) {
				withdrawBills.setUpdatedAt(new Date());
				withdrawBills.setConfirmedAt(new Date());
				withdrawBills.setStatus("WITHDRAWED");
				withdrawBills.setPayFee(withdrawBills.getPayFee());
				withdrawBills.setHuifuStatus(map.get("withdraw_status").toString() + "call");
				tradeWithdrawBillService.updateTradeWithdrawBills(withdrawBills);
	
				TradeWithdrawRecords tradeWithdrawRecords = new TradeWithdrawRecords();
	
				tradeWithdrawRecords.setUserId(users.getId());
	
				tradeWithdrawRecords.setWithdrawBillId(withdrawBills.getId());
	
				tradeWithdrawRecords.setAmount(withdrawBills.getAmount());
	
				tradeWithdrawRecords.setDate(new Date());
	
				tradeWithdrawRecodeService.insetintoWithdrawRecords(tradeWithdrawRecords);
	
				// 发送站内信
				JSONObject noticeQueue = new JSONObject();
				noticeQueue.put("userId", users.getId());
				noticeQueue.put("title", "提现");
				noticeQueue.put("info", 4);
				noticeQueue.put("status", 0);
				noticeQueue.put("amount", withdrawBills.getAmount()/10000);
				noticeQueue.put("remark", "'ID:" + users.getId() + "提现成功");
				noticeQueue.put("TradeWithdrawBillsId", withdrawBills.getId());
				noticeQueue.put("tradeWithdrawRecordsId", tradeWithdrawRecords.getId());
				noticeQueue.put("serviceName", "withdrawService");
				noticeQueue.put("targetServiceName", "noticeService");
				
				MqMessage mmNoticeQueue = mqMessageSender.saveMqMessageToTable(noticeQueue.toString(),users.getId(), "noticeQueue","withdrawService");
				
				noticeQueue.put("messageId", mmNoticeQueue.getId());
				
				mqMessageSender.sendMessage("noticeQueue", noticeQueue.toString());
	
				QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(users.getId());
	
				Double sina_account_amount = (query_balance.getBalance() != null
						&& query_balance.getResponse_code().equals("APPLY_SUCCESS")) ? query_balance.getBalance() : 0L;
				PaySinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(users.getId());
				sinaUserInfo.setSinapayAmount(sina_account_amount.longValue());
	
				sinaUserInfoService.updateByUserId(sinaUserInfo);
				return "SUCCESS";
			}
		} else if (map.get("withdraw_status").equals("FAILED")) {
			if (withdrawBills != null && withdrawBills.getStatus().equals("WAITING_WITHDRAW")
					&& withdrawRecords == null) {
				withdrawBills.setStatus("CANCELLED");
				withdrawBills.setConfirmedAt(new Date());
				withdrawBills.setUpdatedAt(new Date());
				withdrawBills.setHuifuStatus(map.get("withdraw_status").toString() + "call");
				tradeWithdrawBillService.updateTradeWithdrawBills(withdrawBills);

				QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(users.getId());

				Double sina_account_amount = (query_balance.getBalance() != null
						&& query_balance.getResponse_code().equals("APPLY_SUCCESS")) ? query_balance.getBalance() : 0L;
						
						
				sinaUserInfoService.updateSinapayAmountById(Math.round(sina_account_amount * 10000L),users.getId());
			}

		} else {
			withdrawBills.setStatus("error");
			withdrawBills.setConfirmedAt(new Date());
			withdrawBills.setUpdatedAt(new Date());
			tradeWithdrawBillService.updateTradeWithdrawBills(withdrawBills);
			return "SUCCESS";
		}
		return "SUCCESS";
	}

}
