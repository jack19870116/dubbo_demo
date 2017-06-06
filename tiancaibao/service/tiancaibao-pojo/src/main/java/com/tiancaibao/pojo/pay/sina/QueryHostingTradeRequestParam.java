package com.tiancaibao.pojo.pay.sina;

public class QueryHostingTradeRequestParam extends SinaBaseRequestParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户标识信息
	private String identity_id;
	// 用户标识类型
	private String identity_type;
	// 交易订单号
	private String out_trade_no;
	// 开始时间
	private String start_time;
	// 结束时间
	private String end_time;
	// 扩展信息
	private String extend_param;
	// 页号
	private Integer page_no;
	// 每页大小
	private Integer page_size;

	public String getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}

	public String getIdentity_type() {
		return identity_type;
	}

	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getExtend_param() {
		return extend_param;
	}

	public void setExtend_param(String extend_param) {
		this.extend_param = extend_param;
	}

	public Integer getPage_no() {
		return page_no;
	}

	public void setPage_no(Integer page_no) {
		this.page_no = page_no;
	}

	public Integer getPage_size() {
		return page_size;
	}

	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}

}
