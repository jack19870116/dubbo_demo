package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemTenderProduct;
import com.tiancaibao.pojo.system.SystemTenderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemTenderProductMapper {
	long countByExample(SystemTenderProductExample example);

	int deleteByExample(SystemTenderProductExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SystemTenderProduct record);

	int insertSelective(SystemTenderProduct record);

	List<SystemTenderProduct> selectByExampleWithBLOBs(SystemTenderProductExample example);

	List<SystemTenderProduct> selectByExample(SystemTenderProductExample example);

	SystemTenderProduct selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SystemTenderProduct record,
			@Param("example") SystemTenderProductExample example);

	int updateByExampleWithBLOBs(@Param("record") SystemTenderProduct record,
			@Param("example") SystemTenderProductExample example);

	int updateByExample(@Param("record") SystemTenderProduct record,
			@Param("example") SystemTenderProductExample example);

	int updateByPrimaryKeySelective(SystemTenderProduct record);

	int updateByPrimaryKeyWithBLOBs(SystemTenderProduct record);

	int updateByPrimaryKey(SystemTenderProduct record);

	/**
	 * 获取热门推荐top2
	 * 
	 * @return
	 */
	List<SystemTenderProduct> getHotTagList();

	/**
	 * 获取单投标列表展示页
	 * 
	 * @return
	 */
	List<SystemTenderProduct> tenderShowList();

	/**
	 * 获取新手特权
	 * 
	 * @return
	 */
	SystemTenderProduct getNovicePrivilege();

	/**
	 * 根据项目id更新项目剩余金额
	 * 
	 * @param record
	 * @return
	 */
	int updateSurplusAmountById(SystemTenderProduct record);
}