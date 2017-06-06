package com.tiancaibao.service.pay.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.mapper.pay.PayRegionsMapper;
import com.tiancaibao.pojo.pay.PayRegions;
import com.tiancaibao.pojo.pay.PayRegionsExample;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.pojo.pay.PayUnBankcards;
import com.tiancaibao.pojo.pay.sina.BankNameList;
import com.tiancaibao.pojo.pay.sina.BindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.pay.sina.BindingBankCardResponseParam;
import com.tiancaibao.pojo.user.UserBankCards;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.pay.IPayUnBankCardService;
import com.tiancaibao.service.interfaces.pay.biz.IPayBizBindBankCardServiceImpl;
import com.tiancaibao.service.interfaces.user.IUserBankCardService;
import com.tiancaibao.service.interfaces.user.IUserInviteLogsService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.validate.Validate;

@Service("payBizBindBankCardService")
public class PayBizBindBankCardServiceImpl implements IPayBizBindBankCardServiceImpl {

	@Resource
	private IUserService userService;
	@Resource
	private IUserInviteLogsService userInviteLogsService;
	@Resource
	private IUserBankCardService userBankCardService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

	@Resource
	PayRegionsMapper payRegionsMapper;

	@Resource
	IPaySinaPayService paySinaPayService;

	@Resource
	IMqMessageService mqMessageSender;
	@Resource
	IPayUnBankCardService payUnBankCardService;

	@Override
	public String verifyUser(String token, String ip) {
		
		JSONObject json = new JSONObject();
		if (ip == null || ip.equals("")) {
			json.put("success", false);
			json.put("error", "参数不正确!");
			return json.toString();
		}

		try {
			Validate.validateString("token", token);
		} catch (ServiceException e) {
			json.put("success", false);
			json.put("error", e.getMessage());
			return json.toString();
		}
		Users users = userService.selectUserByToken(token);
		if (users == null) {
			json.put("success", false);
			json.put("error", "用户不存在!");
			return json.toString();
		}
		// bindBankCardInit(users.getId(), users.getIdcardName());

		return bindBankCardInit(users.getId(), users.getIdcardName());
	}

	@Override
	public String bindBankCardInit(Long user_id, String idcard_name) {

		JSONObject json = new JSONObject();
		PaySinaUserInfo payUser = sinaUserInfoService.selectByUserId(user_id);
		if (payUser != null && payUser.getSinapayBankCard() != null && !payUser.getSinapayBankCard().equals("")) {
			json.put("success", true);
			json.put("error", "您已经绑过卡了");
			json.put("status", "1");
			return json.toString();
		}

		if (idcard_name == null || idcard_name.equals("") || payUser == null
				|| (payUser != null && payUser.getPhone() == null)) {
			json.put("success", false);
			json.put("error", "实名认证未通过");
			json.put("status", "0");
			return json.toString();
		}

		return bindBankCardGetRegions(user_id, idcard_name);
	}

	@Override
	public String bindBankCardGetRegions(Long user_id, String idcard_name) {
		JSONObject json = new JSONObject();
		PayRegionsExample example = new PayRegionsExample();
		example.createCriteria().andParentIdEqualTo(Long.parseLong("0"));
		List<PayRegions> selectByExample = payRegionsMapper.selectByExample(example);

		json.put("success", true);
		json.put("error", "绑卡准备成功");
		json.put("binkinfo", new BankNameList());
		json.put("area", selectByExample);
		json.put("name", idcard_name);
		json.put("status", "0");
		return json.toString();

	}

	@Override
	public String bindBankCardGetChildRegions(String regions_id) {
		JSONObject json = new JSONObject();
		PayRegionsExample example = new PayRegionsExample();
		example.createCriteria().andParentIdEqualTo(Long.parseLong(regions_id));
		List<PayRegions> selectByExample = payRegionsMapper.selectByExample(example);

		json.put("success", true);
		json.put("error", "获取地区信息成功");
		json.put("data", selectByExample);

		return json.toString();
	}

	@Override
	public String bindBankCardCode(String bank_id, String token, String bank_card, String phone, Long province_code,
			Long area_id, String ip) {
		JSONObject json = new JSONObject();

		if (bank_id == null || bank_id.equals("")) {
			json.put("success", false);
			json.put("error", "请选择银行");
			return json.toString();
		}
		Users users = userService.selectUserByToken(token);

		/**
		 * 省份
		 */
		PayRegionsExample example = new PayRegionsExample();
		example.createCriteria().andIdEqualTo(province_code);
		List<PayRegions> province = payRegionsMapper.selectByExample(example);
		/**
		 * 城市
		 */
		PayRegionsExample example_area = new PayRegionsExample();
		example_area.createCriteria().andIdEqualTo(area_id);
		List<PayRegions> area = payRegionsMapper.selectByExample(example_area);

		BindingBankCardResponseParam binding_bank_card = paySinaPayService.binding_bank_card(users.getId(), bank_id,
				bank_card, users.getIdcardName(), users.getIdcardNumber(), phone, province.get(0).getName(),
				area.get(0).getName(), ip);

		if (binding_bank_card != null && binding_bank_card.getResponse_code().equals("APPLY_SUCCESS")
				&& binding_bank_card.getTicket() != null) {

			json.put("success", true);
			json.put("ticket", binding_bank_card.getTicket());
			json.put("data", "[{'ticket':'" + binding_bank_card.getTicket() + "'}]");

			return json.toString();

		} else if (binding_bank_card != null) {
			json.put("success", false);
			json.put("terror", binding_bank_card.getResponse_message());
			return json.toString();

		} else {
			json.put("success", false);
			json.put("error", "请求新浪出错");
			return json.toString();
		}

	}

