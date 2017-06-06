package com.tiancaibao.service.test.trade.withdraw;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.pojo.trade.TradeWithdrawBills;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawBillService;
import com.tiancaibao.service.interfaces.trade.withdraw.ITradeWithdrawRecodeService;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class WithdrawServiceImplTest {
	
	@Resource
	private ITradeWithdrawBillService withdrawbillService;
	@Resource
	private ITradeWithdrawRecodeService withdrawRecodeService;
	
	@Test
	public void testSelectWithdrawFee() {
		Integer withdrawfee = withdrawRecodeService.selectWithdrawFee(40L);
		System.out.println(withdrawfee);
	}

	@Test
	public void testSelectSystemWithDrawSumAmountCurrentDay() {
		Long sum = withdrawbillService.selectSystemWithDrawSumAmountCurrentDay();
		System.out.println(sum);
	}

	@Test
	public void testSelectSumAmountByUserId() {
		Long sumamount = withdrawRecodeService.selectSumAmountByUserId(102952L);
		System.out.println(sumamount);
	}

	@Test
	public void testSelectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay() {
		Long sumamount = withdrawRecodeService.selectSumAamountByUserIdAndStatusAndCurrentCycleCurrentDay(102952L, "CANCELLED", "");
		System.out.println(sumamount);
	}

	@Test
	public void testInsertWithdrawBillsSelectiveReturnId() {
		TradeWithdrawBills wdb = new TradeWithdrawBills();
		wdb.setAmount(123L);
		Long id = withdrawbillService.insertWithdrawBillsSelectiveReturnId(wdb);
		System.out.println(id);
	}

}
