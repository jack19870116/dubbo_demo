package com.tiancaibao.service.interfaces.user.biz;

public interface IUserBizSignInService {
	/**
	 * 用户签到处理
	 * 
	 * @param token
	 *            用户token值
	 * @return
	 */
	public String signIn(String token);

	/**
	 * 获取用户签到记录
	 * 
	 * @param token
	 * @return
	 */
	public String postSignRecord(String token);

}
