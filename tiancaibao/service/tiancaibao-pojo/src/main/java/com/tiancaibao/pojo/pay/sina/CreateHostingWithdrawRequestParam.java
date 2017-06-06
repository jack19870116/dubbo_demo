package com.tiancaibao.pojo.pay.sina;

public class CreateHostingWithdrawRequestParam extends SinaBaseRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空参数
	 */
	//交易订单号
	private String out_trade_no;
	//用户标识信息
	private String identity_id;
	//用户标识类型
	private String identity_type;
	//金额
	private Double amount;
	//用户IP地址
	private String user_ip;
	
	/**
	 * 可空
	 */
	//摘要
	private String summary;
	//账户类型
	private String account_type;
	//用户手续费
	private Double user_fee;
	//银行卡ID
	private String card_id;
	//提现方式
	private String withdraw_mode;
	//到账类型
	private String payto_type;
	//提现关闭时间
	private String withdraw_close_time;
	//扩展信息
	private String extend_param;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public Double getUser_fee() {
		return user_fee;
	}
	public void setUser_fee(Double user_fee) {
		this.user_fee = user_fee;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getWithdraw_mode() {
		return withdraw_mode;
	}
	public void setWithdraw_mode(String withdraw_mode) {
		this.withdraw_mode = withdraw_mode;
	}
	public String getPayto_type() {
		return payto_type;
	}
	public void setPayto_type(String payto_type) {
		this.payto_type = payto_type;
	}
	public String getWithdraw_close_time() {
		return withdraw_close_time;
	}
	public void setWithdraw_close_time(String withdraw_close_time) {
		this.withdraw_close_time = withdraw_close_time;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	
	
}
