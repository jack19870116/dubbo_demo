package com.tiancaibao.controller.redeem;

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
import com.tiancaibao.controller.redeem.sub.RedeemSub;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.invest.service.InvestService;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.redeem.service.RedeemService;
import com.tiancaibao.sinapay.service.SinaPayService;
import com.tiancaibao.sinauserinfo.service.SinaUserInfoService;
import com.tiancaibao.user.service.UserService;
import com.tiancaibao.utils.NumberFormat;
import com.tiancaibao.validate.Validate;

@Controller
@RequestMapping("/redeem")
public class RedeemController {
	private static Logger logger = Logger.getLogger(RedeemController.class);

	@Resource
	private SinaUserInfoController sinaUserInfoController;
	@Resource
	private UserService userService;
	@Resource 
	private RedeemService redeemService;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private SinaUserInfoService sinaUserInfoService;
	@Resource
	private BlackListService blackListService;
	@Resource
	private InvestService investService;
	@Resource
	private RedeemSub redeemSub;

	/**
	 * 查询赎回限额
	 * 
	 * @return
	 */
	@RequestMapping("/limit.do")
	@ResponseBody
	public String limit(String token) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				// 验证用户是否实名认证    绑卡
				Integer realnamecode = sinaUserInfoService.isRealName(user.getId());
				if (ServiceConstants.CODE_REALNAME_ALREADY.equals(realnamecode)) {
					Long lockAmount = blackListService.selectUserLockAmount(user.getId().intValue(), (byte) 1);
					// 活期未满赎回时间24h的总金额
					Long redeemCurrentLimit = investService.selectCurrentSumAmountNotWithDraw(user.getId());
					Double redeemNotSumAmount = NumberFormat.doubleSplitTwoDecimal((redeemCurrentLimit + 0.0) / 10000);
					success = true;
					data.put("limit", user.getAmount() - lockAmount - redeemNotSumAmount);
					if (redeemNotSumAmount == 0) {
						data.put("info", "");
					} else {
						data.put("limit", "小主，您有￥" + redeemNotSumAmount + "元活期投资未满24小时赎回时间哦~");
					}
					success = true;
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
	 * 赎回提交(处理程序)
	 * 
	 * @return
	 */
	@RequestMapping("/submit.do")
	@ResponseBody
	public String submit(String token, Double amount, String redeem, String ip, String client) {
		JSONObject json = new JSONObject();
		Boolean success = false;
		Map<String, Object> data = new HashMap<String, Object>(0);
		try {
			Users user = userService.selectUserByToken(token);
			Long userId = user.getId();
			// 判断输入金额
			Validate.amount(amount);
			// ----------- 2016-06-29 原来的黑名单和历史记录检查增加到活期赎回 start--------//
			// 检验用户黑名单
			Long lockAmount = blackListService.selectUserLockAmount(userId.intValue(), (byte) 1);
			// 赎回时间24h限制
			Long redeemCurrentLimit = investService.selectCurrentSumAmountNotWithDraw(user.getId());
			redeemSub.selectValidateUserRedeemAmount(amount, user.getAmount(), lockAmount, redeemCurrentLimit);
			// 判断用户以往的投资总额
			redeemSub.validateAccountRedeem(userId,amount,lockAmount);
			redeemSub.isSetPayPassword(userId);  
			// 验证是否绑定卡
			sinaUserInfoController.validateRealName(userId);
			//校验是否在redeem时间段内
			redeemSub.isTimeCanRedeem();
			// 每月活期赎回超过15w减天才值 //需要测试dao参数传递是否正确
			Double redeemAmountOutCurrentMonth = redeemSub.redeemAmountOutCurrentMonth(userId,amount);
			if(redeemAmountOutCurrentMonth>0&&"yes".equals(redeem)){
				data.put(TCB.RETURN_ERROR,"赎回超出限制");
				data.put("money", NumberFormat.doubleSplitTwoDecimal(redeemAmountOutCurrentMonth));
				data.put("talent_value", Math.ceil(redeemAmountOutCurrentMonth / 1000));
				data.put("status", 3);
				data.put("amount", amount);
			}else{
				// 活期减少
				Long curramount = (long) (user.getAmount() - amount); // 此处数据精度待确定
				user.setAmount(curramount);
				Long billid = redeemSub.reduceUserAmountAndSaveCollectionRecord(user,amount.longValue(),1,ip,client); 
				success = true;
				data.put("orderid", billid);
				data.put("amount", amount);
			}
			
		} catch (ServiceException e) {
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch(ControllerException e){
			data.put(TCB.RETURN_ERROR, e.getMessage());
		} catch (Exception e) {
			data.put(TCB.RETURN_ERROR, TCB.EXCEPTION_MSG);
			e.printStackTrace();
			logger.error("赎回提交(处理程序):" + e.getMessage());
		}
		json.put(TCB.RETURN_SUCCESS, success);
		json.put(TCB.RETURN_DATA, data);
		return json.toString();
	}
}
