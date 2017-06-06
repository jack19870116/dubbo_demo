package com.tiancaibao.service.test.user;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.util.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.user.IUserService;

@ContextConfiguration(locations = {"classpath:spring/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Resource 
	private IUserService userService;
	

	@Test
	public void testSelectUserByToken() {
		System.out.println("\ntesting SelectUserByToken!\n");
	 
	}


	@Test
	public void testUpdateUserAmountById() {
		System.out.println("\ntesting UpdateUserAmountById!\n");
		Boolean updateUserCurrentAmountById =  userService.updateUserCurrentAmountById(2L, 8888L,9999L);
		Assert.isTrue(updateUserCurrentAmountById,"更新用户活期余额失败");
		Users user = userService.selectUserById(2L);
		Assert.isTrue(user.getAmount().equals(8888L), "更新用户活期余额失败");
	}

}
