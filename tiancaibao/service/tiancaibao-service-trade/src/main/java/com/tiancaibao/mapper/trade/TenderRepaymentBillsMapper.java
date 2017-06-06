package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderRepaymentBills;
import com.tiancaibao.pojo.trade.TenderRepaymentBillsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderRepaymentBillsMapper {
    long countByExample(TenderRepaymentBillsExample example);

    int deleteByExample(TenderRepaymentBillsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TenderRepaymentBills record);

    int insertSelective(TenderRepaymentBills record);

    List<TenderRepaymentBills> selectByExample(TenderRepaymentBillsExample example);

    TenderRepaymentBills selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TenderRepaymentBills record, @Param("example") TenderRepaymentBillsExample example);

    int updateByExample(@Param("record") TenderRepaymentBills record, @Param("example") TenderRepaymentBillsExample example);

    int updateByPrimaryKeySelective(TenderRepaymentBills record);

    int updateByPrimaryKey(TenderRepaymentBills record);
}