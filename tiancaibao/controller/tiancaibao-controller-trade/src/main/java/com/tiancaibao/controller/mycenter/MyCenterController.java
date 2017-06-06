/*package com.tiancaibao.controller.mycenter;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.AssetIncreaseRecords;
import com.tiancaibao.pojo.InvestRecords;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.pojo.sina.QueryBankCardResponseParam;
import com.tiancaibao.pojo.sina.UnbindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.sina.UnbindingBankCardResponseParam;
import com.tiancaibao.service.current.CurrentService;
import com.tiancaibao.service.impl.sinapay.SinaPayService;
import com.tiancaibao.service.redeem.RedeemService;
import com.tiancaibao.service.trade.InvestService;
import com.tiancaibao.service.transform.TransformService;
import com.tiancaibao.service.user.UserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;

@Controller
@RequestMapping("/mycenter")
public class MyCenterController {
	private static Logger logger = Logger.getLogger(MyCenterController.class);
	@Resource
	private UserService userService;
	@Resource
	private CurrentService currentService;
	@Resource
	private InvestService investService;
	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private RedeemService redeemService;
	@Resource
	private TransformService transformService;

	*//**
	 * 我的信息 暂弃用
	 * 
	 * @param token
	 * @return
	 *//*
	@RequestMapping("/info.do")
	@ResponseBody
	public String info(String token) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				Long sumAsset = user.getAccountAmount() + user.getAmount() + user.getFixedAmount();
				json.put("success", true);
				json.put("sum_asset", NumberFormat.doubleSplitTwoDecimal(sumAsset + 0.0));
				json.put("account_amount", user.getAccountAmount());
				json.put("current_amount", user.getAmount());
				json.put("fixed_amount", user.getFixedAmount());
			} else {
				json.put("success", false);
				json.put("error", "获取用户信息失败!");
			}
		} catch (Exception e) {
			logger.error("我的信息:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 我的活期收益(带分页)
	 * 
	 * @param token
	 * @param currPage
	 * @param pageSize
	 * @return
	 *//*
	@RequestMapping("/current.do")
	@ResponseBody
	public String current(String token, Integer currPage, Integer pageSize) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			List<AssetIncreaseRecords> assetRecords = currentService
					.seleAssetIncreaseRecordByUseridAndAmountGreatThanAndOrderByDateWithPage(user.getId(), 100L,
							currPage, pageSize, "desc");
			Long sumAsset = currentService.selectSumAmountFromAssetIncreaseRecordByUserId(user.getId());
			json.put("success", true);
			json.put("record", assetRecords); //
			json.put("sumasset", NumberFormat.doubleSplitTwoDecimal((sumAsset + 0.0) / 10000));
			json.put("currentAmount", user.getAmount());
		} catch (Exception e) {
			logger.error("我的活期收益(带分页):" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 我的定期收益(正在进行)(带分页)
	 * 
	 * @param token
	 * @param currPage
	 * @param pageSize
	 * @return
	 *//*
	@RequestMapping("/fixed.do")
	@ResponseBody
	public String fixed(String token, Integer currPage, Integer pageSize) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			// 正在进行
			List<InvestRecords> fetureRecords = investService.selectUnderwayFixByUserIdWithPage(userid, currPage,
					pageSize);
			Long futureInterest = 0L;
			for (InvestRecords ir : fetureRecords) {
				ir.setMonth(ir.getDays() / 30);
				futureInterest += ir.getInterest();
				ir.setIs_change(true);// 是否可以修改复投状态
				if (DateUtil.afterNDay(new Date(), 4).compareTo(ir.getExpireDate()) >= 0) {
					ir.setIs_change(false);
				}
			}
			// 累计已完成收益
			Long finishfixsuminterest = investService.selectFinishFixSumInterestByUserId(userid);
			Double historyInterest = NumberFormat.doubleSplitTwoDecimal(finishfixsuminterest + 0.0);
			json.put("success", true);
			json.put("nowRecord", fetureRecords);
			json.put("fixedAmount", user.getFixedAmount());
			json.put("futureInterest", NumberFormat.doubleSplitTwoDecimal(futureInterest + 0.0));
			json.put("historyInterest", historyInterest);
		} catch (Exception e) {
			logger.error("我的定期收益(正在进行)(带分页):" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 我的定期收益(已经完成)(带分页)
	 * 
	 * @param token
	 * @param currPage
	 * @param pageSize
	 * @return
	 *//*
	@RequestMapping("/doneFixed.do")
	@ResponseBody
	public String doneFixed(String token, Integer currPage, Integer pageSize) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			List<InvestRecords> historyRecords = investService.doneFixedInvestRecordByUserId(userid, currPage,
					pageSize);
			for (InvestRecords ir : historyRecords) {
				ir.setMonth(ir.getDays() / 30);
			}
			json.put("success", true);
			json.put("doneRecord", historyRecords);
		} catch (Exception e) {
			logger.error("我的定期收益(已经完成)(带分页):" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 解绑银行卡
	 * 
	 * @param token
	 * @param ip
	 * @return
	 *//*
	@RequestMapping("/unBankCard.do")
	@ResponseBody
	public String unBankCard(String token, String ip) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			QueryBankCardResponseParam bankcardlist = sinaPayService.query_bank_card(userid);
			if (bankcardlist == null || bankcardlist.getCard_list() == null) {
				json.put("success", false);
				json.put("error", "客户未绑定银行卡!");
				return json.toString();
			}
			String[] isHave = bankcardlist.getCard_list().split("^");
			// 解绑卡
			UnbindingBankCardResponseParam ubcrp = sinaPayService.unbinding_bank_card(userid, ip, isHave[0]);
			if ("APPLY_SUCCESS".equals(ubcrp.getResponse_code())) {
				json.put("success", false);
				json.put("error", ubcrp.getResponse_message());
				return json.toString();
			}
			json.put("success", true);
			json.put("ticket", ubcrp.getTicket());
		} catch (Exception e) {
			logger.error("解绑银行卡:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 解绑银行卡推进
	 * 
	 * @param token
	 * @param valid_code
	 * @param ticket
	 * @param ip
	 * @return
	 *//*
	@RequestMapping("/unBankCardAdvance.do")
	@ResponseBody
	public String unBankCardAdvance(String token, String valid_code, String ticket, String ip) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			if (valid_code == null || ticket == null) {
				json.put("success", false);
				json.put("error", "访问令牌和手机验证码都不能为空!");
				return json.toString();
			}
			UnbindingBankCardAdvanceResponseParam ubcarp = sinaPayService.unbinding_bank_card_advance(userid, ip,
					ticket, valid_code);
			if ("APPLY_SUCCESS".equals(ubcarp.getResponse_code())) {
				json.put("success", false);
				json.put("error", ubcarp.getResponse_message());
				return json.toString();
			}
			json.put("success", true);
		} catch (Exception e) {
			logger.error("解绑银行卡推进:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 获取所有消息
	 * 
	 * @return
	 *//*
	public String messageAll() {
		JSONObject json = new JSONObject();
		try {
		} catch (Exception e) {
			logger.error("获取所有消息:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 获取用户不扣天钱值的金额
	 * 
	 * @param token
	 * @return
	 *//*
	@RequestMapping("/membersGrade.do")
	@ResponseBody
	public String membersGrade(String token) {
		JSONObject json = new JSONObject();
		try {
			Users user = userService.selectUserByToken(token);
			Long userid = user.getId();
			// $members_grade = $this -> user -> title();
			String members_grade = null;
			// $limit_amount = $this -> user -> credit();
			Double limit_amount = null;
			Long redeemAmount = redeemService.selectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM(userid, 1,
					DateUtil.formatDateByFormat(new Date(), "yyyy-MM"));
			Double limitredeemamount = (150000.0 - redeemAmount) / 10000 > 0 ? (150000.0 - redeemAmount) / 10000 : 0;
			json.put("success", true);
			json.put("talent_value", user.getTalentValue());
			json.put("limit_amount", limit_amount);
			json.put("limit_redeem_amount", NumberFormat.doubleSplitTwoDecimal(limitredeemamount));
			json.put("members_grade", members_grade);
			json.put("integral", user.getIntegral());
		} catch (Exception e) {
			logger.error("获取用户不扣天钱值的金额:" + e.getMessage());
		}
		return json.toString();
	}

	public String transformation(String token, Long num) {
		JSONObject json = new JSONObject();
		try {
			num = num == null ? 0L : num;
			if (num == 0L) {
				json.put("success", false);
				json.put("error", "请输入有效参数");
				return json.toString();
			}
			// 操作过于频繁 统一处理

			if (!DateUtil.isMembersDay()) {
				json.put("success", false);
				json.put("error", "会员日才可兑换哦!");
				return json.toString();
			}
			Users user = userService.selectUserByToken(token);
			if (user != null) {
				Long userid = user.getId();
				if (user.getTalentValue() > 900 && user.getTalentValue() - num > 900) {
					Long talentValue = user.getTalentValue();
					Integer integral = user.getIntegral();
					transformService.talentValueToIntegral(userid,talentValue,integral,num);
					json.put("success", true);
					json.put("error", "转换成功");
				} else {
					json.put("success", false);
					json.put("error", "您的天才值不足");
				}
			} else {
				json.put("success", false);
				json.put("error", "获取用户信息失败!");
			}

		} catch (Exception e) {
			logger.error("天才值转化积分:" + e.getMessage());
		}
		return json.toString();
	}

}
*/