package com.tiancaibao.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.system.biz.ISystemNewsBizService;

@Controller
@RequestMapping("/system")
public class SystemNewsController {
	@Resource
	private ISystemNewsBizService systemNewsBizService;
	/**
	 * 行业动态
	 */
	@RequestMapping(value="/industry.do" ,method = RequestMethod.POST)
	@ResponseBody
	public String industry(HttpServletRequest request, Integer publish, String type, Integer currpage, Integer pageSize) {
		return systemNewsBizService.newsList(1, type, currpage, pageSize);
	}
	
	/**
	 * 新闻媒体行业动态详情
	 * @param type
	 * @param news_id
	 * @param publish
	 * @return
	 */
	@RequestMapping(value="/newsDetails.do" ,method = RequestMethod.POST)
	@ResponseBody
	public String newsDetails(HttpServletRequest request, String type, Long news_id, Integer publish) {
		return systemNewsBizService.newsDetails(type, news_id, 1);
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
	@RequestMapping(value="/monthlyrReport.do" ,method = RequestMethod.POST)
	@ResponseBody
	public String monthlyrReport(HttpServletRequest request, Integer publish, String type, Integer currpage, Integer pageSize) {
		return systemNewsBizService.monthlyrReport(1, type, currpage, pageSize);
	}
	
	/**
	 * 行业动态 月报最新发布时间app3.0
	 * 
	 * @return
	 */
	@RequestMapping(value="/newsReleaseTime.do" ,method = RequestMethod.POST)
	@ResponseBody
	public String newsReleaseTime() {
		return systemNewsBizService.newsReleaseTime();
	}
	
		
	
}