package com.tiancaibao.mapper.coupons;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.coupons.CouponsCurrentCashBenefits;
import com.tiancaibao.pojo.coupons.CouponsCurrentCashBenefitsExample;

public interface CouponsCurrentCashBenefitsMapper {
    long countByExample(CouponsCurrentCashBenefitsExample example);

    int deleteByExample(CouponsCurrentCashBenefitsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponsCurrentCashBenefits record);

    int insertSelective(CouponsCurrentCashBenefits record);

    List<CouponsCurrentCashBenefits> selectByExample(CouponsCurrentCashBenefitsExample example);

    CouponsCurrentCashBenefits selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponsCurrentCashBenefits record, @Param("example") CouponsCurrentCashBenefitsExample example);

    int updateByExample(@Param("record") CouponsCurrentCashBenefits record, @Param("example") CouponsCurrentCashBenefitsExample example);

    int updateByPrimaryKeySelective(CouponsCurrentCashBenefits record);

    int updateByPrimaryKey(CouponsCurrentCashBenefits record);
    
    Float sumValue(CouponsCurrentCashBenefitsExample example);
}