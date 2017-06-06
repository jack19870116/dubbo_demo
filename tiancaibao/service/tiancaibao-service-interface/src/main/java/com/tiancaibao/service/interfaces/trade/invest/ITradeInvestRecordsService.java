package com.tiancaibao.service.interfaces.trade.invest;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.trade.TradeInvestRecords;
import com.tiancaibao.pojo.trade.TradeInvestRecordsExample;

public interface ITradeInvestRecordsService {
	
	/**
	 * 根据UserID查询用户最近的一条投资记录
	 */
	public TradeInvestRecords selectTradeInvestRecordsByUserId(Long user_id);

	/**
	 * 
	 * @param userid
	 * @param amount
	 * @param days
	 * @param startcreatedAt
	 * @param endcreatedAt
	 * @return
	 */
	TradeInvestRecords selectInvestRecordByUserIdAndAmountGreatThanAndDaysGreatThanAndCreateAtBetween(Long userid,
			Integer amount, Integer days, Date startcreatedAt, Date endcreatedAt);

	/**
	 * 根据产品标识统计该产品总的投资金额
	 * @param product_sign
	 * @return
	 */
	Long selectSumAmountInvestRecordByProductSign(String product_sign);

	/**
	 * 统计投资成功表的总记录条数
	 * @return
	 */
	Integer selectCountInvestRecord();

	/**
	 * 根据用户ID,ID,过期时间返回一条记录
	 * @param id
	 * @param userid
	 * @param expire_date
	 * @return
	 */
	TradeInvestRecords selectInvestRecordByIdAndUserIdAndGreatThanExpireDate(Long id, Long userid, Date expire_date);
	
	/**
	 * 统计投资成功表总的投资金额
	 */
	Long selectSumAmountInvestRecord(TradeInvestRecordsExample ire);

	/**
	 * 
	 * @param userid
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<TradeInvestRecords> selectUnderwayFixByUserIdWithPage(Long userid, Integer currPage, Integer pageSize);

	/**
	 * 
	 * @param userid
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<TradeInvestRecords> doneFixedInvestRecordByUserId(Long userid, Integer currPage, Integer pageSize);

	/**
	 * 
	 * @param userid
	 * @return
	 */
	Long selectFinishFixSumInterestByUserId(Long userid);

	/**
	 * 更新订单成功表设置复投状态
	 * @param investRecordsID
	 * @param is_auto_invest
	 */
	void updateInvestRecordsSetIsAutoInvest(Long investRecordsID, Integer is_auto_invest);

	/**
	 * 根据用户ＩＤ获取用户所有已完成的定期投资的收益
	 * @param userId
	 * @return
	 */
	Long selectFixedIncomeByUserId(Long userId);

	/**
	 * 
	 * @param UserId
	 * @return
	 */
	public Long selectSumAmountByUserId(long UserId);

	/**
	 * 
	 * @param l
	 * @return
	 */
	public Long selectCurrentSumAmountNotWithDraw(long l);
	
	
	
	
	/**
	 * 插入一条数据
	 */
	
	public TradeInvestRecords saveTradeInvestRecords(TradeInvestRecords tradeInvestRecords);
	
	/**
	 * 查询一条记录
	 */
	
	public int selectTradeInvestRecords(Long user_id,Integer days);
	

	/**
	 * 
	 * @param UserId
	 * @return
	 */
	public Long selectSumAmountByUserIdAndCreatedAt(Long UserId);
	
	/**
	 * 根据条件查询总条数
	 * @return
	 */
	Integer selectCountInvestRecordByCondition(TradeInvestRecordsExample ire);

	
	
}
