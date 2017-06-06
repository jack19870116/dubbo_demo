package com.tiancaibao.service.system.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.system.SystemMessages;
import com.tiancaibao.service.interfaces.system.ISystemMessagesService;
import com.tiancaibao.service.interfaces.system.biz.ISystemMessagesBizService;
import com.tiancaibao.utils.DateUtil;

@Service("systemMessagesBizService")
public class SystemMessagesBizServiceImpl implements ISystemMessagesBizService {
	
	@Resource
	ISystemMessagesService MessagesService;
	
	/**
	 * APP获取公告消息
	 * 
	 * @param start_id
	 * @param end_id
	 * @param latest
	 * @return
	 */
	public String appMessagesList(Long start_id, Long end_id, String latest, String flow){
		JSONObject json = new JSONObject();
		if ((start_id != null && !start_id.equals("")) && (end_id == null || (end_id != null && "".equals(end_id)))) {
			json.put("success", false);
			json.put("error", "没有选择结束时间!");
			json.put("data", "");
			return json.toString();
		}
			
		if ((end_id != null && !end_id.equals("")) && (start_id == null || (start_id != null && "".equals(start_id)))) {
			json.put("success", false);
			json.put("error", "没有选择开始时间!");
			json.put("data", "");
			return json.toString();
		}
		
		List<SystemMessages> selectGetAll = null;
		if((start_id == null || (start_id != null && "".equals(start_id))) && (end_id == null || (end_id != null && "".equals(end_id))) && (latest == null || (latest != null && "".equals(latest))) && (flow == null || (flow != null && "".equals(flow)))){
			selectGetAll = MessagesService.selectMessagesListByIdBetween(null, null);
		}else if((start_id != null && !start_id.equals("")) && (end_id != null && !end_id.equals("")) && (latest == null || (latest != null && "".equals(latest))) && (flow == null || (flow != null && "".equals(flow)))){
			selectGetAll = MessagesService.selectMessagesListByIdBetween(start_id, end_id);
		}else if((latest != null && !latest.equals("")) && (start_id == null || (start_id != null && "".equals(start_id))) && (end_id == null || (end_id != null && "".equals(end_id))) && (flow == null || (flow != null && "".equals(flow)))){
			selectGetAll = MessagesService.selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByIdWithPage(DateUtil.parseDate(DateUtil.formatDate(new Date())), "desc", 1, 1);
		}else if((flow != null && !flow.equals("")) && (start_id == null || (start_id != null && "".equals(start_id))) && (end_id == null || (end_id != null && "".equals(end_id))) && (latest == null || (latest != null && "".equals(latest)))){
			selectGetAll = MessagesService.selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByCreateAtWithPage(DateUtil.parseDate(DateUtil.formatDate(new Date())), "desc", 1, 5);
		}
		
		json.put("success", true);
		json.put("error", "");
		json.put("data", selectGetAll);
		return json.toString();
	}
	
	/**
	 * 分页排序返回公告列表
	 * 
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	public String messagesList(String order, Integer currpage, Integer pageSize){
		JSONObject json = new JSONObject();
		
		List<SystemMessages> selectGetAll = MessagesService.selectMessagesListOrderByCreateAtWithPage(order, currpage, pageSize);
		
		if (selectGetAll == null) {
			json.put("success", true);
			json.put("error", "暂无公告信息");
			json.put("data", "");
			return json.toString();
		}

		json.put("success", true);
		json.put("error", "");
		json.put("data", selectGetAll);
		return json.toString();
	}
	
	/**
	 * 分页排序返回公告列表（公告轮播）
	 * 
	 * @param end_at
	 * @param order
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	public String messagesSliderList(Date end_at, String order, Integer currpage, Integer pageSize){
		JSONObject json = new JSONObject();
		
		List<SystemMessages> selectGetAll = MessagesService.selectMessagesListByGreaterThanOrEqualToEndAtAndOrderByCreateAtWithPage(end_at, order, currpage, pageSize);
		
		if (selectGetAll == null) {
			json.put("success", true);
			json.put("error", "暂无公告信息");
			json.put("data", "");
			return json.toString();
		}

		json.put("success", true);
		json.put("error", "");
		json.put("data", selectGetAll);
		return json.toString();
	}
	
	/**
	 * 公告详情
	 * 
	 * @param news_id
	 * @return
	 */
	public String messagesDetails(Long messages_id){
		JSONObject json = new JSONObject();
		
		if (messages_id == null || (messages_id != null && "".equals(messages_id))) {
			json.put("success", false);
			json.put("error", "没有您想要的信息");
			json.put("data", "");
			return json.toString();
		}
		
		SystemMessages messages = MessagesService.selectMessagesById(messages_id);
		if (messages == null) {
			json.put("success", false);
			json.put("error", "没有您想要的信息");
			json.put("data", "");
			return json.toString();
		}
		
		//上一篇
		SystemMessages prev = MessagesService.selectMessagesByGreaterThanId(messages_id);
		if(prev != null){
			json.put("prev", prev.getId());
		}else{
			json.put("prev", "");
		}
		
		//下一篇
		SystemMessages next = MessagesService.selectMessagesByLessThanIdAndOrderById(messages_id, "desc");
		if(next != null){
			json.put("next", next.getId());
		}else{
			json.put("next", "");
		}
		
		json.put("success", true);
		json.put("error", "");
		json.put("data", messages);
		return json.toString();
	}

}
