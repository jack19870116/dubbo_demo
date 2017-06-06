package com.tiancaibao.service.interfaces.debt;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.debt.DebtCurrentUserHolding;

/**
 * @author caochunmin
 * @version 创建时间：2017年5月31日 下午4:36:17 类说明
 */
public interface IDebtCurrentUserHoldingService {
	/**
	 * 根据id获取实体
	 * 
	 * @param id
	 * @return
	 */
	DebtCurrentUserHolding getDebtCurrentUserHolding(long id);

	/**
	 * 根据用户id获取用户当前持有债权的总金额（发送消息之前处理？？？？？？？？）
	 * 
	 * @param userId
	 * @return
	 */
	long getDebtUserHoldingAmountAll(long userId);

	/**
	 * 根据用户id获取用户债权列表以金额排序
	 * 
	 * @param userId
	 * @return
	 */
	List<DebtCurrentUserHolding> getDebtCurrentUserHoldingListByAmountOrder(long userId);

	/**
	 * 更新实体
	 * 
	 * @param id
	 * @param currentCount
	 * @param amount
	 * @param transferId
	 */
	void updateDebtCurrentUserHolding(long id, int currentCount, long amount, long transferId);

	/**
	 * 
	 * @param amount
	 * @param currentCount
	 * @param date
	 * @param transferId
	 */
	public void updateDebtCurrentUserHolding(Long amount, Integer currentCount, Date date, Long transferId);

	/**
	 * 
	 * @param userId
	 * @param investId
	 * @param debtOriginalAssetId
	 * @param currentCount
	 * @param originalCount
	 * @param amount
	 * @param originalAmount
	 */
	public void addDebtCurrentUserHolding(Long userId, Long investId, Long debtOriginalAssetId, Integer currentCount,
			Integer originalCount, Long amount, Long originalAmount);

	/**
	 * 随心转投资未满24h的总金额
	 * 
	 * @param userId
	 * @return
	 */
	long selectAmountByCondtion(long userId);

	/**
	 * 用户可转份数
	 * 
	 * @param userId
	 * @return
	 */
	long selectTransferableCount(Long userId);

	/**
	 * 获取用户当前持有的可转活期债权
	 * 
	 * @param userId
	 * @return
	 */
	List<DebtCurrentUserHolding> selectCurrentTransferableDebtRecords(Long userId);

}
