package com.tiancaibao.service.integral;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.mapper.integral.IntegralRecordsMapper;
import com.tiancaibao.pojo.integral.IntegralRecords;
import com.tiancaibao.pojo.integral.IntegralRecordsExample;
import com.tiancaibao.service.interfaces.integral.IIntegralService;
import com.tiancaibao.utils.DateUtil;

@Service("integralService")
public class IntegralServiceImpl implements IIntegralService {

	@Resource
	private IntegralRecordsMapper integralRecordsMapper;

	/**
	 * 积分记录分页查询
	 */
	@Transactional
	@Override
	public List<IntegralRecords> selectIntegralRecordWithPageByUserId(Integer currPage, Integer pageSize, Long userId) {
		if (currPage == null) {
			currPage = 1;
		}
		if (pageSize == null) {
			pageSize = 20;
		}
		IntegralRecordsExample ire = new IntegralRecordsExample();
		ire.setPageNo(currPage);
		ire.setPageSize(pageSize);
		ire.createCriteria().andUserIdEqualTo(userId);
		return integralRecordsMapper.selectByExample(ire);
	}

	/**
	 * 根据用户ID和积分来源 返回一条记录
	 */
	@Override
	public IntegralRecords selectIntegralRecordByUserIdAndSourceAndCreateAtCurrentDayFirst(Long userId,
			Integer source) {
		IntegralRecordsExample ire = new IntegralRecordsExample();
		ire.createCriteria().andUserIdEqualTo(userId).andSourceEqualTo(source)
				.andCreatedAtBetween(DateUtil.getDayStartDate(), DateUtil.getDayEndDate());
		List<IntegralRecords> irlist = integralRecordsMapper.selectByExample(ire);
		if (irlist != null && irlist.size() > 0) {
			return irlist.get(0);
		}
		return null;
	}

	/**
	 *   增加积分记录
	 */
	@Transactional
	@Override
	public void insertIntegralRecord(Long userId, Integer integral, Integer source, Integer userCurrentIntegral,
			String remark) {
		IntegralRecords ir = new IntegralRecords();
		ir.setUserId(userId);
		ir.setIntegral(integral);
		ir.setSource(source.toString());
		ir.setUserCurrentIntegral(userCurrentIntegral);
		ir.setCreatedAt(new Date());
		ir.setUpdatedAt(new Date());
		ir.setRemark(remark);
		integralRecordsMapper.insertSelective(ir);
	}
	/**
	 *   从积分表中拿到已兑换积分
	 */
	@Override
	public Integer selectUseIntegralSum(Long userid) {
		return integralRecordsMapper.selectUseIntegralSum(userid);
	}

}
