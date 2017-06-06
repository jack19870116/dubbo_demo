package com.tiancaibao.mapper.shop;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.shop.ShopElectronicCoupons;
import com.tiancaibao.pojo.shop.ShopElectronicCouponsExample;

public interface ShopElectronicCouponsMapper {
    int countByExample(ShopElectronicCouponsExample example);

    int deleteByExample(ShopElectronicCouponsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopElectronicCoupons record);

    int insertSelective(ShopElectronicCoupons record);

    List<ShopElectronicCoupons> selectByExample(ShopElectronicCouponsExample example);

    ShopElectronicCoupons selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopElectronicCoupons record, @Param("example") ShopElectronicCouponsExample example);

    int updateByExample(@Param("record") ShopElectronicCoupons record, @Param("example") ShopElectronicCouponsExample example);

    int updateByPrimaryKeySelective(ShopElectronicCoupons record);

    int updateByPrimaryKey(ShopElectronicCoupons record);
}