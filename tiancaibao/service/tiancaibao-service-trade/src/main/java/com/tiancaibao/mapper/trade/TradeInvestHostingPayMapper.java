package com.tiancaibao.mapper.trade;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeInvestHostingPay;
import com.tiancaibao.pojo.trade.TradeInvestHostingPayExample;

public interface TradeInvestHostingPayMapper {
    int countByExample(TradeInvestHostingPayExample example);

    int deleteByExample(TradeInvestHostingPayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeInvestHostingPay record);

    int insertSelective(TradeInvestHostingPay record);

    List<TradeInvestHostingPay> selectByExample(TradeInvestHostingPayExample example);

    TradeInvestHostingPay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeInvestHostingPay record, @Param("example") TradeInvestHostingPayExample example);

    int updateByExample(@Param("record") TradeInvestHostingPay record, @Param("example") TradeInvestHostingPayExample example);

    int updateByPrimaryKeySelective(TradeInvestHostingPay record);

    int updateByPrimaryKey(TradeInvestHostingPay record);
}