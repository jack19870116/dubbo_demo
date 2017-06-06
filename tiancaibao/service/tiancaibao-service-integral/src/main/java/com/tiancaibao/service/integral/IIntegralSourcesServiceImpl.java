package com.tiancaibao.service.integral;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.integral.IntegralSourcesMapper;
import com.tiancaibao.pojo.integral.IntegralSources;
import com.tiancaibao.service.interfaces.integral.IIntegralSourcesService;

@Service("integralSourcesService")
public class IIntegralSourcesServiceImpl implements IIntegralSourcesService {

	@Resource
	IntegralSourcesMapper integralSourcesMapper;

	@Override
	public IntegralSources selectIntegralSourcesById(Integer id) {

		IntegralSources selectByPrimaryKey = integralSourcesMapper.selectByPrimaryKey(id);

		// TODO Auto-generated method stub
		return selectByPrimaryKey;
	}

}
