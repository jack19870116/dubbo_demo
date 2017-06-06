package com.tiancaibao.service.pay;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pojo.pay.sina.BindingBankCardAdvanceRequestParam;
import com.tiancaibao.pojo.pay.sina.BindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.pay.sina.BindingBankCardRequestParam;
import com.tiancaibao.pojo.pay.sina.BindingBankCardResponseParam;
import com.tiancaibao.pojo.pay.sina.BindingVerifyRequestParam;
import com.tiancaibao.pojo.pay.sina.BindingVerifyResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateActivateMemberRequestParam;
import com.tiancaibao.pojo.pay.sina.CreateActivateMemberResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateHostingCollectTradeRequestParam;
import com.tiancaibao.pojo.pay.sina.CreateHostingCollectTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateHostingDepositRequestParam;
import com.tiancaibao.pojo.pay.sina.CreateHostingWithdrawRequestParam;
import com.tiancaibao.pojo.pay.sina.CreateSingleHostingPayTradeRequestParam;
import com.tiancaibao.pojo.pay.sina.CreateSingleHostingPayTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceRequestParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBankCardRequestParam;
import com.tiancaibao.pojo.pay.sina.QueryBankCardResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryHostingDepositRequestParam;
import com.tiancaibao.pojo.pay.sina.QueryHostingDepositResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryHostingTradeRequestParam;
import com.tiancaibao.pojo.pay.sina.QueryHostingTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryIsSetPayPasswordRequestParam;
import com.tiancaibao.pojo.pay.sina.QueryIsSetPayPasswordResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryVerifyRequestParam;
import com.tiancaibao.pojo.pay.sina.QueryVerifyResponseParam;
import com.tiancaibao.pojo.pay.sina.SetRealNameRequestParam;
import com.tiancaibao.pojo.pay.sina.SetRealNameResponseParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardAdvanceRequestParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardRequestParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardResponseParam;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;

@Service("paySinaPayService")
public class PaySinaPayServiceImpl implements IPaySinaPayService {

	@Resource
	private PaySinaPaySendService sinaPaySendService;

	private static final Logger log = LoggerFactory.getLogger(PaySinaPayServiceImpl.class);
	/**
	 * 查询余额/基金份额
	 */
	@Override
	public QueryBalanceResponseParam query_balance(Long userid) {
		QueryBalanceRequestParam qbrpar = new QueryBalanceRequestParam();
		// 基本参数抽取到父类中初始值
		qbrpar.setService("query_balance");
		qbrpar.setIdentity_id(String.valueOf(userid));
		qbrpar.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		qbrpar.setAccount_type(PropertiesUtil.getValue("ACCOUNT_TYPE"));
		qbrpar.setExtend_param("channel_black_list^online_bank");
		QueryBalanceResponseParam qbrp = sinaPaySendService.send2SinPay(qbrpar, QueryBalanceResponseParam.class);
		log.info("serviceName:查询余额(query_balance), userId: " + userid + " 查询参数: " + qbrpar + " 返回值: " + qbrp + "\n");
		return qbrp;
	}

	/*
	 * 托管提现 托管用户账户余额提现到银行卡，其中银行卡须归属此用户。
	 *
	 */
	@Override
	public String create_hosting_withdraw(Long userid, String billID, Double amount, Float fee, String account_type,
			String withdrawCallBackUrl, String fcallbackurl, String app, String ip) {
		CreateHostingWithdrawRequestParam chwr = new CreateHostingWithdrawRequestParam();
		// 服务名称
		chwr.setService("create_hosting_withdraw");
		// 交易订单号
		chwr.setOut_trade_no(billID);
		// 摘要[可空]
		chwr.setSummary("余额提现");
		// 用户标识信息
		chwr.setIdentity_id(userid + "");
		// 用户标识类型
		chwr.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 金额
		chwr.setAmount(amount);
		// 帐户类型
		chwr.setAccount_type(account_type);
		// ip
		chwr.setUser_ip(ip);
		// 用户手续费[可空]
		chwr.setUser_fee(fee.doubleValue());
		// 回调地址
		chwr.setNotify_url(withdrawCallBackUrl);
		// 页面跳转同步返回页面路径
		chwr.setReturn_url(fcallbackurl);
		log.info("serviceName:托管提现(create_hosting_withdraw),userId: " + userid + " 查询参数: " + chwr + "\n");
		return sinaPaySendService.send2SinPayGetSinaUrl(chwr);

	}

