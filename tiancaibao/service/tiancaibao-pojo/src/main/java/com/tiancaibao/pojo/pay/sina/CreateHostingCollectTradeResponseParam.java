package com.tiancaibao.pojo.pay.sina;

public class CreateHostingCollectTradeResponseParam extends SinaBaseResponseParam {

	private static final long serialVersionUID = 1L;
	// 交易订单号
	private String out_trade_no;
	// 交易状态 可空
	private String trade_status;
	// 支付状态 可空
	private String pay_status;
	// 后续推进需要的参数
	private String ticket;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
