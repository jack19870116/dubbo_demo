package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemVersionDirects;
import com.tiancaibao.pojo.system.SystemVersionDirectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemVersionDirectsMapper {
    long countByExample(SystemVersionDirectsExample example);

    int deleteByExample(SystemVersionDirectsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemVersionDirects record);

    int insertSelective(SystemVersionDirects record);

    List<SystemVersionDirects> selectByExample(SystemVersionDirectsExample example);

    SystemVersionDirects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemVersionDirects record, @Param("example") SystemVersionDirectsExample example);

    int updateByExample(@Param("record") SystemVersionDirects record, @Param("example") SystemVersionDirectsExample example);

    int updateByPrimaryKeySelective(SystemVersionDirects record);

    int updateByPrimaryKey(SystemVersionDirects record);
}