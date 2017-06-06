package com.tiancaibao.mapper.shop;

import com.tiancaibao.pojo.shop.ShopLottery;
import com.tiancaibao.pojo.shop.ShopLotteryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopLotteryMapper {
    long countByExample(ShopLotteryExample example);

    int deleteByExample(ShopLotteryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopLottery record);

    int insertSelective(ShopLottery record);

    List<ShopLottery> selectByExample(ShopLotteryExample example);

    ShopLottery selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopLottery record, @Param("example") ShopLotteryExample example);

    int updateByExample(@Param("record") ShopLottery record, @Param("example") ShopLotteryExample example);

    int updateByPrimaryKeySelective(ShopLottery record);

    int updateByPrimaryKey(ShopLottery record);
}