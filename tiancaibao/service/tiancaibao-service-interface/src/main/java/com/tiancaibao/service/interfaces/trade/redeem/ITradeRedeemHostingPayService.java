package com.tiancaibao.service.interfaces.trade.redeem;

import com.tiancaibao.pojo.trade.TradeRedeemHostingPay;

/**
 * @author zhozhihang
 * @version 创建时间：2017年5月31日 下午4:27:38 类说明
 */
public interface ITradeRedeemHostingPayService {

	
	
	/**
	 * 插入一条记录
	 * @param tradeRedeemHostingPay
	 * @return
	 */
	public int savetradeRedeemHostingPayService(TradeRedeemHostingPay tradeRedeemHostingPay);

	
	/**
	 * 查询一条记录
	 * @param order_code
	 * @return
	 */
	public  TradeRedeemHostingPay selectTradeRedeemHostingPayByorder_code(String order_code);

}
