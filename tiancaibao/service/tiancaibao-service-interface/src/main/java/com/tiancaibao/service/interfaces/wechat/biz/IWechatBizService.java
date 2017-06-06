package com.tiancaibao.service.interfaces.wechat.biz;


public interface IWechatBizService {
	
	/**
	 * 发送微信绑定
	 * @param phone
	 * @param open_id
	 * @param password
	 * @param is_encryption
	 * @param agent_num
	 * @param source
	 * @param system
	 * @return
	 */
	public String wechatBind(String phone, String open_id, String password, String is_encryption,
			String agent_num, String source, String system);

	
	/**
	 * 查询微信绑定
	 * @param openId
	 * @return
	 */
	public String openIdLogin(String openId);
	
	
	
	
}