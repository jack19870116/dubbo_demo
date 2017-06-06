package com.tiancaibao.service.trade.repayment;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TenderRepaymentHostingPayMapper;
import com.tiancaibao.pojo.trade.TenderRepaymentHostingPay;
import com.tiancaibao.service.interfaces.trade.redeem.ITenderRepaymentHostingPayService;

@Service("TenderRepaymentHostingPayService")
public class TenderRepaymentHostingPayServiceImpl implements ITenderRepaymentHostingPayService {
	@Resource
	private TenderRepaymentHostingPayMapper TenderRepaymentHostingPayMapper;

	/**
	 * 添加记录
	 */
	@Override
	public int addTenderRepaymentHostingPay(long userId, long amount, long redeemOrderId, long hostingPayOrderId,
			String status, String orderCode, String ip) {
		long id = TenderRepaymentHostingPayMapper.getMaxId() + 1;

		TenderRepaymentHostingPay record = new TenderRepaymentHostingPay();
		record.setId(id);
		record.setUserId(userId);
		record.setAmount(amount * 10000);
		record.setHostingPayOrderId(hostingPayOrderId + "");
		record.setRedeemOrderId(redeemOrderId + "");
		record.setStatus(status);
		record.setOrderCode(orderCode);
		record.setIp(ip);
		record.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		int insertSelective = TenderRepaymentHostingPayMapper.insertSelective(record);
		return insertSelective;
	}

	/**
	 * 根据订单号获取代付实体
	 */
	@Override
	public TenderRepaymentHostingPay getTenderRepaymentHostingPayByOrderCode(String orderCode) {
		return TenderRepaymentHostingPayMapper.getTenderRepaymentHostingPayByOrderCode(orderCode);
	}

	/**
	 * 根据id更新代付实体类
	 */
	@Override
	public int updateTenderRepaymentHostingPay(long id, String hostingPayOrderId, String status) {
		TenderRepaymentHostingPay record = new TenderRepaymentHostingPay();
		record.setId(id);
		record.setHostingPayOrderId(hostingPayOrderId);
		record.setStatus(status);
		return TenderRepaymentHostingPayMapper.updateByPrimaryKey(record);
	}

}
