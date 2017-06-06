package com.tiancaibao.controller.activity;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pojo.Lottery;
import com.tiancaibao.pojo.Users;
/**
 * 九宫格抽奖
 */
import com.tiancaibao.service.activity.ActivityService;
import com.tiancaibao.service.user.user.UserService;

@Controller
@RequestMapping("/activity")
public class LotteryDrawController {

	@Resource
	private ActivityService activityService;
	@Resource
	private UserService userService;

	@RequestMapping("/joinLotteryDraw.do")
	public String joinLotteryDraw(String token){
		JSONObject json = new JSONObject();
		try {
			//检查活动是否有效
			activityService.isValidActive(); 
			Users user = userService.selectUserByToken(token);
			 //检查用户是否有抽奖资格 在抽奖动作之前应有过至少一笔定期投资
			activityService.isUserHaveQualification(user.getId());
			//检查用户今天是否参加过活动
			activityService.isAlreadyAttendToday(user.getId());
			//抽取奖品
			Lottery prize = activityService.extractRandomPrize();
			//写中奖数据库
			activityService.savePrize(user,prize);
		 	json.put("success",true);
			json.put("data",prize);
			json.put("message", "恭喜你获得"+prize.getGoodsName()+",抽奖成功,奖品发放完毕!");
		}catch(ServiceException e){
			json.put("success",false);
			json.put("error",e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return json.toString();
	}
}
