package com.tiancaibao.service.interfaces.themis.biz;

public interface IThemisBizMqService {
	/**
	 * 发送外部themis请求
	 * @param userId
	 * @param type
	 * @return
	 */
	public Boolean SendThemis(Long userId,Integer type);
	
}
