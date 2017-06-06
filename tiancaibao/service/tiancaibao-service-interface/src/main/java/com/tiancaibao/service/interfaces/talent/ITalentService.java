package com.tiancaibao.service.interfaces.talent;

import java.util.Date;

import com.tiancaibao.pojo.integral.IntegralTalentSource;

public interface ITalentService {


	/**
	 * 根据用户ID和来源ID返回这一类型记录的条数
	 * @param userid
	 * @param sourceId
	 * @return
	 */
	int selectCountChangeTalentValueRecordByUserIdAndSourceId(Long userid, Integer sourceId);

	/**
	 * 向天财值记录表插入一条数据
	 * @param userid
	 * @param value
	 * @param userCurrentValue
	 * @param date
	 * @param sourceId
	 * @return
	 */
	int insertChangeTalentValueRecord(Long userid, Long value, Long userCurrentValue, Date date, Integer sourceId);

	/**
	 * 根据天财值来源ID返回一条记录
	 * @param id
	 * @return
	 */
	IntegralTalentSource selectTalentSourceById(int integralTalentSourcId);
	
	/**
	 * 转换天财值为积分
	 * @param userid
	 * @param talentValue
	 * @param integral
	 * @param num
	 */
	void ChangeTalentValueToIntegral(Long userid, Long talentValue, Integer integral, Long num);

}
