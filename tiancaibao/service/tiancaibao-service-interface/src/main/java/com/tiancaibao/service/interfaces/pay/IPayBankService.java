package com.tiancaibao.service.interfaces.pay;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.pojo.pay.PayBankcards;
import com.tiancaibao.pojo.pay.PayRegions;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;


public interface IPayBankService {

	/**
	 * 根据父级城市编号返回所有的子级城市列表
	 * @param parent_id
	 * @return
	 */
	List<PayRegions> selectRegionsByParentId(long parent_id);

	/**
	 * 根据城市ID返回城市名称
	 * @param id
	 * @return
	 */
	String selectNameOfRegionsById(Long id);

	/**
	 * 根据用户ID返回用户绑卡记录
	 * @param userid
	 * @return
	 */
	PayBankcards selectBankCardByUserId(Long userid);

	/**
	 * 向用户绑卡表插入一条记录
	 * @param talentSource
	 * @param card_id
	 * @param sinauserinfo
	 * @param bc
	 * @param userid
	 * @param phone
	 * @param bank_id
	 * @param bank_card
	 * @param province_id
	 * @param area_id
	 * @param bank_name
	 * @param talentValue
	 * @param createdAt
	 */
	void saveUserBankCard(IntegralTalentSource talentSource,String card_id,PaySinaUserInfo sinauserinfo,PayBankcards bc,Long userid, String phone, String bank_id, String bank_card, String province_id,
			String area_id, String bank_name, Long talentValue,Date createdAt);

	/**
	 * 同时向用户绑卡表和新浪用户信息表插入记录
	 * @param bankCard
	 * @param sinaUserInfo
	 * @param uid
	 * @param phone
	 * @param bank_id
	 * @param bank_name
	 * @param bank_card
	 * @param card_id
	 */
	void saveUserBankCardAndSinaUserInfoForBankInterface(PayBankcards bankCard, PaySinaUserInfo sinaUserInfo, Long uid,
			String phone, String bank_id, String bank_name, String bank_card, String card_id);

}
