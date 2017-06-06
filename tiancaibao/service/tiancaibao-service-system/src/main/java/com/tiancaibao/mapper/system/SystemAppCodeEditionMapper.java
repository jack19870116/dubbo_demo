package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemAppCodeEdition;
import com.tiancaibao.pojo.system.SystemAppCodeEditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemAppCodeEditionMapper {
    long countByExample(SystemAppCodeEditionExample example);

    int deleteByExample(SystemAppCodeEditionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAppCodeEdition record);

    int insertSelective(SystemAppCodeEdition record);

    List<SystemAppCodeEdition> selectByExample(SystemAppCodeEditionExample example);

    SystemAppCodeEdition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAppCodeEdition record, @Param("example") SystemAppCodeEditionExample example);

    int updateByExample(@Param("record") SystemAppCodeEdition record, @Param("example") SystemAppCodeEditionExample example);

    int updateByPrimaryKeySelective(SystemAppCodeEdition record);

    int updateByPrimaryKey(SystemAppCodeEdition record);
}