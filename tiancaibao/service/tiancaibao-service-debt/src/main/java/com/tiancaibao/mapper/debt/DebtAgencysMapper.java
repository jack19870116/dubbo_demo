package com.tiancaibao.mapper.debt;

import com.tiancaibao.pojo.debt.DebtAgencys;
import com.tiancaibao.pojo.debt.DebtAgencysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DebtAgencysMapper {
    long countByExample(DebtAgencysExample example);

    int deleteByExample(DebtAgencysExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DebtAgencys record);

    int insertSelective(DebtAgencys record);

    List<DebtAgencys> selectByExampleWithBLOBs(DebtAgencysExample example);

    List<DebtAgencys> selectByExample(DebtAgencysExample example);

    DebtAgencys selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DebtAgencys record, @Param("example") DebtAgencysExample example);

    int updateByExampleWithBLOBs(@Param("record") DebtAgencys record, @Param("example") DebtAgencysExample example);

    int updateByExample(@Param("record") DebtAgencys record, @Param("example") DebtAgencysExample example);

    int updateByPrimaryKeySelective(DebtAgencys record);

    int updateByPrimaryKeyWithBLOBs(DebtAgencys record);

    int updateByPrimaryKey(DebtAgencys record);
}