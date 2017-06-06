package com.tiancaibao.mapper.coupons;

import com.tiancaibao.pojo.coupons.CouponsFixedCashCouponsSources;
import com.tiancaibao.pojo.coupons.CouponsFixedCashCouponsSourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponsFixedCashCouponsSourcesMapper {
    long countByExample(CouponsFixedCashCouponsSourcesExample example);

    int deleteByExample(CouponsFixedCashCouponsSourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponsFixedCashCouponsSources record);

    int insertSelective(CouponsFixedCashCouponsSources record);

    List<CouponsFixedCashCouponsSources> selectByExample(CouponsFixedCashCouponsSourcesExample example);

    CouponsFixedCashCouponsSources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponsFixedCashCouponsSources record, @Param("example") CouponsFixedCashCouponsSourcesExample example);

    int updateByExample(@Param("record") CouponsFixedCashCouponsSources record, @Param("example") CouponsFixedCashCouponsSourcesExample example);

    int updateByPrimaryKeySelective(CouponsFixedCashCouponsSources record);

    int updateByPrimaryKey(CouponsFixedCashCouponsSources record);
}