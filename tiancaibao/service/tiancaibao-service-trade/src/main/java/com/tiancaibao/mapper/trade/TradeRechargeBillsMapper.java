package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeRechargeBills;
import com.tiancaibao.pojo.trade.TradeRechargeBillsExample;

public interface TradeRechargeBillsMapper {
    int countByExample(TradeRechargeBillsExample example);

    int deleteByExample(TradeRechargeBillsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeRechargeBills record);

    int insertSelective(TradeRechargeBills record);

    List<TradeRechargeBills> selectByExample(TradeRechargeBillsExample example);

    TradeRechargeBills selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeRechargeBills record, @Param("example") TradeRechargeBillsExample example);

    int updateByExample(@Param("record") TradeRechargeBills record, @Param("example") TradeRechargeBillsExample example);

    int updateByPrimaryKeySelective(TradeRechargeBills record);

    int updateByPrimaryKey(TradeRechargeBills record);

	void insertSelectiveReturnId(TradeRechargeBills record);

	Long sumAmount(TradeRechargeBillsExample example);
}