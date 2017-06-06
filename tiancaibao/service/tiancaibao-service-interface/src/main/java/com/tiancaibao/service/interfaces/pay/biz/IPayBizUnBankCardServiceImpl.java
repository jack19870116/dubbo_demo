package com.tiancaibao.service.interfaces.pay.biz;

public interface IPayBizUnBankCardServiceImpl {

	/**
	 *  解绑卡初始化
	 * @param token
	 * @param ip
	 * @return
	 */
	public String verifyUser(String token, String ip);

	/**
	 *  解绑银行卡
	 * @param user_id
	 * @param ip
	 * @return
	 */
	public String unbindBankCard(Long userId, String ip);

	/**
	 * 解绑卡推进
	 * @param user_id
	 * @param ip
	 * @param valid_code
	 * @param ticket
	 * @return
	 */
	public String UnBankCardAdvance(Long userId, String ip,String validCode, String ticket);

}
