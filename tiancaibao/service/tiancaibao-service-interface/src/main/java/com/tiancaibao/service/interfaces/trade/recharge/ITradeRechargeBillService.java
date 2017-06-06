package com.tiancaibao.service.interfaces.trade.recharge;

import java.util.List;

import com.tiancaibao.pojo.trade.TradeRechargeBills;

public interface ITradeRechargeBillService {


	/**
	 * 存贮充值Bill表
	 * @param userid
	 * @param amount
	 * @param paytypeid
	 * @param order_code
	 * @param status
	 * @param ip
	 * @param client
	 * @return
	 */
	Long insertRechargeBill(Long userid, Long amount, String paytypeid, String order_code, String status, String ip,
			String client);

	/**
	 * 根据ID取回充值bill的一条记录
	 * @param id
	 * @return
	 */
	TradeRechargeBills selectRechargeBillById(Long id);

	/**
	 * 根据充值状态和创建时间从充值bill表取回符合条件的记录
	 * @param status
	 * @param orderByCreatedAt
	 * @return
	 */
	List<TradeRechargeBills> selectRechargeBillByStatusAndOrderByCreatedAt(String status, String orderByCreatedAt);

	/**
	 * 根据时间>5分钟检查所有用户的充值状态
	 * @param deposit
	 * @return
	 */
	Boolean checkRechargeData(String deposit);
	
	
	/**
	 * 查询今日已充值额度
	 * @param userId
	 * @param status
	 * @return
	 */
	
	Long sumAmounts(Long userId,String status);
	
	
	/**
	 * 根据order_code查询一条记录
	 */
	
	TradeRechargeBills selectRechargeBillByOrderCode(String order_code);
	
	/**
	 * 更新数据表
	 */
	
	int updateRechargeBill(TradeRechargeBills tradeRechargeBills);

}
