package com.tiancaibao.mapper.debt;

import com.tiancaibao.pojo.debt.DebtCurrentReceive;
import com.tiancaibao.pojo.debt.DebtCurrentReceiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DebtCurrentReceiveMapper {
	long countByExample(DebtCurrentReceiveExample example);

	int deleteByExample(DebtCurrentReceiveExample example);

	int deleteByPrimaryKey(Long id);

	int insert(DebtCurrentReceive record);

	int insertSelective(DebtCurrentReceive record);

	List<DebtCurrentReceive> selectByExample(DebtCurrentReceiveExample example);

	DebtCurrentReceive selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") DebtCurrentReceive record,
			@Param("example") DebtCurrentReceiveExample example);

	int updateByExample(@Param("record") DebtCurrentReceive record,
			@Param("example") DebtCurrentReceiveExample example);

	int updateByPrimaryKeySelective(DebtCurrentReceive record);

	int updateByPrimaryKey(DebtCurrentReceive record);

	long getLastInsertId();
}