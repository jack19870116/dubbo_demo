/*package com.tiancaibao.controller.callback;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tiancaibao.service.impl.sinapay.SinaPayService;
import com.tiancaibao.utils.RequestUtil;

@Controller
@RequestMapping("/callback")
public class CallbackController {

	@Resource
	private SinaPayService sinaPayService;

	@RequestMapping(value = "/rechargeNotify.do", method = { RequestMethod.POST })
	@ResponseBody
	public String rechargeNotify(HttpServletRequest request, HttpServletResponse response) {
		try {
			String receivePostJson = RequestUtil.receivePostJson(request);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
*/