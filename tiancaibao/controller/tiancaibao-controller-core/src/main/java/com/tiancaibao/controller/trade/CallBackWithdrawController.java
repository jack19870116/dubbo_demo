package com.tiancaibao.controller.trade;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.trade.withdraw.biz.ICallBackTradeWithdraw;
import com.tiancaibao.utils.ValidateUtil;

@Controller
@RequestMapping("/withdrawCallBack")
public class CallBackWithdrawController {

	@Resource
	ICallBackTradeWithdraw callBackTradeWithdraw;

	/**
	 * 提现回调
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/indexNotify.do", method = { RequestMethod.POST})
	@ResponseBody
	public String withdrawNotify(HttpServletRequest request) {
		Map<String, String> map = ValidateUtil.getMap(request);
		return callBackTradeWithdraw.withdrawNotify(map);
	}

}
