package com.tiancaibao.service.trade.recharge;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeRechargeRecordsMapper;
import com.tiancaibao.pojo.trade.TradeRechargeRecords;
import com.tiancaibao.pojo.trade.TradeRechargeRecordsExample;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeRecodeService;

@Service("tradeRechargeRecodeService")
public class TradeRechargeRecodeServiceImpl implements ITradeRechargeRecodeService {
	@Resource
	private TradeRechargeRecordsMapper rechargeRecordsMapper;
	
	private static final Logger log = LoggerFactory.getLogger(TradeRechargeRecodeServiceImpl.class);

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Long selectRechargeSumAmountByUserId(Long userId) {
		return rechargeRecordsMapper.selectSumAmountByUserId(userId);
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Integer selectCountRechargeRecordForLimit(Long userId, Long amount, Date currentDay) {
		TradeRechargeRecordsExample rre = new TradeRechargeRecordsExample();
		rre.createCriteria().andUserIdEqualTo(userId).andAmountLessThan(amount).andCreatedAtGreaterThan(currentDay);
		Integer number = rechargeRecordsMapper.countByExample(rre);
		
		log.info("根据用户ID userId: " + userId + " 查询 TradeRechargeRecords 用户不满1块钱的记录条数 :" + number + "\n");
		return number;
	}

	@Override
	public int insertintoRechargeRecord(TradeRechargeRecords tradeRechargeRecords) {
		tradeRechargeRecords.setCreatedAt(new Date());
		tradeRechargeRecords.setUpdatedAt(new Date());
		log.info("插入 tradeRechargeRecords 用户ID userId=" + tradeRechargeRecords.getUserId() + "插入内容" +  tradeRechargeRecords + ".\n");
		return rechargeRecordsMapper.insert(tradeRechargeRecords);
	}

	@Override
	public Long rechargeAmount(Long userId, Date start, Date end) {

		return null;
	}

}
