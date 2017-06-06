package com.tiancaibao.mapper.trade;

import com.tiancaibao.pojo.trade.TenderInvestHostingCollect;
import com.tiancaibao.pojo.trade.TenderInvestHostingCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenderInvestHostingCollectMapper {
	long countByExample(TenderInvestHostingCollectExample example);

	int deleteByExample(TenderInvestHostingCollectExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TenderInvestHostingCollect record);

	int insertSelective(TenderInvestHostingCollect record);

	List<TenderInvestHostingCollect> selectByExample(TenderInvestHostingCollectExample example);

	TenderInvestHostingCollect selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TenderInvestHostingCollect record,
			@Param("example") TenderInvestHostingCollectExample example);

	int updateByExample(@Param("record") TenderInvestHostingCollect record,
			@Param("example") TenderInvestHostingCollectExample example);

	int updateByPrimaryKeySelective(TenderInvestHostingCollect record);

	int updateByPrimaryKey(TenderInvestHostingCollect record);

	// 获取投资代收表的最大id
	long getMaxId();
}