package com.tiancaibao.controller.trade;

import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.transport.https.HttpsClientTransport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.service.interfaces.trade.recharge.biz.ICallBackTradeRecharge;
import com.tiancaibao.utils.ValidateUtil;

@Controller
@RequestMapping("/rechargeCallBack")
public class CallBackRechargeController {

	@Resource
	ICallBackTradeRecharge callBackTradeRecharge;

	/**
	 * 回调充值
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/indexNotify.do", method = { RequestMethod.POST })
	@ResponseBody
	public void rechargeNotify(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = ValidateUtil.getMap(request);
		String rechargeNotify = callBackTradeRecharge.RechargeNotify(map);
		if (rechargeNotify != null) {
			try {
				JSONObject json = JSONObject.parseObject(rechargeNotify);

				if (json.get("SUCCESS").equals("SUCCESS")) {
					PrintWriter writer = response.getWriter();
					writer.println(json.get("SUCCESS").toString());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
