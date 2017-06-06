package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderRepaymentHostingPay;
import com.tiancaibao.pojo.trade.TenderRepaymentHostingPayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderRepaymentHostingPayMapper {
	long countByExample(TenderRepaymentHostingPayExample example);

	int deleteByExample(TenderRepaymentHostingPayExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TenderRepaymentHostingPay record);

	int insertSelective(TenderRepaymentHostingPay record);

	List<TenderRepaymentHostingPay> selectByExample(TenderRepaymentHostingPayExample example);

	TenderRepaymentHostingPay selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TenderRepaymentHostingPay record,
			@Param("example") TenderRepaymentHostingPayExample example);

	int updateByExample(@Param("record") TenderRepaymentHostingPay record,
			@Param("example") TenderRepaymentHostingPayExample example);

	int updateByPrimaryKeySelective(TenderRepaymentHostingPay record);

	int updateByPrimaryKey(TenderRepaymentHostingPay record);

	/**
	 * 根据订单号获取代付实体
	 * 
	 * @param orderCode
	 * @return
	 */
	TenderRepaymentHostingPay getTenderRepaymentHostingPayByOrderCode(String orderCode);

	/**
	 * 获取代付表的最大id
	 * 
	 * @return
	 */
	int getMaxId();
}