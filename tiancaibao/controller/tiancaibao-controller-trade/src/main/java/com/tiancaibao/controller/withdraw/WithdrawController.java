package com.tiancaibao.controller.withdraw;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.blacklist.service.BlackListService;
import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.constants.TCB;
import com.tiancaibao.controller.core.sinauserinfo.SinaUserInfoController;
import com.tiancaibao.controller.withdraw.sub.WithdrawSub;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.sinapay.service.SinaPayService;
import com.tiancaibao.sinauserinfo.service.SinaUserInfoService;
import com.tiancaibao.user.service.UserService;
import com.tiancaibao.utils.NumberUtil;
import com.tiancaibao.utils.OrderUtil;
import com.tiancaibao.validate.Validate;
import com.tiancaibao.withdraw.service.WithdrawService;

@Controller
@RequestMapping("/with")
public class WithdrawController {

	private static Logger logger = Logger.getLogger(WithdrawController.class);

	@Resource
	private WithdrawSub withdrawSub;
	@Resource
	private SinaUserInfoController sinaUserInfoController;
	@Resource
	private UserService userService;
	@Resource
	private SinaUserInfoService sinaUserInfoService;
	@Resource
	private BlackListService blackListService;
	@Resource
	private WithdrawService withdrawService;
	@Resource
	private SinaPayService sinaPayService;

	/**
	 * 提现准备
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/ready.do")
	@ResponseBody
	public String ready(String token) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				// 验证用户是否实名认证 绑卡
				Integer realnamecode = sinaUserInfoService.isRealName(user.getId());
				if (ServiceConstants.CODE_REALNAME_ALREADY .equals(realnamecode)) {
					success = true;
					Long lockAmount = blackListService.selectUserLockAmount(user.getId().intValue(), (byte) 1);
					Integer fee = withdrawService.selectWithdrawFee(user.getId());
					Long sinapayAmount = sinaUserInfoService.selectSinapayAmountByUserId(user.getId());
					Long amount = user.getAccountAmount() + sinapayAmount - fee - lockAmount;
					if (amount < 0L) {
						amount = 0L;
					}
					data.put("amount", NumberUtil.long2double(amount));
					data.put("fee", fee);

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

	/**
	 * 提现确认(处理程序)
	 * 
	 * @param amount
	 * @param trading_password
	 * @param withdraw
	 * @param ip
	 * @param client
	 * @return
	 */
	@RequestMapping("/confirm.do")
	@ResponseBody // amount类型待定
	public String confirm(String token, Long amount, String trading_password, String withdraw, String ip, String client,
			String plat, String host) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			// 单笔提现限制
			withdrawSub.validateSingleLimit(amount);
			Long withdrawSumAmount = withdrawService.selectSystemWithDrawSumAmountCurrentDay();
			// 提现金额超出本日T+0金额的80%时，发送短信通知财务，客服
			if (((withdrawSumAmount + 0.0) / 10000 + amount) / TCB.SYSTEMWITHDRAWLIMIT > 0.8) {
				// 发送短信的电话号数组 朱艳 李婷 孟倩 余丹丹 张腾 赵国强
				String[] phoneArray = { "15311601876", "13810230289", "18811041717", "15212901293", "18811496100",
						"18500988114" }; // 最好从数据库中读出
				for (String phone : phoneArray) {
					//统一调用短信服务
					
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
				data.put(TCB.RETURN_ERROR, TCB.OVERSYSTEMLIMIT_MSG);
				data.put(TCB.RETURN_ERRNO, TCB.OVERSYSTEMLIMIT_CODE);
				data.put("amount", amount);
				json.put(TCB.RETURN_SUCCESS, success);
				json.put(TCB.RETURN_DATA, data);
				return json.toString();
			}
			// ----------- 2016-06-28 提现提醒 end--------//
			sinaUserInfoController.validateRealName(user.getId());
			Validate.amount(amount+0.0);
			// throw 查询余额错误,无法提现
			Long sinaBalance = withdrawSub.findSinaBalance(user.getId());
			sinaUserInfoController.updateSinaUserInfoByUserId(sinaBalance, user.getId());
			Integer fee = withdrawService.selectWithdrawFee(user.getId());
			withdrawSub.withDrawWarn(amount, fee, sinaBalance);
			String currentCycle = withdrawSub.findAccountAbnormal(user.getId(), amount, withdraw);
			String orderCode = OrderUtil.createOrderId("WIT", "PAY", user.getId());
			// 所有验证通过 写入了bill,再请求提现接口订单
			Long withdrawBillId = withdrawSub.saveWithdrawBill(user.getId(), amount, fee, orderCode, "2", ip,
					client, currentCycle);
			String fcallbackurl = withdrawSub.selectFcallbackurl(plat, host, amount);
			String sinaUrl = withdrawSub.selectSinaUrl(user.getId(), orderCode,amount.doubleValue(), fee.floatValue(), "SAVING_POT",
					fcallbackurl, ip);
			data.put("orderid", withdrawBillId);
			data.put("sinaURL", sinaUrl);
		} catch (ServiceException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (ControllerException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("提现确认(处理程序):" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}
}
