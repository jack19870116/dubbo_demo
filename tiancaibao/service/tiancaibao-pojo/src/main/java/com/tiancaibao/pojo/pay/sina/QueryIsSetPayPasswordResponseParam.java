package com.tiancaibao.pojo.pay.sina;

public class QueryIsSetPayPasswordResponseParam extends SinaBaseResponseParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空
	 */
	//是否已设置支付密码
	private String is_set_paypass;
	public String getIs_set_paypass() {
		return is_set_paypass;
	}
	public void setIs_set_paypass(String is_set_paypass) {
		this.is_set_paypass = is_set_paypass;
	}
	@Override
	public String toString() {
		return "QueryIsSetPayPasswordResponseParam ["
				+ (is_set_paypass != null ? "is_set_paypass=" + is_set_paypass + ", " : "")
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
