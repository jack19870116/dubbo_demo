package com.tiancaibao.service.pay.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.pay.PayUnBankcards;
import com.tiancaibao.pojo.pay.sina.QueryBankCardResponseParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardResponseParam;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;
import com.tiancaibao.service.interfaces.pay.IPayUnBankCardService;
import com.tiancaibao.service.interfaces.pay.biz.IPayBizUnBankCardServiceImpl;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.validate.Validate;

@Service("payBizUnBankCardService")
public class PayBizUnBankCardServiceImpl implements IPayBizUnBankCardServiceImpl {

	@Resource
	private IUserService userService;

	@Resource
	IPaySinaPayService paySinaPayService;

	@Resource
	IPayUnBankCardService payUnBankCardService;

	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;

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
		return unbindBankCard(users.getId(), ip);
	}

	@Override
	public String unbindBankCard(Long user_id, String ip) {
		JSONObject json = new JSONObject();
		QueryBankCardResponseParam qbcrpr = paySinaPayService.query_bank_card(user_id);

		if (qbcrpr != null && "APPLY_SUCCESS".equals(qbcrpr.getResponse_code()) && qbcrpr.getCard_list() != null) {
			String[] isHave = qbcrpr.getCard_list().split("\\^");

			UnbindingBankCardResponseParam unbinding_bank_card = paySinaPayService.unbinding_bank_card(user_id, ip,
					isHave[0]);
			if (unbinding_bank_card != null && unbinding_bank_card.getResponse_code() != null
					&& !unbinding_bank_card.getResponse_code().equals("APPLY_SUCCESS")) {

				json.put("success", false);
				json.put("error", unbinding_bank_card.getResponse_message() != null
						? unbinding_bank_card.getResponse_message() : "新浪未返回数据！");
				return json.toString();

			}
			int insertintoBankcards = payUnBankCardService.insertintoBankcards(user_id, isHave[2], "WAITING_CONFIRM",
					unbinding_bank_card.getTicket());

			if (insertintoBankcards > 0) {
				json.put("success", true);
				json.put("ticket", unbinding_bank_card.getTicket());
				return json.toString();

			} else {

				json.put("success", false);
				json.put("error", "解绑加载失败");
				return json.toString();

			}

		} else {
			json.put("success", false);
			json.put("error", "客户未绑定银行卡");
			return json.toString();
		}

	}

	@Override
	public String UnBankCardAdvance(Long user_id, String ip, String valid_code, String ticket) {
		JSONObject json = new JSONObject();

		if (valid_code == null || (valid_code != null && valid_code.equals("")) || ticket == null
				|| (ticket != null && ticket.equals(""))) {
			json.put("success", false);
			json.put("error", "访问令牌和手机验证码都不能为空!");
			return json.toString();

		}

		PayUnBankcards selectPayUnBankcardsByTicket = payUnBankCardService.selectPayUnBankcardsByTicket(ticket);

		if (selectPayUnBankcardsByTicket == null) {
			json.put("success", false);
			json.put("error", "访问令牌失效");
			return json.toString();

		}
		UnbindingBankCardAdvanceResponseParam unbinding_bank_card_advance = paySinaPayService
				.unbinding_bank_card_advance(user_id, ip, ticket, valid_code);

		if (unbinding_bank_card_advance != null
				&& !unbinding_bank_card_advance.getResponse_code().equals("APPLY_SUCCESS")) {

			int updatePayUnBankcards = payUnBankCardService.updatePayUnBankcards(selectPayUnBankcardsByTicket.getId(),
					"CANCELLED");
			if (updatePayUnBankcards > 0) {

				json.put("success", false);
				json.put("error", unbinding_bank_card_advance.getResponse_message());
				return json.toString();

			}

		}

		QueryBankCardResponseParam qbcrpr = paySinaPayService.query_bank_card(user_id);

		if (qbcrpr != null && "APPLY_SUCCESS".equals(qbcrpr.getResponse_code()) && qbcrpr.getCard_list() != null) {
			String[] isHave = qbcrpr.getCard_list().split("\\^");

			sinaUserInfoService.updateSinaUserInfoBnakCardById(user_id, isHave[2], "", isHave[0]);

		} else {
			sinaUserInfoService.updateSinaUserInfoBnakCardById(user_id, "", "", "");
		}
		int updatePayUnBankcards = payUnBankCardService.updatePayUnBankcards(selectPayUnBankcardsByTicket.getId(),
				"CONFIRMED");
		if (updatePayUnBankcards > 0) {
			json.put("success", true);
			return json.toString();
		} else {

			payUnBankCardService.updatePayUnBankcards(selectPayUnBankcardsByTicket.getId(), "CANCELLED");
			json.put("success", false);
			json.put("error", "数据更新失败");
			return json.toString();

		}

	}

}
