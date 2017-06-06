package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeYibao20160107s;
import com.tiancaibao.pojo.trade.TradeYibao20160107sExample;

public interface TradeYibao20160107sMapper {
    long countByExample(TradeYibao20160107sExample example);

    int deleteByExample(TradeYibao20160107sExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeYibao20160107s record);

    int insertSelective(TradeYibao20160107s record);

    List<TradeYibao20160107s> selectByExample(TradeYibao20160107sExample example);

    TradeYibao20160107s selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeYibao20160107s record, @Param("example") TradeYibao20160107sExample example);

    int updateByExample(@Param("record") TradeYibao20160107s record, @Param("example") TradeYibao20160107sExample example);

    int updateByPrimaryKeySelective(TradeYibao20160107s record);

    int updateByPrimaryKey(TradeYibao20160107s record);
    
    Long selectSumAmountByUserId(Long  userId);
}