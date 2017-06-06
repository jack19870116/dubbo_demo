//package com.tiancaibao.service.trade.current;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.tiancaibao.mapper.system.SystemAssetIncreaseRecordsMapper;
//import com.tiancaibao.pojo.system.SystemAssetIncreaseRecords;
//import com.tiancaibao.pojo.system.SystemAssetIncreaseRecordsExample;
//import com.tiancaibao.service.interfaces.trade.ICurrentService;
//
//@Service("currentService")
//public class CurrentServiceImpl implements ICurrentService {
//
//	@Resource
//	private SystemAssetIncreaseRecordsMapper assetIncreaseRecordsMapper;
//
//	@Override
//	public Long selectSumAmountAssetIncreaseRecord() {
//		return assetIncreaseRecordsMapper.selectSumAmountAssetIncreaseRecord();
//	}
//
//	@Override
//	public List<SystemAssetIncreaseRecords> seleAssetIncreaseRecordByUseridAndAmountGreatThanAndOrderByDateWithPage(
//			Long userid, Long amount, Integer currPage, Integer pageSize, String orderByDate) {
//		if(currPage==null){
//			currPage = 1;
//		}
//		if(pageSize==null){
//			pageSize = 10;
//		}
//		SystemAssetIncreaseRecordsExample air = new SystemAssetIncreaseRecordsExample();
//		air.setPageNo(currPage);
//		air.setPageSize(pageSize);
//		air.setOrderByClause("date desc");
//		air.createCriteria().andUserIdEqualTo(userid).andAmountGreaterThanOrEqualTo(amount);
//		return assetIncreaseRecordsMapper.selectByExample(air);
//	}
//
//	@Override
//	public Long selectSumAmountFromAssetIncreaseRecordByUserId(Long userid) {
//		return assetIncreaseRecordsMapper.selectSumAmountFromAssetIncreaseRecordByUserId(userid);
//	}
//
//}
