package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemAssetAddRecordsMapper;
import com.tiancaibao.pojo.system.SystemAssetAddRecords;
import com.tiancaibao.pojo.system.SystemAssetAddRecordsExample;
import com.tiancaibao.service.interfaces.system.ISystemAssetAddRecordsService;

@Service("systemAssetAddRecordsService")
public class ISystemAssetAddRecordsServiceImpl implements ISystemAssetAddRecordsService {

	@Resource
	SystemAssetAddRecordsMapper systemAssetAddRecordsMapper;

	@Override
	public SystemAssetAddRecords selectSystemAssetAddRecords(SystemAssetAddRecordsExample example) {

		List<SystemAssetAddRecords> selectByExample = systemAssetAddRecordsMapper.selectByExample(example);

		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

	@Override
	public Long sumAmountBySystemAssetAddRecords(SystemAssetAddRecords record) {

		Long sumAmountByExample = systemAssetAddRecordsMapper.sumAmountByExample(record);

		return sumAmountByExample == null ? 0L : sumAmountByExample;
	}

}
