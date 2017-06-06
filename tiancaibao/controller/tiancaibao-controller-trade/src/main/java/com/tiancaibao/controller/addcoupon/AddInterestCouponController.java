/*package com.tiancaibao.controller.addcoupon;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.AddInterestCoupons;
import com.tiancaibao.pojo.CashCoupons;
import com.tiancaibao.pojo.SystemAssets;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.service.addinterest.AddInterestService;
import com.tiancaibao.service.system.SystemService;
import com.tiancaibao.service.user.UserService;
import com.tiancaibao.utils.page.Pagination;

@Controller
@RequestMapping("/trade")
public class AddInterestCouponController {
	@Resource
	private SystemService systemService;
	@Resource
	private UserService userService;
	@Resource
	private AddInterestService addInterestService;

	*//**
	 * 分页查询加息券/红包
	 * 
	 * @param currPage
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param type
	 *            加息劵/红包
	 * @return
	 *//*
	@RequestMapping("/findRecord.do")        
	@ResponseBody							 //pageIndex 是指当前页还是sql语句中的startRow					
	public String findRecord(String token, Integer currPage, Integer pageSize, String type) {
		JSONObject json = new JSONObject();
		// 查询用户
		Users user = userService.selectUserByToken(token);
		//查询活期利率
		Long rate = systemService.selectRateOfSystemAssetRateByDay(1);
		switch (type) {
		case "interest":
			// 先判断列表加息劵是否过期，修改
			addInterestService.reviseExpireCoupon(user.getId());
			// 分页查询加息劵
			Pagination pagination =  addInterestService.selectCouponWithPage(currPage, pageSize, user.getId());
			json.put("success", true);
			json.put("data",pagination);
			json.put("rate", rate);
			break;
		case "coupon":
			// 先判断列表红包是否过期，修改之！
			addInterestService.reviseExpireCashCoupon(user.getId());
			// 分页查询红包
			Pagination paginations = addInterestService.selectCashCouponWithPage(currPage, pageSize, user.getId());
			json.put("success", true);
			json.put("data",paginations);
			json.put("rate", rate);
			break;
		default:
			json.put("success", false);
			json.put("error", type == null ? type : type + "格式错误");
			break;
		}

		return json.toString();
	}

	*//**
	 * pc端获取红包加息劵
	 * 
	 * @param token
	 * @param currPage
	 * @param pageSize
	 * @param type
	 * @return
	 *//*
	@RequestMapping("/selectRecordForPc.do")
	@ResponseBody
	public String selectRecordForPc(String token,@RequestParam(required=false,defaultValue="0") Integer currPage,@RequestParam(required=false,defaultValue="9") Integer pageSize, String type) {
		JSONObject json = new JSONObject();
		// 查询用户
		Users user = userService.selectUserByToken(token);
		Long userid = user.getId();
		if (currPage == null) {
			currPage = 0;
		}
		if (pageSize == null) {
			pageSize = 9;
		}
		
		Long rate = systemService.selectRateOfSystemAssetRateByDay(1);
		switch (type) {
		case "interest":
			// 先判断列表加息劵是否过期，修改
			addInterestService.reviseExpireCoupon(user.getId());
			List<AddInterestCoupons> aicList = addInterestService.selectAddInterestFromAddInterestCouponsByUserIdForPc(userid);
			json.put("success", true);
			json.put("data", aicList);
			json.put("rate", rate);
			break;
		case "coupon":
			// 先判断列表红包是否过期，修改之！
			addInterestService.reviseExpireCashCoupon(user.getId());
			// 查询红包
			List<CashCoupons> ccList = addInterestService.selectCouponsFromCashCouponsByUserIdForPc(userid);
			json.put("success", true);
			json.put("data", ccList);
			json.put("rate", rate);
			break;
		default:
			json.put("success", false);
			json.put("error", type == null ? type : type + "格式错误");
			break;
		}

		return json.toString();
	}

	*//**
	 * 使用加息劵的规则
	 * @param token
	 * @param id
	 * @return
	 *//*
	@RequestMapping("/useRuleCoupon.do")
	@ResponseBody
	public String useRuleCoupon(String token, Long id) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			if (user == null || user.getIdcardNumber() == null) {
				json.put("success", false);
				json.put("error", "未进行实名认证");
				return json.toString();
			}
			// 查询今日已使用加息劵的个数
			int usedCoponCount = addInterestService.selectUsedCouponCountByUsedAtAndUserId(user.getId());
			if (usedCoponCount != 0) {
				json.put("success", false);
				json.put("error", "每个用户每天只能使用一张加息券");
				return json.toString();
			}
			SystemAssets sa = systemService.selectSystemAssetByDay(1);
			AddInterestCoupons ac = addInterestService.selectAddInterestCouponById(id);
			if (ac == null) {
				json.put("success", false);
				json.put("error", "加息券不存在");
				return json.toString();
			}
			if ("USED".equals(ac.getStatus())) {
				json.put("success", false);
				json.put("error", "加息券已使用过了!");
				return json.toString();
			}
			if (ac.getUserId() == user.getId() && "AVAILABLE".equals(ac.getStatus())) {
				addInterestService.updateStatusAndUsedAtById("USED", id);
				Long rate = sa.getRate() + ac.getValue();
				json.put("success", true);
				json.put("message", "'您已使用" + ac.getValue() + "'% 的加息券，您今日年化收益率为" + rate + "%");
			}
		} catch (Exception e) {
			json.put("success", "false");
			json.put("error", "使用加息券失败");
			e.printStackTrace();
		}
		return json.toString();
	}

	*//**
	 * 邀请帮助好友获得1%加息券
	 * 
	 * @param phone
	 * @return
	 *//*
	@RequestMapping("/inviteAddInterest.do")
	@ResponseBody
	public String inviteAddInterest(String token, String phone) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Users inviter = userService.selectUserByPhone(phone);
			if (inviter == null) {
				json.put("success", false);
				json.put("error", "该用户不存在");
				return json.toString();
			}
			if (user != null && user.getInvitedByUserId() != null) {
				json.put("success", false);
				json.put("error", "抱歉，您已被邀请过");                //我被邀请就不能邀请别人了吗?
				return json.toString();
			}
			if (phone.equals(user.getPhone())) {
				json.put("success", false);
				json.put("error", "抱歉，自己不能邀请自己");
				return json.toString();
			}
			if (inviter.getInvitedByUserId() == user.getId()) {
				json.put("success", false);
				json.put("error", "抱歉，不允许互相邀请");
				return json.toString();
			}
			//下面要放在同一个事务中   分属不同的服务
			userService.updateUserSetInvitedByUserId(inviter.getId(),user.getId());
			addInterestService.addAddInterestCouponPercent(inviter.getId());
			json.put("success", true);
			json.put("message", "你已帮助好友获得1%加息券");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}
	
	*//**
	 * 确认是否今日可以使用加息劵              
	 * @param token
	 * @return
	 *//*
	@RequestMapping("/confirmUse.do")
	public String confirmUse(String token) {
		JSONObject json = new JSONObject();
		Users user = userService.selectUserByToken(token);
		if (user == null || user.getIdcardNumber() == null) {
			json.put("success", false);
			json.put("error", "未进行实名认证");
			return json.toString();
		}
		// 查询今日已使用加息劵的个数
		int usedCoponCount = addInterestService.selectUsedCouponCountByUsedAtAndUserId(user.getId());
		if (usedCoponCount != 0) {
			json.put("success", false);
			json.put("error", "每个用户每天只能使用一张加息券");
		}else{
			json.put("success",true);
		}
		return json.toString();
	}
}
*/