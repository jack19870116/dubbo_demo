package com.tiancaibao.pojo.pay.sina;

public class BindingVerifyResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "BindingVerifyResponseParam ["
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
	
	/**
	 * 无业务响应
	 */

}
