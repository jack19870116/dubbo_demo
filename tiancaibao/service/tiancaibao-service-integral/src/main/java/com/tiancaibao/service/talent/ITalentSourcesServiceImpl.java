package com.tiancaibao.service.talent;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.integral.IntegralTalentSourceMapper;
import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.service.interfaces.integral.ITalentSourcesService;

@Service("talentSourcesService")
public class ITalentSourcesServiceImpl implements ITalentSourcesService {

	@Resource
	IntegralTalentSourceMapper integralTalentSourceMapper;

	@Override
	public IntegralTalentSource selectIntegralTalentSource(Integer id) {
		IntegralTalentSource selectByPrimaryKey = integralTalentSourceMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

}
