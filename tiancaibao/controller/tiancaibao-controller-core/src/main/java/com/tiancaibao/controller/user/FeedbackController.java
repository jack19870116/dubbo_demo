package com.tiancaibao.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.user.biz.IUserBizFeedbackServivce;

/**
 * 
 * @author Mack
 *
 */


@RequestMapping("/user")
@Controller
public class FeedbackController {

	@Resource
	private IUserBizFeedbackServivce userFeedbackServivce;
	/**
	 * 用户反馈处理
	 * @param content
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/userFeedback.do",method = RequestMethod.POST)
	@ResponseBody
	public String userFeedback(Integer userid,String content,String email) {
		return userFeedbackServivce.postFeedback(userid,content, email);
	}
		
}
