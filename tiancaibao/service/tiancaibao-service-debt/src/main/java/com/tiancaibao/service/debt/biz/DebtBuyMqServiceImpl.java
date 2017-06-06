package com.tiancaibao.service.debt.biz;

import java.net.URLDecoder;
import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.service.interfaces.debt.DebtBuyService;
import com.tiancaibao.service.interfaces.debt.biz.DebtBuyMqService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;

public class DebtBuyMqServiceImpl implements DebtBuyMqService ,MessageListener{

	@Resource
	IMqMessageService mqMessageSender;
	@Resource
	DebtBuyService debtBuyService;
	// 消息队列接收用户的id和金额
	@Override
	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userId = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");
			Long amount = Long.parseLong(json.get("amount").toString());
			String sinNo = json.get("sinNo").toString();
			TransferDeliverMq(userId,amount,sinNo);
			System.out.println("接受信息" + receiverMessage);
			mqMessageSender.updateMqMessageReceiveStatus(messageId,Mq.Receive_Status);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Transactional
	@Override
	public String TransferDeliverMq(Long userId, Long amount,String sinNo) {
		try {
			String string = debtBuyService.TransferDeliver(userId, amount, sinNo);
			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return "债权匹配失败";
		}
	}

}
