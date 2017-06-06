package com.tiancaibao.service.trade.redeem;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TradeRedeemBillsMapper;
import com.tiancaibao.pojo.trade.TradeRedeemBills;
import com.tiancaibao.pojo.trade.TradeRedeemBillsExample;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemBillsService;

@Service("tradeRedeemBillsService")
public class TradeRedeemBillsServiceImpl implements ITradeRedeemBillsService {

	@Resource
	TradeRedeemBillsMapper tradeRedeemBillsMapper;

	@Override
	public Long todayRedeemAmount(Long user_id, String status, Date created_at) {
		TradeRedeemBillsExample example = new TradeRedeemBillsExample();
		example.createCriteria().andUserIdEqualTo(user_id).andStatusNotEqualTo(status)
				.andCreatedAtGreaterThanOrEqualTo(created_at);

		Long selectSumAmont = tradeRedeemBillsMapper.selectSumAmont(example);

		return selectSumAmont;
	}

	@Override
	public int saveTradeRedeemBills(TradeRedeemBills tradeRedeemBills) {

		int insertSelective = tradeRedeemBillsMapper.insertSelective(tradeRedeemBills);

		return insertSelective;
	}

	@Override
	public TradeRedeemBills selectTradeRedeemBillsById(Long Id) {
		TradeRedeemBills selectByPrimaryKey = tradeRedeemBillsMapper.selectByPrimaryKey(Id);
		return selectByPrimaryKey;
	}

}
