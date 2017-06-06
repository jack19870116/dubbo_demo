package com.tiancaibao.service.trade.invest;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeInvestRecordsMapper;
import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecordsExample;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;
import com.tiancaibao.utils.DateUtil;

@Service("tradeInvestRecordsService")
public class TradeInvestRecordsServiceImpl implements ITradeInvestRecordsService {

	@Resource
	TradeInvestRecordsMapper tradeInvestRecordsMapper;

	private static Logger log = LoggerFactory.getLogger(TradeInvestRecordsServiceImpl.class);

	@Override
	public TradeInvestRecords selectTradeInvestRecordsByUserId(Long user_id) {
		TradeInvestRecordsExample example = new TradeInvestRecordsExample();

		example.createCriteria().andUserIdEqualTo(user_id);

		List<TradeInvestRecords> selectByExample = tradeInvestRecordsMapper.selectByExample(example);

		return selectByExample.get(0);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public TradeInvestRecords selectInvestRecordByUserIdAndAmountGreatThanAndDaysGreatThanAndCreateAtBetween(
			Long userid, Integer amount, Integer days, Date startcreatedAt, Date endcreatedAt) {
		TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
		ire.createCriteria().andUserIdEqualTo(userid).andAmountGreaterThan(amount.longValue()).andDaysGreaterThan(days)
				.andCreatedAtBetween(startcreatedAt, endcreatedAt);
		List<TradeInvestRecords> irlist = tradeInvestRecordsMapper.selectByExample(ire);
		if (irlist != null) {
			return irlist.get(0);
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public Long selectSumAmountInvestRecordByProductSign(String product_sign) {
		return tradeInvestRecordsMapper.selectSumAmountInvestRecordByProductSign(product_sign);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public Integer selectCountInvestRecord() {
		TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
		return tradeInvestRecordsMapper.countByExample(ire);
	}

	@Override
	public Long selectSumAmountInvestRecord(TradeInvestRecordsExample ire) {
		Long selectSumAmountInvestRecordByrecord = tradeInvestRecordsMapper.selectSumAmountInvestRecordByrecord(ire);

		return selectSumAmountInvestRecordByrecord;
	}

	@Override
	public TradeInvestRecords selectInvestRecordByIdAndUserIdAndGreatThanExpireDate(Long id, Long userid,
			Date expire_date) {
		TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
		ire.createCriteria().andIdEqualTo(id).andUserIdEqualTo(userid).andExpireDateGreaterThan(expire_date);
		List<TradeInvestRecords> irelist = tradeInvestRecordsMapper.selectByExample(ire);
		if (irelist != null) {
			return irelist.get(0);
		}
		return null;
	}

	@Override
	public List<TradeInvestRecords> selectUnderwayFixByUserIdWithPage(Long userid, Integer currPage, Integer pageSize) {
		if (currPage == null) {
			currPage = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
		ire.setPageNo(currPage);
		ire.setPageSize(pageSize);
		ire.setOrderByClause("created_at DESC , expire_date asc");
		ire.createCriteria().andUserIdEqualTo(userid).andDaysNotEqualTo(1).andExpireDateGreaterThan(new Date());
		return tradeInvestRecordsMapper.selectByExample(ire);
	}

	@Override
	public List<TradeInvestRecords> doneFixedInvestRecordByUserId(Long userid, Integer currPage, Integer pageSize) {
		if (currPage == null) {
			currPage = 1;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		TradeInvestRecordsExample ire = new TradeInvestRecordsExample();
		ire.setPageNo(currPage);
		ire.setPageSize(pageSize);
		ire.setOrderByClause("created_at DESC , expire_date asc");
		ire.createCriteria().andUserIdEqualTo(userid).andDaysNotEqualTo(1).andExpireDateLessThanOrEqualTo(new Date());
		return tradeInvestRecordsMapper.selectByExample(ire);
	}

	@Override
	public Long selectFinishFixSumInterestByUserId(Long userid) {
		return tradeInvestRecordsMapper.selectFinishFixSumInterestByUserId(userid);
	}

	@Transactional
	@Override
	public void updateInvestRecordsSetIsAutoInvest(Long investRecordsID, Integer is_auto_invest) {
		TradeInvestRecords ir = new TradeInvestRecords();
		ir.setId(investRecordsID);
		ir.setIsAutoInvest(is_auto_invest.byteValue());
		ir.setUpdatedAt(new Date());
		tradeInvestRecordsMapper.updateByPrimaryKeySelective(ir);
	}

	@Override
	public Long selectFixedIncomeByUserId(Long userId) {

		Long selectFixedIncomeByUserId = tradeInvestRecordsMapper.selectFixedIncomeByUserId(userId);
		log.info("根据用户id userId = " + userId + "总的定期投资收益为 FixedIncomeAmount = " + selectFixedIncomeByUserId + "; \n");
		return selectFixedIncomeByUserId;
	}

	@Override
	public Long selectSumAmountByUserId(long UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long selectCurrentSumAmountNotWithDraw(long l) {
		return tradeInvestRecordsMapper.selectCurrentSumAmountNotWithDraw(l, DateUtil.addDays(-1));
	}

	@Override
	public TradeInvestRecords saveTradeInvestRecords(TradeInvestRecords tradeInvestRecords) {

		tradeInvestRecordsMapper.insertSelective(tradeInvestRecords);

		return tradeInvestRecords;
	}

	@Override
	public int selectTradeInvestRecords(Long user_id, Integer days) {
		TradeInvestRecordsExample example = new TradeInvestRecordsExample();

		example.createCriteria().andUserIdEqualTo(user_id).andDaysGreaterThan(days);

		List<TradeInvestRecords> selectByExample = tradeInvestRecordsMapper.selectByExample(example);

		return selectByExample.size();
	}

	@Override
	public Long selectSumAmountByUserIdAndCreatedAt(Long UserId) {

		Long selectSumAmountByUserIdAndCreatedAt = tradeInvestRecordsMapper.selectSumAmountByUserIdAndCreatedAt(UserId);

		return selectSumAmountByUserIdAndCreatedAt;
	}

	@Override
	public Integer selectCountInvestRecordByCondition(TradeInvestRecordsExample ire) {
		return tradeInvestRecordsMapper.countByExample(ire);
	}

}
