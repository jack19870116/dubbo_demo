package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderRepaymentHostingCollect;
import com.tiancaibao.pojo.trade.TenderRepaymentHostingCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderRepaymentHostingCollectMapper {
	long countByExample(TenderRepaymentHostingCollectExample example);

	int deleteByExample(TenderRepaymentHostingCollectExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TenderRepaymentHostingCollect record);

	int insertSelective(TenderRepaymentHostingCollect record);

	List<TenderRepaymentHostingCollect> selectByExample(TenderRepaymentHostingCollectExample example);

	TenderRepaymentHostingCollect selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TenderRepaymentHostingCollect record,
			@Param("example") TenderRepaymentHostingCollectExample example);

	int updateByExample(@Param("record") TenderRepaymentHostingCollect record,
			@Param("example") TenderRepaymentHostingCollectExample example);

	int updateByPrimaryKeySelective(TenderRepaymentHostingCollect record);

	int updateByPrimaryKey(TenderRepaymentHostingCollect record);

	/**
	 * 根据订单号获取代收记录
	 * 
	 * @param orderCode
	 * @return
	 */
	TenderRepaymentHostingCollect getTenderRepaymentHostingCollectByOrderCode(String orderCode);
}