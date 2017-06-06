package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderInvestRecords;
import com.tiancaibao.pojo.trade.TenderInvestRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderInvestRecordsMapper {
	long countByExample(TenderInvestRecordsExample example);

	int deleteByExample(TenderInvestRecordsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TenderInvestRecords record);

	int insertSelective(TenderInvestRecords record);

	List<TenderInvestRecords> selectByExample(TenderInvestRecordsExample example);

	TenderInvestRecords selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TenderInvestRecords record,
			@Param("example") TenderInvestRecordsExample example);

	int updateByExample(@Param("record") TenderInvestRecords record,
			@Param("example") TenderInvestRecordsExample example);

	int updateByPrimaryKeySelective(TenderInvestRecords record);

	int updateByPrimaryKey(TenderInvestRecords record);

	// 获取投资记录表的最大id
	int getMaxId();

	// 获取用户的还款记录（还款中和已经还款）
	List<TenderInvestRecords> getRepaymentInRecords(long userId);

	// 获取用户的待收益
	long getPendingIncome(long userId);

	// 获取用户的已获取的收益
	long getAreadyIncome(long userId);
}