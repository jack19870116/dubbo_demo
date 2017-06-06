package com.tiancaibao.service.pay.biz;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.sina.BindingVerifyResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateActivateMemberResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryVerifyResponseParam;
import com.tiancaibao.pojo.pay.sina.SetRealNameResponseParam;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.pay.biz.IPayBizVerifyIdCardService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.validate.IdcardInfoExtractor;
import com.tiancaibao.validate.Validate;

@Service("payBizVerifyIdCardService")
public class PayBizVerifyIdCardServiceImpl implements IPayBizVerifyIdCardService {

	@Resource
	private IUserService userService;
	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;
	@Resource
	private IPaySinaPayService paySinaPayService;

	@Resource
	private IMqMessageService mqMessageSender;

	@Override
	public String setRealName(String token, String ip, String idcard_number, String idcard_name) {
		JSONObject json = new JSONObject();
		/**
		 * 验证传入参数 基础验证
		 */
		try {
			Validate.validateString("token", token);
			Validate.validateString("idcard_number", idcard_number);
			Validate.validateString("idcard_name", idcard_name);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			return json.toString();
		}
		/**
		 * 根据token查询user
		 */
		Users user = userService.selectUserByToken(token);
		if (user != null) {
			/**
			 * 根据userID查询PaySinaUserInfo
			 */
			PaySinaUserInfo sinaUserInfo = sinaUserInfoService.selectByUserId(user.getId());
			/**
			 * 是否已经实名认证过
			 */
			if (sinaUserInfo != null && (sinaUserInfo.getPhone() != null && !sinaUserInfo.getPhone().equals(""))
					&& (sinaUserInfo.getSinaidcardnumber() != null && !sinaUserInfo.getSinaidcardnumber().equals(""))
					&& (user.getIdcardNumber() != null && !user.getIdcardNumber().equals(""))) {
				json.put("success", false);
				json.put("error", "已认证过了,如有问题，请联系客服");
				return json.toString();
			}
			/**
			 * 判断本地是否有记录
			 */
			if (user.getIdcardNumber() == null || sinaUserInfo == null
					|| (sinaUserInfo != null && sinaUserInfo.getSinaidcardnumber() == null)) {
				/**
				 * 验证姓名是否符合规则 暂时定义两到四位
				 */
				try {
					Validate.validateIdCardName(idcard_name);
				} catch (ServiceException e) {
					json.put("success", false);
					json.put("error", e.getMessage());
					return json.toString();
				}
				/**
				 * 验证身份证是否合法
				 */
				try {
					Validate.validateIdCard(idcard_number);
				} catch (ServiceException e) {
					json.put("success", false);
					json.put("error", e.getMessage());
					return json.toString();
				}

			}
			/**
			 * 调试开启false
			 */
			boolean test = false;
			if (test) {

				/**
				 * 调用新浪接口查询
				 */
				if (ip == null || ip.equals("")) {
					json.put("success", false);
					json.put("error", "ip地址不正确!");
					return json.toString();
				}
				
				
				CreateActivateMemberResponseParam member = paySinaPayService.create_activate_member(user.getId(), ip);
				if (member == null || member.getResponse_code() == null) {
					json.put("success", false);
					json.put("error", "请求未正确返回，请联系客服!");
					return json.toString();
				}

				if (!member.getResponse_code().equals("APPLY_SUCCESS")) {
					json.put("success", false);
					json.put("error", member.getResponse_message());
					return json.toString();
				}
				/**
				 * 查询手机号认证
				 */
				QueryVerifyResponseParam query_verify_phone = paySinaPayService.query_verify(user.getId(), "");
				if (query_verify_phone == null || query_verify_phone.getResponse_code() == null) {
					json.put("success", false);
					json.put("error", "请求未正确返回，请联系客服!");
					return json.toString();
				}
				/**
				 * 手机认证查询返回： 1.已认证的(返回提交成功)，检查数据状态，进行下一步。 2.返回未认证，进行认证，然后更新数据表
				 */
				if (query_verify_phone.getResponse_code().equals("APPLY_SUCCESS")
						&& query_verify_phone.getResponse_message().equals("提交成功")
						&& query_verify_phone.getVerify_entity() != null) {
					if (sinaUserInfo == null) {
						sinaUserInfoService.insertSinaUserInfo(user.getId(), query_verify_phone.getVerify_entity());
						sinaUserInfo = sinaUserInfoService.selectByUserId(user.getId());
					} else if (sinaUserInfo.getPhone() == null || sinaUserInfo.getPhone().equals("")) {
						sinaUserInfoService.updateSinaUserInfoSetPhoneById(query_verify_phone.getVerify_entity(),
								user.getId());
					}
				} else if (query_verify_phone.getResponse_code().equals("VERIFY_NOT_EXIST")
						|| query_verify_phone.getResponse_code().equals("MEMBER_NOT_EXIST")) {

					BindingVerifyResponseParam binding_verify = paySinaPayService.binding_verify(user.getId(),
							user.getPhone(), ip);
					if (binding_verify.getResponse_code() == null
							|| !binding_verify.getResponse_code().equals("APPLY_SUCCESS")) {
						json.put("success", false);
						json.put("error", "新浪返回错误信息为:" + binding_verify.getResponse_message() + "请联系客服");
						return json.toString();
					} else if (binding_verify.getResponse_code().equals("APPLY_SUCCESS")) {
						if (sinaUserInfo == null) {
							sinaUserInfoService.insertSinaUserInfo(user.getId(), user.getPhone());
							sinaUserInfo = sinaUserInfoService.selectByUserId(user.getId());
						} else if (sinaUserInfo.getPhone() == null || sinaUserInfo.getPhone().equals("")) {
							sinaUserInfoService.updateSinaUserInfoSetPhoneById(user.getPhone(), user.getId());
						}
					} else {
						json.put("success", false);
						json.put("error", "请求新浪接口失败,请重试!");
						return json.toString();
					}
				}
				/**
				 * 查询身份证认证
				 */
				QueryVerifyResponseParam query_verify_idcard = paySinaPayService.query_verify(user.getId(), "ID");

				if (query_verify_idcard == null || query_verify_idcard.getResponse_code() == null) {
					json.put("success", false);
					json.put("error", "请求未正确返回，请联系客服!");
					return json.toString();
				}
				/**
				 * 身份证号码认证查询返回： 1.已认证的(返回提交成功)，检查数据状态，返回已通过认证，结束处理。
				 * 2.返回未认证，进行认证，然后更新数据表，
				 */
				if (query_verify_idcard.getResponse_code().equals("APPLY_SUCCESS")
						&& query_verify_idcard.getResponse_message().equals("提交成功")
						&& query_verify_idcard.getVerify_entity() != null) {
					if (sinaUserInfo == null) {
						sinaUserInfoService.insertUserIdAndIdcardToSinaUserInfo(user.getId(),
								query_verify_idcard.getVerify_entity());
						sinaUserInfo = sinaUserInfoService.selectByUserId(user.getId());
					} else if (sinaUserInfo.getSinaidcardnumber() == null
							|| sinaUserInfo.getSinaidcardnumber().equals("")) {
						sinaUserInfoService.updateIdcardNumberSinaUserInfoById(sinaUserInfo.getId(),
								query_verify_idcard.getVerify_entity());
					}
					if (user.getIdcardNumber() == null || user.getIdcardName() == null) {
						userService.updateUserById(user.getId(), idcard_name, idcard_number, null);
					}
					json.put("success", false);
					json.put("error", "已认证过了,如有问题，请联系客服");
					return json.toString();

				} else if (query_verify_idcard.getResponse_code().equals("VERIFY_NOT_EXIST")
						|| query_verify_idcard.getResponse_code().equals("MEMBER_NOT_EXIST")) {
					/**
					 * 设定身份证实名认证
					 */
					SetRealNameResponseParam set_real_name = paySinaPayService.set_real_name(user.getId(),
							idcard_number, idcard_name, ip);

					if (set_real_name == null) {
						json.put("success", false);
						json.put("error", "请求新浪接口失败,请重试!");
						return json.toString();
					}
					if (!set_real_name.getResponse_code().equals("APPLY_SUCCESS")) {
						json.put("success", false);
						json.put("error", "新浪返回错误信息为:" + set_real_name.getResponse_message() + "请联系客服");
						return json.toString();
					} else if (set_real_name.getResponse_code().equals("APPLY_SUCCESS")) {
						if (user.getIdcardNumber() == null || user.getIdcardName() == null) {
							IdcardInfoExtractor ie = new IdcardInfoExtractor(idcard_number);
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
							userService.updateUserById(user.getId(), idcard_name, idcard_number,
									simpleDateFormat.format(ie.getBirthday()));
						}
						if (sinaUserInfo == null) {
							sinaUserInfoService.insertUserIdAndIdcardToSinaUserInfo(user.getId(), idcard_number);
							sinaUserInfo = sinaUserInfoService.selectByUserId(user.getId());
						} else if (sinaUserInfo.getSinaidcardnumber() == null
								|| sinaUserInfo.getSinaidcardnumber().equals("")) {
							sinaUserInfoService.updateIdcardNumberSinaUserInfoById(sinaUserInfo.getId(), idcard_number);
						}
					} else {
						json.put("success", false);
						json.put("error", "请求新浪接口失败,请重试!");
						return json.toString();
					}

				}
			}
			/**
			 * 给实名用户发送加息券以及红包
			 * 
			 */
			JSONObject couponsGrant = new JSONObject();
			couponsGrant.put("userId", user.getId());
			couponsGrant.put("type", "realname");
			couponsGrant.put("serviceName", "payBizVerifyIdCardService");
			
			mqMessageSender.sendMessage("couponsGrant", couponsGrant.toString());
			/**
			 * 更改用户天财值
			 */
			JSONObject talentValuequeue = new JSONObject();
			talentValuequeue.put("userId", user.getId());
			talentValuequeue.put("sourceId", 3);
			talentValuequeue.put("oldTalentValue", user.getTalentValue());
			talentValuequeue.put("type", 2);
			talentValuequeue.put("serviceName", "payBizVerifyIdCardService");
			mqMessageSender.sendMessage("talentValuequeue", talentValuequeue.toString());
			/**
			 * 发放体验金 暂不使用
			 */

			/**
			 * 实名短信
			 */
			JSONObject smsQueue = new JSONObject();
			smsQueue.put("userId", user.getId());
			smsQueue.put("phone", user.getPhone());
			smsQueue.put("type", 2);
			smsQueue.put("serviceName","payBizVerifyIdCardService");
			mqMessageSender.sendMessage("smsQueue", smsQueue.toString());
			/**
			 * 站内信
			 */
			JSONObject noticeQueue = new JSONObject();
			noticeQueue.put("userId", user.getId());
			noticeQueue.put("title", "完成实名认证");
			noticeQueue.put("info", 1);
			noticeQueue.put("status", 0);
			noticeQueue.put("remark", "'ID:" + user.getId() + "完成实名认证");
			noticeQueue.put("serviceName", "payBizVerifyIdCardService");
			mqMessageSender.sendMessage("noticeQueue", noticeQueue.toString());

			json.put("success", true);
			json.put("error", "实名认证成功");
			return json.toString();
		} else {
			json.put("success", false);
			json.put("error", "用户不存在");
			return json.toString();
		}
	}

}
