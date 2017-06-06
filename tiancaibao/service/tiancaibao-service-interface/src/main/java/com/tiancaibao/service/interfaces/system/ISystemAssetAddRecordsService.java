package com.tiancaibao.service.interfaces.system;

import com.tiancaibao.pojo.system.SystemAssetAddRecords;
import com.tiancaibao.pojo.system.SystemAssetAddRecordsExample;

/** 
* @author zhozhihang
* @version 创建时间：2017年6月5日 上午10:50:19 
* 类说明 
*/
public interface ISystemAssetAddRecordsService {
	
	/**
	 * 根据条件查询一条记录
	 * @param systemAssetAddRecords
	 * @return
	 */
	
	public SystemAssetAddRecords selectSystemAssetAddRecords(SystemAssetAddRecordsExample example);
	/**
	 * 总计
	 * @param example
	 * @return
	 */
	
	public Long sumAmountBySystemAssetAddRecords(SystemAssetAddRecords record);
	

}
