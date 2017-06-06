package com.tiancaibao.mapper.coupons;

import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCoupons;
import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponsCurrentInterestratesCouponsMapper {
    long countByExample(CouponsCurrentInterestratesCouponsExample example);

    int deleteByExample(CouponsCurrentInterestratesCouponsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponsCurrentInterestratesCoupons record);

    int insertSelective(CouponsCurrentInterestratesCoupons record);

    List<CouponsCurrentInterestratesCoupons> selectByExample(CouponsCurrentInterestratesCouponsExample example);

    CouponsCurrentInterestratesCoupons selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponsCurrentInterestratesCoupons record, @Param("example") CouponsCurrentInterestratesCouponsExample example);

    int updateByExample(@Param("record") CouponsCurrentInterestratesCoupons record, @Param("example") CouponsCurrentInterestratesCouponsExample example);

    int updateByPrimaryKeySelective(CouponsCurrentInterestratesCoupons record);

    int updateByPrimaryKey(CouponsCurrentInterestratesCoupons record);
}