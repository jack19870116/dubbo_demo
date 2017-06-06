/*package com.tiancaibao.controller.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.Bankcards;
import com.tiancaibao.pojo.Regions;
import com.tiancaibao.pojo.SinaUserInfo;
import com.tiancaibao.pojo.TalentSource;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.pojo.sina.BankNameList;
import com.tiancaibao.pojo.sina.BindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.sina.BindingBankCardResponseParam;
import com.tiancaibao.service.bank.BankService;
import com.tiancaibao.service.impl.sinapay.SinaPayService;
import com.tiancaibao.service.talentsource.TalentSourceService;
import com.tiancaibao.service.user.UserService;

*//**
 * 此类中是否都要判断token无效以及用户不存在
 * 
 * @author Mack
 *
 *//*
@Controller
@RequestMapping("/bank")
public class BankCardController {

	private static Logger logger = Logger.getLogger(BankCardController.class);
	@Resource
	private UserService userService;
	@Resource
	private BankService bankService;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private TalentSourceService talentSourceService;

	*//**
	 * 绑卡初始请求，发送区域和银行信息
	 * 
	 * @param token
	 * @param ip
	 * @return
	 *//*
	@RequestMapping("/load.do")
	@ResponseBody
	public String load(String token, String ip) {
		JSONObject json = new JSONObject();
		try {
			if (StringUtils.isBlank(token)) {
				json.put("success", false);
				json.put("error", "token无效");
				return json.toString();
			}
			Users user = userService.selectUserByToken(token);
			if (user == null) {
				json.put("success", false);
				json.put("error", "用户不存在");
				return json.toString();
			}
			Long userid = user.getId();
			SinaUserInfo sinauserinfo = userService.selectSinaUserInfoByUserId(userid);
			if (sinauserinfo == null || sinauserinfo.getSinapayBankCard() == null) {
				json.put("success", true);
				json.put("error", "您已经绑过卡了");
				json.put("status", "1");
				return json.toString();
			}
			if (user.getIdcardName() == null || sinauserinfo.getPhone() == null) {
				json.put("success", false);
				json.put("error", "实名认证未通过");
				json.put("status", "0");
				return json.toString();
			}
			List<Regions> regionlist = bankService.selectRegionsByParentId(0L);
			json.put("success", true);
			json.put("error", "绑卡准备成功");
			json.put("binkinfo", new BankNameList());
			json.put("area", regionlist);
			json.put("name", user.getIdcardName());
			json.put("status", "0");
		} catch (Exception e) {
			logger.error("绑卡初始请求，发送区域和银行信息:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 获取银行卡所在省份
	 * 
	 * @param token
	 * @return
	 *//*
	@RequestMapping("/belongToProvince.do")
	@ResponseBody
	public String belongToProvince(String token) {
		JSONObject json = new JSONObject();
		try {
			if (StringUtils.isBlank(token)) {
				json.put("success", false);
				json.put("error", "token无效");
				return json.toString();
			}
			Users user = userService.selectUserByToken(token);
			if (user == null) {
				json.put("success", false);
				json.put("error", "用户不存在");
				return json.toString();
			}
			Long userid = user.getId();
			SinaUserInfo sinauserinfo = userService.selectSinaUserInfoByUserId(userid);
			if (sinauserinfo != null || sinauserinfo.getSinapayBankCard() != null) {
				// return 您已经绑过卡了
			}
			String idcardName = user.getIdcardName();
			BankNameList bankname = new BankNameList();
			if (StringUtils.isBlank(idcardName)) {
				json.put("success", false);
				json.put("error", "实名认证未通过");
				json.put("status", "0");
				return json.toString();
			}
			List<Regions> regionlist = bankService.selectRegionsByParentId(0L);
			Map<String, Object> data = new HashMap<>();
			data.put("binkinfo", bankname);
			data.put("area", regionlist);
			json.put("success", true);
			json.put("data", data);
			json.put("error", "获取地区信息成功");

		} catch (Exception e) {
			logger.error("获取银行卡所在省份:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 获取银行卡所在子区域
	 * 
	 * @param regions_id
	 * @return
	 *//*
	@RequestMapping("/childRegions.do")
	@ResponseBody
	public String childRegions(Long regions_id) {
		JSONObject json = new JSONObject();
		try {
			List<Regions> regionlist = bankService.selectRegionsByParentId(regions_id);
			json.put("success", true);
			json.put("data", regionlist);
			json.put("error", "获取地区信息成功");
		} catch (Exception e) {
			logger.error("获取银行卡所在子区域:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 请求新浪发送绑卡短信
	 * 
	 * @param token
	 * @param bank_id
	 * @param bank_card
	 * @param phone
	 * @param province_code
	 * @param area_id
	 * @param ip
	 * @return
	 *//*
	@RequestMapping("/code.do")
	@ResponseBody
	public String code(String token, String bank_id, String bank_card, String phone, Long province_code, Long area_id,
			String ip) {
		JSONObject json = new JSONObject();
		try {
			if (StringUtils.isBlank(bank_id)) {
				json.put("success", false);
				json.put("error", "请选择银行");
				return json.toString();
			}
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			String provinceName = bankService.selectNameOfRegionsById(province_code);
			String areaName = bankService.selectNameOfRegionsById(area_id);
			BindingBankCardResponseParam bbcrp = sinaPayService.binding_bank_card(userid, bank_id, bank_card,
					user.getIdcardName(), user.getIdcardNumber(), phone, provinceName, areaName, ip);
			// 此处未做bbcrp判空
			if ("APPLY_SUCCESS".equals(bbcrp.getResponse_code()) && "提交成功".equals(bbcrp.getResponse_message())
					&& bbcrp.getTicket() != null) {
				Map<String, Object> data = new HashMap<>();
				data.put("ticket", bbcrp.getTicket());
				json.put("success", true);
				json.put("ticket", bbcrp.getTicket());
				json.put("data", data);
			} else {
				json.put("success", false);
				json.put("error", bbcrp.getResponse_message());
			}
		} catch (Exception e) {
			logger.error("请求新浪发送绑卡短信:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 保存用户银行卡
	 * 
	 * @param token
	 * @param ticket
	 * @param phone_code
	 * @param ip
	 * @param phone
	 * @param bank_id
	 * @param bank_card
	 * @param province_id
	 * @param area_id
	 * @param bank_name
	 * @return
	 *//*
	@RequestMapping("/bind.do")
	@ResponseBody
	public String bind(String token, String ticket, String phone_code, String ip, String phone, String bank_id,
			String bank_card, String province_id, String area_id, String bank_name) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			Bankcards bc = bankService.selectBankCardByUserId(userid);
			// 绑定银行卡推进
			BindingBankCardAdvanceResponseParam bbcarp = sinaPayService.binding_bank_card_advance(ticket, phone_code,
					ip);
			SinaUserInfo sinauserinfo = userService.selectSinaUserInfoByUserId(userid);
			TalentSource talentSource = talentSourceService.selectTalentSourceById(4);
			if ("提交成功".equals(bbcarp.getResponse_message()) && "APPLY_SUCCESS".equals(bbcarp.getResponse_code())) {
				// 比对用户已保存的银行卡是否与新浪保存的银行卡一致，如一致，不做操作，不一致，更新银行卡号
				bankService.saveUserBankCard(talentSource, bbcarp.getCard_id(), sinauserinfo, bc, userid, phone,
						bank_id, bank_card, province_id, area_id, bank_name, user.getTalentValue(),
						user.getCreatedAt());
				json.put("success", true);
			} else {
				json.put("success", false);
				json.put("error", bbcarp.getResponse_message());
			}
		} catch (Exception e) {
			logger.error("保存用户银行卡:" + e.getMessage());
		}
		return json.toString();
	}

	@RequestMapping("/haveBind.do")
	@ResponseBody
	public String haveBind(String token) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			SinaUserInfo sinauserinfo = userService.selectSinaUserInfoByUserId(user.getId());
			if (sinauserinfo == null || sinauserinfo.getSinapayBankCard() == null) {
				json.put("success", false);
				return json.toString();
			}
			json.put("success", true);
			json.put("bank_name", ""); // sinauserinfo 中无 bank_name
			json.put("card_number", sinauserinfo.getSinapayBankCard());
		} catch (Exception e) {
			logger.error("haveBind:" + e.getMessage());
		}
		return json.toString();
	}

}
*/