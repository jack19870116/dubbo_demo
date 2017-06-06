package com.tiancaibao.service.interfaces.user;

import com.tiancaibao.pojo.user.UserBankCards;

public interface IUserBankCardService {

	/**
	 * 查找用户绑定银行卡
	 * 
	 * @param user_id
	 * @return
	 */
	public UserBankCards selectUserBankCardByUserID(Long user_id);

	/**
	 * 添加用户绑定银行卡
	 */
	public int insertintoBankCard(Long user_id, String phone, String bank_code, String bank_name, String number,
			String province_code, String area_code);

	/**
	 * 更新用户绑卡银行号
	 */
	public int updateBnakCard(Long id, String bank_card, String bank_name);

}
