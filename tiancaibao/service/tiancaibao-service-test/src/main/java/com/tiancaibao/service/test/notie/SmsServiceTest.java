package com.tiancaibao.service.test.notie;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tiancaibao.service.interfaces.notice.INoticeSmsSaveService;


import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SmsServiceTest {
	@Resource 
	private INoticeSmsSaveService noticeSavaSmsService;
	
	@Test
	public void testSaveSmsToSmsTable(){
		System.out.println("testing saveSmsToSmsTable!");
		noticeSavaSmsService.saveSmsToSmsTable("123","rtdrh");
		
	}
}
