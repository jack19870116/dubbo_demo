package com.tiancaibao.service.interfaces.pay;

import java.util.Map;

import com.tiancaibao.pojo.pay.sina.BindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.pay.sina.BindingBankCardResponseParam;
import com.tiancaibao.pojo.pay.sina.BindingVerifyResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateActivateMemberResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateHostingCollectTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.CreateSingleHostingPayTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBankCardResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryHostingDepositResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryHostingTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryVerifyResponseParam;
import com.tiancaibao.pojo.pay.sina.SetRealNameResponseParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardAdvanceResponseParam;
import com.tiancaibao.pojo.pay.sina.UnbindingBankCardResponseParam;
import com.tiancaibao.pojo.user.Users;

/**
 * 新浪支付接口的Dubbo服务接口
 * 
 * @author Mack 2017年2月3日 下午4:00:07
 */
public interface IPaySinaPayService {

	public QueryBalanceResponseParam query_balance(Long userid);

	public String create_hosting_withdraw(Long userid, String billID, Double amount, Float fee, String account_type,
			String withdrawCallBackUrl, String fcallbackurl, String app, String ip);

	public Boolean query_is_set_pay_password(Long userid);

	public QueryVerifyResponseParam query_verify(Long userid, String verify_type);

	public CreateActivateMemberResponseParam create_activate_member(Long userid, String ip);

	public SetRealNameResponseParam set_real_name(Long userid, String idcard_number, String idcard_name, String ip);

	/**
	 * 绑定认证信息
	 * 
	 * @author Mack 2017年2月10日 下午2:39:50
	 * @param userid
	 * @param phone
	 * @param ip
	 * @return
	 */
	public BindingVerifyResponseParam binding_verify(Long userid, String phone, String ip);

	/**
	 * 绑定银行卡
	 * 
	 * @author Mack 2017年2月10日 下午2:41:44
	 * @param userid
	 * @param bank_id
	 * @param bank_card
	 * @param idcardName
	 * @param idcardNumber
	 * @param phone
	 * @param provinceName
	 * @param areaName
	 * @param ip
	 * @return
	 */
	public BindingBankCardResponseParam binding_bank_card(Long userid, String bank_id, String bank_card,
			String idcardName, String idcardNumber, String phone, String provinceName, String areaName, String ip);

	/**
	 * 绑卡推进
	 * 
	 * @param ticket
	 * @param phone_code
	 * @param ip
	 * @return
	 */
	public BindingBankCardAdvanceResponseParam binding_bank_card_advance(String ticket, String phone_code, String ip);

	/**
	 * 查询银行卡
	 * 
	 * @author Mack 2017年2月13日 下午3:47:43
	 * @param uid
	 * @return
	 */

	/**
	 * 根据用户信息查询新浪用户所绑定的银行卡
	 * 
	 * @param userInfo
	 */
	public void queryBankCard(Users userInfo);

	/**
	 * 根据用户ID查询用户的绑卡记录
	 * 
	 * @param uid
	 * @return
	 */
	public QueryBankCardResponseParam query_bank_card(Long uid);

	/**
	 * 解绑卡
	 * 
	 * @param userid
	 * @param ip
	 * @param card_id
	 * @return
	 */
	public UnbindingBankCardResponseParam unbinding_bank_card(Long userid, String ip, String card_id);

	/**
	 * 解绑卡推进
	 * 
	 * @param userid
	 * @param ip
	 * @param ticket
	 * @param valid_code
	 * @return
	 */
	public UnbindingBankCardAdvanceResponseParam unbinding_bank_card_advance(Long userid, String ip, String ticket,
			String valid_code);

	/**
	 * 
	 * @param userid
	 * @param orderCode
	 * @param start_time
	 * @param end_time
	 * @return
	 */
	public QueryHostingDepositResponseParam query_hosting_deposit(Long userid, String orderCode, String start_time,
			String end_time);

	public QueryHostingTradeResponseParam query_hosting_trade(Long userId, String outtradeno);

	public Map<String, String> operate_col(String marked, Long userid, Double amount, long days, String ip,
			String client);

	public String create_hosting_deposit(String orderCard, Double amount, String fcallbackurl, Long userid,
			String rechargeCallBackUrl, String ip);

	/**
	 * 代收交易
	 * 
	 * @param order_code
	 * @param out_trade_code
	 * @param summary
	 * @param payer_id
	 * @param ip
	 * @param payer_identity_type
	 * @param notify_url
	 * @param call_url_address
	 * @return
	 */
	public CreateHostingCollectTradeResponseParam create_hosting_collect_trade(String order_code, String out_trade_code,
			String summary, String payer_id, String ip, String payer_identity_type, String notify_url,
			String call_url_address,Double amount,String account_type);

	/**
	 * 代付交易
	 * 
	 * @param order_code
	 * @param amount
	 * @param user_id
	 * @param notify_url
	 * @param ip
	 * @param summary
	 * @return
	 */
	public CreateSingleHostingPayTradeResponseParam create_single_hosting_pay_trade(String order_code, Double amount,
			String user_id, String notify_url, String ip, String summary);

	
	public String create_order_id(String ingerface_name,String direction,Long user_id);
	
	
	
}
