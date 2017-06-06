package com.tiancaibao.service.debt;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.debt.DebtCurrentUserHoldingMapper;
import com.tiancaibao.pojo.debt.DebtCurrentUserHolding;
import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.debt.DebtCurrentUserHoldingExample;
import com.tiancaibao.pojo.debt.DebtCurrentUserHoldingExample.Criteria;
import com.tiancaibao.service.interfaces.debt.IDebtCurrentUserHoldingService;

@Service("debtCurrentUserHoldingService")
public class DebtCurrentUserHoldingServiceImpl implements IDebtCurrentUserHoldingService {
	@Resource
	private DebtCurrentUserHoldingMapper debtCurrentUserHoldingMapper;

	@Override
	public DebtCurrentUserHolding getDebtCurrentUserHolding(long id) {
		return debtCurrentUserHoldingMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新用户持有债权信息
	 */
	@Override
	public void updateDebtCurrentUserHolding(long id, int currentCount, long amount, long transferId) {
		DebtCurrentUserHolding debtCurrentUserHolding = new DebtCurrentUserHolding();
		debtCurrentUserHolding.setId(id);
		debtCurrentUserHolding.setCurrentCount(currentCount);
		debtCurrentUserHolding.setAmount(amount);
		debtCurrentUserHolding.setTransferId(transferId);
		debtCurrentUserHoldingMapper.updateByPrimaryKeySelective(debtCurrentUserHolding);
	}

	@Override
	public void updateDebtCurrentUserHolding(Long amount, Integer currentCount, Date date, Long userHoldingId) {
		DebtCurrentUserHolding holdTran = new DebtCurrentUserHolding();
		holdTran.setAmount(amount);
		holdTran.setCurrentCount(currentCount);
		holdTran.setUpdatedAt(date);
		DebtCurrentUserHoldingExample example = new DebtCurrentUserHoldingExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(userHoldingId);
		debtCurrentUserHoldingMapper.updateByExampleSelective(holdTran, example);

	}

	@Override
	public void addDebtCurrentUserHolding(Long userId, Long investId, Long debtOriginalAssetId, Integer currentCount,
			Integer originalCount, Long amount, Long originalAmount) {
		DebtCurrentUserHolding holdRec = new DebtCurrentUserHolding();
		holdRec.setUserId(userId);
		holdRec.setInvestId(investId);
		holdRec.setDebtOriginalAssetId(debtOriginalAssetId);
		holdRec.setCurrentCount(currentCount);
		holdRec.setOriginalCount(originalCount);
		holdRec.setAmount(amount);
		holdRec.setOriginalAmount(originalAmount);
		debtCurrentUserHoldingMapper.insert(holdRec);
	}

	/**
	 * 根据用户id获取用户债权列表以金额排序
	 */
	@Override
	public List<DebtCurrentUserHolding> getDebtCurrentUserHoldingListByAmountOrder(long userId) {
		DebtCurrentUserHoldingExample example = new DebtCurrentUserHoldingExample();
		example.createCriteria().andUserIdEqualTo(userId);
		example.setOrderByClause("amount desc");
		return debtCurrentUserHoldingMapper.selectByExample(example);
	}

	/**
	 * 根据用户id获取用户当前持有债权的总金额
	 */
	@Override
	public long getDebtUserHoldingAmountAll(long userId) {
		return debtCurrentUserHoldingMapper.getDebtUserHoldingAmountAll(userId);
	}

	/**
	 * 随心转投资未满24h的总金额
	 */
	@Override
	public long selectAmountByCondtion(long userId) {
		return debtCurrentUserHoldingMapper.selectAmountByCondtion(userId);
	}

	/**
	 * 用户可转份数
	 */
	@Override
	public long selectTransferableCount(Long userId) {
		return debtCurrentUserHoldingMapper.selectTransferableCount(userId);
	}

	/**
	 * 获取用户当前持有的可转活期债权
	 */
	@Override
	public List<DebtCurrentUserHolding> selectCurrentTransferableDebtRecords(Long userId) {
		return debtCurrentUserHoldingMapper.selectCurrentTransferableDebtRecords(userId);
	}
}
