package com.tiancaibao.service.trade.yibao;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.trade.TradeYibao20160107sMapper;
import com.tiancaibao.service.interfaces.trade.ITradeYiBaoService;
/**
 * dubbo服务接口实现类--易宝
 * @author Mack
 * 2017年2月14日 下午12:00:04
 */
@Service("yiBaoService")
public class YiBaoServiceImpl implements ITradeYiBaoService {
	@Resource
	private TradeYibao20160107sMapper yibao20160107sMapper;
	
	private static final Logger log = LoggerFactory.getLogger(YiBaoServiceImpl.class);

	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	@Override
	public Long selectSumAmountByUserId(Long userId) {
		Long amount = yibao20160107sMapper.selectSumAmountByUserId(userId);
		log.info("使用userId: " + userId + " 查询 TradeYibao20160107s 该用户2016-01-07以前总提现金额: " + amount +"\n");
		return amount;
	}

}
