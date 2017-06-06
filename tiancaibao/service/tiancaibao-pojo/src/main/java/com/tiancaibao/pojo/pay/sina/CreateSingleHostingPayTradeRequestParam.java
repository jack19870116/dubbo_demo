package com.tiancaibao.pojo.pay.sina;

public class CreateSingleHostingPayTradeRequestParam extends SinaBaseRequestParam {

	private static final long serialVersionUID = 1L;

	// 交易订单号
	private String out_trade_no;
	// 外部业务代码
	private String out_trade_code;
	// 收款人标识
	private String payee_identity_id;
	// 收款人标识类型
	private String payee_identity_type;
	// 收款人账户类型 可空
	private String account_type;

	// 金额
	private Double amount;
	// 分账信息列表 可空
	private String split_list;

	// 摘要
	private String summary;
	//用户IP地址
		private String user_ip;
	// 扩展信息
	private String extend_param;
	// 商户标的号
	private String goods_id;
	
	// 债权变动明细
	private String creditor_i;
	// 列表 只针对恒丰
	private String nfo_list;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getOut_trade_code() {
		return out_trade_code;
	}
	public void setOut_trade_code(String out_trade_code) {
		this.out_trade_code = out_trade_code;
	}
	public String getPayee_identity_id() {
		return payee_identity_id;
	}
	public void setPayee_identity_id(String payee_identity_id) {
		this.payee_identity_id = payee_identity_id;
	}
	public String getPayee_identity_type() {
		return payee_identity_type;
	}
	public void setPayee_identity_type(String payee_identity_type) {
		this.payee_identity_type = payee_identity_type;
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
	public String getSplit_list() {
		return split_list;
	}
	public void setSplit_list(String split_list) {
		this.split_list = split_list;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getCreditor_i() {
		return creditor_i;
	}
	public void setCreditor_i(String creditor_i) {
		this.creditor_i = creditor_i;
	}
	public String getNfo_list() {
		return nfo_list;
	}
	public void setNfo_list(String nfo_list) {
		this.nfo_list = nfo_list;
	}

}
