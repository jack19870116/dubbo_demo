/*package com.tiancaibao.service.impl.activity;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.mapper.CashCouponsMapper;
import com.tiancaibao.pojo.CashCoupons;
import com.tiancaibao.utils.DateUtil;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ActivityServiceImplTest {
	@Resource
	private CashCouponsMapper cashCouponsMapper;

	@Test
	public void testIsValidActive() {
		CashCoupons cc = new CashCoupons();
		cc.setUserId(111L);
		cc.setValue(2000L);
		cc.setCondition(20);
		
		cc.setStartline(new Date());
		cc.setDeadline(DateUtil.afterNDay(new Date(), 15));
		cc.setSource(6L);
		cc.setCreatedAt(new Date());
		cc.setDays(0); // 确认此处字段赋值情况
		cashCouponsMapper.insertSelective(cc);
	}

}
*/