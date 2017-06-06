package com.tiancaibao.service.trade.withdraw;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.trade.TradeBbinRedeemRecordsMapper;
import com.tiancaibao.pojo.trade.TradeBbinRedeemRecordsExample;
import com.tiancaibao.service.interfaces.trade.withdraw.TradeBbinRedeemRecordsService;

@Service("tradeBbinRedeemRecordsService")
public class TradeBbinRedeemRecordsServiceImpl implements TradeBbinRedeemRecordsService {

	@Resource
	TradeBbinRedeemRecordsMapper tradeBbinRedeemRecordsMapper;

	private static Logger log = LoggerFactory.getLogger(TradeBbinRedeemRecordsServiceImpl.class);
	
	@Override
	public Long sumAmount(Long userId) {

		TradeBbinRedeemRecordsExample example = new TradeBbinRedeemRecordsExample();
		example.createCriteria().andUserIdEqualTo(userId);
		Long amount =tradeBbinRedeemRecordsMapper.sumAmount(example);
		log.info("使用userId=" + userId + "查询tradeBbinRedeemRecords体验金总额返回值是:" + amount +"; \n");
		return amount;
	}

}
