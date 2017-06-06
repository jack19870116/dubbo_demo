package com.tiancaibao.service.interfaces.system;

import java.util.List;

import com.tiancaibao.pojo.system.SystemBanners;

public interface ISystemBannerService {

	/**
	 * 根据mark和inset获取符合条件的banner信息
	 * @param mark
	 * @param inset
	 * @param orderBy
	 * @param currpage
	 * @param pageSize
	 * @return
	 */
	List<SystemBanners> selectBannerListByMarkAndInset(Byte mark, Byte inset);

}
