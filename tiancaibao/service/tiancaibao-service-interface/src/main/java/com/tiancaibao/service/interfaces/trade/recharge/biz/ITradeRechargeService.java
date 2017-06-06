package com.tiancaibao.service.interfaces.trade.recharge.biz;

public interface ITradeRechargeService {

	/**
	 * 充值初始化
	 * 
	 * @param token
	 * @param plat
	 * @return
	 */
	public String RechargeIndex(String token, String plat);

	/**
	 * 充值确认
	 */
	public String RechargeConfirmClass(String token, String plat, String ip, String client, Double amount,
			String source, String host);

	/**
	 * 接收充值同步通知
	 * 
	 * @param token
	 * @param billId
	 * @param plat
	 * @param host
	 * @return
	 */

	public String notifys(String token, Long billId, String plat, String host);

	/**
	 * 查询银行限额
	 */
	public String bankLimitClass();

}
