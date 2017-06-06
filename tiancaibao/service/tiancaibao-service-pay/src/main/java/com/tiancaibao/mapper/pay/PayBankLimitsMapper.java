package com.tiancaibao.mapper.pay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.pay.PayBankLimits;
import com.tiancaibao.pojo.pay.PayBankLimitsExample;

public interface PayBankLimitsMapper {
    int countByExample(PayBankLimitsExample example);

    int deleteByExample(PayBankLimitsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayBankLimits record);

    int insertSelective(PayBankLimits record);

    List<PayBankLimits> selectByExample(PayBankLimitsExample example);

    PayBankLimits selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayBankLimits record, @Param("example") PayBankLimitsExample example);

    int updateByExample(@Param("record") PayBankLimits record, @Param("example") PayBankLimitsExample example);

    int updateByPrimaryKeySelective(PayBankLimits record);

    int updateByPrimaryKey(PayBankLimits record);
}