/**
 * 
 */
package com.tiancaibao.service.interfaces.user.biz;

/**
 * @author Magic
 *
 */
public interface IUserBizRegisterService {
	/**
	 * 注册
	 * 
	 * @param is_encryption
	 * @param agent_num
	 * @param ip
	 * @param phone
	 * @param password
	 * @param invited_by_phone
	 * @param phone_code
	 * @param channel_name
	 * @return
	 */
	public String postRegist(String is_encryption, String agent_num, String ip, String phone, String password,
			String invited_by_phone, String phone_code, String channel_name);

	
	/**
	 * 异步验证手机号
	 * 没有限制
	 */
	public String verifyPhone(String phone);
	
	
	
	
}
