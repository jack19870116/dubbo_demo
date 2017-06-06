package com.tiancaibao.pojo.pay.sina;

public class BindingBankCardRequestParam extends SinaBaseRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空
	 */
	//绑卡请求号
	private String request_no;
	//用户标识信息
	private String identity_id;
	//用户标识类型
	private String identity_type;
	//银行编号
	private String bank_code;
	//银行卡号
	private String bank_account_no;
	//卡类型
	private String card_type;
	//卡属性
	private String card_attribute;
	//省份
	private String province;
	//城市
	private String city;
	//请求者IP
	private String client_ip;
	
	
	/**
	 * 可空
	 */
	//户名
	private String account_name;
	//证件类型
	private String cert_type;
	//证件号码
	private String cert_no;
	//银行预留手机号
	private String phone_no;
	//有效期
	private String validity_period;
	//CVV2
	private String verification_value;
	//支行名称
	private String bank_branch;
	//认证方式
	private String verify_mode;
	//扩展信息
	private String extend_param;
	public String getRequest_no() {
		return request_no;
	}
	public void setRequest_no(String request_no) {
		this.request_no = request_no;
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
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(String bank_account_no) {
		this.bank_account_no = bank_account_no;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getCard_attribute() {
		return card_attribute;
	}
	public void setCard_attribute(String card_attribute) {
		this.card_attribute = card_attribute;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getCert_type() {
		return cert_type;
	}
	public void setCert_type(String cert_type) {
		this.cert_type = cert_type;
	}
	public String getCert_no() {
		return cert_no;
	}
	public void setCert_no(String cert_no) {
		this.cert_no = cert_no;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getValidity_period() {
		return validity_period;
	}
	public void setValidity_period(String validity_period) {
		this.validity_period = validity_period;
	}
	public String getVerification_value() {
		return verification_value;
	}
	public void setVerification_value(String verification_value) {
		this.verification_value = verification_value;
	}
	public String getBank_branch() {
		return bank_branch;
	}
	public void setBank_branch(String bank_branch) {
		this.bank_branch = bank_branch;
	}
	public String getVerify_mode() {
		return verify_mode;
	}
	public void setVerify_mode(String verify_mode) {
		this.verify_mode = verify_mode;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	
}
