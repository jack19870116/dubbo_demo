package com.tiancaibao.mapper.shop;

import com.tiancaibao.pojo.shop.ShopInterestCashCoupons;
import com.tiancaibao.pojo.shop.ShopInterestCashCouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopInterestCashCouponsMapper {
    long countByExample(ShopInterestCashCouponsExample example);

    int deleteByExample(ShopInterestCashCouponsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopInterestCashCoupons record);

    int insertSelective(ShopInterestCashCoupons record);

    List<ShopInterestCashCoupons> selectByExampleWithBLOBs(ShopInterestCashCouponsExample example);

    List<ShopInterestCashCoupons> selectByExample(ShopInterestCashCouponsExample example);

    ShopInterestCashCoupons selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopInterestCashCoupons record, @Param("example") ShopInterestCashCouponsExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopInterestCashCoupons record, @Param("example") ShopInterestCashCouponsExample example);

    int updateByExample(@Param("record") ShopInterestCashCoupons record, @Param("example") ShopInterestCashCouponsExample example);

    int updateByPrimaryKeySelective(ShopInterestCashCoupons record);

    int updateByPrimaryKeyWithBLOBs(ShopInterestCashCoupons record);

    int updateByPrimaryKey(ShopInterestCashCoupons record);
}