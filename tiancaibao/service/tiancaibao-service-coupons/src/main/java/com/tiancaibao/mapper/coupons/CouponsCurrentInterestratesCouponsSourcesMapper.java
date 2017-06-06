package com.tiancaibao.mapper.coupons;

import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCouponsSources;
import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCouponsSourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponsCurrentInterestratesCouponsSourcesMapper {
    long countByExample(CouponsCurrentInterestratesCouponsSourcesExample example);

    int deleteByExample(CouponsCurrentInterestratesCouponsSourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponsCurrentInterestratesCouponsSources record);

    int insertSelective(CouponsCurrentInterestratesCouponsSources record);

    List<CouponsCurrentInterestratesCouponsSources> selectByExample(CouponsCurrentInterestratesCouponsSourcesExample example);

    CouponsCurrentInterestratesCouponsSources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponsCurrentInterestratesCouponsSources record, @Param("example") CouponsCurrentInterestratesCouponsSourcesExample example);

    int updateByExample(@Param("record") CouponsCurrentInterestratesCouponsSources record, @Param("example") CouponsCurrentInterestratesCouponsSourcesExample example);

    int updateByPrimaryKeySelective(CouponsCurrentInterestratesCouponsSources record);

    int updateByPrimaryKey(CouponsCurrentInterestratesCouponsSources record);
}