package com.tiancaibao.service.interfaces.trade.redeem;

import com.tiancaibao.pojo.trade.TradeRedeemHostingCollect;

/** 
* @author zhozhihang
* @version 创建时间：2017年5月31日 下午3:31:11 
* 类说明 
*/
public interface ITradeRedeemHostingCollectService {
	
	/**
	 * 保存数据
	 */
	public int saveRedeemHostingCollect(TradeRedeemHostingCollect tradeRedeemHostingCollect);
	
	/**
	 * 查询数据
	 */
	public TradeRedeemHostingCollect selectTradeRedeemHostingCollectByorder_code(String order_code);
	
	/**
	 * 更新数据
	 */

	public int updateTradeRedeemHostingCollect(TradeRedeemHostingCollect tradeRedeemHostingCollect);
	
	
	
}
