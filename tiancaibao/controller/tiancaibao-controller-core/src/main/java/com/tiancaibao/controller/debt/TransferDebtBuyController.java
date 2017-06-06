package com.tiancaibao.controller.debt;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.debt.DebtBuyService;

@Controller
@RequestMapping("/transferDebtBuy")
public class TransferDebtBuyController {
	@Resource
	DebtBuyService debtBuyService;

	@RequestMapping(value = "/debtBuy")
	@ResponseBody
	public String getValue(HttpServletRequest request, Long userId, Integer amount) {
		//String string = debtBuyService.TransferDeliver(userId, amount, sinNo);
		//return string;
		return null;
	}
}
