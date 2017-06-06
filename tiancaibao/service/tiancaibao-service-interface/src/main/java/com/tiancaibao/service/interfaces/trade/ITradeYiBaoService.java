package com.tiancaibao.service.interfaces.trade;
/**
 * dubbo服务接口--易宝
 * @author Mack
 * 2017年2月14日 上午11:59:36
 */
public interface ITradeYiBaoService {
	/**
	 * 易宝个人账户
	 * @author Mack
	 * 2017年2月7日 下午4:38:18 
	 * @param userId
	 * @return
	 */
	Long selectSumAmountByUserId(Long userId);

}
