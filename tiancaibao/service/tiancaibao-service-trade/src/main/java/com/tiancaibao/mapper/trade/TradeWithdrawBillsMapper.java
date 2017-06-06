package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeWithdrawBills;
import com.tiancaibao.pojo.trade.TradeWithdrawBillsExample;

public interface TradeWithdrawBillsMapper {
    int countByExample(TradeWithdrawBillsExample example);

    int deleteByExample(TradeWithdrawBillsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeWithdrawBills record);

    int insertSelective(TradeWithdrawBills record);

    List<TradeWithdrawBills> selectByExample(TradeWithdrawBillsExample example);

    TradeWithdrawBills selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeWithdrawBills record, @Param("example") TradeWithdrawBillsExample example);

    int updateByExample(@Param("record")  TradeWithdrawBills record, @Param("example") TradeWithdrawBillsExample example);

    int updateByPrimaryKeySelective(TradeWithdrawBills record);

    int updateByPrimaryKey(TradeWithdrawBills record);

	Long selectSumAamountByUserIdAndStatusAndCurrentCycle(@Param("userid") Long userid,@Param("status")  String status,@Param("current_cycle") String current_cycle);
	
	//============= 二  二 二 二 二 二 ===================//
	Long selectSystemWithDrawSumAmountCurrentDay();

	Long insertSelectiveReturnId(TradeWithdrawBills withdrawBills);
}