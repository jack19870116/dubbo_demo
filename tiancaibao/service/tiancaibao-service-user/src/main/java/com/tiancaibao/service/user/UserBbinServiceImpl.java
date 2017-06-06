package com.tiancaibao.service.user;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.user.UserBbinMapper;
import com.tiancaibao.pojo.user.UserBbin;
import com.tiancaibao.service.interfaces.user.IUserBbinService;

@Service("userBbinService")
public class UserBbinServiceImpl implements IUserBbinService {

	@Resource
	UserBbinMapper userBbinMapper;

	@Override
	public int insertintoUserBbin(Long userId, Integer bbin_amount, Long amount, Byte type) {
		UserBbin userBbin = new UserBbin();
		userBbin.setUserId(userId);
		userBbin.setBbinAmount(bbin_amount);
		userBbin.setAmount(amount);
		userBbin.setCreatedAt(new Date());
		userBbin.setType(type);
		return userBbinMapper.insertSelective(userBbin);
	}

}
