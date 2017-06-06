package com.tiancaibao.service.test.trade.recharge.biz;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

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

	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub

		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			String phone = (String) json.get("phone");
			Integer messageId = (Integer) json.get("messageId");
			String serviceName = json.getString("serviceName");
			System.out.println("接受信息" + receiverMessage);
			mqMessageSender.updateMqMessageReceiveStatus(messageId, Mq.Receive_Status);
			sendSMSOnMq(phone, serviceName,json);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendSMSOnMq(String phone, String serviceName,JSONObject json) {
		try{
			int type = (int) json.get("type");

			String content = sendSmsService.createSms(phone, type).getContent();
			Long smsId = smsSaveService.saveSmsToSmsTable(phone, content);
			Boolean smsStatus = sendSmsService.sendSMS(phone, content);
			smsSaveService.updateSmsStatusToSmsTable(smsId, smsStatus);
			
			mqMessageSender.updateMqMessageProcessStatus((Integer) json.get("messageId"), Mq.Process_Status);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
