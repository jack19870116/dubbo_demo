package com.tiancaibao.pojo.pay.sina;

public class UnbindingBankCardResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 可空
	 */
	//后续推进需要的参数
	private String ticket;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "UnbindingBankCardResponseParam [" + (ticket != null ? "ticket=" + ticket + ", " : "")
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
