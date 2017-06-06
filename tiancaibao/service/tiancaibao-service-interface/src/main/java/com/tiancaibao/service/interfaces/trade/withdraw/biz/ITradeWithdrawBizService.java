package com.tiancaibao.service.interfaces.trade.withdraw.biz;

public interface ITradeWithdrawBizService {
	/**
	 * 提现准备
	 * 
	 * @param token
	 * @return
	 */
	public String ready(String token);

	/**
	 * 提现确认(处理程序)
	 * 
	 * @param amount
	 * @param trading_password
	 * @param withdraw
	 * @param ip
	 * @param client
	 * @return
	 */
	public String confirm(String token, Long amount, String trading_password, String withdraw, String ip, String client,
			String plat, String host);

	public void validateSingleLimit(Long amount);

	public void withDrawWarn(Long amount, Integer fee, Long sinaBalance);

	public String findAccountAbnormal(Long userId, Long amount, String withdraw);
	
	public String selectFcallbackurl(String plat, String host, Long amount);
	
	public  String  selectSinaUrl(Long userId, String orderCode, Double amount, Float fee, String account_type,
			String fcallbackurl, String ip);
	
	public Long findSinaBalance(Long userId);

}
