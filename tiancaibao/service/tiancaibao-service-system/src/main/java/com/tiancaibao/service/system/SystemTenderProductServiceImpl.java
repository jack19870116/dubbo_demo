package com.tiancaibao.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tiancaibao.mapper.system.SystemTenderProductMapper;
import com.tiancaibao.pojo.system.SystemTenderProduct;
import com.tiancaibao.service.interfaces.system.ISystemTenderProductService;

@Service("systemTenderProductService")
public class SystemTenderProductServiceImpl implements ISystemTenderProductService {
	@Resource
	private SystemTenderProductMapper systemTenderProductMapper;

	/**
	 * 获取项目实体类
	 */
	@Override
	public SystemTenderProduct getSystemTenderProduct(long id) {
		return systemTenderProductMapper.selectByPrimaryKey(id);
	}

	/**
	 * 获取热门推荐top2
	 */
	@Override
	public List<SystemTenderProduct> getHotTagList() {
		return systemTenderProductMapper.getHotTagList();
	}

	/**
	 * 获取单投标列表展示页
	 */
	@Override
	public List<SystemTenderProduct> tenderShowList() {
		return systemTenderProductMapper.tenderShowList();
	}

	/**
	 * 更新剩余金额
	 */
	@Override
	public int updateSystemTenderProductSurplusAmount(long id, long amount) {

		// 根据id获取项目的实体

		SystemTenderProduct selectByPrimaryKey = systemTenderProductMapper.selectByPrimaryKey(id);
		long surplusAmount = selectByPrimaryKey.getSurplusAmount() - amount * 10000;
		SystemTenderProduct record = new SystemTenderProduct();
		record.setId(id);
		record.setSurplusAmount(surplusAmount);
		// 根据项目id更新项目剩余金额
		return systemTenderProductMapper.updateSurplusAmountById(record);
	}

	/**
	 * 获取新手特权
	 */
	@Override
	public SystemTenderProduct getNovicePrivilege() {
		return systemTenderProductMapper.getNovicePrivilege();
	}

}
