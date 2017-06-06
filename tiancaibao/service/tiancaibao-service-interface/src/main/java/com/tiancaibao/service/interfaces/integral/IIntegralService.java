package com.tiancaibao.service.interfaces.integral;

import java.util.List;

import com.tiancaibao.pojo.integral.IntegralRecords;

public interface IIntegralService {

	/**
	 * 根据用户ID分页返回用户积分记录
	 * 
	 * @param currPage
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	List<IntegralRecords> selectIntegralRecordWithPageByUserId(Integer currPage, Integer pageSize, Long userid);

	/**
	 * 根据用户ID和来源返回首条记录
	 * 
	 * @param userid
	 * @param source
	 * @return
	 */
	IntegralRecords selectIntegralRecordByUserIdAndSourceAndCreateAtCurrentDayFirst(Long userid, Integer source);

	/**
	 * 插入一条记录到用户积分记录表
	 * 
	 * @param userid
	 * @param integral
	 * @param source
	 * @param userCurrentIntegral
	 */
	void insertIntegralRecord(Long userid, Integer integral, Integer source, Integer userCurrentIntegral,
			String remark);
	/**
	 * 通过UserId来查询已使用的积分总和
	 * 
	 * @param id
	 * @return 已使用的积分总和
	 */
	Integer selectUseIntegralSum(Long userid);

}
