package com.tiancaibao.service.system.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.system.SystemNews;
import com.tiancaibao.service.interfaces.system.ISystemNewsService;
import com.tiancaibao.service.interfaces.system.biz.ISystemNewsBizService;


@Service("systemNewsBizService")
public class SystemNewsBizServiceImpl implements ISystemNewsBizService {

	@Resource
	ISystemNewsService NewsService;
	
	/**
	 * 媒体公告/行业动态/平台月报---列表
	 * 分页排序返回所有已经发布的新闻
	 * 
	 * @param publish  是否发布（0：不发布；1：发布）
	 * @param type     类型（media=媒体，industry=行业动态,report=月报）
	 * @param currpage 第几页
	 * @param pageSize 每页显示数量
	 * @return
	 */
	public String newsList(Integer publish, String type, Integer currpage, Integer pageSize) {
		JSONObject json = new JSONObject();
		
		List<SystemNews> selectGetAll = NewsService.selectNewsListByPublishAndTypeOrderByCreateAtWithPage(publish, type, currpage, pageSize);
		
		if (selectGetAll == null) {
			json.put("success", true);
			json.put("error", "暂无相关信息");
			json.put("data", "");
			json.put("type", type);
			return json.toString();
		}

		json.put("success", true);
		json.put("error", "");
		json.put("data", selectGetAll);
		json.put("type", type);
		return json.toString();
		
	}
	
	/**
	 * 新闻媒体行业动态详情
	 * 
	 * @param publish  是否发布（0：不发布；1：发布）
	 * @param type     类型（media=媒体，industry=行业动态,report=月报）
	 * @param news_id  公告ID
	 * @return
	 */
	public String newsDetails(String type, Long news_id, Integer publish) {
		JSONObject json = new JSONObject();
		
		if (news_id == null || (news_id != null && "".equals(news_id))) {
			json.put("success", false);
			json.put("error", "没有您想要的信息");
			json.put("data", "");
			json.put("type", type);
			return json.toString();
		}
		
		SystemNews news = NewsService.selectNewsByIdAndPublishAndType(news_id, publish, type);
		if (news == null) {
			json.put("success", false);
			json.put("error", "没有您想要的信息");
			json.put("data", "");
			json.put("type", type);
			return json.toString();
		}
		
		//上一篇
		SystemNews prev = NewsService.selectNewsByGreaterThanIdAndPublishAndType(news_id, publish, type);
		if(prev != null){
			json.put("prev", prev.getId());
		}else{
			json.put("prev", "");
		}
		
		//下一篇
		SystemNews next = NewsService.selectNewsByLessThanIdAndPublishAndTypeAndOrderById(news_id, publish, type);
		if(next != null){
			json.put("next", next.getId());
		}else{
			json.put("next", "");
		}
		
		json.put("success", true);
		json.put("error", "");
		json.put("data", news);
		json.put("type", type);
		return json.toString();
	}
	
	/**
	 * 月报(app3.0)
	 * 
	 * @param type		类型（media=媒体，industry=行业动态,report=月报）
	 * @param publish	是否发布（0：不发布；1：发布）
	 * @param currpage	第几页
	 * @param pageSize	每页显示数量
	 * @return
	 */
	public String monthlyrReport(Integer publish, String type, Integer currpage, Integer pageSize){
		JSONObject json = new JSONObject();
		List<SystemNews>  news = NewsService.selectNewsListByPublishAndTypeOrderByCreateAtWithPage(publish, type, currpage, pageSize);
		json.put("success", true);
		json.put("data", news);
		return json.toString();
	}
	
	/**
	 * 行业动态 月报最新发布时间app3.0
	 * 
	 * @return
	 */
	public String newsReleaseTime(){
		JSONObject json = new JSONObject();
		//行业动态
		SystemNews  industry = NewsService.selectNewsByPublishAndType(1, "industry");
		//月报
		SystemNews  report = NewsService.selectNewsByPublishAndType(1, "report");
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if(industry == null){
			modelMap.put("last_dynamic_date", "0");
		}else{
			modelMap.put("last_dynamic_date", industry.getCreatedAt().getTime());
		}
		
		if(report == null){
			modelMap.put("last_dynamic_date", "0");
		}else{
			modelMap.put("last_dynamic_date", report.getCreatedAt().getTime());
		}
		
		json.put("success", true);
		json.put("data", modelMap);
		return json.toString();
	}
	
}
