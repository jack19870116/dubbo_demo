package com.tiancaibao.pojo.pay.sina;

public class SetRealNameRequestParam extends SinaBaseRequestParam {

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
	//真实姓名
	private String real_name;
	//证件类型
	private String cert_type;
	//证件号码
	private String cert_no;
	//请求者IP
	private String client_ip;
	/**
	 * 可空
	 */
	//是否认证
	private String need_confirm;
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
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
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
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getNeed_confirm() {
		return need_confirm;
	}
	public void setNeed_confirm(String need_confirm) {
		this.need_confirm = need_confirm;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	
}
