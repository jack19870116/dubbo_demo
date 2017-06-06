package com.tiancaibao.service.interfaces.mq;

import com.tiancaibao.pojo.mq.MqMessage;

public interface IMqMessageService {
	/**
	 * 向指定的队列发送消息
	 * 
	 * @param queueName
	 * @param message
	 */
	public void sendMessage(final String queueName, final String message);

	/**
	 * 在数据库表中保存发送的消息
	 * 
	 * @param content
	 * @param userId
	 * @param queueName
	 * @param serverName
	 */
	public MqMessage saveMqMessageToTable(String content, Long userId, String queueName, String serverName);

	/**
	 * 更新接收状态
	 * 
	 * @param message_id
	 * @param user_id
	 */

	Boolean updateMqMessageReceiveStatus(Integer messageId, String receiveStatus);
	
	
	/**
	 * 更新处理状态
	 * @param messageId
	 * @param processStatus
	 * @return
	 */
	Boolean updateMqMessageProcessStatus(Integer messageId, String processStatus);

	/**
	 * 
	 * @param messageId
	 * @return
	 */
	MqMessage selectMqMessageByMessageId(Integer messageId);

}
