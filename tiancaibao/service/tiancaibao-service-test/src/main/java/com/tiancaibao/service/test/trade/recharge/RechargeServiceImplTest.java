package com.tiancaibao.service.test.trade.recharge;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.pojo.trade.TradeRechargeBills;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeBillService;
import com.tiancaibao.service.interfaces.trade.recharge.ITradeRechargeRecodeService;
import com.tiancaibao.utils.DateUtil;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class RechargeServiceImplTest {
	@Resource
	private ITradeRechargeBillService rechargeBillService;
	@Resource
	private ITradeRechargeRecodeService rechargeRecodeService;
	
	
	@Test
	public void testSelectSumAmountByUserId() {
		//Long sum = rechargeService.selectSumAmountByUserId(40L);
		//System.out.println(sum);
	}

	@Test
	public void testSelectCountRechargeRecordForLimit() {
		Integer limit = rechargeRecodeService.selectCountRechargeRecordForLimit(40L, 10000L, DateUtil.getDayStartDate());
		System.out.println(limit);
	}

	@Test
	public void testInsertRechargeBill() {
		Long id = rechargeBillService.insertRechargeBill(40L, 2323L, "", "", "CANCELLED", "127.0.0.1", "");
		System.out.println(id);
	}

	@Test
	public void testSelectRechargeBillById() {
		TradeRechargeBills rb = rechargeBillService.selectRechargeBillById(40L);
		System.out.println(rb);
	}

}
