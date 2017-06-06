package com.tiancaibao.pojo.pay.sina;


public class QueryHostingDepositResponseParam extends SinaBaseResponseParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//可空参数
	
	//充值明细列表
	private String deposit_list;
	//页号
	private String page_no;
	//每页大小
	private String page_size;
	//总记录数
	private Integer total_item;
	public String getDeposit_list() {
		return deposit_list;
	}
	public void setDeposit_list(String deposit_list) {
		this.deposit_list = deposit_list;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "QueryHostingDepositResponseParam ["
				+ (deposit_list != null ? "deposit_list=" + deposit_list + ", " : "")
				+ (page_no != null ? "page_no=" + page_no + ", " : "")
				+ (page_size != null ? "page_size=" + page_size + ", " : "")
				+ (total_item != null ? "total_item=" + total_item + ", " : "")
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
