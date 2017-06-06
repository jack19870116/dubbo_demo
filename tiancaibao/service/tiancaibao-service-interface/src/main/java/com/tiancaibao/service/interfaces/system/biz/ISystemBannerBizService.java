package com.tiancaibao.service.interfaces.system.biz;

public interface ISystemBannerBizService {
	/**
	 * 根据mark和inset获取符合条件的banner信息，返回json
	 * @param mark
	 * @param inset
	 * @return
	 */
	public String postBannerInfo(Byte mark, Byte inset);
}
