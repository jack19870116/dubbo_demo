package com.tiancaibao.mapper.integral;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.integral.IntegralRecords;
import com.tiancaibao.pojo.integral.IntegralRecordsExample;

public interface IntegralRecordsMapper {
    int countByExample(IntegralRecordsExample example);

    int deleteByExample(IntegralRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegralRecords record);

    int insertSelective(IntegralRecords record);

    List<IntegralRecords> selectByExample(IntegralRecordsExample example);

    IntegralRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegralRecords record, @Param("example") IntegralRecordsExample example);

    int updateByExample(@Param("record") IntegralRecords record, @Param("example") IntegralRecordsExample example);

    int updateByPrimaryKeySelective(IntegralRecords record);

    int updateByPrimaryKey(IntegralRecords record);

	Integer selectUseIntegralSum(Long userid);
}