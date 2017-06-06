package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderInvestBills;
import com.tiancaibao.pojo.trade.TenderInvestBillsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderInvestBillsMapper {
	long countByExample(TenderInvestBillsExample example);

	int deleteByExample(TenderInvestBillsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TenderInvestBills record);

	int insertSelective(TenderInvestBills record);

	List<TenderInvestBills> selectByExample(TenderInvestBillsExample example);

	TenderInvestBills selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TenderInvestBills record,
			@Param("example") TenderInvestBillsExample example);

	int updateByExample(@Param("record") TenderInvestBills record, @Param("example") TenderInvestBillsExample example);

	int updateByPrimaryKeySelective(TenderInvestBills record);

	int updateByPrimaryKey(TenderInvestBills record);

	// 获取最大id
	long getMaxId();

	// 跟据订单号获取投资账单
	TenderInvestBills getTenderInvestBillsByOrderNum(String orderCode);

	// 获取投资账单记录
	List<TenderInvestBills> getTenderInvestBillsByUsersId(Long userId);
}