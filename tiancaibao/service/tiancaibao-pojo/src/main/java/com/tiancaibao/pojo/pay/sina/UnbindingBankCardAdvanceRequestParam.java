package com.tiancaibao.pojo.pay.sina;

public class UnbindingBankCardAdvanceRequestParam extends SinaBaseRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空
	 */
	//用户标识信息
	private String identity_id;
	//用户标识类型
	private String identity_type;
	//绑卡时返回的ticket
	private String ticket;
	//短信验证码
	private String valid_code;
	//请求者IP
	private String client_ip;
	/**
	 * 可空
	 */
	//扩展信息
	private String extend_param;
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
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getValid_code() {
		return valid_code;
	}
	public void setValid_code(String valid_code) {
		this.valid_code = valid_code;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	
	
}
