package com.tiancaibao.service.coupons.biz;

import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.service.interfaces.coupons.biz.ICouponsMqService;
import com.tiancaibao.service.interfaces.coupons.biz.ICouponsService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;

@Component
public class CouponsMqServiceImpl implements ICouponsMqService, MessageListener {

	@Resource
	ICouponsService couponsService;
	@Resource
	IMqMessageService mqMessageSender;

	private static final Logger log = LoggerFactory.getLogger(CouponsMqServiceImpl.class);
	
	@Override
	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userId = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");
			String serviceName = (String) json.get("serviceName");
			mqMessageSender.updateMqMessageReceiveStatus(messageId, "ReceiveSuccess");
			grantCoupons(userId, serviceName,json);
			log.info("加息券服务 CouponsMqService 接收到信息" + receiverMessage +"\n" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean grantCoupons(Long userId, String serviceName,JSONObject jsonMessage) {
		boolean ok = false;
		try{
			switch (serviceName) {
				case "realname": // 实名发放
					couponsService.realNameVerifySuccessGrantFixedCashCoupons(userId);
					couponsService.realNameVerifySuccessGrantCurrentInterestCoupons(userId);
					ok = true;
					break;
				case "bindBank": // 绑卡发放给邀请人
					couponsService.bindBankCardSuccessGrantFixedCashCoupons(userId);
					ok = true;
					break;
				case "firstInvest":// 首投
					couponsService.firstInvestAddInterestCoupon(userId, jsonMessage.getString("remark"));
					ok = true;
					break;
				default:
					ok = true;
					break;
				}
			
			mqMessageSender.updateMqMessageProcessStatus((Integer)jsonMessage.get("messageId"), Mq.Process_Status);

		}catch(Exception e){
			e.printStackTrace();
		}	
		return ok;
	}

	public static void main(String[] args) {

	}

}
