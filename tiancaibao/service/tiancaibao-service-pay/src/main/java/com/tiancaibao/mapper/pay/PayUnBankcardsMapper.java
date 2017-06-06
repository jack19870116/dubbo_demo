package com.tiancaibao.mapper.pay;

import com.tiancaibao.pojo.pay.PayUnBankcards;
import com.tiancaibao.pojo.pay.PayUnBankcardsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayUnBankcardsMapper {
    long countByExample(PayUnBankcardsExample example);

    int deleteByExample(PayUnBankcardsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayUnBankcards record);

    int insertSelective(PayUnBankcards record);

    List<PayUnBankcards> selectByExample(PayUnBankcardsExample example);

    PayUnBankcards selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayUnBankcards record, @Param("example") PayUnBankcardsExample example);

    int updateByExample(@Param("record") PayUnBankcards record, @Param("example") PayUnBankcardsExample example);

    int updateByPrimaryKeySelective(PayUnBankcards record);

    int updateByPrimaryKey(PayUnBankcards record);
}