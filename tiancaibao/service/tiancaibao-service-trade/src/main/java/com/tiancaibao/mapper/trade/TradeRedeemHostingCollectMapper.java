package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeRedeemHostingCollect;
import com.tiancaibao.pojo.trade.TradeRedeemHostingCollectExample;

public interface TradeRedeemHostingCollectMapper {
    int countByExample(TradeRedeemHostingCollectExample example);

    int deleteByExample(TradeRedeemHostingCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeRedeemHostingCollect record);

    int insertSelective(TradeRedeemHostingCollect record);

    List<TradeRedeemHostingCollect> selectByExample(TradeRedeemHostingCollectExample example);

    TradeRedeemHostingCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeRedeemHostingCollect record, @Param("example") TradeRedeemHostingCollectExample example);

    int updateByExample(@Param("record") TradeRedeemHostingCollect record, @Param("example") TradeRedeemHostingCollectExample example);

    int updateByPrimaryKeySelective(TradeRedeemHostingCollect record);

    int updateByPrimaryKey(TradeRedeemHostingCollect record);
}