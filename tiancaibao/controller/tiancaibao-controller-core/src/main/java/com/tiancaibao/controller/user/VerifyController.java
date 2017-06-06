//package com.tiancaibao.controller.user;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSONObject;
//import com.tiancaibao.exception.ServiceException;
//import com.tiancaibao.pojo.IntegralSources;
//import com.tiancaibao.pojo.SinaUserInfo;
//import com.tiancaibao.pojo.TalentSource;
//import com.tiancaibao.pojo.Users;
//import com.tiancaibao.pojo.sina.BindingVerifyResponseParam;
//import com.tiancaibao.pojo.sina.CreateActivateMemberResponseParam;
//import com.tiancaibao.pojo.sina.QueryIsSetPayPasswordResponseParam;
//import com.tiancaibao.pojo.sina.QueryVerifyResponseParam;
//import com.tiancaibao.pojo.sina.SetRealNameResponseParam;
//import com.tiancaibao.service.impl.sinapay.SinaPayService;
//import com.tiancaibao.service.shop.IntegralService;
//import com.tiancaibao.service.system.SystemService;
//import com.tiancaibao.service.talentsource.TalentSourceService;
//import com.tiancaibao.service.test.SinaService;
//import com.tiancaibao.service.user.user.UserService;
//import com.tiancaibao.validate.Validate;
//
///**
// * 身份认证 + 新浪身份认证
// * 
// * @author Mack
// *
// */
//@Controller
//@RequestMapping("/verify")
//public class VerifyController {
//	private static Logger logger = Logger.getLogger(VerifyController.class);
//	@Resource
//	private UserService userService;
//	@Resource
//	private SinaPayService sinaPayService;
//	@Resource
//	private SystemService systemService;
//	@Resource
//	private TalentSourceService talentSourceService;
//	@Resource
//	private IntegralService integralService;
//
//	/**
//	 * 认证身份证号码处理程序
//	 * 
//	 * @param token
//	 * @param ip
//	 * @return
//	 */
//	@RequestMapping("/verifyIdCard.do")
//	public String verifyIdCard(String token, String ip, String idcard_name, String idcard_number) {
//		JSONObject json = new JSONObject();
//		try {
//			Users user = userService.selectUserByToken(token);
//			Long userid = user.getId();
//			SinaUserInfo sinauserinfo = userService.selectSinaUserInfoByUserId(userid);
//			if (user.getIdcardName() == null) { // 本地无记录
//				// 先验证姓名
//				Validate.validateIdCardName(idcard_name);
//				// 姓名合法时验证身份证
//				// ValidateService.validateIdCardNumber(idcard_name,idcard_number);
//			}
//			Map<String, Object> data = new HashMap<>();
//			data.put("idcard_name", idcard_name);
//			data.put("idcard_number", idcard_number);
//			data.put("phone", user.getPhone());
//			data.put("id", user.getId());
//			data.put("ip", ip);
//			// 调用新浪查询接口认证信息
//			QueryVerifyResponseParam qvrp = sinaPayService.query_verify(userid, "ID");
//			if (qvrp == null) {
//				json.put("success", false);
//				json.put("error", "请求未正确返回，请联系客服!");
//				return json.toString();
//			}
//			if ("APPLY_SUCCESS".equals(qvrp.getResponse_code()) && "提交成功".equals(qvrp.getResponse_message())
//					&& StringUtils.isNotBlank(qvrp.getVerify_entity())) {
//				if (sinauserinfo == null) {
//					userService.insertUserIdAndPhoneToSinaUserInfo(userid, user.getPhone());
//				} else if (sinauserinfo.getPhone() == null) {
//					userService.updateSinaUserInfoSetPhoneById(user.getPhone(), sinauserinfo.getId());
//				} else {
//					userService.updateSinaUserInfoSetPhoneById(qvrp.getVerify_entity(), sinauserinfo.getId());
//				}
//				json.put("success", false);
//				json.put("error", "已认证过了");
//			} else if ("VERIFY_NOT_EXIST".equals(qvrp.getResponse_code())
//					|| "MEMBER_NOT_EXIST".equals(qvrp.getResponse_code())) {
//				// 调用新浪创建用户接口
//				CreateActivateMemberResponseParam camrp = sinaPayService.create_activate_member(userid, ip);
//				if ("APPLY_SUCCESS".equals(camrp.getResponse_code())
//						|| "DUPLICATE_IDENTITY_ID".equals(camrp.getResponse_code())) {
//					SetRealNameResponseParam srnrp = sinaPayService.set_real_name(userid,idcard_number,idcard_name,ip);
//					if (srnrp == null || srnrp.getResponse_code() == null) {
//						json.put("success", false);
//						json.put("error", "请求新浪接口失败,请重试!");
//						return json.toString();
//					}
//					if ("APPLY_SUCCESS".equals(srnrp.getResponse_code())) {
//						json.put("success", false);
//						json.put("error", srnrp.getResponse_message());
//						return json.toString();
//					}
//					// 调用新浪绑定认证信息接口
//					BindingVerifyResponseParam bvrp = sinaPayService.binding_verify(userid, user.getPhone(),ip);
//					if (!"APPLY_SUCCESS".equals(bvrp.getResponse_code())) {
//						json.put("success", false);
//						json.put("error", bvrp.getResponse_message());
//						return json.toString();
//					} else {
//						String birthday = idcard_number.substring(10, 12) + "-" + idcard_number.substring(12, 14);
//						userService.updateUserById(idcard_name, idcard_number, birthday, userid);
//						if (sinauserinfo == null) {
//							userService.insertSinaUserInfo(userid, user.getPhone());
//						} else if (sinauserinfo.getPhone() == null) {
//							userService.updateSinaUserInfoById(userid, user.getPhone(), sinauserinfo.getId());
//						}
//						// 实名认证天才值变动
//						TalentSource talentSource = systemService.selectTalentSourceById(3);
//						if (talentSource != null && talentSource.getPublishedAt() != null
//								&& talentSource.getPublishedAt().compareTo(user.getCreatedAt()) < 0) {
//							int count = talentSourceService.selectCountChangeTalentValueRecordByUserIdAndSourceId(
//									userid, talentSource.getSourceId());
//							if (count == 0) {
//								Long talentValue = user.getTalentValue() + talentSource.getTalent();
//								user.setTalentValue(talentValue);
//								userService.updateTalentValueOfUserById(talentValue, userid);
//								talentSourceService.insertChangeTalentValueRecord(userid, talentSource.getTalent(),
//										talentValue, new Date(), talentSource.getSourceId());
//							}
//						}
//						// 是否有邀请人
//						Users inviter = null;
//						if (user.getInvitedByUserId() != null) {
//							inviter = userService.selectUserById(user.getInvitedByUserId());
//						}
//						// 积分变动
//						IntegralSources integralSource = systemService.selectIntegralSourceById(5);
//						if (inviter != null) {
//							Integer interest = inviter.getIntegral() + integralSource.getIntegral(); // 此处不应该是邀请人的积分吗?
//							integralService.insertIntegralRecord(inviter.getId(), integralSource.getIntegral(),
//									integralSource.getId(), user.getIntegral());
//							userService.updateIntegralOfInviterById(interest, inviter.getId());
//						}
//						// 实名认证成功事件，给推荐人发加息券 //基于消息中间件完成
//						// new RealNameVerifySuccessEvent($user));
//						json.put("success", true);
//						json.put("error", "实名认证成功");
//						return json.toString();
//					}
//
//				} else {
//					json.put("success", false);
//					json.put("error", "新浪返回错误信息:" + camrp.getResponse_message());
//				}
//			} else {
//				json.put("success", false);
//				json.put("error", "新浪返回错误信息:" + qvrp.getResponse_message());
//			}
//		} catch (ServiceException e) {
//			json.put("success", false);
//			json.put("error", e.getMessage());
//		} catch (Exception e) {
//			logger.error("认证身份证号码处理程序:" + e.getMessage());
//		}
//		return json.toString();
//	}
//
//	@RequestMapping("/verifycard.do")
//	@ResponseBody
//	public String verifyCard(String token) {
//		JSONObject json = new JSONObject();
//		try {
//			Users user = userService.selectUserByToken(token);
//			if(user!=null&&user.getIdcardNumber()!=null){
//				QueryVerifyResponseParam qvrp = sinaPayService.query_verify(user.getId(), "ID");
//				if(qvrp!=null&&"提交成功".equals(qvrp.getResponse_message())&&"APPLY_SUCCESS".equals(qvrp.getResponse_code())){
//					json.put("success",false);
//					json.put("error", "数据库中已经存在记录并且新浪回复已认证过!");
//					return json.toString();
//				}
//			}
//			json.put("success", true);
//			json.put("user", user);
//		} catch (Exception e) {
//			logger.error("verifycard:"+e.getMessage());
//		}
//		return json.toString();
//	}
//
//}
