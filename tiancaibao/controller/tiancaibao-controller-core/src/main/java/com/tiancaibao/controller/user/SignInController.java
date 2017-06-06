package com.tiancaibao.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.user.biz.IUserBizSignInService;

@Controller
@RequestMapping("/user")
public class SignInController {

	@Resource
	private IUserBizSignInService userBizSignInService;

	@RequestMapping(value = "/SignIn.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postSignIn(HttpServletRequest request, String token) {
		return userBizSignInService.signIn(token);
	}

	@RequestMapping(value = "/PostSignRecord.do", method = { RequestMethod.POST })
	@ResponseBody
	public String postSignRecord(HttpServletRequest request, String token) {
		return userBizSignInService.postSignRecord(token);
	}
	// /**
	// * 签到处理程序(***好好测试一下此方法)
	// *
	// * @param token
	// * @return
	// */
	// @RequestMapping("/sign.do")
	// @ResponseBody
	// public String sign(String token) {
	// JSONObject json = new JSONObject();
	// try {
	// Map<String, Object> data = new HashMap<String, Object>();
	// Users user = userService.selectUserByToken(token);
	// Long userid = user.getId();
	// SignIns signin =
	// userService.selectSignInByUserIdAndOrderByCreateAtFirst(userid, "desc");
	// Integer integral_tomorrow = null;
	// Integer integral = null;
	// if (signin != null) {
	// if (DateUtil.formatDate(new
	// Date()).equals(DateUtil.formatDate(signin.getSignDate()))) {
	// if (user.getSignNum() < 5) {
	// integral_tomorrow = user.getSignNum() + 1;
	// } else {
	// integral_tomorrow = 10;
	// }
	// IntegralRecords integralRecord = integralService
	// .selectIntegralRecordByUserIdAndSourceAndCreateAtCurrentDayFirst(userid,
	// 1);
	//
	// if (integralRecord != null) {
	// integral = integralRecord.getIntegral();
	// }
	// data.put("days", user.getSignNum());
	// data.put("signin_today", true);
	// json.put("error", "今天已签到");
	// json.put("is_sign", true);
	// }
	// }
	// // 没有签到 没有连续签到的重头算起
	// Integer signinlistCount =
	// userService.selectSignInCountByUserIdOrderByCreatedAt(userid, "desc");
	// if (signinlistCount == 0 || !DateUtil.formatDate(DateUtil.afterNDay(new
	// Date(), -1))
	// .equals(DateUtil.formatDate(signin.getSignDate()))) {
	// signInService.insertTableSignInAndIntegralRecordAndUpdateUserForResetSignIn(userid,
	// 1, 1,
	// user.getIntegral(), 1);
	// integral = 1;
	// integral_tomorrow = 2;
	// data.put("days", 1);
	// data.put("signin_today", false);
	// json.put("is_sign", false);
	// }
	// if (DateUtil.formatDate(DateUtil.afterNDay(new Date(), -1))
	// .equals(DateUtil.formatDate(signin.getSignDate()))) {
	// user.setSignNum(user.getSignNum() + 1);
	//
	// switch (user.getSignNum()) {
	// case 1:
	// integral = 1;
	// integral_tomorrow = 2;
	// break;
	// case 2:
	// integral = 2;
	// integral_tomorrow = 3;
	// break;
	// case 3:
	// integral = 3;
	// integral_tomorrow = 4;
	// break;
	// case 4:
	// integral = 4;
	// integral_tomorrow = 5;
	// break;
	// case 5:
	// integral = 5;
	// integral_tomorrow = 10;
	// break;
	// default:
	// integral = 10;
	// integral_tomorrow = 10;
	// break;
	// }
	// signInService.insertTableSignInAndIntegralRecordAndUpdateUserForResetSignIn(userid,
	// integral, 1,
	// user.getIntegral(), user.getSignNum());
	// data.put("days", user.getSignNum());
	// data.put("signin_today", false);
	// json.put("is_sign", false);
	// }
	// data.put("integral", integral);
	// data.put("integral_tomorrow", integral_tomorrow);
	// data.put("holiday_msg", "");
	// json.put("success", true);
	// json.put("data", data);
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error("签到处理程序:" + e.getMessage());
	// }
	// return json.toString();
	// }
	//
	// /**
	// * 获取近来两个月签到记录
	// *
	// * @param token
	// * @return
	// */
	// @RequestMapping("/signRecord.do")
	// @ResponseBody
	// public String signRecordTwoMonths(String token) {
	// JSONObject json = new JSONObject();
	// try {
	// Users user = userService.selectUserByToken(token);
	// Long userid = user.getId();
	// List<SignIns> currentMonthRecord =
	// userService.selectSignInListByUserIdAndCreateAtOrderByCreateAt(userid,
	// "asc", "current");
	// List<SignIns> lastMonthRecord =
	// userService.selectSignInListByUserIdAndCreateAtOrderByCreateAt(userid,
	// "asc", "last");
	// Map<String, Object> data = new HashMap<String, Object>();
	// data.put("month", currentMonthRecord);
	// data.put("lastmonth", lastMonthRecord);
	// json.put("error", "");
	// if (currentMonthRecord == null && lastMonthRecord == null) {
	// json.put("error", "没有您的签到记录");
	// }
	// json.put("success", true);
	// json.put("data", data);
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error("获取近来两个月签到记录:" + e.getMessage());
	// }
	// return json.toString();
	// }

}
