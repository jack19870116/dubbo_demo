package com.tiancaibao.mapper.integral;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.integral.IntegralSources;
import com.tiancaibao.pojo.integral.IntegralSourcesExample;

public interface IntegralSourcesMapper {
    int countByExample(IntegralSourcesExample example);

    int deleteByExample(IntegralSourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntegralSources record);

    int insertSelective(IntegralSources record);

    List<IntegralSources> selectByExample(IntegralSourcesExample example);

    IntegralSources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntegralSources record, @Param("example") IntegralSourcesExample example);

    int updateByExample(@Param("record") IntegralSources record, @Param("example") IntegralSourcesExample example);

    int updateByPrimaryKeySelective(IntegralSources record);

    int updateByPrimaryKey(IntegralSources record);
}