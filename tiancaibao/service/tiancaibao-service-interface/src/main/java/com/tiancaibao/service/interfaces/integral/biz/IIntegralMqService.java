package com.tiancaibao.service.interfaces.integral.biz;

import javax.jms.Message;

import com.alibaba.fastjson.JSONObject;

public interface IIntegralMqService {
	/**
	 * 接收所有积分队列消息
	 * 
	 * @param message
	 */
	public void onMessage(Message message);

	/**
	 * 具体处理消息队列中的消息
	 * 
	 * @param userid
	 * @param sourceId
	 * @param oldTalentValue
	 * @param type
	 * @return
	 */
	public boolean grantIntegral(Long userId, String serviceName, JSONObject message);
}
