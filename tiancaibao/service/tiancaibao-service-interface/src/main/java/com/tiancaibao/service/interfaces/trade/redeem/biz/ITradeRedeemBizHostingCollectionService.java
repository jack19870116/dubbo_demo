package com.tiancaibao.service.interfaces.trade.redeem.biz;
/**
 * dubbo服务接口--代收记录
 * @author Mack
 * 2017年2月13日 上午10:47:17
 */
public interface ITradeRedeemBizHostingCollectionService {
	/**
	 * 赎回托管代收服务
	 * @author Mack
	 * 2017年2月13日 上午11:04:00 
	 * @param userId
	 * @param amount
	 * @param days
	 * @param ip
	 * @param client
	 * @return
	 */
	Long redeemHostingCollection(Long userId, Long amount, Integer days, String ip, String client);

}
