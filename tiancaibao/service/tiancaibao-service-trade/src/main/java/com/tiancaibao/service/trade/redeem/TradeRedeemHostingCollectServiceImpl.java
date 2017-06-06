package com.tiancaibao.service.trade.redeem;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TradeRedeemHostingCollectMapper;
import com.tiancaibao.pojo.trade.TradeRedeemHostingCollect;
import com.tiancaibao.pojo.trade.TradeRedeemHostingCollectExample;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemHostingCollectService;

@Service("tradeRedeemHostingCollectService")
public class TradeRedeemHostingCollectServiceImpl implements ITradeRedeemHostingCollectService {

	@Resource
	TradeRedeemHostingCollectMapper tradeRedeemHostingCollectMapper;

	@Override
	public int saveRedeemHostingCollect(TradeRedeemHostingCollect tradeRedeemHostingCollect) {

		int insertSelective = tradeRedeemHostingCollectMapper.insertSelective(tradeRedeemHostingCollect);

		return insertSelective;
	}

	@Override
	public TradeRedeemHostingCollect selectTradeRedeemHostingCollectByorder_code(String order_code) {

		TradeRedeemHostingCollectExample example = new TradeRedeemHostingCollectExample();

		example.createCriteria().andOrderCodeEqualTo(order_code);

		List<TradeRedeemHostingCollect> selectByExample = tradeRedeemHostingCollectMapper.selectByExample(example);

		return selectByExample.size() == 0 ? null : selectByExample.get(0);

	}

	@Override
	public int updateTradeRedeemHostingCollect(TradeRedeemHostingCollect tradeRedeemHostingCollect) {

		TradeRedeemHostingCollect record = new TradeRedeemHostingCollect();
		TradeRedeemHostingCollectExample example = new TradeRedeemHostingCollectExample();

		record.setHostingCollectOrderId(tradeRedeemHostingCollect.getHostingCollectOrderId());
		record.setStatus(tradeRedeemHostingCollect.getStatus());

		example.createCriteria().andIdEqualTo(tradeRedeemHostingCollect.getId());

		int updateByExampleSelective = tradeRedeemHostingCollectMapper.updateByExampleSelective(record, example);

		return updateByExampleSelective;
	}

}
