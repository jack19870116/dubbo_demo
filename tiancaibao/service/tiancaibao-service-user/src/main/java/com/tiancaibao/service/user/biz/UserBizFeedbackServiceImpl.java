package com.tiancaibao.service.user.biz;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.service.interfaces.user.IUserFeedBackService;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.service.interfaces.user.biz.IUserBizFeedbackServivce;
import com.tiancaibao.validate.Validate;

@Service("userFeedbackServivce")
public class UserBizFeedbackServiceImpl implements IUserBizFeedbackServivce{

	@Resource
	private IUserService userService;

	@Resource
	private IUserFeedBackService feedBackService;
	private static final Logger log = LoggerFactory.getLogger(UserBizFeedbackServiceImpl.class);
	
	@Override
	public String  postFeedback(Integer userid,String content,String emailOrPhone){
		
		JSONObject json = new JSONObject();
		
		try {
			Validate.validateUserFeedBackContent(content);
			feedBackService.saveToFeedBack(userid,content,emailOrPhone);
			json.put("success",true);
			return json.toString();
		} catch (ServiceException e) {
			json.put("success",false);
			json.put("error",e.getMessage());
			return json.toString();
		} catch (Exception e) {
			json.put("success",false);
			json.put("error",e.getMessage());
			e.printStackTrace();
			log.error(" 用户信息反馈处理:"+e.getMessage());
		}
		return json.toString();
	}
	
}
