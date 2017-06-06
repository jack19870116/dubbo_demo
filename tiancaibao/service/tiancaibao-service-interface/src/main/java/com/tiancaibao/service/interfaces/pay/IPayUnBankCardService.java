package com.tiancaibao.service.interfaces.pay;

import com.tiancaibao.pojo.pay.PayUnBankcards;

public interface IPayUnBankCardService {

	/**
	 * 查询解绑记录
	 */
	public  PayUnBankcards selectPayUnBankcardsByUserId(Long user_id,String status);
	
	/**
	 * 添加一条解绑记录
	 */
	public int insertintoBankcards(Long user_id,String number,String status,String ticket);
	
	
	
	/**
	 * 根据ticket查询解绑解绑记录
	 */
	public  PayUnBankcards selectPayUnBankcardsByTicket(String ticket);
	
	
	/**
	 * 更新解绑记录
	 */
	public int updatePayUnBankcards(Long id,String status);
	
	
	
	
}
