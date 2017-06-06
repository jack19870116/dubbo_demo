package com.tiancaibao.pojo.pay.sina;

public class QueryBalanceRequestParam extends SinaBaseRequestParam {

	private static final long serialVersionUID = 1L;
	/**
	 * 非空参数
	 */
	// 用户标识信息
	private String identity_id;
	// 用户标识类型
	private String identity_type;
	/**
	 * 可空参数
	 */
	// 账户类型
	private String account_type;
	// 扩展信息
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

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getExtend_param() {
		return extend_param;
	}

	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}

}
