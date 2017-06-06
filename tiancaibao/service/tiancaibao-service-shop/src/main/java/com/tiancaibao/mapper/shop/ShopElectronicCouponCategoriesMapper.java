package com.tiancaibao.mapper.shop;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.shop.ShopElectronicCouponCategories;
import com.tiancaibao.pojo.shop.ShopElectronicCouponCategoriesExample;

public interface ShopElectronicCouponCategoriesMapper {
    int countByExample(ShopElectronicCouponCategoriesExample example);

    int deleteByExample(ShopElectronicCouponCategoriesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopElectronicCouponCategories record);

    int insertSelective(ShopElectronicCouponCategories record);

    List<ShopElectronicCouponCategories> selectByExample(ShopElectronicCouponCategoriesExample example);

    ShopElectronicCouponCategories selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopElectronicCouponCategories record, @Param("example") ShopElectronicCouponCategoriesExample example);

    int updateByExample(@Param("record") ShopElectronicCouponCategories record, @Param("example") ShopElectronicCouponCategoriesExample example);

    int updateByPrimaryKeySelective(ShopElectronicCouponCategories record);

    int updateByPrimaryKey(ShopElectronicCouponCategories record);
}