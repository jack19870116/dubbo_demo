package com.tiancaibao.service.trade.recharge;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeRechargeBillsMapper;
import com.tiancaibao.pojo.trade.TradeRechargeBills;
import com.tiancaibao.pojo.trade.TradeRechargeBillsExample;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeBillService;

@Service("tradeRechargeBillService")
public class TradeRechargeBillServiceImpl implements ITradeRechargeBillService {
	@Resource
	private TradeRechargeBillsMapper rechargeBillsMapper;
	
	private static final Logger log = LoggerFactory.getLogger(TradeRechargeBillServiceImpl.class);

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public TradeRechargeBills selectRechargeBillById(Long billId) {
		TradeRechargeBills trb =  rechargeBillsMapper.selectByPrimaryKey(billId);
		log.info("使用 billId： " + billId + "查询 TradeRechargeBills 返回结果: " + trb + "\n");
		return trb;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Long insertRechargeBill(Long userId, Long amount, String paytypeid, String order_code, String status,
			String ip, String client) {
		TradeRechargeBills rb = new TradeRechargeBills();
		rb.setUserId(userId);
		rb.setAmount((amount * 10000));
		rb.setPaytypeid(paytypeid);
		rb.setOrderCode(order_code);
		rb.setStatus(status);
		rb.setIp(ip);
		rb.setClient(client);
		rb.setCreatedAt(new Date());
		rechargeBillsMapper.insertSelectiveReturnId(rb);
		log.info("插入 rechargeBills用户ID userId=" + userId + " 插入内容 " +  rb + ".\n");
		return rb.getId();
	}

	@Override
	public List<TradeRechargeBills> selectRechargeBillByStatusAndOrderByCreatedAt(String status,
			String orderByCreatedAt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean checkRechargeData(String deposit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long sumAmounts(Long userId, String status) {
		TradeRechargeBillsExample example = new TradeRechargeBillsExample();

		example.createCriteria().andUserIdEqualTo(userId).andStatusNotEqualTo(status)
				.andCreatedAtGreaterThanOrEqualTo(new Date());

		Long sumAmount = rechargeBillsMapper.sumAmount(example);

		return sumAmount;
	}

	@Override
	public TradeRechargeBills selectRechargeBillByOrderCode(String order_code) {

		TradeRechargeBillsExample example = new TradeRechargeBillsExample();

		example.createCriteria().andOrderCodeEqualTo(order_code);

		List<TradeRechargeBills> selectByExample = rechargeBillsMapper.selectByExample(example);
		log.info("根据order_code = " + order_code + " 查询TradeRechargeBills 结果为 ＝ " + selectByExample.get(0) + ";\n");
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

	@Override
	public int updateRechargeBill(TradeRechargeBills tradeRechargeBills) {

		TradeRechargeBills record = new TradeRechargeBills();
		record.setId(tradeRechargeBills.getId());
		record.setConfirmedAt(tradeRechargeBills.getConfirmedAt());
		record.setStatus(tradeRechargeBills.getStatus());
		record.setOrderid(tradeRechargeBills.getOrderid());
		record.setIsHuifuChecked(tradeRechargeBills.getIsHuifuChecked());
		int updateByPrimaryKeySelective = rechargeBillsMapper.updateByPrimaryKeySelective(record);
		log.info("更新 tradeRechargeBills用户ID userId = " + tradeRechargeBills.getUserId() + " 更新内容" +  tradeRechargeBills + ".\n");
		return updateByPrimaryKeySelective;
	}
}