	/**
	 * 查询是否设置支付密码
	 * 
	 * @author Mack 2017年2月10日 上午10:32:15
	 * @param userid
	 * @return
	 */
	@Override
	public Boolean query_is_set_pay_password(Long userid) {
		QueryIsSetPayPasswordRequestParam qpara = new QueryIsSetPayPasswordRequestParam();
		qpara.setService("query_is_set_pay_password");
		qpara.setIdentity_id(userid + "");
		qpara.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		QueryIsSetPayPasswordResponseParam qisppr = sinaPaySendService.send2SinPay(qpara,
				QueryIsSetPayPasswordResponseParam.class);
		
		log.info("serviceName:查询是否设置支付密码(query_is_set_pay_password),userId: " + userid + " 查询参数: " + qpara + " 返回值: " + qisppr + "\n");
		
		if ("APPLY_SUCCESS".equals(qisppr.getResponse_code()) && "Y".equals(qisppr.getIs_set_paypass())) {
			return true;
		}
		
		return false;
	}

	/**
	 * 查询认证信息
	 * 
	 * @author Mack 2017年2月10日 上午10:40:42
	 * @param userid
	 * @param verify_type
	 * @return
	 */
	@Override
	public QueryVerifyResponseParam query_verify(Long userid, String verify_type) {
		QueryVerifyRequestParam qvrp = new QueryVerifyRequestParam();
		// 服务名称
		qvrp.setService("query_verify");
		// 用户标识信息
		qvrp.setIdentity_id(userid + "");
		// 用户标识类型
		qvrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 认证类型
		if (StringUtils.isNotBlank(verify_type)) {
			qvrp.setVerify_type(verify_type);
		} else {
			qvrp.setVerify_type(PropertiesUtil.getValue("SINAPAY_VERIFY_TYPE"));
		}
		QueryVerifyResponseParam qvrpr = sinaPaySendService.send2SinPay(qvrp, QueryVerifyResponseParam.class);
		
		log.info("serviceName:查询认证信息(query_verify),userId:" + userid + "查询参数: " + qvrp + " 返回值: " + qvrpr + "\n");


		/*
		 * Map<String, String> resultmap = sinaPaySendService.send(qvrp); if
		 * (resultmap.get("error") != null) { throw new ServiceException(
		 * "sign error"); } if (resultmap.get("result") != null) { return
		 * JSONObject.parseObject(resultmap.get("result"),
		 * QueryVerifyResponseParam.class); }
		 */
		return qvrpr;
	}

	/**
	 * 创建激活会员
	 * 
	 * @author Mack 2017年2月10日 上午10:50:07
	 * @param userid
	 * @param ip
	 * @return
	 */
	@Override
	public CreateActivateMemberResponseParam create_activate_member(Long userid, String ip) {
		CreateActivateMemberRequestParam camrp = new CreateActivateMemberRequestParam();
		// 业务参数
		camrp.setService("create_activate_member");
		camrp.setIdentity_id(userid + "");
		camrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 用户类型，默认为1，个人用户
		camrp.setMember_type(PropertiesUtil.getValue("SINAPAY_VERIFY_TYPE"));
		// 请求者ip
		camrp.setClient_ip(ip);
		CreateActivateMemberResponseParam camrpr = sinaPaySendService.send2SinPay(camrp,
				CreateActivateMemberResponseParam.class);
		
		log.info("serviceName:创建激活会员(create_activate_member),userId: " + userid + " 查询参数: " + camrp + " 返回值: " + camrpr + "\n");

		return camrpr;
	}

