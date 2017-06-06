package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeTransferRecord;
import com.tiancaibao.pojo.trade.TradeTransferRecordExample;

public interface TradeTransferRecordMapper {
    int countByExample(TradeTransferRecordExample example);

    int deleteByExample(TradeTransferRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeTransferRecord record);

    int insertSelective(TradeTransferRecord record);

    List<TradeTransferRecord> selectByExample(TradeTransferRecordExample example);

    TradeTransferRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransferRecord record, @Param("example") TradeTransferRecordExample example);

    int updateByExample(@Param("record") TradeTransferRecord record, @Param("example") TradeTransferRecordExample example);

    int updateByPrimaryKeySelective(TradeTransferRecord record);

    int updateByPrimaryKey(TradeTransferRecord record);
}