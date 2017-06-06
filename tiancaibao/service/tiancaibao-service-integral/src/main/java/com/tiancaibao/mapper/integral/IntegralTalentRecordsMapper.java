package com.tiancaibao.mapper.integral;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.integral.IntegralTalentRecords;
import com.tiancaibao.pojo.integral.IntegralTalentRecordsExample;


public interface IntegralTalentRecordsMapper {
    int countByExample(IntegralTalentRecordsExample example);

    int deleteByExample(IntegralTalentRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IntegralTalentRecords record);

    int insertSelective(IntegralTalentRecords record);

    List<IntegralTalentRecords> selectByExample(IntegralTalentRecordsExample example);

    IntegralTalentRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IntegralTalentRecords record, @Param("example") IntegralTalentRecordsExample example);

    int updateByExample(@Param("record") IntegralTalentRecords record, @Param("example") IntegralTalentRecordsExample example);

    int updateByPrimaryKeySelective(IntegralTalentRecords record);

    int updateByPrimaryKey(IntegralTalentRecords record);
}