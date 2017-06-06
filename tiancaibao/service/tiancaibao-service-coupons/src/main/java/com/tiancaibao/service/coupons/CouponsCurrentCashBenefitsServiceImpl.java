package com.tiancaibao.service.coupons;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.coupons.CouponsCurrentCashBenefitsMapper;
import com.tiancaibao.pojo.coupons.CouponsCurrentCashBenefitsExample;
import com.tiancaibao.service.interfaces.coupons.ICouponsCurrentCashBenefitsService;

@Service("couponsCurrentCashBenefitsService")
public class CouponsCurrentCashBenefitsServiceImpl implements ICouponsCurrentCashBenefitsService {

	@Resource
	CouponsCurrentCashBenefitsMapper couponsCurrentCashBenefitsMapper;

	private static Logger log = LoggerFactory.getLogger(CouponsCurrentCashBenefitsServiceImpl.class);
	
	@Override
	public Float sumValueByuserID(Long userId, String status) {

		CouponsCurrentCashBenefitsExample example = new CouponsCurrentCashBenefitsExample();
		example.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo(status);
		Float amount = couponsCurrentCashBenefitsMapper.sumValue(example);
		log.info("使用userId=" + userId + "查询couponsCurrentCashBenefits现金券总额返回值是:" + amount +"; \n");
		return amount;

	}

}
