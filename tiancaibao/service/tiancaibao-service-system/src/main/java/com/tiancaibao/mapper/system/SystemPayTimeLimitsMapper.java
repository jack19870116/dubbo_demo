package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemPayTimeLimits;
import com.tiancaibao.pojo.system.SystemPayTimeLimitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemPayTimeLimitsMapper {
    long countByExample(SystemPayTimeLimitsExample example);

    int deleteByExample(SystemPayTimeLimitsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemPayTimeLimits record);

    int insertSelective(SystemPayTimeLimits record);

    List<SystemPayTimeLimits> selectByExample(SystemPayTimeLimitsExample example);

    SystemPayTimeLimits selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemPayTimeLimits record, @Param("example") SystemPayTimeLimitsExample example);

    int updateByExample(@Param("record") SystemPayTimeLimits record, @Param("example") SystemPayTimeLimitsExample example);

    int updateByPrimaryKeySelective(SystemPayTimeLimits record);

    int updateByPrimaryKey(SystemPayTimeLimits record);
}