	/**
	 * 设置实名信息
	 * 
	 * @author Mack 2017年2月10日 上午10:56:42
	 * @param userid
	 * @param idcard_number
	 * @param idcard_name
	 * @param ip
	 * @return
	 */
	@Override
	public SetRealNameResponseParam set_real_name(Long userid, String idcard_number, String idcard_name, String ip) {
		SetRealNameRequestParam arnrp = new SetRealNameRequestParam();
		// 业务参数
		arnrp.setService("set_real_name");
		arnrp.setIdentity_id(userid + "");
		arnrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 对证件号进行加密
		arnrp.setCert_no(idcard_number);
		arnrp.setReal_name(idcard_name);
		// 证件类型
		arnrp.setCert_type(PropertiesUtil.getValue("SINAPAY_VERIFY_TYPE"));
		// 请求者ip
		arnrp.setClient_ip(ip);
		SetRealNameResponseParam arnrpr = sinaPaySendService.send2SinPay(arnrp, SetRealNameResponseParam.class);
		
		log.info("serviceName:设置实名认证(set_real_name),userId: " + userid + " 查询参数: " + arnrp + "返回值: " + arnrpr + "\n");


		return arnrpr;
	}

	@Override
	public BindingVerifyResponseParam binding_verify(Long userid, String phone, String ip) {
		BindingVerifyRequestParam bvrp = new BindingVerifyRequestParam();
		// 业务参数
		bvrp.setService("binding_verify");
		bvrp.setIdentity_id(userid + "");
		bvrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 认证类型
		bvrp.setVerify_type(PropertiesUtil.getValue("SINAPAY_VERIFY_TYPE"));
		// 请求者ip
		bvrp.setClient_ip(ip);
		// 认证内容
		bvrp.setVerify_entity(phone);
		BindingVerifyResponseParam bvrpr = sinaPaySendService.send2SinPay(bvrp, BindingVerifyResponseParam.class);
		
		log.info("serviceName:绑定认证手机号(binding_verify),userId: " + userid + " 查询参数: " + bvrp + " 返回值: " + bvrpr + "\n");


		return bvrpr;
	}

	@Override
	public BindingBankCardResponseParam binding_bank_card(Long userid, String bank_id, String bank_card,
			String idcardName, String idcardNumber, String phone, String provinceName, String areaName, String ip) {
		BindingBankCardRequestParam bbcrp = new BindingBankCardRequestParam();
		bbcrp.setService("binding_bank_card");
		// 绑卡请求号
		bbcrp.setRequest_no(DateUtil.formatDateByFormat(new Date(), "yyyyMMddHHmmss") + userid);
		// 用户标识信息
		bbcrp.setIdentity_id(userid + "");
		// 用户标识类型
		bbcrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 银行编号
		bbcrp.setBank_code(bank_id);
		// 银行卡号
		bbcrp.setBank_account_no(bank_card);
		// 户名[可空][RSA加密]
		bbcrp.setAccount_name(idcardName);
		// 卡类型
		bbcrp.setCard_type(PropertiesUtil.getValue("SINAPAY_CARD_TYPE"));
		// 请求者ip
		bbcrp.setClient_ip(ip);
		// 卡属性
		bbcrp.setCard_attribute(PropertiesUtil.getValue("SINA_CARD_ATTRIBUTE"));
		// 证件类型[可空]
		bbcrp.setCert_type(PropertiesUtil.getValue("SINAPAY_CERT_TYPE"));
		// 证件号码[可空]
		bbcrp.setCert_no(idcardNumber);
		// 银行预留手机号码[可空]
		bbcrp.setPhone_no(phone);
		// 省份
		bbcrp.setProvince(provinceName);
		// 城市
		bbcrp.setCity(areaName);
		// 认证方式[可空]
		bbcrp.setVerify_mode("SIGN");
		BindingBankCardResponseParam bbcrpr = sinaPaySendService.send2SinPay(bbcrp, BindingBankCardResponseParam.class);
		
		log.info("serviceName:绑定银行卡(binding_bank_card),userId: " + userid + " 查询参数: " + bbcrp + " 返回值: " + bbcrpr + "\n");


		return bbcrpr;
	}

