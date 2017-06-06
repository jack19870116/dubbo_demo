package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeRedeemBills;
import com.tiancaibao.pojo.trade.TradeRedeemBillsExample;

public interface TradeRedeemBillsMapper {
	int countByExample(TradeRedeemBillsExample example);

	int deleteByExample(TradeRedeemBillsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TradeRedeemBills record);

	int insertSelective(TradeRedeemBills record);

	List<TradeRedeemBills> selectByExample(TradeRedeemBillsExample example);

	TradeRedeemBills selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TradeRedeemBills record,
			@Param("example") TradeRedeemBillsExample example);

	int updateByExample(@Param("record") TradeRedeemBills record, @Param("example") TradeRedeemBillsExample example);

	int updateByPrimaryKeySelective(TradeRedeemBills record);

	int updateByPrimaryKey(TradeRedeemBills record);

	Long insertSelectiveReturnId(TradeRedeemBills record);

	Long selectSumAmont(TradeRedeemBillsExample example);

}