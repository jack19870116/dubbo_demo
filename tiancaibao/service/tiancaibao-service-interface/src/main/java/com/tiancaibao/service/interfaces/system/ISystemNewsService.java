package com.tiancaibao.service.interfaces.system;

import java.util.List;

import com.tiancaibao.pojo.system.SystemNews;

public interface ISystemNewsService {

	/**
	 * 分页排序返回所有已经发布的新闻
	 * @param publish
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	List<SystemNews> selectNewsListByPublishOrderByCreateAtWithPage(Integer publish, String order, Integer currpage, Integer pageSize);

	/**
	 * 根据新闻ID和是否发布、新闻类型返回一条已发布的新闻
	 * @param news_id
	 * @param publish
	 * @param type
	 * @return
	 */
	SystemNews selectNewsByIdAndPublishAndType(Long news_id, Integer publish, String type);

	/**
	 * 返回该ID的上一条已发布的新闻
	 * @param news_id
	 * @param publish
	 * @param type
	 * @return
	 */
	SystemNews selectNewsByGreaterThanIdAndPublishAndType(Long newsId, Integer publish, String type);

	/**
	 * 返回该ID的下一条已发布的新闻
	 * @param news_id
	 * @param publish
	 * @param type
	 * @param order
	 * @return
	 */
	SystemNews selectNewsByLessThanIdAndPublishAndTypeAndOrderById(Long newsId, Integer publish, String type);
	
	/**
	 * 分页排序返回所有某个类型已经发布的新闻
	 * @param publish
	 * @param type
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	List<SystemNews> selectNewsListByPublishAndTypeOrderByCreateAtWithPage(Integer publish, String type, Integer currpage, Integer pageSize);
	
	/**
	 * 根据是否发布、新闻类型返回最新的一条已发布的新闻
	 * @param news_id
	 * @param publish
	 * @param type
	 * @return
	 */
	SystemNews selectNewsByPublishAndType(Integer publish, String type);
}
