package com.tiancaibao.service.interfaces.notice.biz;

import com.alibaba.fastjson.JSONObject;

public interface INoteiceInternalMessageBizMqSmsService {

	/**
	 * 返回内容
	 * 
	 * @param types
	 */

	public String getNoticeMessageContext(String serviceName, String phone, String amount);

	/**
	 * 发送信息
	 * 
	 * @param userId
	 * @param title
	 * @param info
	 * @param status
	 * @param remark
	 * @return
	 */
	public boolean sendNoticeMessage(Long userId, String serviceName, JSONObject json);

	/**
	 * 消息列表 站内信
	 * 
	 * @param userId
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	public String noticeList(Long userId, Integer currpage, Integer pageSize);
	
	/**
	 * 站内信详情
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	public String noticeDetails(Long id, Long userId);
	
	/**
	 * 修改站内信状态
	 * 
	 * @param userId
	 * @return
	 */
	public String updateNotice(Long userId);
	

}
