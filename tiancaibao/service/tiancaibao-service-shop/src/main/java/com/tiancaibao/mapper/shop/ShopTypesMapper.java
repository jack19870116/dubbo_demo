package com.tiancaibao.mapper.shop;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.shop.ShopTypes;
import com.tiancaibao.pojo.shop.ShopTypesExample;

public interface ShopTypesMapper {
    int countByExample(ShopTypesExample example);

    int deleteByExample(ShopTypesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopTypes record);

    int insertSelective(ShopTypes record);

    List<ShopTypes> selectByExample(ShopTypesExample example);

    ShopTypes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopTypes record, @Param("example") ShopTypesExample example);

    int updateByExample(@Param("record") ShopTypes record, @Param("example") ShopTypesExample example);

    int updateByPrimaryKeySelective(ShopTypes record);

    int updateByPrimaryKey(ShopTypes record);
}