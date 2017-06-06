package com.tiancaibao.service.interfaces.pay.biz;

public interface IPayBizBindBankCardServiceImpl {

	/**
	 * 验证用户输入的有效性
	 * 
	 * @param token
	 * @param ip
	 * @return
	 */
	public String verifyUser(String token, String ip);

	/**
	 * 绑定银行卡初始化
	 * 
	 * @return
	 */
	public String bindBankCardInit(Long user_id, String idcard_name);

	/**
	 * 获取银行卡所在省份
	 * 
	 * @param user_id
	 * @param idcard_name
	 * @return
	 */
	public String bindBankCardGetRegions(Long user_id, String idcard_name);

	/**
	 * 获取银行卡所在子区域
	 * 
	 * @param regions_id
	 * @return
	 */
	public String bindBankCardGetChildRegions(String regions_id);

	/**
	 * 请求新浪发送绑卡短信
	 * 
	 * @param bank_id
	 * @param token
	 * @param bank_card
	 * @param phone
	 * @param province_code
	 * @param area_id
	 * @param ip
	 * @return
	 */
	public String bindBankCardCode(String bank_id, String token, String bank_card, String phone, Long province_code,
			Long area_id, String ip);

	/**
	 * 保存用户银行卡
	 * @param ticket
	 * @param user_id
	 * @param phone_code
	 * @param ip
	 * @param phone
	 * @param bank_id
	 * @param bank_card
	 * @param province_id
	 * @param area_id
	 * @param bank_name
	 * @return
	 */
	public String bindBankCard(String ticket,Long user_id,String phone_code,String ip,String phone,String bank_id,String bank_card,String province_id,String area_id,String bank_name);
	

}
