package com.tiancaibao.service.interfaces.notice.biz;

public interface INoticeBizSendSMSNoMqService {
	/**
	 * 业务逻辑层的不经过队列发送短信处理
	 * @param phone
	 * @param type
	 * @return
	 */
	public String sendSmsProcessing(final String phone, Integer type);
}
