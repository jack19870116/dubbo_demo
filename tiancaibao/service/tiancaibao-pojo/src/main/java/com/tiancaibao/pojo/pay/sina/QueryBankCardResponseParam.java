package com.tiancaibao.pojo.pay.sina;

public class QueryBankCardResponseParam extends SinaBaseResponseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 可空
	 */
	//卡列表
	private String card_list;

	public String getCard_list() {
		return card_list;
	}

	public void setCard_list(String card_list) {
		this.card_list = card_list;
	}
	
}
