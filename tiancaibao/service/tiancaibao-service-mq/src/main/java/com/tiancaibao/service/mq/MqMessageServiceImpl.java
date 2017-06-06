package com.tiancaibao.service.mq;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.mapper.mq.MqMessageMapper;
import com.tiancaibao.pojo.mq.MqMessage;
import com.tiancaibao.pojo.mq.MqMessageExample;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;

@Service("mqMessageSender")
public class MqMessageServiceImpl implements IMqMessageService {

	@Resource
	private MqMessageMapper mqMessageMapper;


	private static final Logger log = LoggerFactory.getLogger(MqMessageServiceImpl.class);
	
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate; // 通过@Qualifier修饰符来注入对应的bean


	/**
	 * 发送一条消息到指定的队列（目标）
	 * 
	 * @param queueName
	 *            队列名称
	 * @param message
	 *            消息内容
	 */
	@Override
	public void sendMessage(final String queueName, final String message) {
		// TODO Auto-generated method stub
		JSONObject json = JSONObject.parseObject(message);
		Integer messageId = Integer.parseInt(json.get("messageId").toString());
		MqMessage mm = selectMqMessageByMessageId(messageId);
 		//根据消息ID查询消息状态，如果已经成功处理，刚不做任何操作
		if(mm.getReceiveStatus() == null){
			final String messageNew = json.toString();
			jmsTemplate.send(queueName, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(messageNew);
				}
			});
		}else{
			
		}
	}

	@Override
	public MqMessage saveMqMessageToTable(String content, Long userId, String queueName, String serverName) {
		// 将消息插入消息记录表
		MqMessage mm = new MqMessage();
		mm.setContent(content);
		mm.setUserId(userId.intValue());
		mm.setCreateAt(new Date());
		mm.setQueueName(queueName);
		mm.setServerName(serverName);
		mqMessageMapper.insertSelective(mm);
		log.info("插入消息记录表"+ mm + "\n");
		return mm;
	}

	@Override
	public Boolean updateMqMessageReceiveStatus(Integer messageId,String receiveStatus){
		MqMessage mm =new MqMessage();
		mm.setId(messageId);
		mm.setReceiveStatus(receiveStatus);
		Integer sumUpdateNumber = mqMessageMapper.updateByPrimaryKeySelective(mm);
		if (sumUpdateNumber == 1) {
			log.info("把messageId是: " + messageId + "的状态更新为：" + "receiveStatus=" + receiveStatus + "更新成功！" + "\n");
			return true;
		} else if (sumUpdateNumber == 0) {
			log.info("把messageId是: " + messageId + "的状态更新为：" + "receiveStatus=" + receiveStatus + "更新失败！" + "\n");
			return false;
		}
		return false;
	}
	
	@Override
	public Boolean updateMqMessageProcessStatus(Integer messageId,String processStatus){
		MqMessage mm =new MqMessage();
		mm.setId(messageId);
		mm.setProcessStatus(processStatus);
		Integer sumUpdateNumber = mqMessageMapper.updateByPrimaryKeySelective(mm);
		if (sumUpdateNumber == 1) {
			log.info("把messageId是: " + messageId + "的状态更新为：" + "processStatus=" + processStatus + "更新成功！" + "\n");
			return true;
		} else if (sumUpdateNumber == 0) {
			log.info("把messageId是: " + messageId + "的状态更新为：" + "processStatus=" + processStatus + "更新失败！" + "\n");
			return false;
		}
		return false;
	}
	
	@Override
	public MqMessage selectMqMessageByMessageId(Integer messageId){
		MqMessageExample mme = new MqMessageExample();
		mme.createCriteria().andIdEqualTo(messageId);
		List <MqMessage> mqMessageList = mqMessageMapper.selectByExample(mme);
		
		return mqMessageList == null ? null:mqMessageList.get(0);
	}

}
