package com.tiancaibao.mapper.pay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.pay.PayBankcards;
import com.tiancaibao.pojo.pay.PayBankcardsExample;

public interface PayBankcardsMapper {
    int countByExample(PayBankcardsExample example);

    int deleteByExample(PayBankcardsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayBankcards record);

    int insertSelective(PayBankcards record);

    List<PayBankcards> selectByExample(PayBankcardsExample example);

    PayBankcards selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayBankcards record, @Param("example") PayBankcardsExample example);

    int updateByExample(@Param("record") PayBankcards record, @Param("example") PayBankcardsExample example);

    int updateByPrimaryKeySelective(PayBankcards record);

    int updateByPrimaryKey(PayBankcards record);
}