package com.tiancaibao.service.trade.withdraw;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeWithdrawBillsMapper;
import com.tiancaibao.pojo.trade.TradeWithdrawBills;
import com.tiancaibao.pojo.trade.TradeWithdrawBillsExample;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawBillService;

@Service("tradeWithdrawBillService")
public class TradeWithdrawBillsServiceImpl implements ITradeWithdrawBillService {

	@Resource
	private TradeWithdrawBillsMapper withdrawBillsMapper;

	private static final Logger log = LoggerFactory.getLogger(TradeWithdrawBillsServiceImpl.class);
	
	@Override
	public TradeWithdrawBills insertWithdrawBill(Long userid, Long amount, Long withdraw_amount,
			Long withdrawLimitAmout, String withdraw, String ip, String client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Long insertWithdrawBillsSelectiveReturnId(TradeWithdrawBills withdrawBills) {
		withdrawBillsMapper.insertSelectiveReturnId(withdrawBills);
		return withdrawBills.getId();
	}

	@Override
	public Long insertWithdrawBillsSelectiveReturnId(Long userId, Long amount, Integer fee, String orderCode,
			String paytypeid, String ip, String client, String currentCycle) {
		TradeWithdrawBills wb = new TradeWithdrawBills();
		wb.setUserId(userId);
		wb.setAmount(amount * 10000);
		wb.setPayFee(fee.floatValue());
		wb.setOrderCode(orderCode);
		wb.setPaytypeid(paytypeid);
		wb.setIp(ip);
		wb.setClient(client);
		wb.setCurrentCycle(currentCycle);
		log.info("插入WithdrawBills表，userId = " + userId + " 数据 = " + wb +"\n");
		return insertWithdrawBillsSelectiveReturnId(wb);
	}

	@Override
	public Long selectWithdrawBillByNotStatusAndCreateAtGreaterThanDayForAmountTotal(String status, Date created_at) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Long selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(Long userId, String status,
			String currentCycle) {
		return withdrawBillsMapper.selectSumAamountByUserIdAndStatusAndCurrentCycle(userId, status, currentCycle);
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Long selectSystemWithDrawSumAmountCurrentDay() {
		Long sumAmount = withdrawBillsMapper.selectSystemWithDrawSumAmountCurrentDay();
		if (sumAmount == null) {
			sumAmount = 0L;
		}
		log.info(" 查询withdrawBills 所有用户今日提现总金额结果(包括未确认)是：" + sumAmount  + "\n");
		return sumAmount;
	}

	@Override
	public TradeWithdrawBills selectTradeWithdrawBillsByOrderCode(String order_code) {
		TradeWithdrawBillsExample example = new TradeWithdrawBillsExample();

		example.createCriteria().andOrderCodeEqualTo(order_code);

		List<TradeWithdrawBills> selectByExample = withdrawBillsMapper.selectByExample(example);

		return selectByExample.get(0);
	}

	@Override
	public int updateTradeWithdrawBills(TradeWithdrawBills tradeWithdrawBills) {
		TradeWithdrawBills record = new TradeWithdrawBills();
		record.setId(tradeWithdrawBills.getId());
		record.setStatus(tradeWithdrawBills.getStatus());
		record.setPayFee(tradeWithdrawBills.getPayFee());
		record.setHuifuStatus(tradeWithdrawBills.getHuifuStatus());
		record.setConfirmedAt(tradeWithdrawBills.getConfirmedAt());
		record.setUpdatedAt(tradeWithdrawBills.getUpdatedAt());
		int updateByPrimaryKeySelective = withdrawBillsMapper.updateByPrimaryKeySelective(record);
		log.info("更新 TradeWithdrawBills 用户ID userId= " + tradeWithdrawBills.getUserId() + " 更新内容 " +  tradeWithdrawBills + ".\n");
		return updateByPrimaryKeySelective;
	}

}
