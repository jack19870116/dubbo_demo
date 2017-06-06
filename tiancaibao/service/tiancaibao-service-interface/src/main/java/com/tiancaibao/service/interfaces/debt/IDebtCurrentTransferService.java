package com.tiancaibao.service.interfaces.debt;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.tiancaibao.pojo.debt.DebtCurrentTransfer;

/**
 * @author caochunmin
 * @version 创建时间：2017年5月31日 下午4:40:34 类说明
 */
public interface IDebtCurrentTransferService {
	/**
	 * 根据条件查询债权匹配
	 * 
	 * @param params
	 * @return
	 */
	List<DebtCurrentTransfer> selectTransferMatch(Map<String, Object> params);

	/**
	 * 
	 * @param id
	 *            债权转让表id
	 * @param status
	 *            状态
	 * @param amount
	 *            金额
	 * @param count
	 *            次数
	 */
	void updateDebtCurrentTransfer(Long id, Integer status, Long amount, Integer count);

	/**
	 * 添加记录
	 * 
	 * @param userId
	 * @param investId
	 * @param debtOriginalAssetId
	 * @param rate
	 * @param status
	 * @param originalAmount
	 * @param amount
	 * @param originalCount
	 * @param count
	 * @param endDate
	 * @return 
	 */
	long addDebtCurrentTransfer(long userId, Long investId, Long debtOriginalAssetId, int rate, int status,
			long originalAmount, long amount, int originalCount, int count, Date endDate);
}
