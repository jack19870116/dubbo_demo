package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemNews;
import com.tiancaibao.pojo.system.SystemNewsExample;
import com.tiancaibao.pojo.system.SystemNewsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemNewsMapper {
    long countByExample(SystemNewsExample example);

    int deleteByExample(SystemNewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemNewsWithBLOBs record);

    int insertSelective(SystemNewsWithBLOBs record);

    List<SystemNewsWithBLOBs> selectByExampleWithBLOBs(SystemNewsExample example);

    List<SystemNews> selectByExample(SystemNewsExample example);

    SystemNewsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemNewsWithBLOBs record, @Param("example") SystemNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemNewsWithBLOBs record, @Param("example") SystemNewsExample example);

    int updateByExample(@Param("record") SystemNews record, @Param("example") SystemNewsExample example);

    int updateByPrimaryKeySelective(SystemNewsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemNewsWithBLOBs record);

    int updateByPrimaryKey(SystemNews record);
}