package com.tiancaibao.service.interfaces.notice;

import com.tiancaibao.pojo.notice.NoticeSms;

public interface INoticeSendSMSService {
	/**
	 * 调用外部接口发送消息
	 * @param phone
	 * @param content
	 * @return
	 */
	public Boolean sendSMS(String phone,String content);
	
	/**
	 * 生成短信内容
	 * @param phone
	 * @param type
	 * @return
	 */
	public NoticeSms createSms(String phone, int type);
}
