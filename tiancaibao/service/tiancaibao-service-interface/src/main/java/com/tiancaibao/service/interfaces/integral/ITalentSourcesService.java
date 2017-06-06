package com.tiancaibao.service.interfaces.integral;

import com.tiancaibao.pojo.integral.IntegralTalentSource;

/**
 * @author zhozhihang
 * @version 创建时间：2017年6月1日 下午3:37:36 类说明
 */
public interface ITalentSourcesService {
	/**
	 * 根据ID查出一条数据
	 * 
	 * @param id
	 * @return
	 */

	public IntegralTalentSource selectIntegralTalentSource(Integer id);

}
