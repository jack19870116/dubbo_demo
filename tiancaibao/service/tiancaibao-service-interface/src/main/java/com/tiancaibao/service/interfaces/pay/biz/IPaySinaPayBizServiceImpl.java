package com.tiancaibao.service.interfaces.pay.biz;

import java.util.Map;

public interface IPaySinaPayBizServiceImpl {
	
	/**
	 * 查询余额存钱罐
	 * @param token
	 * @return
	 */
	public String queryBalance(String token);
	/**
	 * 代收交易
	 * @param token
	 * @param order_code
	 * @param amount_coupon
	 * @param ip
	 * @param finishUrl
	 * @return
	 */
	public String createHostingCollectTrade(String token,String order_code,Double amount_coupon,String ip,String finishUrl);
	/**
	 * 验签
	 * @param map
	 * @return
	 */
	public String checkSignMsg(Map<String, String> map);
	
	/**
	 * 
	 * @return
	 */
	
	public String redeemCollectTrade();
	

}
