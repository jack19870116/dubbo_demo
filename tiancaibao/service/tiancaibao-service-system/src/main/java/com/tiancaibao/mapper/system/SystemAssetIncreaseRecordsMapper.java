package com.tiancaibao.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.system.SystemAssetIncreaseRecords;
import com.tiancaibao.pojo.system.SystemAssetIncreaseRecordsExample;

public interface SystemAssetIncreaseRecordsMapper {
    long countByExample(SystemAssetIncreaseRecordsExample example);

    int deleteByExample(SystemAssetIncreaseRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAssetIncreaseRecords record);

    int insertSelective(SystemAssetIncreaseRecords record);

    List<SystemAssetIncreaseRecords> selectByExample(SystemAssetIncreaseRecordsExample example);

    SystemAssetIncreaseRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAssetIncreaseRecords record, @Param("example") SystemAssetIncreaseRecordsExample example);

    int updateByExample(@Param("record") SystemAssetIncreaseRecords record, @Param("example") SystemAssetIncreaseRecordsExample example);

    int updateByPrimaryKeySelective(SystemAssetIncreaseRecords record);

    int updateByPrimaryKey(SystemAssetIncreaseRecords record);

	Long selectSumAmountByUserId(SystemAssetIncreaseRecordsExample example);
}