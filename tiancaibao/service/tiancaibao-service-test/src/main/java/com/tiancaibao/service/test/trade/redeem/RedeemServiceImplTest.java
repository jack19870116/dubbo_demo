package com.tiancaibao.service.test.trade.redeem;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.service.interfaces.trade.redeem.ITenderRepaymentBillsService;
import com.tiancaibao.service.interfaces.trade.redeem.ITradeRedeemRecordsService;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class RedeemServiceImplTest {

	@Resource
	private ITenderRepaymentBillsService redeemBillsService;

	@Resource
	private ITradeRedeemRecordsService redeemRecordsService;
	
	@Test
	public void testSelectRedeemSumAmount() {
		Long sum = redeemRecordsService.selectRedeemAmountByUserId(99299L);
		System.out.println(sum);
	}

	@Test
	public void testSelectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM() {
		Long sumamount = redeemRecordsService.selectSumAmountOfRedeemRecordsByUserIdAndDaysAndCreateAtYM(99299L, 1, "2016-05");
		System.out.println(sumamount);
	}

}
