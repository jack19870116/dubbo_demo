package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeInvestHostingCollect;
import com.tiancaibao.pojo.trade.TradeInvestHostingCollectExample;

public interface TradeInvestHostingCollectMapper {
    int countByExample(TradeInvestHostingCollectExample example);

    int deleteByExample(TradeInvestHostingCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeInvestHostingCollect record);

    int insertSelective(TradeInvestHostingCollect record);

    List<TradeInvestHostingCollect> selectByExample(TradeInvestHostingCollectExample example);

    TradeInvestHostingCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeInvestHostingCollect record, @Param("example") TradeInvestHostingCollectExample example);

    int updateByExample(@Param("record") TradeInvestHostingCollect record, @Param("example") TradeInvestHostingCollectExample example);

    int updateByPrimaryKeySelective(TradeInvestHostingCollect record);

    int updateByPrimaryKey(TradeInvestHostingCollect record);
}