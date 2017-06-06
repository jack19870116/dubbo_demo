package com.tiancaibao.service.integral;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.integral.IntegralRecordsMapper;
import com.tiancaibao.pojo.integral.IntegralRecords;
import com.tiancaibao.service.interfaces.integral.IIntegralRecordsService;

@Service("integralRecordsService")
public class IIntegralRecordsServiceImpl implements IIntegralRecordsService {

	@Resource
	IntegralRecordsMapper integralRecordsMapper;

	@Override
	public int saveIntegralRecords(IntegralRecords integralRecords) {
		int insertSelective = integralRecordsMapper.insertSelective(integralRecords);
		// TODO Auto-generated method stub
		return insertSelective;
	}

}
