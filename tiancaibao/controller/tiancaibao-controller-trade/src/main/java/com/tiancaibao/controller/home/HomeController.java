/*package com.tiancaibao.controller.home;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.Actives;
import com.tiancaibao.pojo.AddInterestCoupons;
import com.tiancaibao.pojo.SystemAssets;
import com.tiancaibao.pojo.Users;
import com.tiancaibao.service.activity.ActivityService;
import com.tiancaibao.service.addinterest.AddInterestService;
import com.tiancaibao.service.current.CurrentService;
import com.tiancaibao.service.fix.FixedTermService;
import com.tiancaibao.service.system.SystemService;
import com.tiancaibao.service.trade.InvestService;
import com.tiancaibao.service.user.UserService;
import com.tiancaibao.utils.DateUtil;
import com.tiancaibao.utils.NumberFormat;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("/home")
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);
	@Resource
	private SystemService systemService;
	@Resource
	private UserService userService;
	@Resource
	private AddInterestService addInterestService;
	@Resource
	private ActivityService activityService;
	@Resource
	private Jedis jedis;
	@Resource
	private InvestService investService;
	// 活期
	@Resource
	private CurrentService currentService;
	// 定期
	@Resource
	private FixedTermService fixedTermService;

	public String homeIndex(String token) {
		JSONObject json = new JSONObject();
		try {
			List<SystemAssets> systemAssetslist = systemService.selectSystemAsset();
			for (SystemAssets systemAsset : systemAssetslist) {
				if (systemAsset.getDays() == 1) {
					Long rate = systemAsset.getRate();
					// 如果已经登录并且使用了加息券,复合年化收益把加息券的附加收益加上
					if (StringUtils.isNotBlank(token)) {
						Users user = userService.selectUserByToken(token);
						if (user != null) {
							AddInterestCoupons aic = addInterestService.selectAddInterestCouponByUserIdAndUsedAtToday(
									user.getId(), DateUtil.getDayStartDate());
							if (aic != null) {
								rate = rate + aic.getValue();
							}
						}
					}
					systemAsset.setInterest(NumberFormat
							.doubleSplitTwoDecimal(10000 * (Math.pow((rate + 0.0 / 100) + 1, 1 + 1.0 / 365) - 1)));
				}
				// 定期
				if (systemAsset.getDays() != 1) {
					Double extraRate = 0.0;
					// 如果已经登录并且使用了加息券,复合年化收益把加息券的附加收益加上
					if (StringUtils.isNotBlank(token)) {
						Users user = userService.selectUserByToken(token);
						if (user != null) {
							// 2016 8月10号 活动 金银铜 投定期3月6月加息
							Actives action = activityService.selectActiveByNameAndIsClose("铜牌以上会员定期专享加息0.5%", 0);
							if (action != null && action.getStartTime().compareTo(new Date()) <= 0
									&& action.getEndTime().compareTo(new Date()) >= 0 && user.getTalentValue() > 299
									&& systemAsset.getDays() != 30) {
								extraRate = 0.5;
							}
						}
					}
					systemAsset.setInterest(NumberFormat.doubleSplitTwoDecimal(
							10000 * (systemAsset.getRate() + extraRate) / 100 * (systemAsset.getDays() / 360)));

				}
				// 关闭购买
				if (DateUtil.isBetweenNHourWithMHour(0, 2) || systemAsset.getRemainAmount() < 0) {
					systemAsset.setRemainAmount(0L);
				}
			}
			// empty(unserialize(Cache::get('Home'))['time']) || time() -
			// unserialize(Cache::get('Home'))['time'] > 24*3600
			// 统一处理 redis
			// if(){
			// 累计定期收益
			Long sumInterestFix = fixedTermService.selectSumInterestFix();
			Double total_fixed_invest_amount = NumberFormat.doubleSplitTwoDecimal((sumInterestFix+0.0)/10000);
			// 累计注册用户
			Integer registerCount = userService.selectRegisterCount();
			// 累计活期收益
			Long sumCurrentAmount = currentService.selectSumAmountAssetIncreaseRecord();
			Double total_current_invest_amount = NumberFormat.doubleSplitTwoDecimal((sumCurrentAmount+0.0)/10000);
			// 累计收益
			Double totalInvest = total_fixed_invest_amount + total_current_invest_amount;
			// 累计交易人次
			Integer totalInvestPeople = investService.selectCountInvestRecord();
			// 累计投资金额
			Long totalInvestAmount = investService.selectSumAmountInvestRecord();
			Double total_invest_amount = NumberFormat.doubleSplitTwoDecimal((totalInvestAmount+0.0)/10000);
			// }
			json.put("success",true);
			json.put("total_fixed_invest_amount", total_fixed_invest_amount);//累计定期收益
			json.put("total_current_invest_amount", total_current_invest_amount);//累计活期收益
			json.put("total_invest", totalInvest);//累计总收益
			json.put("total_invest_people", totalInvestPeople);//累计交易人次
			json.put("total_invest_amount", total_invest_amount);//累计投资金额
			json.put("system_asset",systemAssetslist);//当前利率
			json.put("totel_register_user", registerCount);//累计注册用户
		} catch (Exception e) {
			logger.error("显示网站主页:" + e.getMessage());
		}
		return json.toString();
	}

}
*/