	@Override
	public BindingBankCardAdvanceResponseParam binding_bank_card_advance(String ticket, String phone_code, String ip) {
		BindingBankCardAdvanceRequestParam bbcarp = new BindingBankCardAdvanceRequestParam();
		bbcarp.setService("binding_bank_card_advance");
		bbcarp.setTicket(ticket);
		bbcarp.setValid_code(phone_code);
		// 请求者ip
		bbcarp.setClient_ip(ip);
		BindingBankCardAdvanceResponseParam bbcarpr = sinaPaySendService.send2SinPay(bbcarp,
				BindingBankCardAdvanceResponseParam.class);
		
		log.info("serviceName:绑卡推进(binding_bank_card_advance),userId: " + " 查询参数: " + bbcarp + " 返回值: " + bbcarpr + "\n");


		return bbcarpr;
	}

	@Override
	public QueryBankCardResponseParam query_bank_card(Long uid) {
		QueryBankCardRequestParam qbcrp = new QueryBankCardRequestParam();
		qbcrp.setService("query_bank_card");
		// 用户标识信息
		qbcrp.setIdentity_id(uid + "");
		// 用户标识类型
		qbcrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		
		QueryBankCardResponseParam qbcrpr = sinaPaySendService.send2SinPay(qbcrp, QueryBankCardResponseParam.class);

		log.info("serviceName:查询银行卡(query_bank_card),userId: " + " 查询参数: " + qbcrp + " 返回值: " + qbcrpr + "\n");
		
		return qbcrpr;
	}

	@Override
	public UnbindingBankCardResponseParam unbinding_bank_card(Long userid, String ip, String card_id) {
		UnbindingBankCardRequestParam ubcrp = new UnbindingBankCardRequestParam();
		ubcrp.setService("unbinding_bank_card");
		// 用户标识信息
		ubcrp.setIdentity_id(userid + "");
		// 用户标识类型
		ubcrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 卡ID
		ubcrp.setCard_id(card_id);
		// 是否推进
		ubcrp.setAdvance_flag("Y");
		// 请求者ip
		ubcrp.setClient_ip(ip);
		UnbindingBankCardResponseParam ubcrpr = sinaPaySendService.send2SinPay(ubcrp,
				UnbindingBankCardResponseParam.class);
		
		log.info("serviceName:解绑银行卡(unbinding_bank_card),userId: " + " 查询参数: " + ubcrp + " 返回值: " + ubcrpr + "\n");

		return ubcrpr;
	}

	@Override
	public UnbindingBankCardAdvanceResponseParam unbinding_bank_card_advance(Long userid, String ip, String ticket,
			String valid_code) {
		UnbindingBankCardAdvanceRequestParam ubcarp = new UnbindingBankCardAdvanceRequestParam();
		ubcarp.setService("unbinding_bank_card_advance");
		// 用户标识信息
		ubcarp.setIdentity_id(userid + "");
		// 用户标识类型
		ubcarp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 卡ID
		ubcarp.setTicket(ticket);
		// 短信验证码
		ubcarp.setValid_code(valid_code);
		// 请求者ip
		ubcarp.setClient_ip(ip);
		UnbindingBankCardAdvanceResponseParam ubcarpr = sinaPaySendService.send2SinPay(ubcarp,
				UnbindingBankCardAdvanceResponseParam.class);
		
		log.info("serviceName:解绑银行卡推进(unbinding_bank_card_advance),userId: " + userid + " 查询参数: " + ubcarp + " 返回值: " + ubcarpr + "\n");
		/*
		 * if (resultmap.get("error") != null) { throw new ServiceException(
		 * "sign error"); } if (resultmap.get("result") != null) { return
		 * JSONObject.parseObject(resultmap.get("result"),
		 * UnbindingBankCardAdvanceResponseParam.class); }
		 */
		return ubcarpr;
	}

