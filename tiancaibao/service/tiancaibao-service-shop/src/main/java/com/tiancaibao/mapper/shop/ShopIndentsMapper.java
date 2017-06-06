package com.tiancaibao.mapper.shop;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.shop.ShopIndents;
import com.tiancaibao.pojo.shop.ShopIndentsExample;

public interface ShopIndentsMapper {
    int countByExample(ShopIndentsExample example);

    int deleteByExample(ShopIndentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopIndents record);

    int insertSelective(ShopIndents record);

    List<ShopIndents> selectByExample(ShopIndentsExample example);

    ShopIndents selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopIndents record, @Param("example") ShopIndentsExample example);

    int updateByExample(@Param("record") ShopIndents record, @Param("example") ShopIndentsExample example);

    int updateByPrimaryKeySelective(ShopIndents record);

    int updateByPrimaryKey(ShopIndents record);
}