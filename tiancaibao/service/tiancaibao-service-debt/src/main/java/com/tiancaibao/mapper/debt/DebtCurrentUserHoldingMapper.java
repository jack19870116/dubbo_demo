package com.tiancaibao.mapper.debt;

import com.tiancaibao.pojo.debt.DebtCurrentUserHolding;
import com.tiancaibao.pojo.debt.DebtCurrentUserHoldingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DebtCurrentUserHoldingMapper {
	long countByExample(DebtCurrentUserHoldingExample example);

	int deleteByExample(DebtCurrentUserHoldingExample example);

	int deleteByPrimaryKey(Long id);

	int insert(DebtCurrentUserHolding record);

	int insertSelective(DebtCurrentUserHolding record);

	List<DebtCurrentUserHolding> selectByExample(DebtCurrentUserHoldingExample example);

	DebtCurrentUserHolding selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") DebtCurrentUserHolding record,
			@Param("example") DebtCurrentUserHoldingExample example);

	int updateByExample(@Param("record") DebtCurrentUserHolding record,
			@Param("example") DebtCurrentUserHoldingExample example);

	int updateByPrimaryKeySelective(DebtCurrentUserHolding record);

	int updateByPrimaryKey(DebtCurrentUserHolding record);

	/**
	 * 根据用户id获取用户当前持有债权的总金额
	 * 
	 * @param userId
	 * @return
	 */
	long getDebtUserHoldingAmountAll(long userId);

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