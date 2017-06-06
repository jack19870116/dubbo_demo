package com.tiancaibao.service.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.system.SystemAssetIncreaseRecordsMapper;
import com.tiancaibao.pojo.system.SystemAssetIncreaseRecords;
import com.tiancaibao.pojo.system.SystemAssetIncreaseRecordsExample;
import com.tiancaibao.service.interfaces.system.ISystemAssetIncreaseRecordsService;

@Service("systemAssetIncreaseRecordsService")
public class SystemAssetIncreaseRecordsImpl implements ISystemAssetIncreaseRecordsService {

	@Resource
	SystemAssetIncreaseRecordsMapper systemAssetIncreaseRecordsMapper;

	private static Logger log = LoggerFactory.getLogger(SystemAssetIncreaseRecordsImpl.class);
	
	@Override
	public SystemAssetIncreaseRecords selectAssetIncreaseByUserIdAndDate(Long user_id, Date date) {

		SystemAssetIncreaseRecordsExample example = new SystemAssetIncreaseRecordsExample();

		example.createCriteria().andUpdatedAtEqualTo(date).andUserIdEqualTo(user_id);
		List<SystemAssetIncreaseRecords> selectByExample = systemAssetIncreaseRecordsMapper.selectByExample(example);
		
		log.info("使用userId=" + user_id + "查询systemAssetIncreaseRecords" + date + "收益返回值是:" + selectByExample.get(0) +"\n");
		return selectByExample.get(0);
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public Long selectSumAmountByUserId(Long userId, Date start, Date end) {

		SystemAssetIncreaseRecordsExample example = new SystemAssetIncreaseRecordsExample();

		example.createCriteria().andUserIdEqualTo(userId).andCreatedAtGreaterThanOrEqualTo(start)
				.andCreatedAtLessThanOrEqualTo(end);
		Long amount = systemAssetIncreaseRecordsMapper.selectSumAmountByUserId(example);
		
		log.info("使用userId: " + userId + " 查询 systemAssetIncreaseRecords 用户所有的活期收益: " + amount  +"\n");
		return amount;
	}
}
