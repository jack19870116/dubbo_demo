package com.tiancaibao.pojo.pay.sina;

public class QueryVerifyResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空
	 */
	// 认证内容
	private String verify_entity;
	// 认证时间
	private String verify_time;
	/**
	 * 可空
	 */
	// 扩展信息
	private String extend_param;

	public String getVerify_entity() {
		return verify_entity;
	}

	public void setVerify_entity(String verify_entity) {
		this.verify_entity = verify_entity;
	}

	public String getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(String verify_time) {
		this.verify_time = verify_time;
	}

	public String getExtend_param() {
		return extend_param;
	}

	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}

	@Override
	public String toString() {
		return "QueryVerifyResponseParam [" + (verify_entity != null ? "verify_entity=" + verify_entity + ", " : "")
				+ (verify_time != null ? "verify_time=" + verify_time + ", " : "")
				+ (extend_param != null ? "extend_param=" + extend_param + ", " : "")
				+ (getResponse_time() != null ? "getResponse_time()=" + getResponse_time() + ", " : "")
				+ (get_input_charset() != null ? "get_input_charset()=" + get_input_charset() + ", " : "")
				+ (getSign() != null ? "getSign()=" + getSign() + ", " : "")
				+ (getSign_type() != null ? "getSign_type()=" + getSign_type() + ", " : "")
				+ (getResponse_code() != null ? "getResponse_code()=" + getResponse_code() + ", " : "")
				+ (getPartner_id() != null ? "getPartner_id()=" + getPartner_id() + ", " : "")
				+ (getResponse_message() != null ? "getResponse_message()=" + getResponse_message() + ", " : "")
				+ (getMemo() != null ? "getMemo()=" + getMemo() + ", " : "")
				+ (getSign_version() != null ? "getSign_version()=" + getSign_version() : "") + "]";
	}

}
