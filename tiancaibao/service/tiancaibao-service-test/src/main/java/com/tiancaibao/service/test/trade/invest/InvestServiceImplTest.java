package com.tiancaibao.service.test.trade.invest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestBillsService;
import com.tiancaibao.service.interfaces.trade.invest.ITradeInvestRecordsService;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class InvestServiceImplTest {
	
	@Resource
	private ITradeInvestBillsService investBillService;
	@Resource
	private ITradeInvestRecordsService investRecordService;
	
	
	@Test
	public void testSelectSumAmountByUserId() {
		Long sum = investRecordService.selectSumAmountByUserId(40L);
		System.out.println(sum);
	}

	@Test
	public void testSelectFixIncome() {
		Long fixIncome = investRecordService.selectFixedIncomeByUserId(416L);
		System.out.println(fixIncome);
	}

	@Test
	public void testSelectCurrentSumAmountNotWithDraw(){
		Long cu = investRecordService.selectCurrentSumAmountNotWithDraw(9L);
		System.out.println(cu);
	}

	@Test
	public void testSelectInvestSumAmount() {
		Long sumAmount = investRecordService.selectSumAmountByUserId(9L);
		System.out.println(sumAmount);
	}

}
