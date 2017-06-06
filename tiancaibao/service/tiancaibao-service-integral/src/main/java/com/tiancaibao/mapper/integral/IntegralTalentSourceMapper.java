package com.tiancaibao.mapper.integral;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.pojo.integral.IntegralTalentSourceExample;

public interface IntegralTalentSourceMapper {
    int countByExample(IntegralTalentSourceExample example);

    int deleteByExample(IntegralTalentSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntegralTalentSource record);

    int insertSelective(IntegralTalentSource record);

    List<IntegralTalentSource> selectByExample(IntegralTalentSourceExample example);

    IntegralTalentSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntegralTalentSource record, @Param("example") IntegralTalentSourceExample example);

    int updateByExample(@Param("record") IntegralTalentSource record, @Param("example") IntegralTalentSourceExample example);

    int updateByPrimaryKeySelective(IntegralTalentSource record);

    int updateByPrimaryKey(IntegralTalentSource record);
}