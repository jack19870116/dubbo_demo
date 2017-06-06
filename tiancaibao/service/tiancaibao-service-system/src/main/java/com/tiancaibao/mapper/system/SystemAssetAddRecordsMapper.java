package com.tiancaibao.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.system.SystemAssetAddRecords;
import com.tiancaibao.pojo.system.SystemAssetAddRecordsExample;

public interface SystemAssetAddRecordsMapper {
    long countByExample(SystemAssetAddRecordsExample example);

    int deleteByExample(SystemAssetAddRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAssetAddRecords record);

    int insertSelective(SystemAssetAddRecords record);

    List<SystemAssetAddRecords> selectByExample(SystemAssetAddRecordsExample example);

    SystemAssetAddRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAssetAddRecords record, @Param("example") SystemAssetAddRecordsExample example);

    int updateByExample(@Param("record") SystemAssetAddRecords record, @Param("example") SystemAssetAddRecordsExample example);

    int updateByPrimaryKeySelective(SystemAssetAddRecords record);

    int updateByPrimaryKey(SystemAssetAddRecords record);
    
    Long sumAmountByExample(SystemAssetAddRecords record);
    
    
    
}