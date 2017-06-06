package com.tiancaibao.pojo.pay.sina;

public class CreateHostingDepositResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//充值订单号
	private String out_trade_no;
	//充值状态
	private String deposit_status;
	//后续推进需要的参数
	private String ticket;
	//线下支付收款单位
	private String trans_account_name;
	//线下支付收款账号
	private String trans_account_no;
	//线下支付收款账号开户行
	private String trans_bank_brank;
	//线下支付收款备注
	private String trans_trade_no;
	//收银台重定向地址
	private String redirect_url;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getDeposit_status() {
		return deposit_status;
	}
	public void setDeposit_status(String deposit_status) {
		this.deposit_status = deposit_status;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getTrans_account_name() {
		return trans_account_name;
	}
	public void setTrans_account_name(String trans_account_name) {
		this.trans_account_name = trans_account_name;
	}
	public String getTrans_account_no() {
		return trans_account_no;
	}
	public void setTrans_account_no(String trans_account_no) {
		this.trans_account_no = trans_account_no;
	}
	public String getTrans_bank_brank() {
		return trans_bank_brank;
	}
	public void setTrans_bank_brank(String trans_bank_brank) {
		this.trans_bank_brank = trans_bank_brank;
	}
	public String getTrans_trade_no() {
		return trans_trade_no;
	}
	public void setTrans_trade_no(String trans_trade_no) {
		this.trans_trade_no = trans_trade_no;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
	@Override
	public String toString() {
		return "CreateHostingDepositResponseParam ["
				+ (out_trade_no != null ? "out_trade_no=" + out_trade_no + ", " : "")
				+ (deposit_status != null ? "deposit_status=" + deposit_status + ", " : "")
				+ (ticket != null ? "ticket=" + ticket + ", " : "")
				+ (trans_account_name != null ? "trans_account_name=" + trans_account_name + ", " : "")
				+ (trans_account_no != null ? "trans_account_no=" + trans_account_no + ", " : "")
				+ (trans_bank_brank != null ? "trans_bank_brank=" + trans_bank_brank + ", " : "")
				+ (trans_trade_no != null ? "trans_trade_no=" + trans_trade_no + ", " : "")
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
