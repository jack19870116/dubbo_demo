package com.tiancaibao.service.debt.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.debt.DebtCurrentUserHolding;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentUserHoldingService;
import com.tiancaibao.service.interfaces.debt.biz.IDebtBizRedeemService;
import com.tiancaibao.service.interfaces.user.IUserService;

@Service("debtBizRedeemService")
public class IDebtBizRedeemServiceImpl implements IDebtBizRedeemService {
	@Resource
	private IUserService userServcie;
	@Resource
	private IDebtCurrentUserHoldingService debtCurrentUserHoldingService;

	/**
	 * 转让退出页
	 */
	@Override
	public String postTransferOutPage(String token) {
		JSONObject json = new JSONObject();
		Long userId = userServcie.selectUserIdByToken(token);
		// 随心转投资未满24h的总金额
		long nonTransferableAmount = debtCurrentUserHoldingService.selectAmountByCondtion(userId);
		json.put("nonTransferableAmount", nonTransferableAmount / 10000);
		// 用户可转份数
		long transferableCount = debtCurrentUserHoldingService.selectTransferableCount(userId);
		json.put("transferableCount", transferableCount);
		// 用户可转金额（待确定）

		return json.toString();
	}

	/**
	 * 赎回匹配
	 */
	@Override
	public String postMedeemingMatch(String token, int count) {
		int currentCount = count;
		// 匹配金额
		long matchAmount = 0l;
		JSONObject json = new JSONObject();
		Long userId = userServcie.selectUserIdByToken(token);
		// 用户可转份数
		long transferableCount = debtCurrentUserHoldingService.selectTransferableCount(userId);
		if (count > transferableCount) {
			json.put("success", false);
			json.put("error", "要转让的分数大于可转让分数");
		} else {
			// 开始匹配（1）获取用户当前持有的可转活期债权
			List<DebtCurrentUserHolding> list = debtCurrentUserHoldingService
					.selectCurrentTransferableDebtRecords(userId);
			if (list != null && list.size() > 0) {
				for (DebtCurrentUserHolding debtCurrentUserHolding : list) {
					if (debtCurrentUserHolding.getCurrentCount() > currentCount) {
						// 获取债转金额

					} else {
						currentCount -= debtCurrentUserHolding.getCurrentCount();
						// 获取债转金额
					}

				}
				json.put("success", true);
				json.put("matchAmount", matchAmount);
			}
		}
		return json.toString();
	}

	/**
	 * 确认转让
	 */
	@Override
	public String postConfirmTransfer(String token, int count) {
		int currentCount = count;
		Long userId = userServcie.selectUserIdByToken(token);
		JSONObject json = new JSONObject();
		// 用户可转份数
		long transferableCount = debtCurrentUserHoldingService.selectTransferableCount(userId);
		if (count > transferableCount) {
			json.put("success", false);
			json.put("error", "要转让的分数大于可转让分数");
		} else {
			// 开始匹配（1）获取用户当前持有的可转活期债权
			List<DebtCurrentUserHolding> list = debtCurrentUserHoldingService
					.selectCurrentTransferableDebtRecords(userId);
			if (list != null && list.size() > 0) {
				for (DebtCurrentUserHolding debtCurrentUserHolding : list) {
					if (debtCurrentUserHolding.getCurrentCount() > currentCount) {
						// 获取债转金额

					} else {
						currentCount -= debtCurrentUserHolding.getCurrentCount();
						// 获取债转金额
					}

				}
				json.put("success", true);
				json.put("msg", "转让成功");
			}
		}
		return json.toString();
	}

}