	/**
	 * 托管充值查询 说明 查询充值结果，可用于补单确认，也可用于页面查询。 交易号和时间至少一项存在，同时存在以交易号为准；
	 * 开始时间和结束时间须同时存在，时间跨度须小于3个月。
	 */
	@Override
	public QueryHostingDepositResponseParam query_hosting_deposit(Long userid, String orderCode, String start_time,
			String end_time) {
		QueryHostingDepositRequestParam qhdrp = new QueryHostingDepositRequestParam();
		// 服务名称
		qhdrp.setService("query_hosting_deposit");
		// 用户标识信息
		qhdrp.setIdentity_id(userid + "");
		// 用户标识类型
		qhdrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 交易订单号[可空][交易订单号和时间区间不能同时为空]
		qhdrp.setOut_trade_no(orderCode); // 订单号为我公司生成的订单号
		// 开始时间[可空]
		qhdrp.setStart_time(start_time);
		// 结束时间[可空]
		qhdrp.setEnd_time(end_time);
		QueryHostingDepositResponseParam qhdrpr = sinaPaySendService.send2SinPay(qhdrp,
				QueryHostingDepositResponseParam.class);
		
		log.info("serviceName:查询托管充值结果(query_hosting_deposit),userId: " + userid + " 查询参数: " + qhdrp + " 返回值: " + qhdrpr + "\n");

		/*
		 * if(qhdrpr==null||qhdrpr.getResponse_code()==null||qhdrpr.
		 * getDeposit_list()==null){ throw new ServiceException("托管充值查询出错"); }
		 */
		return qhdrpr;
	}

	@Override
	public QueryHostingTradeResponseParam query_hosting_trade(Long userId, String outtradeno) {
		QueryHostingTradeRequestParam qhtrp = new QueryHostingTradeRequestParam();
		qhtrp.setService("query_hosting_trade");
		// 用户标识信息
		qhtrp.setIdentity_id(userId + "");
		// 用户标识类型
		qhtrp.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 交易订单号
		qhtrp.setOut_trade_no(outtradeno);
		QueryHostingTradeResponseParam qhtrpr = sinaPaySendService.send2SinPay(qhtrp,
				QueryHostingTradeResponseParam.class);
		
		log.info("serviceName:查询托管交易结果(query_hosting_trade),userId: " + userId + " 查询参数: " + qhtrp + " 返回值: " + qhtrpr + "\n");


		return qhtrpr;
	}

	@Override
	public String create_hosting_deposit(String orderCade, Double amount, String fcallbackurl, Long userid,
			String rechargeCallBackUrl, String ip) {
		CreateHostingDepositRequestParam chdr = new CreateHostingDepositRequestParam();
		chdr.setService("create_hosting_deposit");
		// 交易订单号
		chdr.setOut_trade_no(orderCade + "");
		// 充值内容摘要[可空]
		chdr.setSummary("账户充值");
		// 用户标识信息
		chdr.setIdentity_id(userid + "");
		// ip
		chdr.setPayer_ip(ip);
		// 用户标识类型
		chdr.setIdentity_type(PropertiesUtil.getValue("SINAPAY_IDENTITY_TYPE"));
		// 账户类型[可空]
		chdr.setAccount_type(PropertiesUtil.getValue("ACCOUNT_TYPE"));
		// 金额
		chdr.setAmount(amount);
		// 支付方式 online_bank + sinapay
		chdr.setPay_method(PropertiesUtil.getValue("SINAPAY_PAY_METHOD") + "^" + amount + "^" + "SINAPAY,"
				+ PropertiesUtil.getValue("SINAPAY_CARD_TYPE") + "," + PropertiesUtil.getValue("SINA_CARD_ATTRIBUTE"));
		// 回调地址
		chdr.setNotify_url(rechargeCallBackUrl);
		// 页面跳转同步返回页面路径
		chdr.setReturn_url(fcallbackurl);
		
		log.info("serviceName:托管充值(create_hosting_deposit),userId: " + " 查询参数: " + chdr + "\n");

		return sinaPaySendService.send2SinPayGetSinaUrl(chdr);

	}

