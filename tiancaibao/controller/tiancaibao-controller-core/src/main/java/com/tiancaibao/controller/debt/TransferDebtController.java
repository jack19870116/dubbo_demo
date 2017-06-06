package com.tiancaibao.controller.debt;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiancaibao.service.interfaces.debt.DebtBuyService;

@Controller
@RequestMapping("/transferDebt")
public class TransferDebtController {
	@Resource
	DebtBuyService debtBuyService;

	@RequestMapping(value = "/delieverDebt")
	@ResponseBody
	public String getValue(HttpServletRequest request, Long userId, Long amount, String sinNo) {
		String string = debtBuyService.TransferDeliver(userId, amount, sinNo);
		return string;
	}
}
