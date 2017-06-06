package com.tiancaibao.service.interfaces.debt;

import com.tiancaibao.pojo.debt.DebtCurrentReceive;

/**
 * @author caochunmin
 * @version 创建时间：2017年5月31日 下午4:37:56 类说明
 */
public interface IDebtCurrentReceiveService {
	public long addDebtCurrentRecieve(Long userId, Long debtOriginalAssetId, Long investId, Long transferUserId,
			Long amount, Long interest, Integer status, String sinNo, Integer count, Long transferId);

	/**
	 * 根据用户的id获取实体
	 * 
	 * @param id
	 * @return
	 */
	public DebtCurrentReceive getDebtCurrentRecieve(long id);
}
