package com.tiancaibao.mapper.shop;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.shop.ShopDangTickets;
import com.tiancaibao.pojo.shop.ShopDangTicketsExample;

public interface ShopDangTicketsMapper {
    int countByExample(ShopDangTicketsExample example);

    int deleteByExample(ShopDangTicketsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopDangTickets record);

    int insertSelective(ShopDangTickets record);

    List<ShopDangTickets> selectByExample(ShopDangTicketsExample example);

    ShopDangTickets selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopDangTickets record, @Param("example") ShopDangTicketsExample example);

    int updateByExample(@Param("record") ShopDangTickets record, @Param("example") ShopDangTicketsExample example);

    int updateByPrimaryKeySelective(ShopDangTickets record);

    int updateByPrimaryKey(ShopDangTickets record);
}