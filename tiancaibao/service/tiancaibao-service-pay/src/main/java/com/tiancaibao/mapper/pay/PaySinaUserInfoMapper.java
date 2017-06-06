package com.tiancaibao.mapper.pay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.pay.PaySinaUserInfo;

import com.tiancaibao.pojo.pay.PaySinaUserInfoExample;



public interface PaySinaUserInfoMapper {
    int countByExample(PaySinaUserInfoExample example);

    int deleteByExample(PaySinaUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaySinaUserInfo record);

    int insertSelective(PaySinaUserInfo record);

    List<PaySinaUserInfo> selectByExample(PaySinaUserInfoExample example);

    PaySinaUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaySinaUserInfo record, @Param("example") PaySinaUserInfoExample example);

    int updateByExample(@Param("record") PaySinaUserInfo record, @Param("example") PaySinaUserInfoExample example);

    int updateByPrimaryKeySelective(PaySinaUserInfo record);

    int updateByPrimaryKey(PaySinaUserInfo record);
}