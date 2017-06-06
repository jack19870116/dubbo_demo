package com.tiancaibao.service.debt;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.debt.DebtCurrentReceiveMapper;
import com.tiancaibao.pojo.debt.DebtCurrentReceive;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentReceiveService;

@Service("debtCurrentReceiveService")
public class DebtCurrentReceiveServiceImpl implements IDebtCurrentReceiveService {
	@Resource
	DebtCurrentReceiveMapper debtCurrentReceiveMapper;

	@Override
	public long addDebtCurrentRecieve(Long userId, Long debtOriginalAssetId, Long investId, Long transferUserId,
			Long amount, Long interest, Integer status, String sinNo, Integer count, Long transferId) {
		DebtCurrentReceive currentRecieve = new DebtCurrentReceive();
		currentRecieve.setUserId(userId);
		currentRecieve.setDebtOriginalAssetId(debtOriginalAssetId);
		currentRecieve.setInvestId(investId);
		currentRecieve.setTransferUserId(transferUserId);
		currentRecieve.setPrincipal(amount);
		currentRecieve.setInterest(interest);
		currentRecieve.setStatus(1);
		currentRecieve.setRequestNo(sinNo);
		currentRecieve.setCount(count);
		currentRecieve.setTransferId(transferId);
		debtCurrentReceiveMapper.insert(currentRecieve);
		return debtCurrentReceiveMapper.getLastInsertId();
	}

	/**
	 * 根据用户的id获取实体
	 */
	@Override
	public DebtCurrentReceive getDebtCurrentRecieve(long id) {
		return debtCurrentReceiveMapper.selectByPrimaryKey(id);
	}

}
