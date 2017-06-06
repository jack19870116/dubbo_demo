/*package com.tiancaibao.controller.pms;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.SystemAssets;
import com.tiancaibao.service.system.SystemService;
import com.tiancaibao.service.trade.InvestService;
import com.tiancaibao.service.user.UserService;
import com.tiancaibao.service.withdraw.WithdrawService;

@Controller
@RequestMapping("/pms")
public class DmsController {

	private static Logger logger = Logger.getLogger(DmsController.class);

	@Resource
	private SystemService systemService;
	@Resource
	private UserService userService;
	@Resource
	private InvestService investService;
	@Resource
	private WithdrawService withdrawService;

	*//**
	 * 接受PMS推送的份额amount
	 * 
	 * @param amount
	 *            份额
	 * @param days
	 *            产品期限，活期为1天
	 * @param product_sign
	 *            标识
	 * @param request_no
	 *            推送编号，不可重复
	 * @return
	 *//*
	@RequestMapping("/dmsamount.do")
	@ResponseBody
	public String dmsamount(Long amount, Integer days, String product_sign, String request_no) {
		JSONObject json = new JSONObject();
		try {
			Integer dmsRecord = systemService.selectCountSystemAssetAddRecordsByRequestNo(request_no);
			if (dmsRecord > 0) {
				json.put("status", false);
				json.put("message", "请求失败,失败信息为:该记录已经推送过");
				return json.toString();
			} else {
				SystemAssets systemAmount = systemService.selectSystemAssetByDay(days);
				if (systemAmount == null) {
					systemService.saveSystemAssetAndSystemAssetAddRecords(amount, days, product_sign, request_no);
					json.put("success", true);
					return json.toString();
				}
				// 添加份额
				Long remainamount = systemAmount.getRemainAmount() + amount;
				systemService.addRemainamountByIdAndSaveSystemAssetAddRecords(systemAmount.getId(), remainamount,
						product_sign, amount, days, request_no);
				json.put("success", true);
				return json.toString();
			}
		} catch (Exception e) {
			logger.error("接受PMS推送的份额amount:" + e.getMessage());
			json.put("status", false);
			json.put("message", "请求失败,失败信息为:系统错误,添加失败");
		}
		return json.toString();
	}

	*//**
	 * 接受PMS推送的利率rate
	 * 
	 * @param rate
	 * @param days
	 * @param product_sign
	 * @return
	 *//*
	@RequestMapping("/dmsrate.do")
	@ResponseBody
	public String dmsrate(Long rate, Integer days, String product_sign) {
		JSONObject json = new JSONObject();
		try {
			SystemAssets systemRate = systemService.selectSystemAssetByDay(days);
			if (systemRate == null) {
				systemService.saveSystemAsset(0L, 0L, rate, product_sign, days);
				json.put("success", true);
				return json.toString();
			}
			systemService.updateSystemAssetsById(product_sign, rate, systemRate.getId());
			json.put("success", true);
			return json.toString();
		} catch (Exception e) {
			logger.error("接受PMS推送的利率rate:" + e.getMessage());
			json.put("status", false);
			json.put("message", "请求失败,失败信息为:系统错误,添加失败");
		}
		return json.toString();
	}
	
	*//**
	 * 向PMS返回线上余额，冻结份额，用户持有，用户赎回
	 * @param product_sign
	 * @return
	 *//*
	@RequestMapping("/dmsdata.do")
	@ResponseBody
	public String dmsdata(String product_sign) {
		JSONObject json = new JSONObject();
		try {
			SystemAssets systemAsset = systemService.selectSystemAssetById(product_sign);
			Long userAmount = userService.sumAmount();
			Long investAmount = investService.selectSumAmountInvestRecordByProductSign(product_sign);
			Long redeem_amount = withdrawService.selectSumAmount(); // 一版提现即赎回
			json.put("success", true);
			json.put("remain_amount",systemAsset.getRemainAmount());  //空指针异常
			json.put("freeze_amount",systemAsset.getFreezeAmount());
			json.put("user_amount",userAmount/10000);   //数据精度
			json.put("invest_amount",investAmount/10000);
			json.put("redeem_amount",redeem_amount/10000);
		} catch (Exception e) {
			logger.error(" 向PMS返回线上余额，冻结份额，用户持有，用户赎回:" + e.getMessage());
			json.put("status", false);
			json.put("message", "请求失败");
		}
		return json.toString();
	}
}
*/