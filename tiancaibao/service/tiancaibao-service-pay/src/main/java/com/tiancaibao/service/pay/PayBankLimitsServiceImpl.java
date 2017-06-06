package com.tiancaibao.service.pay;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.pay.PayBankLimitsMapper;
import com.tiancaibao.pojo.pay.PayBankLimits;
import com.tiancaibao.pojo.pay.PayBankLimitsExample;
import com.tiancaibao.service.interfaces.pay.IPayBankLimitsService;

@Service("payBankLimitsService")
public class PayBankLimitsServiceImpl implements IPayBankLimitsService {

	@Resource
	PayBankLimitsMapper payBankLimitsMapper;

	private static Logger log = Logger.getLogger(PayBankLimitsServiceImpl.class);
	
	@Override
	public List<PayBankLimits> selectGetAll() {
		PayBankLimitsExample example = new PayBankLimitsExample();

		List<PayBankLimits> selectByExample = payBankLimitsMapper.selectByExample(example);
		log.info("查询银行限额表 PayBankLimits 返回 " + selectByExample + "\n");
		return selectByExample;
	}

}
