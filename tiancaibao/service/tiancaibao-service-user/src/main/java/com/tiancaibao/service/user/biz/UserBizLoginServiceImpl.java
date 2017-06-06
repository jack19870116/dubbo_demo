package com.tiancaibao.service.user.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.user.UserLoginLogs;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.user.IUserLoginLogsService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.user.biz.IUserBizLoginService;
import com.tiancaibao.utils.BCrypt;
import com.tiancaibao.utils.JedisUtil;
import com.tiancaibao.utils.MD5Util;
import com.tiancaibao.utils.ValidateUtil;
import com.tiancaibao.validate.Validate;

@Service("userBizLoginService")
public class UserBizLoginServiceImpl implements IUserBizLoginService {

	@Resource
	IUserService userService;

	@Resource
	IUserLoginLogsService loginLogService;

	@Override
	public String Login(String phone, String password, String agent_num, String source, String system,
			String app_version, String is_encryption) {
		JSONObject json = new JSONObject();
		if (agent_num == null || agent_num.equals("") || source == null || source.equals("") || system == null
				|| system.equals("")) {
			json.put("success", false);
			json.put("error", "获取设备信息失败");
			json.put("message", "获取设备信息失败");
			return json.toString();
		}

		try {
			Validate.validatePhone(phone);
			if ("is_false".equals(is_encryption) || "0".equals(is_encryption)) {
				if (!ValidateUtil.isAlphaNum(password)) {
					json.put("success", false);
					json.put("error", "密码输入有误!");
					json.put("message", "密码输入有误!");
					return json.toString();
				}
			} else {
				Validate.validatePasswordMd5(password);
			}

		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			json.put("message", e.getMessage());
			return json.toString();
		}

		Users selectUserByPhone = userService.selectUserByPhone(phone);

		if (selectUserByPhone != null) {
			int errorCount = 0;
			// 从redis中获取error次数
			String errorStr = JedisUtil.getJedis().get(phone + "errorCount");

			if ("is_false".equals(is_encryption) && selectUserByPhone.getIsEncryption()) {
				if (!BCrypt.checkpw(MD5Util.md5(password), selectUserByPhone.getPassword())) {
					if (errorStr == null) {
						JedisUtil.setString(phone + "errorCount", JedisUtil.EXRP_HALF_HOUR, "1");
						JedisUtil.setString(phone + "errorCount", JedisUtil.EXRP_HALF_HOUR, "1");
						json.put("success", false);
						json.put("error", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
						json.put("message", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
					} else {
						errorCount = Integer.parseInt(errorStr);
						if (errorCount == 3) {
							json.put("success", false);
							json.put("error", "登录错误次数超3次!对不起，请您在半小时之后登录!");
							json.put("message", "登录错误次数超3次!对不起，请您在半小时之后登录!");
						} else if (errorCount < 3) {
							json.put("success", false);
							json.put("error", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
							json.put("message", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
							JedisUtil.setString(phone + "errorCount", JedisUtil.EXRP_HALF_HOUR,
									String.valueOf(errorCount + 1));
						}
					}
					return json.toString();

				}

			} else {
				if (!BCrypt.checkpw(password, selectUserByPhone.getPassword())) {
					if (errorStr == null) {
						JedisUtil.setString(phone + "errorCount", JedisUtil.EXRP_HALF_HOUR, "1");
						json.put("success", false);
						json.put("error", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
						json.put("message", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
					} else {
						errorCount = Integer.parseInt(errorStr);
						if (errorCount == 3) {
							json.put("success", false);
							json.put("error", "登录错误次数超3次!对不起，请您在半小时之后登录!");
							json.put("message", "登录错误次数超3次!对不起，请您在半小时之后登录!");
						} else if (errorCount < 3) {
							json.put("success", false);
							json.put("error", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
							json.put("message", "登录密码错误!对不起，您还有" + (3 - errorCount) + "次登录机会!");
							JedisUtil.setString(phone + "errorCount", JedisUtil.EXRP_HALF_HOUR,
									String.valueOf(errorCount + 1));
						}
					}
					return json.toString();

				}

			}

		} else {

			json.put("success", false);
			json.put("error", "用户不存在");
			json.put("message", "用户不存在");
			return json.toString();

		}

		String token = MD5Util.md5(selectUserByPhone.getId() + selectUserByPhone.getPhone() + Math.random() * 10000);
		if (selectUserByPhone.getRememberToken() == null || selectUserByPhone.getRememberToken().equals("")) {
			/**
			 * 没有token更新
			 */
			userService.updateUserRememberTokenById(selectUserByPhone.getId(), token,
					selectUserByPhone.getRememberToken());

		}
		/**
		 * 查询更新之后的数据
		 */
		selectUserByPhone = userService.selectUserByPhone(phone);

		UserLoginLogs UserLoginLogs = loginLogService.selectUserLoginLogsByuserIdAndAgentNum(selectUserByPhone.getId(),
				agent_num);

		if (UserLoginLogs == null) {
			// 没有记录就创建
			loginLogService.saveUserLoginLogs(selectUserByPhone.getId(), agent_num, source, system, token);
		} else {
			// 有记录也创建新的记录 待定
			loginLogService.saveUserLoginLogs(selectUserByPhone.getId(), agent_num, source, system, token);

		}
		if (!selectUserByPhone.getIsEncryption()) {
			userService.updateUserPasswordByIdMD5(selectUserByPhone.getId(), MD5Util.MD5(password),
					selectUserByPhone.getPassword(), true);
		}
		//返回登录成功
		json.put("success", true);
		JSONObject data = new JSONObject();
		data.put("token", selectUserByPhone.getRememberToken());
		data.put("phone", selectUserByPhone.getPhone());
		data.put("userInfo", selectUserByPhone);
		json.put("data", data);
		return json.toString();
	}

	// @Override
	// public String LoginData(String token) {
	// JSONObject json = new JSONObject();
	// if ("".equals(token) || token == null) {
	//
	// json.put("success", false);
	// json.put("error", "参数不正确!");
	// json.put("message", "参数不正确!");
	// return json.toString();
	// }
	// Users users = userService.selectUserByToken(token);
	// if (users == null) {
	//
	// json.put("success", false);
	// json.put("error", "logout");
	// json.put("message", "");
	// return json.toString();
	//
	// }
	//
	// PaySinaUserInfo sinaUserInfo =
	// sinaUserInfoService.selectByUserId(users.getId());
	//
	// Long systemAssetRate = systemService.selectRateOfSystemAssetRateByDay(1);
	//
	// CouponsCurrentInterestratesCoupons AddInterestCoupon =
	// couponsCurrentInterestservice
	// .selectAddInterestCouponByUserIdAndUsedAtToday(users.getId(), new
	// Date());
	//
	// Long value = AddInterestCoupon.getValue() == null ? systemAssetRate +
	// AddInterestCoupon.getValue()
	// : systemAssetRate;
	//
	// int days = DateUtil.betweenDate(2) ? -2 : -1;
	//
	// SystemAssetIncreaseRecords systemAssetIncreaseRecords =
	// systemAssetIncreaseRecordsService.select(users.getId(),
	// DateUtil.addDaysTime(days));
	// Long amount = Long.parseLong("0");
	// if (systemAssetIncreaseRecords != null &&
	// systemAssetIncreaseRecords.getAmount() != null
	// && !"".equals(systemAssetIncreaseRecords.getAmount())) {
	// amount = systemAssetIncreaseRecords.getAmount();
	// }
	//
	// Double balance = 0.0;
	// String idcard_name = users.getIdcardName();
	// String idcard_number = users.getIdcardNumber();
	// String bankCard = "";
	// if (sinaUserInfo != null && sinaUserInfo.getPhone() != null &&
	// !"".equals(sinaUserInfo.getPhone())) {
	//
	// if (sinaUserInfo.getSinapayBankCard() != null) {
	// bankCard = sinaUserInfo.getSinapayBankCard();
	// QueryBalanceResponseParam query_balance =
	// paySinaPayService.query_balance(users.getId());
	//
	// if (query_balance != null
	// && (query_balance.getResponse_code() == null ||
	// query_balance.getResponse_message() == null)) {
	//
	// json.put("success", false);
	// json.put("error", "查询余额出错");
	// json.put("message", "查询余额出错");
	// return json.toString();
	//
	// }
	// balance = query_balance.getBalance() != null &&
	// query_balance.getResponse_code().equals("APPLY_SUCCESS")
	// ? query_balance.getBalance() : 0L;
	// sinaUserInfoService.updateSinapayAmountById(Long.parseLong(balance + ""),
	// sinaUserInfo.getId());
	//
	// }
	//
	// } else {
	// idcard_name = "";
	// idcard_number = "";
	// bankCard = "";
	// }
	// Long sum_asset = users.getAccountAmount() + users.getFixedAmount() +
	// users.getAmount()
	// + Long.parseLong(balance + "");
	// String recharge_http = "";// 暂时空缺
	// Integer sex;
	// if (users.getIdcardNumber() == null) {
	//
	// sex = -1;
	// } else {
	// IdcardInfoExtractor ie = new
	// IdcardInfoExtractor(users.getIdcardNumber());
	// sex = ie.getGender().equals("女") ? 1 : 0;
	//
	// }
	//
	// return null;
	// }
	//
	// public static void main(String[] args) {
	// int days = DateUtil.betweenDate(2) ? -2 : -1;
	// System.out.println(days);
	//
	// }

}
