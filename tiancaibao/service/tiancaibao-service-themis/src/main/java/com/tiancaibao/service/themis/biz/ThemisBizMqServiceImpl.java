package com.tiancaibao.service.themis.biz;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.themis.biz.IThemisBizMqService;

public class ThemisBizMqServiceImpl implements IThemisBizMqService, MessageListener {
	@Resource
	IMqMessageService mqMessageSender;

	@Override
	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userId = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");;

			Integer type = (Integer) json.get("type");
			SendThemis(userId, type);
			System.out.println("接受信息" + receiverMessage);
			mqMessageSender.updateMqMessageReceiveStatus(messageId, Mq.Receive_Status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Boolean SendThemis(Long userId, Integer type) {
		// TODO Auto-generated method stub
		return null;
	}
}
