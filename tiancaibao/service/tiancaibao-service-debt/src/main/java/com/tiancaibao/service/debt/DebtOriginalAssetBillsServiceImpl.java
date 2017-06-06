package com.tiancaibao.service.debt;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.debt.DebtOriginalAssetBillsMapper;
import com.tiancaibao.pojo.debt.DebtOriginalAssetBills;
import com.tiancaibao.service.interfaces.debt.IDebtOriginalAssetBillsService;

@Service("debtOriginalAssetBillsService")
public class DebtOriginalAssetBillsServiceImpl implements IDebtOriginalAssetBillsService {
	@Resource
	private DebtOriginalAssetBillsMapper debtOriginalAssetBillsMapper;

	@Override
	public DebtOriginalAssetBills getDebtOriginalAssetBills(long id) {
		return debtOriginalAssetBillsMapper.selectByPrimaryKey(id);
	}

}
