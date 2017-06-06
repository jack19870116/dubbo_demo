//package com.tiancaibao.controller.debt;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.tiancaibao.service.interfaces.debt.biz.IDebtBizRedeemService;
//
//@Controller
//@RequestMapping("/redeemDebt")
//public class RedeemDebtController {
//	@Resource
//	private IDebtBizRedeemService debtBizRedeemService;
//
//	/**
//	 * 转让退出页
//	 * 
//	 * @param request
//	 * @param token
//	 * @return
//	 */
//	@RequestMapping(value = "/transferOut.do", method = { RequestMethod.POST })
//	@ResponseBody
//	public String postTransferOutPage(HttpServletRequest request, String token) {
//		return debtBizRedeemService.postTransferOutPage(token);
//	}
//
//	/**
//	 * 赎回匹配
//	 * 
//	 * @param request
//	 * @param token
//	 * @param count
//	 * @return
//	 */
//	@RequestMapping(value = "/redeemingMatch.do", method = { RequestMethod.POST })
//	@ResponseBody
//	public String postMedeemingMatch(HttpServletRequest request, String token, int count) {
//		return debtBizRedeemService.postMedeemingMatch(token, count);
//	}
//
//	/**
//	 * 确认转让
//	 * 
//	 * @param request
//	 * @param token
//	 * @param count
//	 * @return
//	 */
//	@RequestMapping(value = "/confirmTransfer.do", method = { RequestMethod.POST })
//	@ResponseBody
//	public String postConfirmTransfer(HttpServletRequest request, String token, int count) {
//		return debtBizRedeemService.postConfirmTransfer(token, count);
//	}
//}
