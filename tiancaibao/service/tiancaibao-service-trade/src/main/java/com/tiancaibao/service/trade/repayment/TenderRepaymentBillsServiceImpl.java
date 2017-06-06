package com.tiancaibao.service.trade.repayment;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TenderRepaymentBillsMapper;
import com.tiancaibao.pojo.trade.TenderRepaymentBills;
import com.tiancaibao.service.interfaces.trade.redeem.ITenderRepaymentBillsService;

@Service("TenderRepaymentBillsService")
public class TenderRepaymentBillsServiceImpl implements ITenderRepaymentBillsService {
	@Resource
	private TenderRepaymentBillsMapper TenderRepaymentBillsMapper;

	/**
	 * 根据Id更新赎回订单表
	 */
	@Override
	public int updateTenderRepaymentBills(long id, String yborderid, String status) {
		TenderRepaymentBills record = new TenderRepaymentBills();
		record.setYborderid(yborderid);
		record.setStatus(status);
		record.setId(id);
		return TenderRepaymentBillsMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据Id获取实体
	 */
	@Override
	public TenderRepaymentBills getTenderRepaymentBillsById(long id) {
		return TenderRepaymentBillsMapper.selectByPrimaryKey(id);
	}

}
