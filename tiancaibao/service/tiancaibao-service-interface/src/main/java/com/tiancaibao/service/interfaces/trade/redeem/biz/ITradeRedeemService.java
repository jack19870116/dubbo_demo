package com.tiancaibao.service.interfaces.trade.redeem.biz;

/**
 * @author zhozhihang
 * @version 创建时间：2017年5月27日 下午2:11:23 类说明
 */
public interface ITradeRedeemService {

	/**
	 * 查询赎回限额
	 * 
	 * @param token
	 * @return
	 */
	public String limit(String token);
	
	
	
	
	
	/**
	 * 赎回提交
	 */
	public String confirmClass(String token,Double amount,String ip,String redeem,String client);
	
	
	

}
