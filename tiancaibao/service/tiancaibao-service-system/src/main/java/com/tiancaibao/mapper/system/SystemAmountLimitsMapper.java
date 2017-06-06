package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemAmountLimits;
import com.tiancaibao.pojo.system.SystemAmountLimitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemAmountLimitsMapper {
    long countByExample(SystemAmountLimitsExample example);

    int deleteByExample(SystemAmountLimitsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAmountLimits record);

    int insertSelective(SystemAmountLimits record);

    List<SystemAmountLimits> selectByExample(SystemAmountLimitsExample example);

    SystemAmountLimits selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAmountLimits record, @Param("example") SystemAmountLimitsExample example);

    int updateByExample(@Param("record") SystemAmountLimits record, @Param("example") SystemAmountLimitsExample example);

    int updateByPrimaryKeySelective(SystemAmountLimits record);

    int updateByPrimaryKey(SystemAmountLimits record);
}