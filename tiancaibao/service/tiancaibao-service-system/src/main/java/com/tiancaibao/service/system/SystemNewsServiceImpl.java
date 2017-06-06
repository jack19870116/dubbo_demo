package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemNewsMapper;
import com.tiancaibao.pojo.system.SystemNews;
import com.tiancaibao.pojo.system.SystemNewsExample;
import com.tiancaibao.service.interfaces.system.ISystemNewsService;

@Service("systemNewsService")
public class SystemNewsServiceImpl implements ISystemNewsService{

		@Resource
		private SystemNewsMapper newsMapper;
	
		@Override
		public List<SystemNews> selectNewsListByPublishOrderByCreateAtWithPage(Integer publish, String order, Integer currpage,
				Integer pageSize) {
			if (pageSize == null) {
				pageSize = 10;
			}
			SystemNewsExample ne = new SystemNewsExample();
			ne.setOrderByClause("created_at " + order);
			ne.setPageNo(currpage);
			ne.setPageSize(pageSize);
			ne.createCriteria().andPublishEqualTo(publish);
			return newsMapper.selectByExample(ne);
		}
	
		@Override
		public SystemNews selectNewsByIdAndPublishAndType(Long news_id, Integer publish, String type) {
			SystemNewsExample ne = new SystemNewsExample();
			ne.createCriteria().andIdEqualTo(news_id).andPublishEqualTo(publish).andTypeEqualTo(type);
			List<SystemNews> newslist = newsMapper.selectByExample(ne);
			if (newslist != null && newslist.size() == 1) {
				return newslist.get(0);
			}
			return null;
		}
	
		@Override
		public SystemNews selectNewsByGreaterThanIdAndPublishAndType(Long news_id, Integer publish, String type) {
			SystemNewsExample ne = new SystemNewsExample();
			ne.createCriteria().andIdGreaterThan(news_id).andPublishEqualTo(publish).andTypeEqualTo(type);
			List<SystemNews> newslist = newsMapper.selectByExample(ne);
			if (newslist != null  && newslist.size() > 0) {
				return newslist.get(0);
			}
			return null;
		}
	
		@Override
		public SystemNews selectNewsByLessThanIdAndPublishAndTypeAndOrderById(Long news_id, Integer publish, String type) {
			SystemNewsExample ne = new SystemNewsExample();
			ne.setOrderByClause("id desc");
			ne.createCriteria().andIdLessThan(news_id).andPublishEqualTo(publish).andTypeEqualTo(type);
			List<SystemNews> newslist = newsMapper.selectByExample(ne);
			if (newslist != null  && newslist.size() > 0) {
				return newslist.get(0);
			}
			return null;
		}
	
		@Override
		public  List<SystemNews> selectNewsListByPublishAndTypeOrderByCreateAtWithPage(Integer publish, String type, Integer currpage,
				Integer pageSize) {
			if (pageSize == null) {
				pageSize = 10;
			}
			if (currpage == null) {
				currpage = 1;
			}
			SystemNewsExample ne = new SystemNewsExample();
			ne.setOrderByClause("created_at desc");
			ne.setPageNo(currpage);
			ne.setPageSize(pageSize);
			ne.createCriteria().andPublishEqualTo(publish);
			ne.createCriteria().andTypeEqualTo(type);
			return newsMapper.selectByExample(ne);
		}
		
		@Override
		public SystemNews selectNewsByPublishAndType(Integer publish, String type) {
			SystemNewsExample ne = new SystemNewsExample();
			ne.createCriteria().andPublishEqualTo(publish).andTypeEqualTo(type);
			ne.setOrderByClause("created_at desc");
			List<SystemNews> newslist = newsMapper.selectByExample(ne);
			if (newslist != null && newslist.size() > 0) {
				return newslist.get(0);
			}
			return null;
		}
}
