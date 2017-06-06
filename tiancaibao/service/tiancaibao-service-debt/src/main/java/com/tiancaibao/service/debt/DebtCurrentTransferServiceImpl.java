package com.tiancaibao.service.debt;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.debt.DebtCurrentTransferMapper;
import com.tiancaibao.pojo.debt.DebtCurrentTransfer;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentTransferService;

@Service("debtCurrentTransferService")
public class DebtCurrentTransferServiceImpl implements IDebtCurrentTransferService {
	@Resource
	private DebtCurrentTransferMapper debtCurrentTransferMapper;

	@Override
	public List<DebtCurrentTransfer> selectTransferMatch(Map<String, Object> params) {
		return debtCurrentTransferMapper.selectTransferMatch(params);
	}

	@Override
	public void updateDebtCurrentTransfer(Long id, Integer status, Long amount, Integer count) {
		DebtCurrentTransfer record = new DebtCurrentTransfer();
		record.setUpdatedAt(new Date());
		record.setId(id);
		record.setStatus(status);
		record.setAmount(amount);
		record.setCount(count);
		debtCurrentTransferMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public long addDebtCurrentTransfer(long userId, Long investId, Long debtOriginalAssetId, int rate, int status,
			long originalAmount, long amount, int originalCount, int count, Date endDate) {
		DebtCurrentTransfer debtCurrentTransfer = new DebtCurrentTransfer();
		debtCurrentTransfer.setAmount(amount);
		debtCurrentTransfer.setCount(count);
		debtCurrentTransfer.setCreatedAt(new Date());
		debtCurrentTransfer.setDebtOriginalAssetId(debtOriginalAssetId);
		debtCurrentTransfer.setEndDate(endDate);// 参数获取未知
		debtCurrentTransfer.setInvestId(investId);
		debtCurrentTransfer.setOriginalAmount(originalAmount);
		debtCurrentTransfer.setOriginalCount(originalCount);
		debtCurrentTransfer.setRate(rate);// 参数获取未知
		debtCurrentTransfer.setStatus(status);// 1为可被接取
		debtCurrentTransfer.setUpdatedAt(new Date());
		debtCurrentTransfer.setUserId(userId);
		debtCurrentTransferMapper.insertSelective(debtCurrentTransfer);
		return debtCurrentTransferMapper.getLastInsertId();
	}

}
