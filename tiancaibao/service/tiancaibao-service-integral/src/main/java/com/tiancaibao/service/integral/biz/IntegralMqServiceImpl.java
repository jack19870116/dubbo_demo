package com.tiancaibao.service.integral.biz;

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
import com.tiancaibao.mapper.integral.IntegralSourcesMapper;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.integral.IIntegralService;
import com.tiancaibao.service.interfaces.integral.biz.IIntegralMqService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.user.IUserService;

@Service("iIntegralMqService")
public class IntegralMqServiceImpl implements IIntegralMqService, MessageListener {
	@Resource
	private IIntegralService integralService;

	@Resource
	private IntegralSourcesMapper integralSourcesMapper;

	@Resource
	private IUserService userService;
	@Resource
	IMqMessageService mqMessageSender;
	private static Logger logger = LoggerFactory.getLogger(IntegralMqServiceImpl.class);

	@Override
	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userId = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");
			String serviceName = (String) json.get("serviceName");
			mqMessageSender.updateMqMessageReceiveStatus(messageId, "ReceiveSuccess");
			logger.info("接收信息" + receiverMessage + "\n");
			grantIntegral(userId, serviceName, json);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("积分模块监听异常");
		}

	}

	@Override
	public boolean grantIntegral(Long userId, String serviceName, JSONObject message) {
		boolean ok = false;
		try{
			switch (serviceName) {
				case "signInService": // 新加一条
				
					Integer source = (Integer) message.get("source");
					Integer integral = (Integer) message.get("integral");
					String remark = (String) message.get("remark");
					Users user = userService.selectUserById(userId);
					integralService.insertIntegralRecord(userId, integral, source, user.getIntegral(), remark);
					break;
				case "B": // 先更新用户,再增加一条
		
					break;
				case "C":// 未定
					break;
				default:
					break;
				}
			
			mqMessageSender.updateMqMessageProcessStatus((Integer)message.get("messageId"), Mq.Process_Status);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ok;
	}

}
