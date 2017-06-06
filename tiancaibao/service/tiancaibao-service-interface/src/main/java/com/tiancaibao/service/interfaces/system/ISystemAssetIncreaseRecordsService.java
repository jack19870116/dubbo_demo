package com.tiancaibao.service.interfaces.system;

import java.util.Date;

import com.tiancaibao.pojo.system.SystemAssetIncreaseRecords;

public interface ISystemAssetIncreaseRecordsService {
	
	/**
	 * 根据用户id和时间查询用户某一天的收益
	 * @param user_id
	 * @param date
	 * @return
	 */
	public SystemAssetIncreaseRecords selectAssetIncreaseByUserIdAndDate(Long user_id,Date date);

	/**
	 * 获取用户所有的活期收益
	 * @param userId
	 * @return
	 */
	Long selectSumAmountByUserId(Long userId,Date start,Date end);
	
	
	
	

}
