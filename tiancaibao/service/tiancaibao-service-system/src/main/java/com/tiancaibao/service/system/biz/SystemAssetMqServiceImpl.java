package com.tiancaibao.service.system.biz;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.system.biz.ISystemAssetMqService;

public class SystemAssetMqServiceImpl implements ISystemAssetMqService, MessageListener {
	@Resource
	IMqMessageService mqMessageSender;

	private static final Logger log = LoggerFactory.getLogger(SystemAssetMqServiceImpl.class);
	
	@Override
	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userId = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");;
			log.info("系统份额服务 SystemAssetMqService 接受到信息" + receiverMessage + "\n");
			mqMessageSender.updateMqMessageReceiveStatus(messageId, Mq.Receive_Status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
