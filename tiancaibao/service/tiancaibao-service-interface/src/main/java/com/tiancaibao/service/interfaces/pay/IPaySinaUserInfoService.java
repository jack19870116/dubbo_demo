package com.tiancaibao.service.interfaces.pay;

import com.tiancaibao.pojo.pay.PaySinaUserInfo;

/**
 * dubbo服务接口---新浪用户本地信息
 * 
 * @author Mack 2017年2月4日 下午2:24:04
 */
public interface IPaySinaUserInfoService {
	/**
	 * 暂未实名认证,返回code
	 * 
	 * @author Mack 2017年2月4日 下午2:49:40
	 * @param userId
	 * @return
	 */
	public Integer isRealName(Long userId);

	/**
	 * 查询用户新浪存钱罐余额
	 * 
	 * @param userId
	 * @return
	 */
	public Long selectSinapayAmountByUserId(Long userId);

	/**
	 * 用用户ID查询新浪认证表
	 * 
	 * @param userId
	 * @return
	 */
	public PaySinaUserInfo selectByUserId(Long userId);

	/**
	 * 更新新浪用户表
	 * 
	 * @param sinaUserInfo
	 */
	public void updateByUserId(PaySinaUserInfo sinaUserInfo);

	/**
	 * 更新新浪用户表存钱罐余额
	 * 
	 * @param queryBalance
	 * @param id
	 */
	public void updateSinapayAmountById(Long queryBalance, Long id);

	public void insertSinaUserInfoSetSinapayBankCardAndUserId(Long userId, String bankCard);

	/**
	 * 插入新浪用户表
	 * 
	 * @param userId
	 * @param bankCard
	 */
	void insertSinaUserInfoSetSinapayBankCardAndUserId1(Long userId, String bankCard);

	/**
	 * 向新浪用户表插入一条记录
	 * 
	 * @param userid
	 * @param phone
	 */
	void insertSinaUserInfo(Long userid, String phone);

	/**
	 * 根据用户ID更新用户新浪存钱罐余额
	 * 
	 * @param account_amount
	 * @param id
	 */
	void updateSinaUserInfoById(Long account_amount, Long id);

	/**
	 * 根据用户ID和手机号向新浪用户表中新增一条记录
	 * 
	 * @param userid
	 * @param phone
	 */
	void insertUserIdAndPhoneToSinaUserInfo(Long userid, String phone);

	/**
	 * 银行卡绑定的时候向新浪插入一条数据
	 * 
	 * @param userid
	 * @param phone
	 */

	void insertoSinaUserInfo(Long userid, String phone, String sinapay_bank_card, String card_id);

	/**
	 * 根据用户id和身份证向新浪用户表中新增一条记录
	 */
	void insertUserIdAndIdcardToSinaUserInfo(Long userid, String idcardNumber);

	/**
	 * 根据用户id更新新浪用户表中的身份证
	 */
	int updateIdcardNumberSinaUserInfoById(Long id, String idcardNumber);

	/**
	 * 更新绑定银行卡
	 * 
	 * @param id
	 * @param bank_card
	 * @param phone
	 * @param card_id
	 */

	void updateSinaUserInfoBnakCardById(Long id, String bank_card, String phone, String card_id);

	/**
	 * 根据新浪表ID更新手机号
	 * 
	 * @param phone
	 * @param id
	 */
	void updateSinaUserInfoSetPhoneById(String phone, Long id);
}
