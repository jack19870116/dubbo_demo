package com.tiancaibao.service.pay.biz;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pojo.pay.sina.CreateHostingCollectTradeResponseParam;
import com.tiancaibao.pojo.pay.sina.QueryBalanceResponseParam;
import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.service.interfaces.pay.IPaySinaPayService;
import com.tiancaibao.service.interfaces.pay.biz.IPaySinaPayBizServiceImpl;
import com.tiancaibao.service.interfaces.user.IUserService;
import com.tiancaibao.utils.ValidateUtil;

@Service("paySinaPayBizService")
public class PaySinaPayBizServiceImpl implements IPaySinaPayBizServiceImpl {

	@Resource
	IPaySinaPayService paySinaPayService;

	@Resource
	private IUserService userService;

	private static Logger logger = Logger.getLogger(PaySinaPayBizServiceImpl.class);

	@Override
	public String queryBalance(String token) {

		JSONObject json = new JSONObject();
		if (token == null || token.equals("")) {
			json.put("success", false);
			json.put("error", "参数不完整!");
			return json.toString();
		}

		Users users = userService.selectUserByToken(token);

		QueryBalanceResponseParam query_balance = paySinaPayService.query_balance(users.getId());
		json.put("success", true);
		json.put("token", token);
		json.put("tempArray", query_balance);
		return json.toString();
	}

	@Override
	public String createHostingCollectTrade(String token, String order_code, Double amount_coupon, String ip,
			String finishUrl) {
		// TODO Auto-generated method stub

		JSONObject json = new JSONObject();
		if (order_code == null || amount_coupon == null || ip == null || finishUrl == null || token == null) {

			json.put("success", false);
			json.put("error", "参数不完整!");
			return json.toString();

		}
		Users users = userService.selectUserByToken(token);

		CreateHostingCollectTradeResponseParam create_hosting_collect_trade = paySinaPayService
				.create_hosting_collect_trade(order_code, "1001", "我来投资", users.getId().toString(), ip, "UID",
						PropertiesUtil.getValue("DEBUG_SINAPAY_MAS_URL") + "/tenderInvest/investCallBack", finishUrl,
						amount_coupon, "BASIC");

		json.put("success", true);
		json.put("sinaURL", create_hosting_collect_trade);
		return json.toString();

	}

	@Override
	public String checkSignMsg(Map<String, String> map) {
		JSONObject json = new JSONObject();
		boolean checkSignMsg = ValidateUtil.checkSignMsg(map, map.get("sign_type"));
		if (!checkSignMsg) {
			String msg = "签名错误 or 非法请求";
			map.put("status", msg);
			logger.error("验证失败,invest-single:" + map.toString());

			json.put("success", false);
			json.put("error", "0");
			return json.toString();
		}

		json.put("success", true);
		json.put("error", "1");
		return json.toString();

	}

	@Override
	public String redeemCollectTrade() {
		// TODO Auto-generated method stub
		return null;
	}

}
