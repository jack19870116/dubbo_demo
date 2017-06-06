//package com.tiancaibao.controller.user;
//
//import javax.annotation.Resource;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.alibaba.fastjson.JSONObject;
//import com.tiancaibao.exception.ServiceException;
//import com.tiancaibao.pojo.SinaUserInfo;
//import com.tiancaibao.pojo.UserLoginLogs;
//import com.tiancaibao.pojo.Users;
//import com.tiancaibao.service.user.user.UserService;
//import com.tiancaibao.utils.BCrypt;
//import com.tiancaibao.utils.MD5Util;
//import com.tiancaibao.utils.RandomUtil;
//import com.tiancaibao.validate.Validate;
//
//@Controller
//@RequestMapping("/user")
//public class UserAuthController {
//
//	@Resource
//	private UserService userService;
//
//	private static Logger logger = Logger.getLogger(UserAuthController.class);
//
//	/**
//	 * 登录
//	 */
//	@RequestMapping("/login.do") // @RequestBody Map<String,String> params
//	@ResponseBody
//	public String postLogin(String phone, String password, String agent_num, String source, String system,
//			String app_version, String token) {
//		JSONObject resultInfo = new JSONObject();
//		try {
//			if (StringUtils.isNotBlank(token) && StringUtils.isBlank(source)) {
//				Users user = userService.selectUserByToken(token); // 根据token查询Users
//				if (user == null) {
//					resultInfo.put("success", "false");
//					resultInfo.put("error", "logout");
//					resultInfo.put("message", "未找到用户");
//					return resultInfo.toJSONString();
//				}
//				SinaUserInfo sinaUserInfo = userService.selectSinaUserInfoByUserId(user.getId());// usersid查询SinaUserInfo
//			} else {
//				// ===================参数验证start==================================
//				// 查询设备信息
//				@SuppressWarnings("unused")
//				Boolean succEqu = Validate.validateEquipment(agent_num, source, system);
//				// app版本比对
//				@SuppressWarnings("unused")
//				Boolean succApp = Validate.validateAppVersion(app_version);
//				// 手机号密码格式校验
//				@SuppressWarnings("unused")
//				Boolean succPhoPwd = Validate.validateLoginPhoPwd(phone, password);
//				// ===================参数验证end==================================
//				// 根据phone查询用户
//				Users user = userService.selectUserByPhone(phone);
//				if (user == null) {
//					resultInfo.put("success", "false");
//					resultInfo.put("error", "用户不存在");
//					resultInfo.put("message", "用户不存在");
//					return resultInfo.toJSONString();
//				} else {
//					// 校验密码
//					if (!BCrypt.checkpw(password, user.getPassword())) {
//						resultInfo.put("success", false);
//						resultInfo.put("error", "对不起,您的密码不正确");
//						resultInfo.put("message", "对不起,您的密码不正确");
//						return resultInfo.toJSONString();
//					}
//				}
//				// 不同设备号刷新token
//				if (!user.getAgentNum().equals(agent_num)) {
//					// token偏移，保证唯一
//					token = user.getId().toString() + agent_num + RandomUtil.getRandom10000();
//					token = MD5Util.md5(token);
//					// 根据用户id跟新agent_num
//					userService.updateUserRememberTokenById(token, user.getId());
//				}
//				// 更新UserLoginLog表 状态
//				UserLoginLogs userLoginLogs = userService.selectUserLoginLogsByuserIdAndAgentNum(user.getId(),
//						agent_num);
//				if (userLoginLogs == null) {
//					userService.saveUserLoginLogs(user.getId(), agent_num, source, system, token);
//				} else {
//					userService.updateUserLoginLogsById(token, system, userLoginLogs.getId());
//				}
//			}
//			resultInfo.put("success", true);
//			resultInfo.put("data", token);
//		} catch (ServiceException e) {
//			resultInfo.put("success", false);
//			resultInfo.put("error", e.getMessage());
//			resultInfo.put("message", e.getMessage());
//		} catch (Exception e) {
//			resultInfo.put("success", false);
//			resultInfo.put("error", "数据库连接异常");
//			e.printStackTrace();
//			logger.error("用户登陆:" + e.getMessage());
//		}
//		return resultInfo.toString();
//	}
//
//}
