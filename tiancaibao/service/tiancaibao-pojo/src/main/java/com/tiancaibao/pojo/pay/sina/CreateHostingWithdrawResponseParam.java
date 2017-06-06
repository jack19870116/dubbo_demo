package com.tiancaibao.pojo.pay.sina;

public class CreateHostingWithdrawResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 非空
	 */
	//提现订单号
	private String out_trade_no;
	/**
	 * 可空
	 */
	//提现状态
	private String withdraw_status;
	//收银台重定向地址
	private String redirect_url;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getWithdraw_status() {
		return withdraw_status;
	}
	public void setWithdraw_status(String withdraw_status) {
		this.withdraw_status = withdraw_status;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	@Override
	public String toString() {
		return "CreateHostingWithdrawResponseParam ["
				+ (out_trade_no != null ? "out_trade_no=" + out_trade_no + ", " : "")
				+ (withdraw_status != null ? "withdraw_status=" + withdraw_status + ", " : "")
				+ (redirect_url != null ? "redirect_url=" + redirect_url + ", " : "")
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
