package com.tiancaibao.service.user;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.user.UserFeedBacksMapper;
import com.tiancaibao.pojo.user.UserFeedBacks;
import com.tiancaibao.service.interfaces.user.IUserFeedBackService;

@Service("feedBackService")
public class UserFeedBackServiceImpl implements IUserFeedBackService{
	
	@Resource
	private UserFeedBacksMapper feedBacksMapper;
	
	/**
	 * 保存用户反馈
	 * @param userid   
	 * @param content
	 * @param email
	 */
	@Override
	public void saveToFeedBack(Integer userid, String content, String email) {
		UserFeedBacks fb = new UserFeedBacks();
		fb.setUserId(userid.longValue());
		fb.setContent(content);
		fb.setEmail(email);
		fb.setCreatedAt(new Date());
		fb.setUpdatedAt(new Date());
		int insertSelective = feedBacksMapper.insertSelective(fb);

	}
}
