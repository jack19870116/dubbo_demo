package com.tiancaibao.mapper.shop;

import com.tiancaibao.pojo.shop.ShopActivitys;
import com.tiancaibao.pojo.shop.ShopActivitysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopActivitysMapper {
    long countByExample(ShopActivitysExample example);

    int deleteByExample(ShopActivitysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopActivitys record);

    int insertSelective(ShopActivitys record);

    List<ShopActivitys> selectByExample(ShopActivitysExample example);

    ShopActivitys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopActivitys record, @Param("example") ShopActivitysExample example);

    int updateByExample(@Param("record") ShopActivitys record, @Param("example") ShopActivitysExample example);

    int updateByPrimaryKeySelective(ShopActivitys record);

    int updateByPrimaryKey(ShopActivitys record);
}