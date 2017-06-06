package com.tiancaibao.service.test.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.util.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.pojo.system.SystemMessages;
import com.tiancaibao.service.interfaces.system.ISystemMessagesService;
import com.tiancaibao.service.interfaces.system.biz.ISystemMessagesBizService;
import com.tiancaibao.utils.DateUtil;

@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class MessagesServiceTest {

	@Resource
	ISystemMessagesService MessagesService;
	
	@Resource
	ISystemMessagesBizService MessagesBizService;
	
	@Test
	public void testSelectMessagesListByIdBetween() {
		System.out.println("\ntesting news--1!\n");
		List<SystemMessages> messages = MessagesService.selectMessagesListByIdBetween(1L, 100L);
		System.out.println(messages + "\n");

	}
	
	@Test
	public void testSelectMessagesListByGreaterThanOrEqualToEndAtAndOrderByIdWithPage() {
		System.out.println("\ntesting news--2!\n");
		List<SystemMessages> messages = MessagesService.selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByIdWithPage(DateUtil.parseDate("2017-01-01"), "desc", 1, 10);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testSelectMessagesListByGreaterThanOrEqualToEndAtAndOrderByCreateAtWithPage() {
		System.out.println("\ntesting news--3!\n");
		List<SystemMessages> messages = MessagesService.selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByCreateAtWithPage(DateUtil.parseDate("2017-01-01"), "desc", 1, 10);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testSelectMessagesListOrderByCreateAtWithPage() {
		System.out.println("\ntesting news--4!\n");
		List<SystemMessages> messages = MessagesService.selectMessagesListOrderByCreateAtWithPage("desc", 1, 10);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testSelectMessagesById() {
		System.out.println("\ntesting news--5!\n");
		SystemMessages messages = MessagesService.selectMessagesById(10L);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testsSelectMessagesByGreaterThanId() {
		System.out.println("\ntesting news--6!\n");
		SystemMessages messages = MessagesService.selectMessagesByGreaterThanId(10L);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testsSelectMessagesByLessThanIdAndOrderById() {
		System.out.println("\ntesting news--6!\n");
		SystemMessages messages = MessagesService.selectMessagesByLessThanIdAndOrderById(10L, "desc");
		System.out.println(messages + "\n");
	}
	
	
	@Test
	public void testsNewsList() {
		System.out.println("\ntesting biz--1!\n");
		String messages = MessagesBizService.appMessagesList(1L, 100L, null, null);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testNewsDetails() {
		System.out.println("\ntesting biz--2!\n");
		String messages = MessagesBizService.messagesList("desc", 1, 10);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testMonthlyrReport() {
		System.out.println("\ntesting biz--3!\n");
		String messages = MessagesBizService.messagesSliderList(DateUtil.parseDate("2017-01-01"), "desc", 1, 10);
		System.out.println(messages + "\n");
	}
	
	@Test
	public void testNewsReleaseTime() {
		System.out.println("\ntesting biz--4!\n");
		String messages = MessagesBizService.messagesDetails(10L);
		System.out.println(messages + "\n");
	}
	
}
