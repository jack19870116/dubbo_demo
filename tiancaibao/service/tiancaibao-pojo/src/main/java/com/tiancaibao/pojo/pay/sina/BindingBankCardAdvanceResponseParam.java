package com.tiancaibao.pojo.pay.sina;

public class BindingBankCardAdvanceResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 非空
	 */
	//卡ID
	private String card_id;
	//是否已认证
	private String is_verified;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getIs_verified() {
		return is_verified;
	}
	public void setIs_verified(String is_verified) {
		this.is_verified = is_verified;
	}
	@Override
	public String toString() {
		return "BindingBankCardAdvanceResponseParam [" + (card_id != null ? "card_id=" + card_id + ", " : "")
				+ (is_verified != null ? "is_verified=" + is_verified + ", " : "")
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
