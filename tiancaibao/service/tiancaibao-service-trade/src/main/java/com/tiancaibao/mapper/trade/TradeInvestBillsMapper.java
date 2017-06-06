package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeInvestBills;
import com.tiancaibao.pojo.trade.TradeInvestBillsExample;

public interface TradeInvestBillsMapper {
	long countByExample(TradeInvestBillsExample example);

	int deleteByExample(TradeInvestBillsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TradeInvestBills record);

	int insertSelective(TradeInvestBills record);

	List<TradeInvestBills> selectByExample(TradeInvestBillsExample example);

	TradeInvestBills selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TradeInvestBills record,
			@Param("example") TradeInvestBillsExample example);

	int updateByExample(@Param("record") TradeInvestBills record, @Param("example") TradeInvestBillsExample example);

	int updateByPrimaryKeySelective(TradeInvestBills record);

	int updateByPrimaryKey(TradeInvestBills record);

	Long sumAoment(TradeInvestBills record);

}