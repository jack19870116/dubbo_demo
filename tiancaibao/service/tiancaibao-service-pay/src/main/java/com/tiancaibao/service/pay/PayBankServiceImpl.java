package com.tiancaibao.service.pay;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.pojo.pay.PayBankcards;
import com.tiancaibao.pojo.pay.PayRegions;
import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.service.interfaces.pay.IPayBankService;

public class PayBankServiceImpl implements IPayBankService{

	@Override
	public List<PayRegions> selectRegionsByParentId(long parent_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectNameOfRegionsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayBankcards selectBankCardByUserId(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void saveUserBankCardAndSinaUserInfoForBankInterface(PayBankcards bankCard,
			com.tiancaibao.pojo.pay.PaySinaUserInfo sinaUserInfo, Long uid, String phone, String bank_id,
			String bank_name, String bank_card, String card_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUserBankCard(IntegralTalentSource talentSource, String card_id, PaySinaUserInfo sinauserinfo,
			PayBankcards bc, Long userid, String phone, String bank_id, String bank_card, String province_id,
			String area_id, String bank_name, Long talentValue, Date createdAt) {
		// TODO Auto-generated method stub
		
	}

}
