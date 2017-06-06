package com.tiancaibao.service.coupons;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.coupons.CouponsFixedInterestCouponsMapper;
import com.tiancaibao.pojo.coupons.CouponsFixedInterestCoupons;
import com.tiancaibao.pojo.coupons.CouponsFixedInterestCouponsExample;
import com.tiancaibao.service.interfaces.coupons.ICouponsFixedInterestCouponsService;

@Service("couponsFixedInterestCouponsService")
public class CouponsFixedInterestCouponsServiceImpl implements ICouponsFixedInterestCouponsService {
	@Resource
	private CouponsFixedInterestCouponsMapper couponsFixedInterestCouponsMapper;

	/**
	 * 获取加息券实体
	 */
	@Override
	public CouponsFixedInterestCoupons getCouponsFixedInterestCouponsById(long id) {
		return couponsFixedInterestCouponsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新加息券
	 */
	@Override
	public int updateaddFixedInterestStates(long id, String status) {
		CouponsFixedInterestCoupons record = new CouponsFixedInterestCoupons();
		record.setId(id);
		record.setStatus(status);
		return couponsFixedInterestCouponsMapper.updateByPrimaryKey(record);
	}

	@Override
	public CouponsFixedInterestCoupons getCouponsFixedInterestCouponsByIdAndUserId(Long id, Long user_id) {

		CouponsFixedInterestCouponsExample example = new CouponsFixedInterestCouponsExample();

		example.createCriteria().andIdEqualTo(id).andUserIdEqualTo(user_id);

		List<CouponsFixedInterestCoupons> selectByExample = couponsFixedInterestCouponsMapper.selectByExample(example);

		return selectByExample == null ? null : selectByExample.get(0);
	}

	@Override
	public int updataCouponsFixedInterestCouponsByByIdAndUserId(Long id, Long user_id, String status) {

		CouponsFixedInterestCouponsExample example = new CouponsFixedInterestCouponsExample();

		CouponsFixedInterestCoupons record = new CouponsFixedInterestCoupons();
		example.createCriteria().andIdEqualTo(id).andUserIdEqualTo(user_id);
		record.setStatus(status);
		record.setUsedAt(new Date());
		int updateByExample = couponsFixedInterestCouponsMapper.updateByExampleSelective(record, example);

		return updateByExample;
	}
}
