package com.tiancaibao.controller.recharge;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.SinaPay;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.controller.core.sinauserinfo.SinaUserInfoController;
import com.tiancaibao.controller.recharge.sub.RechargeSub;
import com.tiancaibao.controller.recharge.sub.exception.RechargeException;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.RechargeBills;
import com.tiancaibao.pojo.SinaUserInfo;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.pojo.sina.QueryBankCardResponseParam;
import com.tiancaibao.pojo.sina.QueryHostingDepositResponseParam;
import com.tiancaibao.recharge.service.RechargeService;
import com.tiancaibao.sinapay.service.SinaPayService;
import com.tiancaibao.sinauserinfo.service.SinaUserInfoService;
import com.tiancaibao.user.service.UserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.utils.NumberUtil;
import com.tiancaibao.utils.OrderUtil;
import com.tiancaibao.validate.Validate;

@Controller
@RequestMapping("/recharge")
public class RechargeController {

	private static Logger logger = Logger.getLogger(RechargeController.class);
	@Resource
	private UserService userService;
	@Resource
	private RechargeService rechargeService;
	@Resource
	private SinaUserInfoController sinaUserInfoController;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private SinaUserInfoService sinaUserInfoService;
	@Resource
	private RechargeSub rechargeSub;

	/**
	 * 充值页面,返回账户余额
	 * 
	 * @param token
	 * @param plat
	 * @return
	 */
	@RequestMapping("/rechargeIndex.do")
	@ResponseBody
	public String rechargeIndex(String token, String plat) {
		// $error_msg 怎么处理error_msg
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		Integer status = null;
		try {
			Boolean isABC = false; 
			Long accountAmount = 0L;
			Users user = userService.selectUserByToken(token);
			sinaUserInfoController.validateRealName(user.getId());
			// 查询新浪帐户余额并存入本地数据库
			Double queryBalance = sinaPayService.query_balance(user.getId());
			SinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(user.getId());
			accountAmount = user.getAccountAmount();
			if (sinaUserInfo != null) {
				// 更新 //数据处理
				sinaUserInfoService.updateSinapayAmountById(NumberUtil.double2long(queryBalance), sinaUserInfo.getId());
				accountAmount += sinaUserInfo.getSinapayAmount();
			}
			success = true;
			data.put("account_amount", accountAmount);
			data.put("plat", plat);
			//data.put("login_error", "");// 什么鬼 error_msg
			data.put("isABC", isABC);
			data.put("status", 0);
		} catch (ServiceException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (ControllerException e) {
			if (TCB.NOT_REAL_NAME.equals(e.getMessage())) {
				data.put("status", 1);
			}
			if (TCB.NOT_BIND_CARD.equals(e.getMessage())) {
				data.put("status", 2);
			}
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("充值页面,返回账户余额:" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	/**
	 * 充值确认(处理程序)
	 * 
	 * @param plat
	 * @param token
	 * @param amount
	 * @param ip
	 * @param client
	 * @param source
	 * @param host
	 * @return
	 */
	@RequestMapping("/confirm.do")
	@ResponseBody
	public String confirm(String plat, String token, Double amount, String ip, String client, String source,
			String host) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			Long userId = user.getId();
			SinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(userId);
			// 验证是否绑卡
			if (sinaUserInfo == null || sinaUserInfo.getSinapayBankCard() == null) {
				String bankCard = rechargeSub.queryBankCard(userId);
				sinaUserInfoService.insertSinaUserInfoSetSinapayBankCardAndUserId(userId, bankCard);
			}
			// 判断输入金额
			Validate.amount(amount);
			// 充值限制
			rechargeSub.validateOverLimit(user.getId());
			String orderCode = OrderUtil.createOrderId("REC", "BIL", userId);
			amount = NumberFormat.doubleSplitTwoDecimal(amount);
			Long rechargeBillId = rechargeService.insertRechargeBill(userId, amount, "2", orderCode, "WAITING_CONFIRM",
					ip, client);
			String fcallbackurl = rechargeSub.selectFcallbackurl(amount, plat, host, rechargeBillId, source);
			String sinaUrl = rechargeSub.selectSinaUrl(rechargeBillId, amount, fcallbackurl, userId, ip);
			success = true;
			data.put("orderid", rechargeBillId);
			data.put("sinaURL", sinaUrl);
		} catch (RechargeException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
			data.put("status", 3);
		} catch (ServiceException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (ControllerException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("充值确认(处理程序):" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

	/**
	 * 接收充值同步通知
	 * 
	 * @param token
	 * @param billId
	 * @param plat
	 * @param host
	 * @return
	 */
	@RequestMapping("/notify.do")
	@ResponseBody
	public String notifys(String token, Long billId, String plat, String host) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			RechargeBills rec = rechargeService.selectRechargeBillById(billId);
			if (rec != null) {
				String orderCode = rec.getOrderCode();
				if (StringUtils.isNotBlank(orderCode)) {
					rechargeSub.queryHostingDeposit(userid, orderCode);
				}
				String fcallbackurl = rechargeSub.selectFcallbackurl(rec.getAmount(), plat, host, billId);
				success = true;
				data.put("backurl", fcallbackurl);
			}
		} catch (ServiceException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (ControllerException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("接收充值同步通知:" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}

}
