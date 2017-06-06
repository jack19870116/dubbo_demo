package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeTransferAmountHostingCollect;
import com.tiancaibao.pojo.trade.TradeTransferAmountHostingCollectExample;

public interface TransferAmountHostingCollectMapper {
    int countByExample(TradeTransferAmountHostingCollectExample example);

    int deleteByExample(TradeTransferAmountHostingCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeTransferAmountHostingCollect record);

    int insertSelective(TradeTransferAmountHostingCollect record);

    List<TradeTransferAmountHostingCollect> selectByExample(TradeTransferAmountHostingCollectExample example);

    TradeTransferAmountHostingCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransferAmountHostingCollect record, @Param("example") TradeTransferAmountHostingCollectExample example);

    int updateByExample(@Param("record") TradeTransferAmountHostingCollect record, @Param("example") TradeTransferAmountHostingCollectExample example);

    int updateByPrimaryKeySelective(TradeTransferAmountHostingCollect record);

    int updateByPrimaryKey(TradeTransferAmountHostingCollect record);
}