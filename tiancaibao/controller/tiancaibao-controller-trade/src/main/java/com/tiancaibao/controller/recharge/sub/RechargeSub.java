package com.tiancaibao.controller.recharge.sub;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.tiancaibao.constants.SinaPay;
import com.tiancaibao.controller.recharge.sub.exception.RechargeException;
import com.tiancaibao.exception.ControllerException;
import com.tiancaibao.pojo.sina.QueryHostingDepositResponseParam;
import com.tiancaibao.recharge.service.RechargeService;
import com.tiancaibao.sinapay.service.SinaPayService;
import com.tiancaibao.utils.DateUtil;

@Controller
public class RechargeSub {

	@Resource
	private SinaPayService sinaPayService;
	@Resource
	private RechargeService rechargeService;

	public String queryBankCard(Long userId) {
		String queryBankCard = sinaPayService.query_bank_card(userId);
		if (queryBankCard == null) {
			throw new ControllerException("请先绑卡");
		}
		return queryBankCard;
	}

	public void validateOverLimit(Long userId) {
		Integer rechargeLimit = rechargeService.selectCountRechargeRecordForLimit(userId, 1000000L,
				DateUtil.getDayStartDate());
		if(rechargeLimit>2){
			throw new RechargeException("当日充值超出限制,请联系客服");
		}
		
	}

	public String selectFcallbackurl(Double amount,String plat, String host, Long rechargeBillId,String source) {
		if("weixin".equals(source)){
			return "http://" + host + "/recharge/notify/"+rechargeBillId+"/"+plat;
		}
		if("app".equals(source)){
			return "http://" + host + "/jump/app-recharge-result?orderid="+rechargeBillId+"&amount="+amount;
		}
		return "";
	}

	public String selectSinaUrl(Long rechargeBillId, Double amount, String fcallbackurl, Long userId, String ip) {
		String sinaUrl = sinaPayService.create_hosting_deposit(rechargeBillId, amount, fcallbackurl, userId, SinaPay.RECHARGE_CALL_BACK_URL, ip);
		if(sinaUrl==null){
			throw new ControllerException("充值失败");
		}
		return sinaUrl;
	}

	public String selectFcallbackurl(Long amount, String plat, String host, Long billId) {
		String fcallbackurl = "http://" + host;
		if ("app".equals(plat)||"weixin".equals(plat)) {
			fcallbackurl += "/jump/recharge-processing/?orderid=" + billId + "&amount=" + amount + "&plat="
					+ plat;
		} else if ("PC_WEB".equals(plat)) {
			fcallbackurl += "/recharge?orderid=" + billId + "&amount=" + amount + "&plat=" + plat;
		} else {
			fcallbackurl += "/jump/recharge-processing/?orderid=" + billId + "&amount=" + amount + "&plat="
					+ plat;
		}
		return fcallbackurl;
	}

	public void queryHostingDeposit(Long userid, String orderCode) {
		QueryHostingDepositResponseParam qhd = sinaPayService.query_hosting_deposit(userid, orderCode, null,
				null);
		if(qhd==null||qhd.getResponse_code()==null||qhd.getDeposit_list()==null){
			throw new ControllerException("充值托管查询出错");
		}
		
	}

}
