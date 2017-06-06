package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeUserBbin;
import com.tiancaibao.pojo.trade.TradeUserBbinExample;

public interface TradeUserBbinMapper {
    int countByExample(TradeUserBbinExample example);

    int deleteByExample(TradeUserBbinExample example);

    int deleteByPrimaryKey(Short id);

    int insert(TradeUserBbin record);

    int insertSelective(TradeUserBbin record);

    List<TradeUserBbin> selectByExample(TradeUserBbinExample example);

    TradeUserBbin selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") TradeUserBbin record, @Param("example") TradeUserBbinExample example);

    int updateByExample(@Param("record") TradeUserBbin record, @Param("example") TradeUserBbinExample example);

    int updateByPrimaryKeySelective(TradeUserBbin record);

    int updateByPrimaryKey(TradeUserBbin record);
}