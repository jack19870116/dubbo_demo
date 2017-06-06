package com.tiancaibao.service.test.pay;

import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBankCardResponseParam;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;

@ContextConfiguration(locations = { "classpath:spring-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SinaPayServiceImplTest {
	@Resource
	private IPaySinaPayService sinaPayService;
	/*
	 * @Resource private SinaPaySend sinaPaySend;
	 */ /*
		 * @Resource private SinaPaySendService sinaPaySendService;
		 */
		
	
	@Test
	public void testCreateOrderId() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery_balance() {
		/*
		 * QueryBalanceRequestParam qbrpar = new QueryBalanceRequestParam();
		 * qbrpar.setService("query_balance"); qbrpar.setIdentity_id(40L+"");
		 * qbrpar.setIdentity_type(SinaPay.SINAPAY_IDENTITY_TYPE);
		 * qbrpar.setAccount_type(SinaPay.ACCOUNT_TYPE);
		 * QueryBalanceResponseParam send2 =
		 * sinaPaySendService.send2SinPay(qbrpar,
		 * QueryBalanceResponseParam.class); System.out.println(send2);
		 */
		QueryBalanceResponseParam query_balance = sinaPayService.query_balance(40L);
		System.out.println(query_balance.getBalance());
	}

	@Test
	public void testCreate_hosting_withdraw() {
		sinaPayService.create_hosting_withdraw(9L, "12345678", 20.32, 2F, "BASIC",
				"http://localhost:8089/JavaDemo/Send", "http://localhost:8089/JavaDemo/index.html", "app",
				"192.168.3.35");
	}

	@Test
	public void testQuery_is_set_pay_password() {
		sinaPayService.query_is_set_pay_password(9L);
	}

	@Test
	public void testQuery_verify() {
		sinaPayService.query_verify(9L, null);
	}

	@Test
	public void testCreate_activate_member() {
		sinaPayService.create_activate_member(4000L, "192.168.3.35");
	}

	@Test
	public void testSet_real_name() {
		sinaPayService.set_real_name(40L, "342221199109026030", "三四五", "101.231.34.38");
	}

	@Test
	public void testBinding_verify() {
		sinaPayService.binding_verify(40L, "17755702902", "101.231.34.38");
	}

	@Test
	public void testBinding_bank_card() {
	}

	@Test
	public void testBinding_bank_card_advance() {
	
	}

	@Test
	public void testQuery_bank_card() {
		QueryBankCardResponseParam tt = sinaPayService.query_bank_card(9L);
		System.out.println(tt.getCard_list());
	}

	@Test
	public void testUnbinding_bank_card() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnbinding_bank_card_advance() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery_hosting_deposit() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery_hosting_trade() {
		fail("Not yet implemented");
	}

	@Test
	public void testOperate_col() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate_hosting_deposit() {
		String sina = sinaPayService.create_hosting_deposit("12095L", 12.36, "http://192.168.3.4/recharge/notify/12095/weixin", 9L,  "http://weixin.51tiancai.com/callback/recharge-notify","192.168.3.4");
	System.out.println(sina);
	}

	@Test
	public void testJSON() {
		String str = "{11:12}";
		StringBuffer b = new StringBuffer();
		Matcher m = Pattern.compile("\\\\u([0-9a-fA-F]{4})").matcher(str);
		while (m.find()) {
			b.append((char) Integer.parseInt(m.group(1), 16));
		}
		System.out.println(b.toString());
	}

}
