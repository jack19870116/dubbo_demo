package com.tiancaibao.mapper.pay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.pay.PayRegions;
import com.tiancaibao.pojo.pay.PayRegionsExample;

public interface PayRegionsMapper {
    int countByExample(PayRegionsExample example);

    int deleteByExample(PayRegionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayRegions record);

    int insertSelective(PayRegions record);

    List<PayRegions> selectByExample(PayRegionsExample example);

    PayRegions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayRegions record, @Param("example") PayRegionsExample example);

    int updateByExample(@Param("record") PayRegions record, @Param("example") PayRegionsExample example);

    int updateByPrimaryKeySelective(PayRegions record);

    int updateByPrimaryKey(PayRegions record);
}