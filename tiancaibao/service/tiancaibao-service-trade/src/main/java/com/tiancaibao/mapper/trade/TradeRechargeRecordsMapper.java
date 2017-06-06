package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeRechargeRecords;
import com.tiancaibao.pojo.trade.TradeRechargeRecordsExample;

public interface TradeRechargeRecordsMapper {
    int countByExample(TradeRechargeRecordsExample example);

    int deleteByExample(TradeRechargeRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeRechargeRecords record);

    int insertSelective(TradeRechargeRecords record);

    List<TradeRechargeRecords> selectByExample(TradeRechargeRecordsExample example);

    TradeRechargeRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeRechargeRecords record, @Param("example") TradeRechargeRecordsExample example);

    int updateByExample(@Param("record") TradeRechargeRecords record, @Param("example") TradeRechargeRecordsExample example);

    int updateByPrimaryKeySelective(TradeRechargeRecords record);

    int updateByPrimaryKey(TradeRechargeRecords record);

	Long selectSumAmountByUserId(Long userid);
}