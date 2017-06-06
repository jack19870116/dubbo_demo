package com.tiancaibao.mapper.shop;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.shop.ShopRegions;
import com.tiancaibao.pojo.shop.ShopRegionsExample;

public interface ShopRegionsMapper {
    int countByExample(ShopRegionsExample example);

    int deleteByExample(ShopRegionsExample example);

    int deleteByPrimaryKey(Short regionId);

    int insert(ShopRegions record);

    int insertSelective(ShopRegions record);

    List<ShopRegions> selectByExample(ShopRegionsExample example);

    ShopRegions selectByPrimaryKey(Short regionId);

    int updateByExampleSelective(@Param("record") ShopRegions record, @Param("example") ShopRegionsExample example);

    int updateByExample(@Param("record") ShopRegions record, @Param("example") ShopRegionsExample example);

    int updateByPrimaryKeySelective(ShopRegions record);

    int updateByPrimaryKey(ShopRegions record);
}