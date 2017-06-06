package com.tiancaibao.mapper.shop;

import com.tiancaibao.pojo.shop.Shops;
import com.tiancaibao.pojo.shop.ShopsExample;
import com.tiancaibao.pojo.shop.ShopsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopsMapper {
    int countByExample(ShopsExample example);

    int deleteByExample(ShopsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopsWithBLOBs record);

    int insertSelective(ShopsWithBLOBs record);

    List<ShopsWithBLOBs> selectByExampleWithBLOBs(ShopsExample example);

    List<Shops> selectByExample(ShopsExample example);

    ShopsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopsWithBLOBs record, @Param("example") ShopsExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopsWithBLOBs record, @Param("example") ShopsExample example);

    int updateByExample(@Param("record") Shops record, @Param("example") ShopsExample example);

    int updateByPrimaryKeySelective(ShopsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShopsWithBLOBs record);

    int updateByPrimaryKey(Shops record);
}