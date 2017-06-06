package com.tiancaibao.service.talent;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.integral.IntegralTalentRecordsMapper;
import com.tiancaibao.mapper.integral.IntegralTalentSourceMapper;
import com.tiancaibao.pojo.integral.IntegralTalentRecords;
import com.tiancaibao.pojo.integral.IntegralTalentRecordsExample;
import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.service.interfaces.talent.ITalentService;

@Service("talentsService")
public class TalentsServiceImpl implements ITalentService {

	
	@Resource
	private  IntegralTalentRecordsMapper integralChangeTalentValueRecordsMapper;
	
	@Resource
	private  IntegralTalentSourceMapper integralTalentSourceMapper;

	@Override
	public int selectCountChangeTalentValueRecordByUserIdAndSourceId(Long userid, Integer sourceId) {
		IntegralTalentRecordsExample example=new IntegralTalentRecordsExample();
		example.createCriteria().andUserIdEqualTo(userid).andSourceIdEqualTo(sourceId);
		
		int countByExample = integralChangeTalentValueRecordsMapper.countByExample(example);

		return countByExample;
	}

	@Override
	public int insertChangeTalentValueRecord(Long userid, Long value, Long userCurrentValue, Date date,Integer sourceId) {
		// TODO Auto-generated method stub
	    IntegralTalentRecords record=new IntegralTalentRecords();
		record.setUserId(userid);
		record.setValue(Long.parseLong(value.toString()));
		record.setUserCurrentValue(userCurrentValue);
		record.setDate(date);
		record.setSourceId(sourceId);
		record.setCreatedAt(new Date());
		record.setUpdatedAt(new Date());
		int insert = integralChangeTalentValueRecordsMapper.insert(record);
		return insert;
	}

	@Override
	public IntegralTalentSource selectTalentSourceById(int id) {
		// TODO Auto-generated method stub
		IntegralTalentSource selectByPrimaryKey = integralTalentSourceMapper.selectByPrimaryKey(id);
		
		return selectByPrimaryKey;
	}

	@Override
	public void ChangeTalentValueToIntegral(Long userid, Long talentValue, Integer integral, Long num) {
		// TODO Auto-generated method stub
		
	}

	

}
