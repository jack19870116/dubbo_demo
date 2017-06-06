package com.tiancaibao.service.pay;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.pay.PayUnBankcardsMapper;
import com.tiancaibao.pojo.pay.PayUnBankcards;
import com.tiancaibao.pojo.pay.PayUnBankcardsExample;
import com.tiancaibao.service.interfaces.pay.IPayUnBankCardService;

@Service("payUnBankCardService")
public class PayUnBankCardServiceImpl implements IPayUnBankCardService {

	@Resource
	PayUnBankcardsMapper payUnBankcardsMapper;

	@Override
	public PayUnBankcards selectPayUnBankcardsByUserId(Long user_id, String status) {

		PayUnBankcardsExample example = new PayUnBankcardsExample();

		example.createCriteria().andUserIdEqualTo(user_id).andStatusEqualTo(status);

		List<PayUnBankcards> selectByExample = payUnBankcardsMapper.selectByExample(example);

		return selectByExample.get(0);
	}

	@Override
	public int insertintoBankcards(Long user_id, String number, String status, String ticket) {
		PayUnBankcards record = new PayUnBankcards();

		record.setUserId(user_id);
		record.setNumber(number);
		record.setStatus(status);
		record.setTicket(ticket);
		record.setCreatedAt(new Date());
		record.setUpdatedAt(new Date());
		return payUnBankcardsMapper.insertSelective(record);
	}

	@Override
	public PayUnBankcards selectPayUnBankcardsByTicket(String ticket) {
		PayUnBankcardsExample example = new PayUnBankcardsExample();

		example.createCriteria().andTicketEqualTo(ticket);

		List<PayUnBankcards> selectByExample = payUnBankcardsMapper.selectByExample(example);

		return selectByExample.get(0);
	}

	@Override
	public int updatePayUnBankcards(Long id, String status) {
		PayUnBankcards record = new PayUnBankcards();
		record.setId(id);
		record.setStatus(status);
		record.setUpdatedAt(new Date());
		payUnBankcardsMapper.updateByPrimaryKeySelective(record);
		return payUnBankcardsMapper.updateByPrimaryKeySelective(record);
	}

}
