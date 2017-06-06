package com.tiancaibao.service.trade.redeem;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TradeRedeemRecordsMapper;
import com.tiancaibao.pojo.trade.TradeRedeemRecordsExample;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemRecordsService;

@Service("tradeRedeemRecordsService")
public class TradeRedeemRecordsServiceImpl implements ITradeRedeemRecordsService {

	@Resource
	TradeRedeemRecordsMapper tradeRedeemRecordsMapper;

	@Override
	public Long sumAmountFromRedeemByUserId(Long user_id) {

		return tradeRedeemRecordsMapper.selectSumAmountOfRedeemRecordsByUserId(user_id);

	}

	@Override
	public Long sumAmountFromRedeem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectRedeemAmountByUserId(long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM(long l, int i, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectSumAmountOfRedeemRecordsByUserIdAndcreated_at(Long user_id) {
		// TODO Auto-generated method stub

		Long selectSumAmountOfRedeemRecordsByUserIdAndcreated_at = tradeRedeemRecordsMapper
				.selectSumAmountOfRedeemRecordsByUserIdAndcreated_at(user_id);

		return selectSumAmountOfRedeemRecordsByUserIdAndcreated_at;
	}

	@Override
	public Long selectSameMonth(Long userId, Date startTime, Date endTime) {

		TradeRedeemRecordsExample example = new TradeRedeemRecordsExample();
		example.createCriteria().andUserIdEqualTo(userId).andCreatedAtGreaterThanOrEqualTo(startTime)
				.andCreatedAtLessThanOrEqualTo(endTime);
		Long selectSameMonth = tradeRedeemRecordsMapper.selectSameMonth(example);

		return selectSameMonth;
	}

}
