package com.tiancaibao.pojo.pay.sina;

public class QueryVerifyRequestParam extends SinaBaseRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空
	 */
	// 用户标识信息
	private String identity_id;
	// 用户标识类型
	private String identity_type;
	// 认证类型
	private String verify_type;
	/**
	 * 可空
	 */
	// 是否掩码
	private String is_mask;
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

	public String getVerify_type() {
		return verify_type;
	}

	public void setVerify_type(String verify_type) {
		this.verify_type = verify_type;
	}

	public String getIs_mask() {
		return is_mask;
	}

	public void setIs_mask(String is_mask) {
		this.is_mask = is_mask;
	}

	public String getExtend_param() {
		return extend_param;
	}

	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}

}
