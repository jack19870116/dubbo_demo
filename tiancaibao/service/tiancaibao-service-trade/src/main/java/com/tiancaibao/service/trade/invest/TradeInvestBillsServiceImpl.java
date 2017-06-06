package com.tiancaibao.service.trade.invest;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeInvestBillsMapper;
import com.tiancaibao.pojo.trade.TradeInvestBills;
import com.tiancaibao.pojo.trade.TradeInvestBillsExample;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestBillsService;
import com.tiancaibao.utils.DateUtil;

@Service("tradeInvestBillsService")
public class TradeInvestBillsServiceImpl implements ITradeInvestBillsService {

	@Resource
	private TradeInvestBillsMapper investBillsMapper;

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@Override
	public List<TradeInvestBills> selectInvestBillListByUserIdAndCreateAtGreatThanDateOrderByCreateAtWithPage(
			Long userid, String date, String order, Integer currPage, Integer pageSize) {
		TradeInvestBillsExample ibe = new TradeInvestBillsExample();
		ibe.setFields("order_code,amount,days,status,created_at,reinvest,user_id");
		ibe.setPageNo(currPage);
		ibe.setPageSize(pageSize);
		ibe.createCriteria().andCreatedAtGreaterThanOrEqualTo(DateUtil.parseDateTime(date));
		ibe.setOrderByClause("created_at " + order);
		return investBillsMapper.selectByExample(ibe);

	}

	@Override
	public TradeInvestBills selectInvestBillByIdAndUserId(Long id, Long userid) {
		TradeInvestBillsExample ibe = new TradeInvestBillsExample();
		ibe.createCriteria().andIdEqualTo(id).andUserIdEqualTo(userid);
		List<TradeInvestBills> iblist = investBillsMapper.selectByExample(ibe);
		if (iblist != null) {
			return iblist.get(0);
		}
		return null;
	}

	@Override
	public TradeInvestBills selectInvestBillById(Long id) {
		return investBillsMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer insertTradeInvestBills(Long userId, Long amount, Date days, Integer is_auto_invest, Integer couponId,
			Integer systemAssetdays, String order_code, String client, String ip) {
		TradeInvestBills ib = new TradeInvestBills();
		ib.setUserId(userId);
		ib.setAmount(amount);
		ib.setStatus("WAITING_CONFIRM");
		ib.setDays(systemAssetdays.longValue());
		ib.setOrderCode(order_code);
		ib.setIsAutoInvest(is_auto_invest.byteValue());
		ib.setCouponId(couponId == null ? 0 : couponId);
		ib.setIp(ip);
		ib.setClient(client);
		ib.setCreatedAt(new Date());
		return investBillsMapper.insertSelective(ib); // 返回id
	}

	@Transactional
	@Override
	public void updateInvestBillsSetIsAutoInvest(Long InvestBillsId, Integer is_auto_invest) {
		TradeInvestBills ib = new TradeInvestBills();
		ib.setId(InvestBillsId);
		ib.setIsAutoInvest(is_auto_invest.byteValue());
		ib.setUpdatedAt(new Date());
		investBillsMapper.updateByPrimaryKeySelective(ib);
	}

	@Override
	public TradeInvestBills saveInvestBills(Long userId, Long amount, String status, Integer days, String order_code,
			Byte isAutoInvest, Integer couponId, Integer interest_id, String ip, String client) {
		TradeInvestBills record = new TradeInvestBills();

		record.setUserId(userId);
		record.setAmount(amount);
		record.setStatus(status);
		record.setDays(days.longValue());
		record.setOrderCode(order_code);
		record.setIsAutoInvest(isAutoInvest);
		record.setCouponId(couponId);
		record.setInterestId(interest_id);
		record.setIp(ip);
		record.setClient(client);

		investBillsMapper.insertSelective(record);

		return record;
	}

	@Override
	public TradeInvestBills selectInvestBillsByOrderCode(String order_code) {
		TradeInvestBillsExample ibe = new TradeInvestBillsExample();
		ibe.createCriteria().andOrderCodeEqualTo(order_code);

		List<TradeInvestBills> selectByExample = investBillsMapper.selectByExample(ibe);

		return selectByExample == null ? null : selectByExample.get(0);
	}

	@Override
	public int updateTradeInvestBills(TradeInvestBills tradeInvestBills) {

		TradeInvestBillsExample example = new TradeInvestBillsExample();

		TradeInvestBills record = new TradeInvestBills();

		record.setStatus(tradeInvestBills.getStatus());
		record.setYborderid(tradeInvestBills.getYborderid());
		record.setConfirmedAt(tradeInvestBills.getConfirmedAt());

		int updateByExampleSelective = investBillsMapper.updateByExampleSelective(record, example);

		// TODO Auto-generated method stub
		return updateByExampleSelective;
	}

	@Override
	public int countTradeInvestBillsByUserId(Long userId, String status, Date creatAt) {
		TradeInvestBillsExample example = new TradeInvestBillsExample();

		example.createCriteria().andUserIdEqualTo(userId).andStatusNotEqualTo(status)
				.andCreatedAtGreaterThanOrEqualTo(creatAt);

		Long countByExample = investBillsMapper.countByExample(example);

		return countByExample.intValue();
	}

	@Override
	public Long sumAoment(Long userId, String status, Date creatAt) {

		TradeInvestBills record = new TradeInvestBills();
		record.setUserId(userId);
		record.setStatus(status);
		record.setCreatedAt(creatAt);

		Long sumAoment = investBillsMapper.sumAoment(record);

		return sumAoment;
	}
}
