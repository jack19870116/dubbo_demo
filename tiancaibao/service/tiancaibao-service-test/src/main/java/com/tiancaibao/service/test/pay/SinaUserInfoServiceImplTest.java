package com.tiancaibao.service.test.pay;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.pojo.pay.PaySinaUserInfo;
import com.tiancaibao.service.interfaces.pay.IPaySinaUserInfoService;

@ContextConfiguration(locations = {"classpath:srping/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class SinaUserInfoServiceImplTest {
	
	@Resource
	private IPaySinaUserInfoService sinaUserInfoService;
	@Test
	public void testIsRealName() {
		Integer realName = sinaUserInfoService.isRealName(10L);
		System.out.println(realName);
	}

	@Test
    @Transactional   //标明此方法需使用事务  
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚 	
	public void testSelectSinapayAmountByUserId() {
		Long amount = sinaUserInfoService.selectSinapayAmountByUserId(102952L);
		System.out.println(amount);
	}

	@Test
    @Transactional   //标明此方法需使用事务  
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚 
	public void testSelectByUserId() {
		PaySinaUserInfo sui = sinaUserInfoService.selectByUserId(102952L);
		System.out.println(sui);
	}

	@Test
    @Transactional   //标明此方法需使用事务  
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚 
	public void testUpdateByUserId() {
		PaySinaUserInfo  sinaUserInfo = new PaySinaUserInfo();
		sinaUserInfo.setUserId(102952L);
		sinaUserInfo.setSinapayAmount(2354L);
		sinaUserInfoService.updateByUserId(sinaUserInfo);
	}

	@Test
    @Transactional   //标明此方法需使用事务  
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚 
	public void testUpdateSinapayAmountById() {
		sinaUserInfoService.updateSinapayAmountById(123L, 2L);;
	}

	@Test
    @Transactional   //标明此方法需使用事务  
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚 
	public void testInsertSinaUserInfoSetSinapayBankCardAndUserId() {
		sinaUserInfoService.insertSinaUserInfoSetSinapayBankCardAndUserId(102952L,"123456789");
	}

}
