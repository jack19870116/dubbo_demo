package com.tiancaibao.pojo.pay.sina;

public class QueryHostingTradeResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//交易明细列表
	private String trade_list;
	//页号
	private String page_no;
	//每页大小
	private String page_size;
	//总记录数
	private Integer total_item;
	public String getTrade_list() {
		return trade_list;
	}
	public void setTrade_list(String trade_list) {
		this.trade_list = trade_list;
	}
	public String getPage_no() {
		return page_no;
	}
	public void setPage_no(String page_no) {
		this.page_no = page_no;
	}
	public String getPage_size() {
		return page_size;
	}
	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}
	public Integer getTotal_item() {
		return total_item;
	}
	public void setTotal_item(Integer total_item) {
		this.total_item = total_item;
	}
	
}
