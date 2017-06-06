package com.tiancaibao.service.interfaces.trade.invest;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.trade.TradeInvestBills;

public interface ITradeInvestBillsService {

	/**
	 * 根据用户ID分页返回用户按定日期的订单记录
	 * 
	 * @param userid
	 * @param date
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<TradeInvestBills> selectInvestBillListByUserIdAndCreateAtGreatThanDateOrderByCreateAtWithPage(
			Long userid, String date, String order, Integer currPage, Integer pageSize);

	/**
	 * 根据投资ID和用户ID返回一条记录
	 * 
	 * @param id
	 * @param userid
	 * @return
	 */
	TradeInvestBills selectInvestBillByIdAndUserId(Long id, Long userid);

	/**
	 * 根据投资ID返回一条记录
	 * 
	 * @param id
	 * @return
	 */
	TradeInvestBills selectInvestBillById(Long id);

	/**
	 * 更新订单表设置复投状态
	 * 
	 * @param InvestBillsId
	 * @param is_auto_invest
	 */
	void updateInvestBillsSetIsAutoInvest(Long InvestBillsId, Integer is_auto_invest);

	/**
	 * 插入一条数据
	 * 
	 * @param userId
	 * @param amount
	 * @param days
	 * @param is_auto_invest
	 * @param couponId
	 * @param systemAssetdays
	 * @param order_code
	 * @param client
	 * @param ip
	 * @return
	 */

	Integer insertTradeInvestBills(Long userId, Long amount, Date days, Integer is_auto_invest, Integer couponId,
			Integer systemAssetdays, String order_code, String client, String ip);

	/**
	 * 插入一条新数据
	 */
	TradeInvestBills saveInvestBills(Long userId, Long amount, String status, Integer days, String order_code, Byte isAutoInvest,
			Integer couponId, Integer interest_id, String ip, String client);

	
	/**
	 * 根据订单号查询订单
	 * @param order_code
	 * @return
	 */
	TradeInvestBills  selectInvestBillsByOrderCode(String order_code);
	
	
	/**
	 * 更新数据
	 */
	
	int updateTradeInvestBills(TradeInvestBills tradeInvestBills);
	
	/**
	 * 查询一分钟内是否有超过三个非成功订单
	 */
	
	int countTradeInvestBillsByUserId(Long userId,String status,Date creatAt);
	
	/**
	 * 查询今日用户投资总额
	 */
	Long sumAoment(Long userId,String status,Date creatAt);
	
	
	
	
	
	
	
}
