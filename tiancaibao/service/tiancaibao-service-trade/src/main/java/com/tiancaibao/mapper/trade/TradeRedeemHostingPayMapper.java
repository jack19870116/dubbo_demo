package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeRedeemHostingPay;
import com.tiancaibao.pojo.trade.TradeRedeemHostingPayExample;

public interface TradeRedeemHostingPayMapper {
    int countByExample(TradeRedeemHostingPayExample example);

    int deleteByExample(TradeRedeemHostingPayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeRedeemHostingPay record);

    int insertSelective(TradeRedeemHostingPay record);

    List<TradeRedeemHostingPay> selectByExample(TradeRedeemHostingPayExample example);

    TradeRedeemHostingPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeRedeemHostingPay record, @Param("example") TradeRedeemHostingPayExample example);

    int updateByExample(@Param("record") TradeRedeemHostingPay record, @Param("example") TradeRedeemHostingPayExample example);

    int updateByPrimaryKeySelective(TradeRedeemHostingPay record);

    int updateByPrimaryKey(TradeRedeemHostingPay record);
}