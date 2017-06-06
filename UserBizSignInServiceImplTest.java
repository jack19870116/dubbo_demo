package com.tiancaibao.service.user.biz;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;

@ContextConfiguration(locations = { "classpath:spring/spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserBizSignInServiceImplTest {
	@Resource
	private IMqMessageService mqMessageSender;

	@Test
	public void test() {
		JSONObject debtRedeemQueue = new JSONObject();
		debtRedeemQueue.put("servicename", "userRedem");
		debtRedeemQueue.put("userId", 97636l);
		debtRedeemQueue.put("debt_holding_id", 44l);
		debtRedeemQueue.put("message_id", 1001);
		mqMessageSender.sendMessage("debtRedeemQueue", debtRedeemQueue.toString());
	}

}
