package com.tiancaibao.service.trade.repayment;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TenderRepaymentHostingCollectMapper;
import com.tiancaibao.pojo.trade.TenderRepaymentHostingCollect;
import com.tiancaibao.pojo.trade.TenderRepaymentHostingCollectExample;
import com.tiancaibao.service.interfaces.trade.redeem.ITenderRepaymentHostingCollectService;

@Service("TenderRepaymentHostingCollectService")
public class TenderRepaymentHostingCollectServiceImpl implements ITenderRepaymentHostingCollectService {
	@Resource
	private TenderRepaymentHostingCollectMapper TenderRepaymentHostingCollectMapper;

	/**
	 * 根据订单号获取代收记录
	 */
	@Override
	public TenderRepaymentHostingCollect getTenderRepaymentHostingCollectByOrderCode(String orderCode) {
		return TenderRepaymentHostingCollectMapper.getTenderRepaymentHostingCollectByOrderCode(orderCode);
	}

	/**
	 * 根据订单号更新状态
	 */
	@Override
	public int updateStatus(String orderCode, String status) {
		TenderRepaymentHostingCollect record = new TenderRepaymentHostingCollect();
		record.setStatus(status);
		TenderRepaymentHostingCollectExample example = new TenderRepaymentHostingCollectExample();
		example.createCriteria().andOrderCodeEqualTo(orderCode);
		return TenderRepaymentHostingCollectMapper.updateByExampleSelective(record, example);
	}

}
