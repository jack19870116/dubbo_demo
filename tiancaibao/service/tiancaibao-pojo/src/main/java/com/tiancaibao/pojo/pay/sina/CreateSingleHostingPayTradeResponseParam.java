package com.tiancaibao.pojo.pay.sina;

public class CreateSingleHostingPayTradeResponseParam extends SinaBaseResponseParam {

	private static final long serialVersionUID = 1L;
	// 交易订单号
	private String out_trade_no;
	// 交易状态 可空
	private String trade_status;

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

}