	@Override
	public String bindBankCard(String ticket, Long user_id, String phone_code, String ip, String phone,
			String bank_id, String bank_card, String province_id, String area_id, String bank_name) {
		JSONObject json = new JSONObject();
		Users users = userService.selectUserById(user_id);

		UserBankCards bankCardByUserID = userBankCardService.selectUserBankCardByUserID(user_id);

		BindingBankCardAdvanceResponseParam binding_bank_card_advance = paySinaPayService
				.binding_bank_card_advance(ticket, phone_code, ip);

		if (binding_bank_card_advance != null && binding_bank_card_advance.getResponse_code() != null
				&& binding_bank_card_advance.getResponse_code().equals("APPLY_SUCCESS")) {
			// 比对用户已保存的银行卡是否与新浪保存的银行卡一致，如一致，不做操作，不一致，更新银行卡号

			if (bankCardByUserID == null) {// 没有绑定的情况
				userBankCardService.insertintoBankCard(user_id, phone, bank_id, bank_name, bank_card, province_id,
						area_id);

			} else if (bankCardByUserID != null && !bankCardByUserID.getNumber().equals(bank_card)) {// 绑定了但是不一致
				userBankCardService.updateBnakCard(bankCardByUserID.getId(), bank_card, bank_name);

			}
			PaySinaUserInfo selectByUserId = sinaUserInfoService.selectByUserId(user_id);
			// 更新新浪用户表
			if (selectByUserId == null) {
				sinaUserInfoService.insertoSinaUserInfo(user_id, phone, bank_card,
						binding_bank_card_advance.getCard_id());

			} else if ((selectByUserId.getSinapayBankCard() != null
					&& !selectByUserId.getSinapayBankCard().equals(bank_card))
					|| selectByUserId.getSinapayBankCard() == null) {
				sinaUserInfoService.updateSinaUserInfoBnakCardById(selectByUserId.getId(), bank_card, phone,
						binding_bank_card_advance.getCard_id());
			}

			/**
			 * 绑卡完成进行其他业务
			 */
			/**
			 * 天财值变动
			 */
			JSONObject talentValuequeue = new JSONObject();
			talentValuequeue.put("userId", users.getId());
			talentValuequeue.put("sourceId", 4);
			talentValuequeue.put("oldTalentValue", users.getTalentValue());
			talentValuequeue.put("type", 2);
			talentValuequeue.put("serviceName", "payBizBindBankCardService");
			mqMessageSender.sendMessage("talentValuequeue", talentValuequeue.toString());

			/**
			 * 加息券发放
			 */
			PayUnBankcards selectPayUnBankcardsByUserId = payUnBankCardService.selectPayUnBankcardsByUserId(user_id,
					"CONFIRMED");

			selectByUserId = sinaUserInfoService.selectByUserId(user_id);

			if (selectPayUnBankcardsByUserId == null && selectByUserId.getSinapayBankCard() != null
					&& !selectByUserId.getSinapayBankCard().equals("")) {

				if (users.getInvitedByUserId() != null && !users.getInvitedByUserId().equals("")) {

					JSONObject couponsGrant = new JSONObject();
					couponsGrant.put("userId", users.getInvitedByUserId());
					couponsGrant.put("type", "bindBank");
					couponsGrant.put("serviceName", "payBizBindBankCardService");
					
					mqMessageSender.sendMessage("couponsGrant", couponsGrant.toString());

					userInviteLogsService.insertintUserInviteLogs(users.getInvitedByUserId(), users.getId(),
							users.getPhone(), 1, "5%加息券", 0, users.getId() + "绑卡");

					JSONObject noticeQueue = new JSONObject();
					noticeQueue.put("userId", users.getId());
					noticeQueue.put("title", "完成实名认证");
					noticeQueue.put("info", 1);
					noticeQueue.put("status", 0);
					noticeQueue.put("phone", users.getPhone());
					noticeQueue.put("remark", "'ID:" + users.getId() + "完成绑卡");
					noticeQueue.put("serviceName", "payBizBindBankCardService");
					
					mqMessageSender.sendMessage("noticeQueue", noticeQueue.toString());

				}

			}
			bankCardByUserID = userBankCardService.selectUserBankCardByUserID(user_id);

			json.put("success", true);

			return json.toString();

		} else {
			json.put("success", false);
			json.put("error", binding_bank_card_advance.getResponse_message() != null
					? binding_bank_card_advance.getResponse_message() : "新浪返回数据错误！");
			return json.toString();
		}

	}

}
