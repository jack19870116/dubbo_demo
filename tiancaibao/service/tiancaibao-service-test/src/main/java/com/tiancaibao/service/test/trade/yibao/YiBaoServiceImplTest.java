package com.tiancaibao.service.test.trade.yibao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.service.interfaces.trade.ITradeYiBaoService;

@ContextConfiguration(locations = { "classpath:srping/spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class YiBaoServiceImplTest {

	@Resource
	private ITradeYiBaoService yiBaoService;


	@Test
	public void testSelectSumAmountByUserId() {
		Long sumAmount = yiBaoService.selectSumAmountByUserId(15845784L);
		System.out.println(sumAmount);
	}

}
