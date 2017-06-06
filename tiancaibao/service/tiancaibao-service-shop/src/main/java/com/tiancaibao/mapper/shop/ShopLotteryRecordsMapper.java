package com.tiancaibao.mapper.shop;

import com.tiancaibao.pojo.shop.ShopLotteryRecords;
import com.tiancaibao.pojo.shop.ShopLotteryRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopLotteryRecordsMapper {
    long countByExample(ShopLotteryRecordsExample example);

    int deleteByExample(ShopLotteryRecordsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopLotteryRecords record);

    int insertSelective(ShopLotteryRecords record);

    List<ShopLotteryRecords> selectByExample(ShopLotteryRecordsExample example);

    ShopLotteryRecords selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopLotteryRecords record, @Param("example") ShopLotteryRecordsExample example);

    int updateByExample(@Param("record") ShopLotteryRecords record, @Param("example") ShopLotteryRecordsExample example);

    int updateByPrimaryKeySelective(ShopLotteryRecords record);

    int updateByPrimaryKey(ShopLotteryRecords record);
}