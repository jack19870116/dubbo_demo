package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeRedeemRecords;
import com.tiancaibao.pojo.trade.TradeRedeemRecordsExample;

public interface TradeRedeemRecordsMapper {
	int countByExample(TradeRedeemRecordsExample example);

	int deleteByExample(TradeRedeemRecordsExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TradeRedeemRecords record);

	int insertSelective(TradeRedeemRecords record);

	List<TradeRedeemRecords> selectByExample(TradeRedeemRecordsExample example);

	TradeRedeemRecords selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TradeRedeemRecords record,
			@Param("example") TradeRedeemRecordsExample example);

	int updateByExample(@Param("record") TradeRedeemRecords record,
			@Param("example") TradeRedeemRecordsExample example);

	int updateByPrimaryKeySelective(TradeRedeemRecords record);

	int updateByPrimaryKey(TradeRedeemRecords record);

	Long selectSumAmountByUserIdAndCreatedAtBetweenNow(@Param("userid") Long userid,
			@Param("startdate") String startdate);

	Long selectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM(@Param("userid") Long userid,
			@Param("days") int days, @Param("yM") String yM);

	Long selectSumAmountOfRedeemRecordsByUserId(@Param("userid") Long userid);
	
	Long selectSumAmountOfRedeemRecordsByUserIdAndcreated_at(@Param("userid") Long userid);

	Long selectSameMonth(TradeRedeemRecordsExample example);
	
	
	
	
	
	
}