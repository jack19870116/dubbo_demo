package com.tiancaibao.service.trade.invest;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TradeInvestHostingCollectMapper;
import com.tiancaibao.pojo.trade.TradeInvestHostingCollect;
import com.tiancaibao.pojo.trade.TradeInvestHostingCollectExample;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestHostingCollectService;

@Service("tradeInvestHostingCollectService")
public class TradeInvestHostingCollectServiceImpl implements ITradeInvestHostingCollectService {

	@Resource
	private TradeInvestHostingCollectMapper investHostingCollectMapper;

	@Override
	public Integer insertInvestHostingCollect(Long userId, Long amount, Integer days, String ip, String client,
			String orderCode, Long investBillId) {
		TradeInvestHostingCollect ihc = new TradeInvestHostingCollect();
		ihc.setUserId(userId);
		ihc.setAmount(amount);
		ihc.setInvestOrderId(investBillId + "");
		ihc.setStatus("WAIT_PAY"); // 等待代付付款状态
		ihc.setOrderCode(orderCode);
		ihc.setIp(ip);
		ihc.setCreatedAt(new Date());
		return investHostingCollectMapper.insertSelective(ihc);
	}

	@Override
	public TradeInvestHostingCollect saveInvestHostingCollect(Long userId, Long amount, String status,
			Integer invest_order_id, String orderCode, String ip) {

		TradeInvestHostingCollect record = new TradeInvestHostingCollect();
		record.setUserId(userId);
		record.setAmount(amount);
		record.setStatus(status);
		record.setInvestOrderId(invest_order_id.toString());
		record.setOrderCode(orderCode);
		record.setIp(ip);
		investHostingCollectMapper.insertSelective(record);

		return record;
	}

	@Override
	public TradeInvestHostingCollect selectTradeInvestHostingCollectByOrederCode(String OrederCode) {
		TradeInvestHostingCollectExample example = new TradeInvestHostingCollectExample();

		example.createCriteria().andOrderCodeEqualTo(OrederCode);

		List<TradeInvestHostingCollect> selectByExample = investHostingCollectMapper.selectByExample(example);

		return selectByExample == null ? null : selectByExample.get(0);
	}

	@Override
	public int updateTradeInvestHostingCollectById(TradeInvestHostingCollect tradeInvestHostingCollect) {
		TradeInvestHostingCollect record = new TradeInvestHostingCollect();

		TradeInvestHostingCollectExample example = new TradeInvestHostingCollectExample();

		record.setHostingCollectOrderId(tradeInvestHostingCollect.getHostingCollectOrderId());

		record.setStatus(tradeInvestHostingCollect.getStatus());
		example.createCriteria().andIdEqualTo(tradeInvestHostingCollect.getId());

		int updateByExampleSelective = investHostingCollectMapper.updateByExampleSelective(record, example);

		return updateByExampleSelective;
	}

}
