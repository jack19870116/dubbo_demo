package com.tiancaibao.service.trade.redeem.biz;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.CreateSingleHostingPayTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.trade.TradeRedeemBills;
import com.tiancaibao.pojo.trade.TradeRedeemHostingCollect;
import com.tiancaibao.pojo.trade.TradeRedeemHostingPay;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemBillsService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemHostingCollectService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemHostingPayService;
import com.tiancaibao.service.interfaces.trade.redeem.biz.ICallBackRedeem;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.ValidateUtil;

@Service("callBackRedeem")
public class CallBackRedeemImpl implements ICallBackRedeem {

	@Resource
	ITradeRedeemHostingCollectService tradeRedeemHostingCollectService;

	@Resource
	ITradeRedeemHostingPayService tradeRedeemHostingPayService;

	@Resource
	private IPaySinaPayService sinaPayService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	private IUserService userService;

	@Resource
	private ITradeRedeemBillsService tradeRedeemBillsService;

	private static Logger logger = Logger.getLogger(CallBackRedeemImpl.class);

	@Override
	public String redeemNotify(Map<String, String> map) {

		boolean checkSignMsg = ValidateUtil.checkSignMsg(map, map.get("sign_type"));
		if (!checkSignMsg) {
			String msg = "签名错误 or 非法请求";
			map.put("status", msg);
			logger.error("验证失败,redeem:" + map.toString());
			return "sign error";
		}
		logger.info("验证成功,redeem:" + map.toString());

		TradeRedeemHostingCollect redeemHostingCollect = tradeRedeemHostingCollectService
				.selectTradeRedeemHostingCollectByorder_code(map.get("outer_trade_no"));

		TradeRedeemHostingPay redeemHostingPay = tradeRedeemHostingPayService
				.selectTradeRedeemHostingPayByorder_code(map.get("outer_trade_no"));
		if (redeemHostingCollect != null && redeemHostingPay == null) {
			if (redeemHostingCollect.getStatus().equals("TRADE_FINISHED")) {
				return "SUCCESS";
			}
			if (map.get("trade_status").equals("TRADE_FINISHED")) {
				redeemHostingCollect.setHostingCollectOrderId(map.get("inner_trade_no"));
				redeemHostingCollect.setStatus(map.get("trade_status"));
				tradeRedeemHostingCollectService.updateTradeRedeemHostingCollect(redeemHostingCollect);

				redeemHostingPay = new TradeRedeemHostingPay();

				redeemHostingPay.setUserId(redeemHostingCollect.getUserId());
				redeemHostingPay.setAmount(Long.parseLong(map.get("trade_amount").toString()));
				redeemHostingPay.setRedeemOrderId(redeemHostingCollect.getRedeemOrderId());
				redeemHostingPay
						.setOrderCode(sinaPayService.create_order_id("RED", "PAY", redeemHostingCollect.getUserId()));
				redeemHostingPay.setHostingPayOrderId(redeemHostingCollect.getId().toString());
				redeemHostingPay.setStatus("WAIT_PAY");
				redeemHostingPay.setIp(redeemHostingCollect.getIp());
				tradeRedeemHostingPayService.savetradeRedeemHostingPayService(redeemHostingPay);
				PaySinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(redeemHostingCollect.getUserId());

				Users user = userService.selectUserById(redeemHostingCollect.getUserId());

				TradeRedeemBills redeemBill = tradeRedeemBillsService
						.selectTradeRedeemBillsById(Long.parseLong(redeemHostingPay.getRedeemOrderId()));

				QueryBalanceResponseParam query_balance = sinaPayService.query_balance(user.getId());
				if (query_balance.getResponse_code() == null || query_balance.getResponse_message() == null) {
					map.put("tempArray", "新浪返回错误");
				}
				// 更新余额
				Long sina_account_amount = query_balance.getBalance() != null
						&& query_balance.getResponse_code().equals("APPLY_SUCCESS")
								? query_balance.getBalance().longValue() : 0L;
				sinaUserInfo.setSinapayAmount(sina_account_amount);
				sinaUserInfoService.updateByUserId(sinaUserInfo);
				String notify_url = "";
				CreateSingleHostingPayTradeResponseParam create_single_hosting_pay_trade = sinaPayService
						.create_single_hosting_pay_trade(redeemHostingPay.getOrderCode(),
								redeemHostingPay.getAmount().doubleValue(), user.getId().toString(), notify_url,
								redeemHostingPay.getIp(), "赎回代付");
				
				 if (redeemBill.getDays() == 1 && user.getAmount() < 0) {
	                    return "SUCCESS";
	                }
				  return "SUCCESS";
			}

		}else if(redeemHostingPay!=null){
			if (map.get("trade_status").equals("TRADE_FINISHED")) {
				

				TradeRedeemBills redeemBill = tradeRedeemBillsService
						.selectTradeRedeemBillsById(Long.parseLong(redeemHostingPay.getRedeemOrderId()));
				  if (redeemBill.getStatus().equals("CONFIRMED") || redeemHostingPay.getStatus().equals("TRADE_FINISHED") ) {
	                    return "SUCCESS";
	                }
				
				
			}
			
			
			
			
			
		}

		return null;
	}

}
