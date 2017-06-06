package com.tiancaibao.service.interfaces.system.biz;

import java.util.Date;

public interface ISystemMessagesBizService {
	
	/**
	 * APP获取公告消息
	 * 
	 * @param start_id
	 * @param end_id
	 * @param latest
	 * @return
	 */
	public String appMessagesList(Long start_id, Long end_id, String latest, String flow);
	
	/**
	 * 分页排序返回公告列表
	 * 
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	public String messagesList(String order, Integer currpage, Integer pageSize);
	
	/**
	 * 分页排序返回公告列表（公告轮播）
	 * 
	 * @param end_at
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	public String messagesSliderList(Date end_at, String order, Integer currpage, Integer pageSize);
	
	/**
	 * 公告详情
	 * 
	 * @param news_id
	 * @return
	 */
	public String messagesDetails(Long messages_id);

}
