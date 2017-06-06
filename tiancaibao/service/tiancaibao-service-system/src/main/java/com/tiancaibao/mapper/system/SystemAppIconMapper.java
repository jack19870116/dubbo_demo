package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemAppIcon;
import com.tiancaibao.pojo.system.SystemAppIconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemAppIconMapper {
    long countByExample(SystemAppIconExample example);

    int deleteByExample(SystemAppIconExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAppIcon record);

    int insertSelective(SystemAppIcon record);

    List<SystemAppIcon> selectByExample(SystemAppIconExample example);

    SystemAppIcon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAppIcon record, @Param("example") SystemAppIconExample example);

    int updateByExample(@Param("record") SystemAppIcon record, @Param("example") SystemAppIconExample example);

    int updateByPrimaryKeySelective(SystemAppIcon record);

    int updateByPrimaryKey(SystemAppIcon record);
}