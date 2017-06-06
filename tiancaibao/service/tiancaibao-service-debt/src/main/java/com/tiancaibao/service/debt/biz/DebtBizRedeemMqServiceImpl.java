package com.tiancaibao.service.debt.biz;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.constants.Mq;
import com.tiancaibao.pojo.debt.DebtCurrentReceive;
import com.tiancaibao.pojo.debt.DebtCurrentUserHolding;
import com.tiancaibao.pojo.debt.DebtOriginalAssetBills;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentReceiveService;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentTransferService;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentUserHoldingService;
import com.tiancaibao.service.interfaces.debt.IDebtOriginalAssetBillsService;
import com.tiancaibao.service.interfaces.debt.biz.IDebtBizRedeemMqService;
import com.tiancaibao.service.interfaces.mq.IMqMessageService;

@Service
public class DebtBizRedeemMqServiceImpl implements IDebtBizRedeemMqService, MessageListener {
	@Resource
	IMqMessageService mqMessageSender;
	@Resource
	private IDebtCurrentTransferService debtCurrentTransferService;
	@Resource
	private IDebtCurrentReceiveService debtCurrentReceiveService;
	@Resource
	private IDebtCurrentUserHoldingService debtCurrentUserHoldingService;
	@Resource
	private IDebtOriginalAssetBillsService debtOriginalAssetBillsService;

	public void onMessage(Message message) {
		try {
			String receiverMessage = URLDecoder.decode(((TextMessage) message).getText(), "UTF-8");
			JSONObject json = JSONObject.parseObject(receiverMessage);
			Long userId = Long.parseLong(json.get("userId").toString());
			Integer messageId = (Integer) json.get("messageId");
			String serviceName = (String) json.get("serviceName");
			System.out.println("接受信息" + receiverMessage);
			redeemProcessingOperation(userId, serviceName, json);
			mqMessageSender.updateMqMessageReceiveStatus(messageId, Mq.Receive_Status);
		} catch (UnsupportedEncodingException | JMSException e) {
			e.printStackTrace();
		}

	}

	@Transactional
	public boolean redeemProcessingOperation(Long userId, String serviceName, JSONObject message) {

		boolean ok = false;
		switch (serviceName) {
		case "userRedeem": // 用户赎回操作>同步触发婷婷帐号>放到债转区
			Long amount = Long.parseLong((message.get("amount").toString()));
			List<DebtCurrentUserHolding> list = debtCurrentUserHoldingService
					.getDebtCurrentUserHoldingListByAmountOrder(userId);
			if (list != null && list.size() > 0) {
				// 赎回金额小于用户一条记录的债权
				DebtCurrentUserHolding holdOne = list.get(0);
				if (holdOne.getAmount() / 10000 > amount) {
					// 获取用户持有债权实体
					DebtCurrentUserHolding debtCurrentUserHolding = debtCurrentUserHoldingService
							.getDebtCurrentUserHolding(holdOne.getId());
					// 获取债权资产账单实体
					DebtOriginalAssetBills debtOriginalAssetBills = debtOriginalAssetBillsService
							.getDebtOriginalAssetBills(debtCurrentUserHolding.getDebtOriginalAssetId());
					// 添加转让债权记录
					long debtCurrentTransferId = debtCurrentTransferService.addDebtCurrentTransfer(userId,
							debtCurrentUserHolding.getInvestId(), debtCurrentUserHolding.getDebtOriginalAssetId(),
							Integer.parseInt(debtOriginalAssetBills.getSaleRate().toString()), 1,
							debtCurrentUserHolding.getOriginalAmount(), amount * 10000,
							debtCurrentUserHolding.getOriginalCount(), (int) (amount / 100),
							debtOriginalAssetBills.getEndDate());
					// 更新用户的债权
					debtCurrentUserHoldingService.updateDebtCurrentUserHolding(holdOne.getId(),
							holdOne.getCurrentCount() - (int) (amount / 100), holdOne.getAmount() - amount * 10000,
							debtCurrentTransferId);
					// 将债权直接放在婷婷账户
					long addDebtCurrentRecieveId = debtCurrentReceiveService.addDebtCurrentRecieve(10001l,
							debtCurrentUserHolding.getDebtOriginalAssetId(), debtCurrentUserHolding.getInvestId(),
							userId, amount * 10000, 0l, 1, "123456", (int) (amount / 100), debtCurrentTransferId);
					DebtCurrentReceive debtCurrentReceive = debtCurrentReceiveService
							.getDebtCurrentRecieve(addDebtCurrentRecieveId);
					// 在用户债权表中为婷婷添加一条记录
					debtCurrentUserHoldingService.addDebtCurrentUserHolding(10001l, debtCurrentReceive.getInvestId(),
							debtCurrentReceive.getDebtOriginalAssetId(), debtCurrentReceive.getCount(),
							debtCurrentUserHolding.getOriginalCount(), amount,
							debtCurrentUserHolding.getOriginalAmount());
					// 放到债转区
					
				} else {

				}
			}
			ok = true;
			break;
		case "B": // 先更新用户,再增加一条

			break;
		case "C":// 未定
			break;
		default:
			break;
		}
		return ok;
	}

}
