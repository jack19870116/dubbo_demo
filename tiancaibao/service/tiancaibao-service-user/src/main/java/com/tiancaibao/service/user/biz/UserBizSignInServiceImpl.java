package com.tiancaibao.service.user.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.integral.IntegralRecords;
import com.tiancaibao.pojo.user.UserSignIns;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.integral.IIntegralService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.user.IUserSignInService;
import com.tiancaibao.service.interfaces.user.biz.IUserBizSignInService;
import com.tiancaibao.utils.DateUtil;


@Service("userBizSignInService")
public class UserBizSignInServiceImpl implements IUserBizSignInService {

	@Resource
	private IUserService userService;
	@Resource
	private IIntegralService integralService;

	@Resource
	private IUserSignInService signInService;

	@Resource
	private IMqMessageService mqMessageSender;

	private static final Logger log = LoggerFactory.getLogger(UserBizSignInServiceImpl.class);

	public String signIn(String token) {
		JSONObject json = new JSONObject();
		Users user = userService.selectUserByToken(token);
		IntegralRecords integralRecords = integralService
				.selectIntegralRecordByUserIdAndSourceAndCreateAtCurrentDayFirst(user.getId(), 1);
		try {
			
			//清除缓存
			userService.clearUserCache(user);
			
			// 未签到
			if (!signInService.selectUserIsSignInByUserId(user.getId())) {
				/**
				 * 获取用户最近签到记录
				 */
				UserSignIns userSignIns = signInService.selectSignInByUserIdAndOrderByCreateAtFirst(user.getId(),
						"desc");
				/**
				 * 判断是否连续签到 formatDateByFormat
				 */
				if (userSignIns != null) {
					Date changeDate = DateUtil.afterNDay(userSignIns.getSignDate(), 1);
					String formatDate = DateUtil.formatDateByFormat(new Date(), DateUtil.DATE_FORMAT);
					if (DateUtil.isEqual(changeDate, DateUtil.parseDate(formatDate))) {
						int signIntegral;
						int integraltomorrow;
						switch (user.getSignNum() + 1) {
						case 1:
							signIntegral = 2;
							integraltomorrow = 4;
							break;
						case 2:
							signIntegral = 4;
							integraltomorrow = 6;
							break;
						case 3:
							signIntegral = 6;
							integraltomorrow = 8;
							break;
						case 4:
							signIntegral = 8;
							integraltomorrow = 10;
							break;
						case 5:
							signIntegral = 10;
							integraltomorrow = 10;
							break;
						default:
							signIntegral = 10;
							integraltomorrow = 10;
							break;
						}
						/**
						 * 签到记录表添加记录
						 */
						signInService.insertTableSignIns(user.getId());

						/**
						 * 连续签到用户sign_num+1
						 * 
						 */
						
						
						int j = userService.updateIntegralAndSignNum(user.getId(), user.getIntegral() + signIntegral,
								user.getSignNum() + 1);
						if (j != 1) {
							json.put("success", false);
							json.put("error", "更新用户积分失败");
						}
						UserSignIns lastUserSignIns = signInService
								.selectSignInByUserIdAndOrderByCreateAtFirst(user.getId(), "desc");
						/**
						 * 给积分模块发消息
						 */
						JSONObject integralQueue = new JSONObject();
						integralQueue.put("userId", user.getId());
						integralQueue.put("serviceName", "signInService");
						integralQueue.put("source", 1);
						integralQueue.put("integral", user.getIntegral() + signIntegral);
						integralQueue.put("remark", String.valueOf(lastUserSignIns.getId()));
						mqMessageSender.sendMessage("integralQueue", integralQueue.toString());
						/**
						 * 返回前台数据
						 */
						JSONObject data = new JSONObject();
						data.put("integral", signIntegral);
						data.put("days", user.getSignNum() + 1);
						data.put("integral_tomorrow", integraltomorrow);
						data.put("holiday_msg", "");
						data.put("signin_today", false);
						json.put("success", true);
						json.put("is_sign", false);
						json.put("data", data);
					} else {
						/**
						 * 签到记录表添加记录
						 */
						signInService.insertTableSignIns(user.getId());
						/**
						 * 用户表中积分变动
						 */
						int i = userService.updateIntegralAndSignNum(user.getId(), user.getIntegral() + 2, 1);
						if (i != 1) {
							json.put("success", false);
							json.put("error", "更新用户积分失败");
						}
						UserSignIns lastUserSignIns = signInService
								.selectSignInByUserIdAndOrderByCreateAtFirst(user.getId(), "desc");
						/**
						 * 添加积分记录==给积分模块发消息
						 */
						JSONObject integralQueue = new JSONObject();
						integralQueue.put("userId", user.getId());
						integralQueue.put("signIntegral", 2);
						integralQueue.put("serviceName", "signInService");
						integralQueue.put("source", 1);
						integralQueue.put("integral", user.getIntegral() + 2);
						integralQueue.put("remark", String.valueOf(lastUserSignIns.getId()));
						mqMessageSender.sendMessage("integralQueue", integralQueue.toString());

						/**
						 * 返回前台数据
						 */
						JSONObject data = new JSONObject();
						data.put("integral", 2);
						data.put("days", 1);
						data.put("integral_tomorrow", 4);
						data.put("holiday_msg", "");
						data.put("signin_today", false);
						json.put("success", true);
						json.put("is_sign", false);
						json.put("data", data);
					}
				} else {
					/**
					 * 签到记录表添加记录
					 */
					signInService.insertTableSignIns(user.getId());
					/**
					 * 用户表中积分变动
					 */
					int i = userService.updateIntegralAndSignNum(user.getId(), user.getIntegral() + 2, 1);
					if (i != 1) {
						json.put("success", false);
						json.put("error", "更新用户积分失败");
					}
					UserSignIns lastUserSignIns = signInService
							.selectSignInByUserIdAndOrderByCreateAtFirst(user.getId(), "desc");
					/**
					 * 添加积分记录==给积分模块发消息
					 */
					JSONObject integralQueue = new JSONObject();
					integralQueue.put("userId", user.getId());
					integralQueue.put("signIntegral", 2);
					integralQueue.put("source", 1);
					integralQueue.put("integral", user.getIntegral() + 2);
					integralQueue.put("remark", String.valueOf(lastUserSignIns.getId()));
					integralQueue.put("serviceName", "signInService");
					mqMessageSender.sendMessage("integralQueue", integralQueue.toString());

					/**
					 * 返回前台数据
					 */
					JSONObject data = new JSONObject();
					data.put("integral", 2);
					data.put("days", 1);
					data.put("integral_tomorrow", 4);
					data.put("holiday_msg", "");
					data.put("signin_today", false);
					json.put("success", true);
					json.put("is_sign", false);
					json.put("data", data);
				}
			} else {
				Integer signNum = user.getSignNum();
				int tomorrowIntegral;
				if (signNum < 5) {
					tomorrowIntegral = (signNum + 1) * 2;
				} else {
					tomorrowIntegral = 10;
				}
				JSONObject data = new JSONObject();
				
				json.put("success", true);
				json.put("error", "今天已签到");
				json.put("is_sign", true);
				data.put("integral", integralRecords.getIntegral());
				data.put("days", signNum);
				data.put("integral_tomorrow", tomorrowIntegral);
				data.put("signin_today", true);
				data.put("holiday_msg", "");
				json.put("data", data);
				
				
//				data.put("userId", user.getId());
//				data.put("integral", integralRecords.getIntegral());
//				data.put("integral_tomorrow", tomorrowIntegral);
//				data.put("signin_today", true);
//				data.put("holiday_msg", "");
//				json.put("success", true);
//				json.put("error", "今天已签到");
//				json.put("is_sign", true);
//				json.put("data", data);
			}
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			return json.toString();
		} catch (Exception e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			e.printStackTrace();
			log.error(" 用户信息签到处理:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 获取用户近两个月的签到记录
	 */
	@Override
	public String postSignRecord(String token) {
		JSONObject json = new JSONObject();
		Users user = userService.selectUserByToken(token);
		/**
		 * 获取当月签到的签到时间列表
		 */
		List<UserSignIns> months = signInService.selectSignInListByUserIdAndCreateAtOrderByCreateAt(user.getId(), "asc",
				"current");

		/**
		 * 获取上月签到的签到时间列表
		 */
		List<UserSignIns> lastMonths = signInService.selectSignInListByUserIdAndCreateAtOrderByCreateAt(user.getId(),
				"asc", "last");
		List<Date> list = new ArrayList<Date>();
		List<Date> list1 = new ArrayList<>();
		if (months == null && lastMonths == null) {
			JSONObject data = new JSONObject();
			data.put("lastmonth", null);
			data.put("month", null);
			json.put("success", true);
			json.put("error", "没有您的签到记录");
			json.put("data", data);
			return json.toString();
		} else {
			JSONObject data = new JSONObject();
			if (months.size() > 0) {
				for (UserSignIns userSignIns : months) {
					list.add(userSignIns.getSignDate());
				}
			}
			if (months.size() > 0) {
				for (UserSignIns userSignIns : lastMonths) {
					list1.add(userSignIns.getSignDate());
				}
			}
			data.put("lastmonth", list1);
			data.put("month", list);
			json.put("success", true);
			json.put("error", "");
			json.put("data", data);
			return json.toString();
		}
	}

}
