package com.tiancaibao.pojo.pay.sina;

public class CreateHostingCollectTradeRequestParam extends SinaBaseRequestParam {

	private static final long serialVersionUID = 1L;

	// 交易订单号
	private String out_trade_no;
	// 外部业务代码
	private String out_trade_code;
	// 摘要
	private String summary;
	// 交易关闭时间 可空
	private String trade_close_time;
	// 交易失败是否重新支付 默认为N 可空
	private String can_repay_on_failed;

	// 扩展信息
	private String extend_param;
	// 商户标的号 可空
	private String goods_id;

	// 付款用户ID
	private String payer_id;
	// 标识类型
	private String payer_identity_typ;
	// 付款用户IP地址
	private String payer_ip;
	// 支付方式
	private String pay_method;
	// 支付方式
	private String collect_trade_type;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getOut_trade_code() {
		return out_trade_code;
	}
	public void setOut_trade_code(String out_trade_code) {
		this.out_trade_code = out_trade_code;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTrade_close_time() {
		return trade_close_time;
	}
	public void setTrade_close_time(String trade_close_time) {
		this.trade_close_time = trade_close_time;
	}
	public String getCan_repay_on_failed() {
		return can_repay_on_failed;
	}
	public void setCan_repay_on_failed(String can_repay_on_failed) {
		this.can_repay_on_failed = can_repay_on_failed;
	}
	public String getExtend_param() {
		return extend_param;
	}
	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getPayer_id() {
		return payer_id;
	}
	public void setPayer_id(String payer_id) {
		this.payer_id = payer_id;
	}
	public String getPayer_identity_typ() {
		return payer_identity_typ;
	}
	public void setPayer_identity_typ(String payer_identity_typ) {
		this.payer_identity_typ = payer_identity_typ;
	}
	public String getPayer_ip() {
		return payer_ip;
	}
	public void setPayer_ip(String payer_ip) {
		this.payer_ip = payer_ip;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getCollect_trade_type() {
		return collect_trade_type;
	}
	public void setCollect_trade_type(String collect_trade_type) {
		this.collect_trade_type = collect_trade_type;
	}
	

}
