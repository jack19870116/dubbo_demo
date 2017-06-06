package com.tiancaibao.pojo.pay.sina;

public class CreateHostingDepositRequestParam extends SinaBaseRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//交易订单号
	private String out_trade_no;
	//摘要
	private String summary;
	//用户标识信息
	private String identity_id;
	//用户标识类型
	private String identity_type;
	//账户类型
	private String account_type;
	//金额
	private Double amount;
	//用户手续费
	private Double user_fee;
	//付款用户IP地址
	private String payer_ip;
	//充值关闭时间
	private String deposit_close_time;
	//支付方式
	private String pay_method ;
	//扩展信息
	private String extend_param;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIdentity_id() {
		return identity_id;
	}
	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}
	public String getIdentity_type() {
		return identity_type;
	}
	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getUser_fee() {
		return user_fee;
	}
	public void setUser_fee(Double user_fee) {
		this.user_fee = user_fee;
	}
	public String getPayer_ip() {
		return payer_ip;
	}
	public void setPayer_ip(String payer_ip) {
		this.payer_ip = payer_ip;
	}
	public String getDeposit_close_time() {
		return deposit_close_time;
	}
	public void setDeposit_close_time(String deposit_close_time) {
		this.deposit_close_time = deposit_close_time;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	
}
