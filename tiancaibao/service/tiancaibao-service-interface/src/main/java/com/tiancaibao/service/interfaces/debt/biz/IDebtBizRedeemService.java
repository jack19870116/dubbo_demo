package com.tiancaibao.service.interfaces.debt.biz;

/**
 * @author caochunmin
 * @version 创建时间：2017年6月5日 下午1:23:33 类说明 :活期债转赎回业务层接口
 */
public interface IDebtBizRedeemService {
	/**
	 * 转让退出页
	 * 
	 * @param token
	 * @return
	 */
	String postTransferOutPage(String token);

	/**
	 * 赎回匹配
	 * 
	 * @param token
	 * @param count
	 * @return
	 */
	String postMedeemingMatch(String token, int count);

	/**
	 * 确认转出
	 * 
	 * @param token
	 * @param count
	 * @return
	 */
	String postConfirmTransfer(String token, int count);

}
