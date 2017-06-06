package com.tiancaibao.service.talent.biz;

import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.mapper.integral.IntegralTalentSourceMapper;
import com.tiancaibao.pojo.integral.IntegralTalentSource;
import com.tiancaibao.pojo.integral.IntegralTalentSourceExample;
import com.tiancaibao.pojo.mq.MqMessage;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.integral.ITalentValuesMqService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.talent.ITalentService;
import com.tiancaibao.service.interfaces.user.IUserService;

public class TalentValueMqServiceImpl implements ITalentValuesMqService, MessageListener {

	@Resource
	private ITalentService talentsService;

	@Resource
	private IntegralTalentSourceMapper integralTalentSourceMapper;

	@Resource
	private IUserService userService;
	@Resource
	IMqMessageService mqMessageSender;
	
	private static Logger logger = LoggerFactory.getLogger(TalentValueMqServiceImpl.class);

	@Override
	public void onMessage(Message message) {

		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userid = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");;
			String serviceName = json.getString("serviceName");
			
			mqMessageSender.updateMqMessageReceiveStatus(messageId, "ReceiveSuccess");
			
			logger.info("天财值服务 talentsService 接收到信息" + receiverMessage + "\n");	
			
			changeTalentValue(userid, serviceName, json);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean changeTalentValue(Long userId, String serviceName, JSONObject message) {
		boolean ok = false;
		
		Integer messageId = (Integer) message.get("messageId");

		MqMessage mm =mqMessageSender.selectMqMessageByMessageId(messageId);
		
		if(mm.getProcessStatus() == null){
			try{
				switch (serviceName) {
					case "registerService": // 注册更改
					case "realNameService": // 实名更改
					case "rechangeService": // 充值服务
						changeTalentValueRecordForFirstTime(userId, Integer.parseInt(message.get("sourceId").toString()), Long.parseLong(message.get("oldTalentValue").toString()));
						ok = true;	
						break;
					default:
						break;
				}
				mqMessageSender.updateMqMessageProcessStatus((Integer)message.get("messageId"), Mq.Process_Status);
				
			}catch(Exception e){
				e.printStackTrace();
			}

		}else{
			ok = false;	
		}
		
		return ok;
	}

	@Override
	public boolean changeTalentValueRecordForFirstTime(Long userId, Integer sourceId, Long oldTalentValue) {
		IntegralTalentSourceExample example = new IntegralTalentSourceExample();
		example.createCriteria().andSourceIdEqualTo(sourceId);
		List<IntegralTalentSource> selectByExample = integralTalentSourceMapper.selectByExample(example);
		if (selectByExample.size() > 0) {
			Long talent = Long.parseLong(selectByExample.get(0).getTalent().toString());
			int RecordByUserIdAndSourceId = talentsService.selectCountChangeTalentValueRecordByUserIdAndSourceId(userId,sourceId);
			//首次操作，送天财值
			if (RecordByUserIdAndSourceId == 0) {
				Users user = userService.selectUserById(userId);
				userService.updateTalentValueById(userId,user.getTalentValue(),oldTalentValue);
				Long talentValue = oldTalentValue + talent;
				logger.info("用户ID userId = " + userId +"首次操作，天财值 talent +  "  +  talent + "; \n");
				int insertChangeTalentValueRecord = talentsService.insertChangeTalentValueRecord(userId,talent, talentValue, new Date(),sourceId);
				if (!(insertChangeTalentValueRecord > 0)) {
					logger.error("插入天财值失败");
				}
				return true;
				
			}
			logger.info("用户ID userId = " + userId +" 非首次操作，不送天财值！ \n");
		}else{
			logger.info("未获取到指定  sourceId ＝ " + sourceId +"的记录，送天财值失败！ \n");
		}
		return false;
	}

	
	@Override
	public Long changeTalentValueRecordForInvest(Long userid, Integer sourceId, Long oldTalentValue) {
		IntegralTalentSourceExample example = new IntegralTalentSourceExample();
		example.createCriteria().andSourceIdEqualTo(sourceId);
		List<IntegralTalentSource> selectByExample = integralTalentSourceMapper.selectByExample(example);
		if (selectByExample.size() > 0) {

			Long talent = Long.parseLong(selectByExample.get(0).getTalent().toString());
			Long talentValue = talent + oldTalentValue;
			userService.updateTalentValueById(userid, talentValue,oldTalentValue);

			int RecordByUserIdAndSourceId = talentsService.selectCountChangeTalentValueRecordByUserIdAndSourceId(userid,sourceId);
			if (RecordByUserIdAndSourceId == 0) {
				int insertChangeTalentValueRecord = talentsService.insertChangeTalentValueRecord(userid,talent, talentValue, new Date(),sourceId);
				if (!(insertChangeTalentValueRecord > 0)) {
					logger.error("插入天财值失败");
				}
			}
		}
		return null;
	}

}
