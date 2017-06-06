/*package com.tiancaibao.controller.bank;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.Bankcards;
import com.tiancaibao.pojo.SinaUserInfo;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.pojo.sina.BindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.sina.BindingBankCardResponseParam;
import com.tiancaibao.pojo.sina.QueryBankCardResponseParam;
import com.tiancaibao.service.bank.BankService;
import com.tiancaibao.service.impl.sinapay.SinaPayService;
import com.tiancaibao.service.user.UserService;

@Controller
@RequestMapping("/bank")
public class BankInterfaceController {

	private static Logger logger = Logger.getLogger(BankInterfaceController.class);
	@Resource
	private UserService userService;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private BankService bankService;

	*//**
	 * 发送银行短信
	 * 
	 * @param bank_name
	 * @param uid
	 * @param bank_card
	 * @param idcard_name
	 * @param idcard_number
	 * @param phone
	 * @param ip
	 * @return
	 *//*
	@RequestMapping("/code.do")
	@ResponseBody
	public String code(String bank_name, Long uid, String bank_card, String idcard_name, String idcard_number,
			String phone, String ip) {
		JSONObject json = new JSONObject();
		try {
			// 根据银行name查询银行编号 看处理方式再定类型
			String bank_id = null;
			if (StringUtils.isBlank(bank_id)) {
				return "没有该银行的标示";
			}
			// 查询用户
			Users user = userService.selectUserById(uid);
			if (user == null) {
				return "用户不存在";
			}
			// 查询是否绑定
			QueryBankCardResponseParam qbcrp = sinaPayService.query_bank_card(uid);
			if ("提交成功".equals(qbcrp.getResponse_message()) && "APPLY_SUCCESS".equals(qbcrp.getResponse_code())
					&& qbcrp.getCard_list() != null) {
				return "您已经绑过卡了";
			}
			// 是否实名认证
			String idcardName = user.getIdcardName();
			if (StringUtils.isBlank(idcardName)) {
				return "实名认证未通过";
			}
			// 发送银行卡短信 //
			// //,bank_id,bank_card,idcard_name,idcard_number,phone,ip
			BindingBankCardResponseParam bbcrp = sinaPayService.binding_bank_card(uid, bank_id, bank_card, idcard_name,
					idcard_number, phone, "0011", "1100", ip);
			if ("APPLY_SUCCESS".equals(bbcrp.getResponse_code()) && "提交成功".equals(bbcrp.getResponse_message())
					&& bbcrp.getTicket() != null) {
				return "银行短信已发送ticket:" + bbcrp.getTicket();
			} else {
				return bbcrp.getResponse_message();
			}
		} catch (Exception e) {
			logger.error("interface发送银行短信:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 保存用户银行卡
	 * 
	 * @return
	 *//*
	public String bind(Long uid, String phone,String bank_name, String bank_card, String ticket, String phone_code, String ip) {
		JSONObject json = new JSONObject();
		try {
			// 通过 bank_name获得bank_id
			String bank_id = null;
			if (StringUtils.isBlank(bank_id)) {
				return "没有该银行的标示";
			}
			// 调用新浪绑卡推进接口，比较返回值与已经保存的值是否一致
			Users user = userService.selectUserById(uid);
			Bankcards bankCard = bankService.selectBankCardByUserId(uid);
			SinaUserInfo sinaUserInfo = userService.selectSinaUserInfoByUserId(uid);
			// 绑定银行卡推进
			BindingBankCardAdvanceResponseParam bbcarp = sinaPayService.binding_bank_card_advance(ticket, phone_code,
					ip);
			if ("提交成功".equals(bbcarp.getResponse_message()) && "APPLY_SUCCESS".equals(bbcarp.getResponse_code())) {
				bankService.saveUserBankCardAndSinaUserInfoForBankInterface(bankCard,sinaUserInfo,uid,phone,bank_id,bank_name,bank_card,bbcarp.getCard_id());
				return "success";
			} else {
				return bbcarp.getResponse_message();
			}
		} catch (Exception e) {
			logger.error("interface保存用户银行卡:" + e.getMessage());
		}
		return json.toString();
	}
}
*/