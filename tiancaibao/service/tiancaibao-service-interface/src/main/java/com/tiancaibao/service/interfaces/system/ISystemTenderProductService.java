package com.tiancaibao.service.interfaces.system;

import java.util.List;

import com.tiancaibao.pojo.system.SystemTenderProduct;

public interface ISystemTenderProductService {
	/**
	 * 获取项目实体类
	 * 
	 * @param id
	 * @return
	 */
	public SystemTenderProduct getSystemTenderProduct(long id);

	/**
	 * 获取热门推荐top2
	 * 
	 * @return
	 */
	public List<SystemTenderProduct> getHotTagList();

	/**
	 * 获取新手特权
	 * 
	 * @return
	 */
	public SystemTenderProduct getNovicePrivilege();

	/**
	 * 获取单投标列表展示页
	 * 
	 * @return
	 */
	public List<SystemTenderProduct> tenderShowList();

	/**
	 * 更新剩余金额
	 * 
	 * @param id
	 * @param amount
	 * @return
	 */
	public int updateSystemTenderProductSurplusAmount(long id, long amount);
}
