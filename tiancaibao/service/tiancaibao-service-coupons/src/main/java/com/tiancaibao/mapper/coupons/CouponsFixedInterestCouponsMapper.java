package com.tiancaibao.mapper.coupons;

import com.tiancaibao.pojo.coupons.CouponsFixedInterestCoupons;
import com.tiancaibao.pojo.coupons.CouponsFixedInterestCouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponsFixedInterestCouponsMapper {
    int countByExample(CouponsFixedInterestCouponsExample example);

    int deleteByExample(CouponsFixedInterestCouponsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponsFixedInterestCoupons record);

    int insertSelective(CouponsFixedInterestCoupons record);

    List<CouponsFixedInterestCoupons> selectByExample(CouponsFixedInterestCouponsExample example);

    CouponsFixedInterestCoupons selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponsFixedInterestCoupons record, @Param("example") CouponsFixedInterestCouponsExample example);

    int updateByExample(@Param("record") CouponsFixedInterestCoupons record, @Param("example") CouponsFixedInterestCouponsExample example);

    int updateByPrimaryKeySelective(CouponsFixedInterestCoupons record);

    int updateByPrimaryKey(CouponsFixedInterestCoupons record);
}