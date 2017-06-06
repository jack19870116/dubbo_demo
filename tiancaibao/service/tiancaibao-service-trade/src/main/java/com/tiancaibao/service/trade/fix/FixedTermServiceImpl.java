//package com.tiancaibao.service.trade.fix;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.tiancaibao.mapper.trade.TradeInvestRecordsMapper;
//import com.tiancaibao.service.interfaces.trade.IFixedTermService;
//@Service("FixedTermService")
//public class FixedTermServiceImpl implements IFixedTermService {
//	
//	@Resource
//	private TradeInvestRecordsMapper investRecordsMapper;
//	
//	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
//	@Override
//	public Long selectSumInterestFix() {
//		return investRecordsMapper.selectSumInterestFix();
//	}
//
//}
