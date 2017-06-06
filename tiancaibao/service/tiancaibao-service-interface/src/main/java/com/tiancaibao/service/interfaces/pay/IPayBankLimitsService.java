package com.tiancaibao.service.interfaces.pay;

import java.util.List;

import com.tiancaibao.pojo.pay.PayBankLimits;

public interface IPayBankLimitsService {

	/**
	 * 查询所有银行限额
	 * 
	 * @return
	 */

	public List<PayBankLimits> selectGetAll();

}
