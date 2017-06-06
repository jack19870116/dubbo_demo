package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemPayTimeLimitsMapper;
import com.tiancaibao.pojo.system.SystemPayTimeLimits;
import com.tiancaibao.pojo.system.SystemPayTimeLimitsExample;
import com.tiancaibao.service.interfaces.system.ISystemPayTimeLimitsService;

@Service("systemPayTimeLimitsService")
public class SystemPayTimeLimitsServiceImpl implements ISystemPayTimeLimitsService {

	@Resource
	SystemPayTimeLimitsMapper systemPayTimeLimitsMapper;

	private static Logger log = Logger.getLogger(SystemPayTimeLimitsServiceImpl.class);
	
	@Override
	public SystemPayTimeLimits selectSystemPayTimeLimitsByType(String Type) {
		SystemPayTimeLimitsExample example = new SystemPayTimeLimitsExample();
		example.createCriteria().andTypeEqualTo(Type);
		List<SystemPayTimeLimits> selectByExample = systemPayTimeLimitsMapper.selectByExample(example);
		log.info("查询充值时间限制表 SystemPayTimeLimits 返回 " + selectByExample.get(0) + "\n" );
		return selectByExample.get(0);
	}

}
