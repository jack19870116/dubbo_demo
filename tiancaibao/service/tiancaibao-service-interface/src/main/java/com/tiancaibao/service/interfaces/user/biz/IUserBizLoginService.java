package com.tiancaibao.service.interfaces.user.biz;

public interface IUserBizLoginService {

	/**
	 * 用户登录
	 * 
	 * @param phone
	 * @param password
	 * @param agent_num
	 * @param source
	 * @param system
	 * @param app_version
	 * @return
	 */
	public String Login(String phone, String password, String agent_num, String source, String system,
			String app_version, String is_encryption);

	// public String LoginData(String token);

}
