package com.tiancaibao.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.system.SystemAssets;
import com.tiancaibao.pojo.system.SystemAssetsExample;

public interface SystemAssetsMapper {
    int countByExample(SystemAssetsExample example);

    int deleteByExample(SystemAssetsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAssets record);

    int insertSelective(SystemAssets record);

    List<SystemAssets> selectByExample(SystemAssetsExample example);

    SystemAssets selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAssets record, @Param("example") SystemAssetsExample example);

    int updateByExample(@Param("record") SystemAssets record, @Param("example") SystemAssetsExample example);

    int updateByPrimaryKeySelective(SystemAssets record);

    int updateByPrimaryKey(SystemAssets record);
    
    
    Long rateAdd(SystemAssetsExample example);
    
    
}