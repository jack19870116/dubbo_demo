package com.tiancaibao.mapper.themis;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.themis.ThemisContracts;
import com.tiancaibao.pojo.themis.ThemisContractsExample;

public interface ThemisContractsMapper {
    int countByExample(ThemisContractsExample example);

    int deleteByExample(ThemisContractsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ThemisContracts record);

    int insertSelective(ThemisContracts record);

    List<ThemisContracts> selectByExample(ThemisContractsExample example);

    ThemisContracts selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ThemisContracts record, @Param("example") ThemisContractsExample example);

    int updateByExample(@Param("record") ThemisContracts record, @Param("example") ThemisContractsExample example);

    int updateByPrimaryKeySelective(ThemisContracts record);

    int updateByPrimaryKey(ThemisContracts record);
}