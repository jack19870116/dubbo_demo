package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeTransferAmountHostingPay;
import com.tiancaibao.pojo.trade.TradeTransferAmountHostingPayExample;

public interface TransferAmountHostingPayMapper {
    int countByExample(TradeTransferAmountHostingPayExample example);

    int deleteByExample(TradeTransferAmountHostingPayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeTransferAmountHostingPay record);

    int insertSelective(TradeTransferAmountHostingPay record);

    List<TradeTransferAmountHostingPay> selectByExample(TradeTransferAmountHostingPayExample example);

    TradeTransferAmountHostingPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransferAmountHostingPay record, @Param("example") TradeTransferAmountHostingPayExample example);

    int updateByExample(@Param("record") TradeTransferAmountHostingPay record, @Param("example") TradeTransferAmountHostingPayExample example);

    int updateByPrimaryKeySelective(TradeTransferAmountHostingPay record);

    int updateByPrimaryKey(TradeTransferAmountHostingPay record);
}