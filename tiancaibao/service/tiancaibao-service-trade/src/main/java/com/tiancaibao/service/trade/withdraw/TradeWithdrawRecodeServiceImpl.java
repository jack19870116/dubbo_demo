package com.tiancaibao.service.trade.withdraw;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.constants.ServiceConstants;
import com.tiancaibao.mapper.trade.TradeWithdrawRecordsMapper;
import com.tiancaibao.pojo.trade.TradeWithdrawRecords;
import com.tiancaibao.pojo.trade.TradeWithdrawRecordsExample;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawRecodeService;
import com.tiancaibao.utils.DateUtil;

@Service("tradeWithdrawRecodeService")
public class TradeWithdrawRecodeServiceImpl implements ITradeWithdrawRecodeService {

	@Resource
	private TradeWithdrawRecordsMapper withdrawRecordsMapper;

	private static final Logger log = LoggerFactory.getLogger(TradeWithdrawRecodeServiceImpl.class);
	
	@Override
	public List<TradeWithdrawRecords> selectWithdrawRecordByUserIdAndDate(Long user_id, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectSumAmountWithdrawRecodeWithAllUsers() {
		Long amount = withdrawRecordsMapper.selectSumAmountFromWithdrawRecode();
		log.info(" 查询所有的用户提现总金额是： " + amount  +" \n");
		return amount;
	}

	@Override
	public Long selectWithdrawRecordByUserIdAndDateCount(Long userid, Date date) {
		// TODO Auto-generated method stub
		return 0L;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Long selectSumAmountByUserId(Long userId) {
		Long amount = withdrawRecordsMapper.selectSumAmountByUserId(userId) ;
		log.info("使用userId: " + userId + " 查询 TradeWithdrawRecords 该用户自2016-01-07以来总提现金额: " + amount +"\n");
		return amount;
		
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Integer selectWithdrawFee(Long userId) {
		TradeWithdrawRecordsExample wdre = new TradeWithdrawRecordsExample();
		wdre.createCriteria().andUserIdEqualTo(userId).andDateEqualTo(DateUtil.todayDate());
		int withdrawCount = withdrawRecordsMapper.countByExample(wdre);
		Integer fee = withdrawCount == 0 ? ServiceConstants.FIRSTWITHDRAWFEE : ServiceConstants.NOTFIRSTWITHDRAWFEE;
		log.info("使用参数userId=" + userId +  "查询withdrawRecord提现费用结果是：" + fee +"\n");
		return withdrawCount == 0 ? ServiceConstants.FIRSTWITHDRAWFEE : ServiceConstants.NOTFIRSTWITHDRAWFEE;
	}

	@Override
	public Long selectWithDrawSumAmountCurrentDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(Long userId, String string,
			String currentCycle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TradeWithdrawRecords selectWithdrawRecordsByWithdrawBillId(Long withdraw_bill_id) {

		TradeWithdrawRecordsExample wdre = new TradeWithdrawRecordsExample();

		wdre.createCriteria().andWithdrawBillIdEqualTo(withdraw_bill_id);

		List<TradeWithdrawRecords> selectByExample = withdrawRecordsMapper.selectByExample(wdre);
		
		log.info("根据 withdraw_bill_id :" + withdraw_bill_id + "获取 TradeWithdrawRecords 结果" + selectByExample + "\n");
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

	@Override
	public int insetintoWithdrawRecords(TradeWithdrawRecords tradeWithdrawRecords) {

		tradeWithdrawRecords.setCreatedAt(new Date());
		tradeWithdrawRecords.setUpdatedAt(new Date());
		int insert = withdrawRecordsMapper.insert(tradeWithdrawRecords);
		log.info("插入WithdrawRecords表，userId = " + tradeWithdrawRecords.getUserId() + " 数据 = " + tradeWithdrawRecords +"\n");
		return insert;
	}

}