	/**
	 * 
	 */
	@Override
	public Map<String, String> operate_col(String marked, Long userid, Double amount, long days, String ip,
			String client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void queryBankCard(Users userInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public CreateHostingCollectTradeResponseParam create_hosting_collect_trade(String order_code, String out_trade_code,
			String summary, String payer_id, String ip, String payer_identity_type, String notify_url,
			String call_url_address, Double amount, String account_type) {
		CreateHostingCollectTradeRequestParam crparam = new CreateHostingCollectTradeRequestParam();
		crparam.setService("create_hosting_collect_trade");
		crparam.setOut_trade_no(order_code);
		crparam.setOut_trade_code(!out_trade_code.equals("1001") ? "1002" : out_trade_code);
		crparam.setSummary(summary);
		crparam.setTrade_close_time("5m");
		crparam.setPayer_id(payer_id);
		crparam.setPayer_ip(ip);
		crparam.setPayer_identity_typ(payer_identity_type);
		if (payer_identity_type.equals("UID")) {

			crparam.setPay_method(PropertiesUtil.getValue("SINAPAY_PAY_METHOD") + "^" + amount + "^" + "SINAPAY,"
					+ PropertiesUtil.getValue("SINAPAY_CARD_TYPE") + ","
					+ PropertiesUtil.getValue("SINA_CARD_ATTRIBUTE"));

		} else if (payer_identity_type.equals("EMAIL")) {
			// 平台
			crparam.setPay_method("balance" + "^" + amount + "^" + account_type);
		} else {
			return null;
		}
		crparam.setNotify_url(notify_url);
		if (call_url_address != null) {
			crparam.setReturn_url(call_url_address);
		}
		CreateHostingCollectTradeResponseParam send2SinPay = sinaPaySendService.send2SinPay(crparam,
				CreateHostingCollectTradeResponseParam.class);
		
		log.info("serviceName:托管代收(create_hosting_collect_trade),userId: " + " 查询参数: " + crparam + " 同步返回值: " + send2SinPay +"\n");
		
		return send2SinPay;
	}

	@Override
	public CreateSingleHostingPayTradeResponseParam create_single_hosting_pay_trade(String order_code, Double amount,
			String user_id, String notify_url, String ip, String summary) {

		CreateSingleHostingPayTradeRequestParam cptrparam = new CreateSingleHostingPayTradeRequestParam();
		cptrparam.setService("create_single_hosting_pay_trade");
		cptrparam.setOut_trade_no(order_code);
		cptrparam.setAmount(amount);
		cptrparam.setOut_trade_code("2002");
		cptrparam.setPayee_identity_id(user_id);
		cptrparam.setPayee_identity_type("UID");
		cptrparam.setAccount_type("SAVING_POT");
		cptrparam.setNotify_url(notify_url);
		cptrparam.setUser_ip(ip);
		cptrparam.setSummary("赎回代付");

		CreateSingleHostingPayTradeResponseParam send2SinPay = sinaPaySendService.send2SinPay(cptrparam,
				CreateSingleHostingPayTradeResponseParam.class);
		
		log.info("serviceName:托管代付(create_single_hosting_pay_trade),userId: " + " 查询参数: " + cptrparam +  " 同步返回值: " + send2SinPay +"\n");

		return send2SinPay;
	}

	@Override
	public String create_order_id(String ingerface_name, String direction, Long user_id) {

		long start = System.nanoTime(); // 毫微秒
		return ingerface_name + "^" + direction + "^" + DateUtil.formatDateTOyMdHmsForSina(new Date()) + "^" + NumberFormat.leftAdd0(user_id);

	}

}
