package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemAmountLimitsMapper;
import com.tiancaibao.pojo.system.SystemAmountLimits;
import com.tiancaibao.pojo.system.SystemAmountLimitsExample;
import com.tiancaibao.service.interfaces.system.ISystemAmountLimitsService;

@Service("systemAmountLimitsService")
public class SystemAmountLimitsServiceImpl implements ISystemAmountLimitsService {
	@Resource
	SystemAmountLimitsMapper systemAmountLimitsMapper;

	private static Logger log = Logger.getLogger(SystemAmountLimitsServiceImpl.class);
	
	@Override
	public SystemAmountLimits selectSystemAmountLimitsByType(String type) {

		SystemAmountLimitsExample example = new SystemAmountLimitsExample();
		example.createCriteria().andTypeEqualTo(type);

		List<SystemAmountLimits> selectByExample = systemAmountLimitsMapper.selectByExample(example);
		log.info("查询充值限额表 SystemAmountLimits 返回 " + selectByExample.get(0) + "\n" );
		return selectByExample.get(0);
	}

}
