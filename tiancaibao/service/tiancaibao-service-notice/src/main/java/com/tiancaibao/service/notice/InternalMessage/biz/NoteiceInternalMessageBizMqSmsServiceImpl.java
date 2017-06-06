package com.tiancaibao.service.notice.InternalMessage.biz;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.pojo.mq.MqMessage;
import com.tiancaibao.pojo.notice.NoticeInternalMessage;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;
import com.tiancaibao.service.interfaces.notice.INoticeInternalMessageService;
import com.tiancaibao.service.interfaces.notice.biz.INoteiceInternalMessageBizMqSmsService;
import com.tiancaibao.utils.page.Pagination;

@Service("internalMessageBizService")
public class NoteiceInternalMessageBizMqSmsServiceImpl implements INoteiceInternalMessageBizMqSmsService, MessageListener {

	@Resource
	INoticeInternalMessageService internalMessageService;

	@Resource
	IMqMessageService mqMessageSender;

	private static Logger log = Logger.getLogger(NoteiceInternalMessageBizMqSmsServiceImpl.class);
	
	@Override
	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);

			Long userId = Long.parseLong(json.get("userId").toString());
			String serviceName = (String) json.get("serviceName");
			Integer messageId = (Integer) json.get("messageId");
			log.info("站内信服务 InternalMessageService 接收到信息" + receiverMessage + "\n");
			mqMessageSender.updateMqMessageReceiveStatus(messageId,Mq.Receive_Status);
			
			sendNoticeMessage(userId,serviceName,json);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public boolean sendNoticeMessage(Long userId, String serviceName, JSONObject json) {
		
		boolean ok = false;
		Integer messageId = (Integer) json.get("messageId");
		MqMessage mm =mqMessageSender.selectMqMessageByMessageId(messageId);
		
		if(mm.getProcessStatus() == null){
			
			String title = json.get("title") =="" ? "" : json.get("title").toString();
			Byte status = Byte.parseByte(json.get("status").toString());
			String remark = json.get("remark") == "" ? null : (String) json.get("remark");
			String phone = json.get("phone") == "" ? null : (String) json.get("phone");
			String amount = json.get("amount") == null ? "" : json.get("amount").toString();
			
			try{
				
				switch (serviceName){
					case "rechangeService":
								
						internalMessageService.insertNotice(userId, title, getNoticeMessageContext(serviceName, phone, amount), status, remark);
						
						ok =true;
						break;
					case "withdrawService":
						
						internalMessageService.insertNotice(userId, title, getNoticeMessageContext(serviceName, phone, amount), status, remark);
						
						ok = true;
						break;
					default:
						
						ok = true;
						break;
				}
				mqMessageSender.updateMqMessageProcessStatus((Integer) json.get("messageId"), Mq.Process_Status);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			ok = false;
		}
		return ok;
	}

	@Override
	public String getNoticeMessageContext(String serviceName, String phone, String amount) {
		String context = "";
		switch (serviceName) {
			case "realNameService": // 实名
				context = "恭喜您实名注册成功！送您新手专享大礼包，20%加息券一张，还有80元现金红包。请到账户查收使用。首投定期满5000元，再送3%加息券一张";
				break;
			case "registerService": // 先更新用户,再增加一条
				context = "您邀请好友" + phone + "绑卡，成功得到5%加息券一张哦";
				break;
			case "rechangeService":// 充值
				context = "您在天财宝成功充值" + amount + "元，可到个人账户查看。天财宝，正当年";
				break;
			case "withdrawService":// 提现
				context = "您在天财宝成功提现" + amount + "元，可到个人账户查看提现记录。天财宝，正当年";
				break;
			case "investFixedFirstService":// 投资
				context = "您所邀请好友"+phone+"首次成功投资一笔定期，送您"+amount+"积分哦！";
				break;
			case "investFixed2000Service":// 投资
				context = "您所邀请好友"+phone+"在注册60天内成功首投定期单笔满2000元，再送您一张5%加息券和"+amount+"积分哦。";
				break;
			case "investFixedfffService":// 投资
				context = "您所邀请好友"+phone+"在注册60天内成功投资任意定期首次单笔满2000元，再送您一张5%加息券哦。";
				break;
			default:
				break;
			}
		return context;

	}

	@Override
	public String noticeList(Long userId, Integer currpage, Integer pageSize) {
		JSONObject json = new JSONObject();
		
		Pagination selectGetAll = internalMessageService.selectNoticesByUserIdWithPage(currpage, pageSize, userId);
		
		if (selectGetAll == null) {
			json.put("success", true);
			json.put("error", "暂无相关信息");
			json.put("data", "");
			return json.toString();
		}

		json.put("success", true);
		json.put("error", "");
		json.put("data", selectGetAll);
		return json.toString();
	}

	@Override
	public String noticeDetails(Long id, Long userId) {
		JSONObject json = new JSONObject();
		
		if (id == null || (id != null && "".equals(id))) {
			json.put("success", false);
			json.put("error", "没有您想要的信息");
			json.put("data", "");
			return json.toString();
		}
		
		NoticeInternalMessage notice = internalMessageService.selectNoticesByIdAndUserId(id, userId);
		if (notice == null) {
			json.put("success", false);
			json.put("error", "没有您想要的信息");
			json.put("data", "");
			return json.toString();
		}
		
		//上一篇
		NoticeInternalMessage prev = internalMessageService.selectNoticesByGreaterThanIdAndUserId(id, userId);
		if(prev != null){
			json.put("prev", prev.getId());
		}else{
			json.put("prev", "");
		}
		
		//下一篇
		NoticeInternalMessage next = internalMessageService.selectNoticesByLessThanIdAndUserIdAndOrderById(id, userId);
		if(next != null){
			json.put("next", next.getId());
		}else{
			json.put("next", "");
		}
		
		json.put("success", true);
		json.put("error", "");
		json.put("data", notice);
		return json.toString();
	}

	@Override
	public String updateNotice(Long userId) {
		JSONObject json = new JSONObject();
		int res = internalMessageService.updateNoticeByUserId(userId);
		json.put("success", true);
		json.put("data", res);
		return json.toString();
	}
	
	
	
	
	

}
