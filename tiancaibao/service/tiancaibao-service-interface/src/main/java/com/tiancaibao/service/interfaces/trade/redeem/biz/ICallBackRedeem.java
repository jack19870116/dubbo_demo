package com.tiancaibao.service.interfaces.trade.redeem.biz;

import java.util.Map;

/**
 * @author zhozhihang
 * @version 创建时间：2017年5月31日 下午4:18:55 类说明
 */
public interface ICallBackRedeem {
	/**
	 * 赎回回调
	 */
	public String redeemNotify(Map<String, String> map);

}
