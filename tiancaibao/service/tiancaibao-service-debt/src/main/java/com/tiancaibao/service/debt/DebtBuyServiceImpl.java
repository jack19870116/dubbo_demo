package com.tiancaibao.service.debt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tiancaibao.pojo.debt.DebtCurrentTransfer;
import com.tiancaibao.service.interfaces.debt.DebtBuyService;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentReceiveService;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentTransferService;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentUserHoldingService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;

@Service("debtBuyService")
public class DebtBuyServiceImpl implements DebtBuyService {

	@Resource
	IMqMessageService mqMessageSender;
	@Resource
	IDebtCurrentTransferService debtCurrentTransferService;
	@Resource
	IDebtCurrentReceiveService debtCurrentReceiveService;
	@Resource
	IDebtCurrentUserHoldingService debtCurrentUserHoldingService;


	@Transactional
	@Override
	public String TransferDeliver(Long userId, Long amount, String sinNo) {
		amount = amount * 10000;
		Map<String, Object> params = new HashMap<String, Object>();
		List<DebtCurrentTransfer> transferList = debtCurrentTransferService.selectTransferMatch(params);
		List<Long> ids = new ArrayList<Long>();
		long amountTotal = 0;
		long amountPart = 0;
		List<Long> amounts = new ArrayList<Long>();
		for (int i = 0; i < transferList.size(); i++) {
			amountTotal = transferList.get(i).getAmount() + amountTotal;
			amounts.add(transferList.get(i).getAmount());
			ids.add(transferList.get(i).getId());
			if (amount <= amountTotal) {
				break;
			}
		}
		// 根据id查出符合条件的转让的债权
		params.put("ids", ids);
		List<DebtCurrentTransfer> transfer = debtCurrentTransferService.selectTransferMatch(params);
		for (int i = 0; i < transfer.size(); i++) {
			int status = 0;
			long amountNow = 0l;
			int count = 0;
			// 第一种情况 第一条满足 用户的购买的金额
			if (amount <= transfer.get(0).getAmount()) {
				// 更新活期债券池的金额和份数
				if (amount.equals(transfer.get(0).getAmount())) {
					// 状态3 全部转让
					status = 3;
					amountNow = 0l;
					count = 0;
				} else {
					// 状态2 部分转让
					status = 2;
					amountNow = transfer.get(0).getAmount() - amount;
					count = Integer.parseInt(String.valueOf((transfer.get(0).getAmount() - amount))) / 100;
				}
				debtCurrentTransferService.updateDebtCurrentTransfer(transfer.get(0).getId(), status, amountNow, count);
				// 往债权接收表里插入数据
				DebtCurrentTransfer currentTransfer = transfer.get(0);
				debtCurrentReceiveService.addDebtCurrentRecieve(userId,currentTransfer.getDebtOriginalAssetId(),currentTransfer.getInvestId(),currentTransfer.getUserId(),
						amount,0L,1,sinNo,Integer.parseInt(String.valueOf(amount)) / 100,currentTransfer.getId());
				// 更新用户的持有表
				// 首先减少转出人的金额和份数
				debtCurrentUserHoldingService.updateDebtCurrentUserHolding(transfer.get(0).getAmount() - amount,Integer.parseInt(String.valueOf(transfer.get(0).getAmount() - amount)) / 100,
						new Date(),Long.valueOf(currentTransfer.getUserHoldingId()));
				// 增加承接人 的 用户持有记录
				debtCurrentUserHoldingService.addDebtCurrentUserHolding(userId,currentTransfer.getInvestId(),currentTransfer.getDebtOriginalAssetId(),
						Integer.parseInt(String.valueOf(amount)) / 100,Integer.parseInt(String.valueOf(amount)) / 100,amount,amount);
				break;
			} else {
				/*
				 * 最大的金额的债权不够用户购买的债权，需要拼接 这边查出来得数 肯定是最后一个不满，前面的肯定已经满了
				 */
				if (i == transfer.size() - 1) {
					if ((amount - amountPart) == transfer.get(i).getAmount()) {
						// 状态3 全部转让
						status = 3;
						amountNow = 0l;
						count = 0;
					} else {
						// 状态2 部分转让
						status = 2;
						amountNow = transfer.get(i).getAmount() - (amount - amountPart);
						count = Integer.parseInt(String.valueOf(transfer.get(i).getAmount() - (amount - amountPart)))
								/ 100;
					}
					debtCurrentTransferService.updateDebtCurrentTransfer(transfer.get(i).getId(), status, amountNow,
							count);
					// 往债权接收表里插入数据
					DebtCurrentTransfer currentTransfer = transfer.get(i);

					debtCurrentReceiveService.addDebtCurrentRecieve(userId,currentTransfer.getDebtOriginalAssetId(),currentTransfer.getInvestId(),currentTransfer.getUserId(),
							amount - amountPart,0L,1,sinNo,Integer.parseInt(String.valueOf(amount - amountPart)) / 100,currentTransfer.getId());
					// 更新用户的持有表
					// 首先减少转出人的金额和份数
					debtCurrentUserHoldingService.updateDebtCurrentUserHolding(transfer.get(i).getAmount() - (amount - amountPart),Integer.parseInt(String.valueOf(transfer.get(i).getAmount() - (amount - amountPart)))
							/ 100,new Date(),currentTransfer.getId());
					// 增加承接人 的 用户持有记录
					debtCurrentUserHoldingService.addDebtCurrentUserHolding(userId,currentTransfer.getInvestId(),currentTransfer.getDebtOriginalAssetId(),
							Integer.parseInt(String.valueOf(amount - amountPart)) / 100,Integer.parseInt(String.valueOf(amount - amountPart)) / 100,amount - amountPart,amount - amountPart);
				} else {
					// 状态3 全部转让
					status = 3;
					amountNow = 0l;
					count = 0;
					debtCurrentTransferService.updateDebtCurrentTransfer(transfer.get(i).getId(), status, amountNow,
							count);
					// 往债权接收表里插入数据
					DebtCurrentTransfer currentTransfer = transfer.get(i);
					amountPart = currentTransfer.getAmount() + amountPart;
					debtCurrentReceiveService.addDebtCurrentRecieve(userId,currentTransfer.getDebtOriginalAssetId(),currentTransfer.getInvestId(),currentTransfer.getUserId(),
							currentTransfer.getAmount(),0L,1,sinNo,currentTransfer.getCount(),currentTransfer.getId());
					// 更新用户的持有表
					// 首先减少转出人的金额和份数
					debtCurrentUserHoldingService.updateDebtCurrentUserHolding(0L,0,new Date(),currentTransfer.getId());
					// 增加承接人 的 用户持有记录
					debtCurrentUserHoldingService.addDebtCurrentUserHolding(userId,currentTransfer.getInvestId(),currentTransfer.getDebtOriginalAssetId(),
							currentTransfer.getCount(),currentTransfer.getCount(),currentTransfer.getAmount(),currentTransfer.getAmount());
				}

			}

		}
		return "债权匹配成功";
	}

}
