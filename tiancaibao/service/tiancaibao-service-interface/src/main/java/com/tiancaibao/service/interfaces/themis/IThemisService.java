package com.tiancaibao.service.interfaces.themis;

import com.tiancaibao.pojo.themis.ThemisContracts;

public interface IThemisService {
	/**
	 * 根据订单ID查询themis记录
	 * @param orderCode
	 * @return
	 */
	public ThemisContracts selectThemisContractsByOrderCode(String orderCode);
	
	/**
	 * 向ThemisContracts表插入记录
	 * @param userId
	 * @param amount
	 * @param orderCode
	 * @param phone
	 * @param status
	 * @param type
	 * @param contractsCode
	 */
	public void insertThemisContracts(Long userId, Long amount, String orderCode, String phone, Byte status, Byte type, String contractsCode);
	
	/**
	 * 更新ThemisContracts表
	 * @param id
	 * @param preservationId
	 */
	public void updateThemisContractsById(Long id, Long preservationId);
	
	
	
	
	
	
	
}
