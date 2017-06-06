package com.tiancaibao.service.notice.sms.biz;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.notice.INoticeSendSMSService;
import com.tiancaibao.service.interfaces.notice.INoticeSmsSaveService;
import com.tiancaibao.service.interfaces.notice.biz.INoticeBizSendSMSOnMqService;

@Service("sendSmsOnMqService")
public class NoticeBizSendSMSOnMqServiceImpl implements INoticeBizSendSMSOnMqService, MessageListener {

	@Resource
	private INoticeSmsSaveService smsSaveService;
	@Resource
	private INoticeSendSMSService sendSmsService;
	@Resource
	IMqMessageService mqMessageSender;

	private static Logger logger = LoggerFactory.getLogger(NoticeBizSendSMSOnMqServiceImpl.class);
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub

		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Integer messageId = (Integer) json.get("messageId");
			String phone = (String) json.get("phone");
			String serviceName = (String) json.get("serviceName");
			logger.info("SMS服务接收到信息：" + receiverMessage + "\n");
			mqMessageSender.updateMqMessageReceiveStatus(messageId, "ReceiveSuccess");
			
			sendSMSOnMq(phone,serviceName, json);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendSMSOnMq(String phone, String serviceName,JSONObject message) {
		try{	
			String content = sendSmsService.createSms(phone, (int) message.get("type")).getContent();
			Long smsId = smsSaveService.saveSmsToSmsTable(phone, content);
			Boolean smsStatus = sendSmsService.sendSMS(phone, content);
			smsSaveService.updateSmsStatusToSmsTable(smsId, smsStatus);
			
			mqMessageSender.updateMqMessageProcessStatus((Integer)message.get("messageId"), Mq.Process_Status);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
