package com.tiancaibao.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.user.UserBankCardsMapper;
import com.tiancaibao.pojo.user.UserBankCards;
import com.tiancaibao.pojo.user.UserBankCardsExample;
import com.tiancaibao.service.interfaces.user.IUserBankCardService;

@Service("userBankCardService")
public class UserBankCardServiceImpl implements IUserBankCardService {

	@Resource
	UserBankCardsMapper userBankCardsMapper;

	@Override
	public UserBankCards selectUserBankCardByUserID(Long user_id) {

		UserBankCardsExample example = new UserBankCardsExample();
		example.createCriteria().andUserIdEqualTo(user_id);

		List<UserBankCards> selectByExample = userBankCardsMapper.selectByExample(example);

		UserBankCards userBankCards = selectByExample.get(0);

		return userBankCards;
	}

	@Override
	public int insertintoBankCard(Long user_id, String phone, String bank_code, String bank_name, String number,
			String province_code, String area_code) {
		UserBankCards userBankCards = new UserBankCards();

		userBankCards.setAreaCode(area_code);
		userBankCards.setPhone(phone);
		userBankCards.setBankCode(bank_code);
		userBankCards.setUserId(user_id);
		userBankCards.setBankName(bank_name);
		userBankCards.setProvinceCode(province_code);
		userBankCards.setNumber(number);
		int insert = userBankCardsMapper.insert(userBankCards);
		return insert;
	}

	@Override
	public int updateBnakCard(Long id, String bank_card, String bank_name) {

		UserBankCards userBankCards = new UserBankCards();
		userBankCards.setId(id);
		UserBankCardsExample example = new UserBankCardsExample();
		example.createCriteria().andNumberEqualTo(bank_card).andBankNameEqualTo(bank_name);

		int updateByExampleSelective = userBankCardsMapper.updateByExampleSelective(userBankCards, example);

		return updateByExampleSelective;
	}

}
