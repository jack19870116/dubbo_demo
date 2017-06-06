package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeWithdrawRecords;
import com.tiancaibao.pojo.trade.TradeWithdrawRecordsExample;

public interface TradeWithdrawRecordsMapper {
    int countByExample(TradeWithdrawRecordsExample example);

    int deleteByExample(TradeWithdrawRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeWithdrawRecords record);

    int insertSelective(TradeWithdrawRecords record);

    List<TradeWithdrawRecords> selectByExample(TradeWithdrawRecordsExample example);

    TradeWithdrawRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeWithdrawRecords record, @Param("example") TradeWithdrawRecordsExample example);

    int updateByExample(@Param("record") TradeWithdrawRecords record, @Param("example") TradeWithdrawRecordsExample example);

    int updateByPrimaryKeySelective(TradeWithdrawRecords record);

    int updateByPrimaryKey(TradeWithdrawRecords record);

	Long selectSumAmountByUserId(Long userid);

	Long selectSumAmountFromWithdrawRecode();
}