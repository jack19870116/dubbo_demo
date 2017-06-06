/*package com.tiancaibao.controller.common;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.RechargeBills;
import com.tiancaibao.pojo.RedeemBills;
import com.tiancaibao.pojo.RedeemHostingCollect;
import com.tiancaibao.pojo.RedeemHostingPay;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.pojo.sina.QueryHostingDepositResponseParam;
import com.tiancaibao.pojo.sina.QueryHostingTradeResponseParam;
import com.tiancaibao.service.impl.sinapay.SinaPayService;
import com.tiancaibao.service.recharge.RechargeService;
import com.tiancaibao.service.redeem.RedeemService;
import com.tiancaibao.service.trade.InvestService;
import com.tiancaibao.service.user.UserService;

@Controller
@RequestMapping("/public")
public class PublicController {
	private static Logger logger = Logger.getLogger(PublicController.class);

	@Resource
	private RechargeService rechargeService;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private RedeemService redeemService;
	@Resource
	private InvestService investService; //
	@Resource
	private UserService userService;

	*//**
	 * 查询订单状态
	 * 
	 * @return
	 *//*
	public String QueryOrder(String phone, String model, Long order_id) {
		JSONObject json = new JSONObject();
		try {
			String status = "";
			if (StringUtils.isBlank(phone)) {
				status = investService.selectUserOrderStatusByModelAndOrderId(model, order_id);
			} else {
				Users user = userService.selectUserByPhone(phone);
				if (user != null) {
					Long userid = user.getId();
					status = investService.selectUserOrderStatusByUserIdAndModelAndOrderId(userid, model, order_id);
				}
			}
			if (StringUtils.isNotBlank(status)) {
				if ("CONFIRMED".equals(status)) {
					json.put("success", true);
					json.put("error", "订单处理成功");
				} else if ("WAITING_CONFIRM".equals(status)) {
					json.put("success", false);
					json.put("error", "订单处理中");
				} else if ("CANCELLED".equals(status)) {
					json.put("success", false);
					json.put("error", "订单处理失败");
				} else {
					json.put("success", false);
					json.put("error", "没有这个订单号");
				}

			} else {
				json.put("success", false);
				json.put("error", "没有这个订单号");
			}
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
		} catch (Exception e) {
			logger.error("查询订单状态:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 查询新浪充值交易状态
	 * 
	 * @return
	 *//*
	@RequestMapping("/sinaqueryhostingdeposit.do")
	@ResponseBody
	public String sinaqueryhostingdeposit() {
		JSONObject json = new JSONObject();
		try {
			List<RechargeBills> recharebillList = rechargeService
					.selectRechargeBillByStatusAndOrderByCreatedAt("WAITING_CONFIRM", "desc");
			for (RechargeBills rb : recharebillList) {

				QueryHostingDepositResponseParam qhdrp = sinaPayService.query_hosting_deposit(rb.getUserId(), "",
						"20160404000001", "20160409120000");
				if ("APPLY_SUCCESS".equals(qhdrp.getResponse_code()) && qhdrp.getDeposit_list() != null) {
					String[] list = qhdrp.getDeposit_list().split("|");
					for (String deposit : list) {
						String[] split = deposit.split("^");
						// 核对函数 //更新数据库充值记录状态
						Boolean succ = rechargeService.checkRechargeData(split);
					}
					return StringEscapeUtils.escapeJava(qhdrp.getDeposit_list()); // 此处return结束方法
				}

			}
		} catch (Exception e) {
			logger.error("查询新浪充值交易状态:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 查询新浪赎回交易状态并更新
	 * 
	 * @return
	 *//*
	public String sinaRedeemStatus() {
		JSONObject json = new JSONObject();
		try {
			// 取前500条
			List<RedeemBills> rblist = redeemService.selectRedeemBillByStatusAndOrderByCreatedAt("WAITING_CONFIRM",
					"desc");
			for (RedeemBills rb : rblist) {
				RedeemHostingPay hostinepay = redeemService
						.selectRedeemHostingPayByStatusAndRedeemOrderId("TRADE_FINISHED", rb.getId());
				RedeemHostingCollect hostinecollect = redeemService
						.selectRedeemHostingCollectByRedeemOrderId(rb.getId());
				if (hostinepay != null && hostinecollect != null && "TRADE_FINISHED".equals(hostinepay.getStatus())
						&& hostinecollect.getOrderCode() != null && "WAIT_PAY".equals(hostinecollect.getStatus())) {
					String outtradeno = hostinecollect.getOrderCode();
					Long userId = hostinecollect.getUserId();
					QueryHostingTradeResponseParam qhtrp = sinaPayService.query_hosting_trade(userId, outtradeno);
					if ("APPLY_SUCCESS".equals(qhtrp.getResponse_code())
							&& "ORDER_NOT_EXIST".equals(qhtrp.getResponse_code())) { // 确定这个方法在用?
						// 订单号

					}
				}

			}
		} catch (Exception e) {
			logger.error("查询新浪赎回交易状态并更新:" + e.getMessage());
		}
		return json.toString();
	}

}
*/