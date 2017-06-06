package com.tiancaibao.service.interfaces.notice.biz;

import com.alibaba.fastjson.JSONObject;

public interface INoticeBizSendSMSOnMqService {
	/**
	 * 业务逻辑层经过队列的发送短信处理
	 * @param phone
	 * @param content
	 */
	public void sendSMSOnMq(String phone, String serviceName,JSONObject message);
}
