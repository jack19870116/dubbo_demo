package com.tiancaibao.service.interfaces.trade.invest.biz;

/**
 * @author zhozhihang
 * @version 创建时间：2017年5月25日 上午9:58:02 类说明
 */
public interface ITradeInvestService {
	/**
	 * 购买
	 * 
	 * @param token
	 * @return
	 */
	public String limit(String token);

	/**
	 * 购买二 ?
	 * 
	 * @param token
	 * @return
	 */
	public String LimitClass(String token,Integer type, Integer month);

	/**
	 * 投资确认
	 */
	public String confirm(String token, Integer days, Long amount, Integer couponId, Integer is_auto_invest, String ip,
			String client, String host, String plat);

	/**
	 * 买入确认
	 * 
	 * @param token
	 * @param source
	 * @param orderid
	 * @param type
	 * @param days
	 * @param amount
	 * @param rate
	 * @param couponId
	 * @param coupon_value
	 * @param interest
	 * @param is_auto_invest
	 * @param ip
	 * @param client
	 * @param host
	 * @param plat
	 * @return
	 */
	public String investHostingCollect(String token, String source, String orderid, String type, Integer days, Long amount, Long rate,
			Integer couponId, Long coupon_value, Double interest, Integer is_auto_invest, String ip, String client,
			String host, String plat);

	/**
	 * 查询订单
	 * 
	 * @param token
	 * @param order_id
	 * @return
	 */
	public String queryInvestOrder(String token, Long order_id);

	/**
	 * 用户执行替换复投 自动赎回 状态
	 * 
	 * @param token
	 * @param invest_records_id
	 * @param is_auto_invest
	 * @return
	 */
	public String changeInvestStatus(String token, Long invest_records_id, Integer is_auto_invest);

}
