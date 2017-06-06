package com.tiancaibao.mapper.shop;

import com.tiancaibao.pojo.shop.ShopLotteryBills;
import com.tiancaibao.pojo.shop.ShopLotteryBillsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopLotteryBillsMapper {
    long countByExample(ShopLotteryBillsExample example);

    int deleteByExample(ShopLotteryBillsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopLotteryBills record);

    int insertSelective(ShopLotteryBills record);

    List<ShopLotteryBills> selectByExample(ShopLotteryBillsExample example);

    ShopLotteryBills selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopLotteryBills record, @Param("example") ShopLotteryBillsExample example);

    int updateByExample(@Param("record") ShopLotteryBills record, @Param("example") ShopLotteryBillsExample example);

    int updateByPrimaryKeySelective(ShopLotteryBills record);

    int updateByPrimaryKey(ShopLotteryBills record);
}