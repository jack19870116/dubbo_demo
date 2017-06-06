package com.tiancaibao.service.trade.repayment;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TenderRepaymentRecordsMapper;
import com.tiancaibao.pojo.trade.TenderRepaymentRecords;
import com.tiancaibao.service.interfaces.trade.redeem.ITenderRepaymentRecordsService;

@Service("TenderRepaymentRecordsService")
public class TenderRepaymentRecordsServiceImpl implements ITenderRepaymentRecordsService {
	@Resource
	private TenderRepaymentRecordsMapper TenderRepaymentRecordsMapper;

	/**
	 * 添加记录
	 */
	@Override
	public int addTenderRepaymentRecords(long userId, long amount, String sinaOrderId, int days, String productSign,
			String status, String orderCode, String ip, int reinvest) {
		TenderRepaymentRecords records = new TenderRepaymentRecords();
		long id = TenderRepaymentRecordsMapper.getMaxId() + 1;
		records.setId(id);
		records.setUserId(userId);
		records.setAmount(amount);
		records.setSinaOrderId(sinaOrderId);
		records.setDays(days);
		records.setProductSign(productSign);
		records.setStatus(status);
		records.setOrderCode(orderCode);
		records.setIp(ip);
		records.setReinvest(reinvest);
		return TenderRepaymentRecordsMapper.insertSelective(records);
	}

}
