package com.tiancaibao.service.themis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.tiancaibao.mapper.themis.ThemisContractsMapper;
import com.tiancaibao.pojo.themis.ThemisContracts;
import com.tiancaibao.pojo.themis.ThemisContractsExample;
import com.tiancaibao.pojo.user.UserAddresses;
import com.tiancaibao.pojo.user.UserAddressesExample;
import com.tiancaibao.service.interfaces.themis.IThemisService;

@Service("themisService")
public class ThemisServiceImpl implements IThemisService{
	
	@Resource
	private ThemisContractsMapper themisContractsMapper;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public ThemisContracts selectThemisContractsByOrderCode(String orderCode) {
		ThemisContractsExample tce = new ThemisContractsExample();
		tce.createCriteria().andOrderCodeEqualTo(orderCode);
		List <ThemisContracts> tclist = themisContractsMapper.selectByExample(tce);
		if(tclist!=null){
			return tclist.get(0);
		}
		return null;
	}
	
	/**
	 * 向ThemisContracts表插入记录
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	@Override
	public void insertThemisContracts(Long userId, Long amount, String orderCode, String phone, Byte status, Byte type, String contractsCode) {
		
		ThemisContracts themisContracts = new ThemisContracts();
		themisContracts.setUserId(userId);
		themisContracts.setAmount(amount);
		themisContracts.setOrderCode(orderCode);
		themisContracts.setPhone(phone);
		themisContracts.setStatus(status);
		themisContracts.setType(type);
		themisContracts.setContractsCode(contractsCode);
		
		themisContractsMapper.insertSelective(themisContracts);
	}
	
	/**
	 * 更新ThemisContracts表
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	@Override
	public void updateThemisContractsById(Long id, Long preservationId) {

		// 更新易保全preservationId
		ThemisContracts themisContracts = new ThemisContracts();
		themisContracts.setId(id);
		themisContracts.setPreservationId(preservationId);
	
		themisContractsMapper.updateByPrimaryKeySelective(themisContracts);
		
	}
	
	
	
	
	
	
	
	
	
}
