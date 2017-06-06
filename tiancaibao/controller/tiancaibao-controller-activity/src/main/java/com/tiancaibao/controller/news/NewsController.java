package com.tiancaibao.controller.news;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.News;
import com.tiancaibao.service.news.NewsService;

/**
 * 
 * @author Mack
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController {

	private static Logger logger = Logger.getLogger(NewsController.class);
	@Resource
	private NewsService newsService;

	@RequestMapping("/newsList.do")
	@ResponseBody
	public String newsList(Integer pageSize) {
		JSONObject json = new JSONObject();
		try {
			List<News> newslist = newsService.selectNewsListByPublishOrderByCreateAtWithPage(1, "desc", 1, pageSize);
			if (newslist == null) {
				json.put("success", true);
				json.put("error", "暂无媒体信息");
				json.put("data", "");
				return json.toString();
			}
			json.put("success", true);
			json.put("error", "");
			json.put("data", newslist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("媒体公告列表:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 公告详情
	 * 
	 * @param news_id
	 * @return
	 */
	@RequestMapping("/newsDetails.do")
	@ResponseBody
	public String newsDetails(Long news_id) {
		JSONObject json = new JSONObject();
		try {
			News news = newsService.selectNewsByIdAndPublish(news_id, 1);
			// 上一篇
			News prevnews = newsService.selectNewsByGreaterThanIdAndPublish(news_id, 1);
			// 下一篇
			News nextnews = newsService.selectNewsByLessThanIdAndPublishAndOrderById(news_id, 1, "desc");
			if (news == null) {
				json.put("success", false);
				json.put("error", "没有您想要的媒体信息");
				json.put("data", "");
				return json.toString();
			}
			json.put("success", true);
			json.put("error", "");
			json.put("data", news);
			json.put("prev", prevnews);
			json.put("next", nextnews);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("公告详情:" + e.getMessage());
		}
		return json.toString();
	}

	/**
	 * 行业动态列表
	 * 
	 * @return
	 */
	@RequestMapping("/industryNews.do")
	@ResponseBody
	public String industryNews() {
		return null;
	}

	/**
	 * 行业动态详情
	 * 
	 * @return
	 */
	@RequestMapping("/industryNewsShows.do")
	@ResponseBody
	public String industryNewsShows() {
		return null;
	}

	/**
	 * 网站公告列表
	 * 
	 * @return
	 */
	@RequestMapping("/noticeList.do")
	@ResponseBody
	public String noticeList() {
		return null;
	}

	/**
	 * 网站公告详情
	 * 
	 * @return
	 */
	@RequestMapping("/noticeListShows.do")
	@ResponseBody
	public String noticeListShows() {
		return null;
	}

}
