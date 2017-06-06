package com.tiancaibao.service.trade.redeem;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TradeRedeemHostingPayMapper;
import com.tiancaibao.pojo.trade.TradeRedeemHostingPay;
import com.tiancaibao.pojo.trade.TradeRedeemHostingPayExample;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemHostingPayService;

@Service("tradeRedeemHostingPayService")
public class TradeRedeemHostingPayServiceImpl implements ITradeRedeemHostingPayService {

	@Resource
	TradeRedeemHostingPayMapper tradeRedeemHostingPayMapper;

	@Override
	public TradeRedeemHostingPay selectTradeRedeemHostingPayByorder_code(String order_code) {
		TradeRedeemHostingPayExample example = new TradeRedeemHostingPayExample();
		example.createCriteria().andOrderCodeEqualTo(order_code);

		List<TradeRedeemHostingPay> selectByExample = tradeRedeemHostingPayMapper.selectByExample(example);

		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

	@Override
	public int savetradeRedeemHostingPayService(TradeRedeemHostingPay tradeRedeemHostingPay) {
		int insertSelective = tradeRedeemHostingPayMapper.insertSelective(tradeRedeemHostingPay);

		// TODO Auto-generated method stub
		return insertSelective;
	}

}
