package com.tiancaibao.service.test.user;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tiancaibao.service.interfaces.user.IUserBlackListService;

@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BlackListServiceImplTest {
	
	@Resource
	private IUserBlackListService userBlackListDataServiceInterface;
	
	@Test
	public void testSelectUserLockAmount() {
		Long userId = 3L;
		Byte blacklistType = 1;
		long lockAmountUnDelete = userBlackListDataServiceInterface.selectUserLockAmount(userId,blacklistType);		
		System.out.println("\n取出用户 ID ="+ userId +"未软删除的锁定金额是 " + lockAmountUnDelete +"\n");
		assertEquals("测试取出未软删除的锁定金额出错",50L, lockAmountUnDelete);
		
		userId = 2L;
		long lockAmountDelete = userBlackListDataServiceInterface.selectUserLockAmount(2L, (byte)1);		
		System.out.println("\n取出用户 ID = " + userId +"未软删除的锁定金额是 " + lockAmountDelete + "\n");
		assertEquals("测试取出已软删除的锁定金额出错",0L, lockAmountDelete);
	}

}
