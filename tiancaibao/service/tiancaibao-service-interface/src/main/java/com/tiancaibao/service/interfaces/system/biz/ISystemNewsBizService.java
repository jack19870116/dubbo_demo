package com.tiancaibao.service.interfaces.system.biz;

public interface ISystemNewsBizService {

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
	public String newsList(Integer publish, String type, Integer currpage, Integer pageSize);
	
	/**
	 * 新闻媒体行业动态详情
	 * 
	 * @param publish  是否发布（0：不发布；1：发布）
	 * @param type     类型（media=媒体，industry=行业动态,report=月报）
	 * @param news_id  公告ID
	 * @return
	 */
	public String newsDetails(String type, Long news_id, Integer publish);
	
	/**
	 * 月报(app3.0)
	 * 
	 * @param type		类型（media=媒体，industry=行业动态,report=月报）
	 * @param publish	是否发布（0：不发布；1：发布）
	 * @param currpage	第几页
	 * @param pageSize	每页显示数量
	 * @return
	 */
	public String monthlyrReport(Integer publish, String type, Integer currpage, Integer pageSize);
	
	/**
	 * 行业动态 月报最新发布时间app3.0
	 * 
	 * @return
	 */
	public String newsReleaseTime();
	
}
