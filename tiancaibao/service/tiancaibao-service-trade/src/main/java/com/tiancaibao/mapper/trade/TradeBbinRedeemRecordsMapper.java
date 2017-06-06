package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeBbinRedeemRecords;
import com.tiancaibao.pojo.trade.TradeBbinRedeemRecordsExample;

public interface TradeBbinRedeemRecordsMapper {
    long countByExample(TradeBbinRedeemRecordsExample example);

    int deleteByExample(TradeBbinRedeemRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeBbinRedeemRecords record);

    int insertSelective(TradeBbinRedeemRecords record);

    List<TradeBbinRedeemRecords> selectByExample(TradeBbinRedeemRecordsExample example);

    TradeBbinRedeemRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeBbinRedeemRecords record, @Param("example") TradeBbinRedeemRecordsExample example);

    int updateByExample(@Param("record") TradeBbinRedeemRecords record, @Param("example") TradeBbinRedeemRecordsExample example);

    int updateByPrimaryKeySelective(TradeBbinRedeemRecords record);

    int updateByPrimaryKey(TradeBbinRedeemRecords record);
    
    Long sumAmount(TradeBbinRedeemRecordsExample example);
    
    
}