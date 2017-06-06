package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeTransferAmountBills;
import com.tiancaibao.pojo.trade.TradeTransferAmountBillsExample;

public interface TradeTransferAmountBillsMapper {
    int countByExample(TradeTransferAmountBillsExample example);

    int deleteByExample(TradeTransferAmountBillsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeTransferAmountBills record);

    int insertSelective(TradeTransferAmountBills record);

    List<TradeTransferAmountBills> selectByExample(TradeTransferAmountBillsExample example);

    TradeTransferAmountBills selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransferAmountBills record, @Param("example") TradeTransferAmountBillsExample example);

    int updateByExample(@Param("record") TradeTransferAmountBills record, @Param("example") TradeTransferAmountBillsExample example);

    int updateByPrimaryKeySelective(TradeTransferAmountBills record);

    int updateByPrimaryKey(TradeTransferAmountBills record);
}