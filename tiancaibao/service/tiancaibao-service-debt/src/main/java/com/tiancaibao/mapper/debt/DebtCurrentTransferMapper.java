package com.tiancaibao.mapper.debt;

import com.tiancaibao.pojo.debt.DebtCurrentTransfer;
import com.tiancaibao.pojo.debt.DebtCurrentTransferExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DebtCurrentTransferMapper {
    long countByExample(DebtCurrentTransferExample example);

    int deleteByExample(DebtCurrentTransferExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DebtCurrentTransfer record);

    int insertSelective(DebtCurrentTransfer record);

    List<DebtCurrentTransfer> selectByExample(DebtCurrentTransferExample example);

    DebtCurrentTransfer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DebtCurrentTransfer record, @Param("example") DebtCurrentTransferExample example);

    int updateByExample(@Param("record") DebtCurrentTransfer record, @Param("example") DebtCurrentTransferExample example);

    int updateByPrimaryKeySelective(DebtCurrentTransfer record);

    int updateByPrimaryKey(DebtCurrentTransfer record);
    
	// 债券的匹配
	List<DebtCurrentTransfer> selectTransferMatch(Map<String, Object> params);

	// 添加记录成功后获取的id
	long getLastInsertId();
}