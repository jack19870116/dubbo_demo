package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderRepaymentRecords;
import com.tiancaibao.pojo.trade.TenderRepaymentRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderRepaymentRecordsMapper {
	long countByExample(TenderRepaymentRecordsExample example);

	int deleteByExample(TenderRepaymentRecordsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TenderRepaymentRecords record);

	int insertSelective(TenderRepaymentRecords record);

	List<TenderRepaymentRecords> selectByExample(TenderRepaymentRecordsExample example);

	TenderRepaymentRecords selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TenderRepaymentRecords record,
			@Param("example") TenderRepaymentRecordsExample example);

	int updateByExample(@Param("record") TenderRepaymentRecords record,
			@Param("example") TenderRepaymentRecordsExample example);

	int updateByPrimaryKeySelective(TenderRepaymentRecords record);

	int updateByPrimaryKey(TenderRepaymentRecords record);

	/**
	 * 获取最大id
	 * 
	 * @return
	 */
	long getMaxId();
}