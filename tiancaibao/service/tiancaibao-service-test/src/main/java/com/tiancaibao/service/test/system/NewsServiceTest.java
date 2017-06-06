package com.tiancaibao.service.test.system;

import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.util.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.pojo.system.SystemNews;
import com.tiancaibao.service.interfaces.system.ISystemNewsService;
import com.tiancaibao.service.interfaces.system.biz.ISystemNewsBizService;

@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class NewsServiceTest {

	@Resource
	ISystemNewsService NewsService;
	
	@Resource
	ISystemNewsBizService NewsBizService;
	
	@Test
	public void testSelectNewsListByPublishOrderByCreateAtWithPage() {
		System.out.println("\ntesting news--1!\n");
		List<SystemNews> news = NewsService.selectNewsListByPublishOrderByCreateAtWithPage(1, "desc", 1, 10);
		System.out.println(news + "\n");

	}
	
	@Test
	public void testSelectNewsByIdAndPublishAndType() {
		System.out.println("\ntesting news--2!\n");
		SystemNews news = NewsService.selectNewsByIdAndPublishAndType(1L, 1, "media");
		System.out.println(news + "\n");
	}
	
	@Test
	public void testSelectNewsByGreaterThanIdAndPublishAndType() {
		System.out.println("\ntesting news--3!\n");
		SystemNews news = NewsService.selectNewsByGreaterThanIdAndPublishAndType(13L, 1, "media");
		System.out.println(news + "\n");
	}
	
	@Test
	public void testSelectNewsByLessThanIdAndPublishAndTypeAndOrderById() {
		System.out.println("\ntesting news--4!\n");
		SystemNews news = NewsService.selectNewsByLessThanIdAndPublishAndTypeAndOrderById(1L, 1, "media");
		System.out.println(news + "\n");
	}
	
	@Test
	public void testSelectNewsListByPublishAndTypeOrderByCreateAtWithPage() {
		System.out.println("\ntesting news--5!\n");
		List<SystemNews> news = NewsService.selectNewsListByPublishAndTypeOrderByCreateAtWithPage(1, "media", 1, 10);
		System.out.println(news + "\n");
	}
	
	@Test
	public void testsSelectNewsByPublishAndType() {
		System.out.println("\ntesting news--6!\n");
		SystemNews news = NewsService.selectNewsByPublishAndType(1, "media");
		System.out.println(news + "\n");
	}
	
	
	@Test
	public void testsNewsList() {
		System.out.println("\ntesting biz--1!\n");
		String news = NewsBizService.newsList(1, "media", 1, 10);
		System.out.println(news + "\n");
	}
	
	@Test
	public void testNewsDetails() {
		System.out.println("\ntesting biz--2!\n");
		String news = NewsBizService.newsDetails("media", 6L, 1);
		System.out.println(news + "\n");
	}
	
	@Test
	public void testMonthlyrReport() {
		System.out.println("\ntesting biz--3!\n");
		String news = NewsBizService.monthlyrReport(1, "media", 1, 10);
		System.out.println(news + "\n");
	}
	
	@Test
	public void testNewsReleaseTime() {
		System.out.println("\ntesting biz--4!\n");
		String news = NewsBizService.newsReleaseTime();
		System.out.println(news + "\n");
	}
	
}
