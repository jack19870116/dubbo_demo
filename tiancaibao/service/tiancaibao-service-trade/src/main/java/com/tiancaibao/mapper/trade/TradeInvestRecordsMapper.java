package com.tiancaibao.mapper.trade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecordsExample;

public interface TradeInvestRecordsMapper {
    int countByExample(TradeInvestRecordsExample example);

    int deleteByExample(TradeInvestRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TradeInvestRecords record);

    int insertSelective(TradeInvestRecords record);

    List<TradeInvestRecords> selectByExample(TradeInvestRecordsExample example);

    TradeInvestRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeInvestRecords record, @Param("example") TradeInvestRecordsExample example);

    int updateByExample(@Param("record") TradeInvestRecords record, @Param("example") TradeInvestRecordsExample example);

    int updateByPrimaryKeySelective(TradeInvestRecords record);

    int updateByPrimaryKey(TradeInvestRecords record);

	Long selectSumInterestByUserIdAndStatusAndDaysGreaterThan(@Param("userid")long userid,@Param("status") String status,@Param("days") int days);

	Long selectSumAmountByUserIdAndCreatedAtBetweenNow(@Param("userid") Long userid,@Param("startdate") String startdate);

	Long selectSumAmountInvestRecordByProductSign(String product_sign);

	Long selectSumInterestFix();

	Long selectSumAmountInvestRecord();
	
	Long selectSumAmountInvestRecordByrecord(TradeInvestRecordsExample example);

	Long selectFinishFixSumInterestByUserId(Long userid);

	Long selectCurrentSumAmountNotWithDraw(@Param("userId") Long userId,@Param("time") String time);
 
	Long selectFixedIncomeByUserId(Long userid);
	
	Long selectSumAmountByUserIdAndCreatedAt(Long userId);
	
	

}