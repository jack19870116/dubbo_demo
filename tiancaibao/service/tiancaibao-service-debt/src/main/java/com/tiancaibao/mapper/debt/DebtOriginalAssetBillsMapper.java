package com.tiancaibao.mapper.debt;

import com.tiancaibao.pojo.debt.DebtOriginalAssetBills;
import com.tiancaibao.pojo.debt.DebtOriginalAssetBillsExample;
import com.tiancaibao.pojo.debt.DebtOriginalAssetBillsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DebtOriginalAssetBillsMapper {
    long countByExample(DebtOriginalAssetBillsExample example);

    int deleteByExample(DebtOriginalAssetBillsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DebtOriginalAssetBillsWithBLOBs record);

    int insertSelective(DebtOriginalAssetBillsWithBLOBs record);

    List<DebtOriginalAssetBillsWithBLOBs> selectByExampleWithBLOBs(DebtOriginalAssetBillsExample example);

    List<DebtOriginalAssetBills> selectByExample(DebtOriginalAssetBillsExample example);

    DebtOriginalAssetBillsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DebtOriginalAssetBillsWithBLOBs record, @Param("example") DebtOriginalAssetBillsExample example);

    int updateByExampleWithBLOBs(@Param("record") DebtOriginalAssetBillsWithBLOBs record, @Param("example") DebtOriginalAssetBillsExample example);

    int updateByExample(@Param("record") DebtOriginalAssetBills record, @Param("example") DebtOriginalAssetBillsExample example);

    int updateByPrimaryKeySelective(DebtOriginalAssetBillsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DebtOriginalAssetBillsWithBLOBs record);

    int updateByPrimaryKey(DebtOriginalAssetBills record);
}