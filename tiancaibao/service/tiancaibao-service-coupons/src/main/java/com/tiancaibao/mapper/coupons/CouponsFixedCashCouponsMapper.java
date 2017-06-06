package com.tiancaibao.mapper.coupons;

import com.tiancaibao.pojo.coupons.CouponsFixedCashCoupons;
import com.tiancaibao.pojo.coupons.CouponsFixedCashCouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponsFixedCashCouponsMapper {
    long countByExample(CouponsFixedCashCouponsExample example);

    int deleteByExample(CouponsFixedCashCouponsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponsFixedCashCoupons record);

    int insertSelective(CouponsFixedCashCoupons record);

    List<CouponsFixedCashCoupons> selectByExample(CouponsFixedCashCouponsExample example);

    CouponsFixedCashCoupons selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponsFixedCashCoupons record, @Param("example") CouponsFixedCashCouponsExample example);

    int updateByExample(@Param("record") CouponsFixedCashCoupons record, @Param("example") CouponsFixedCashCouponsExample example);

    int updateByPrimaryKeySelective(CouponsFixedCashCoupons record);

    int updateByPrimaryKey(CouponsFixedCashCoupons record);

    /**
     * 获取指定用户的所有已使用的红包的总金额
     * @return
     */
	Long selectSumAmountByUserIdAndCreatedAtGreaterThanAndStatus(CouponsFixedCashCouponsExample example);
}