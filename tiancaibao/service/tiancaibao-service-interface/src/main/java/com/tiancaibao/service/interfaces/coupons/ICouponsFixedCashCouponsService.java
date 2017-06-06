package com.tiancaibao.service.interfaces.coupons;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.coupons.CouponsFixedCashCoupons;
import com.tiancaibao.utils.page.Pagination;

public interface ICouponsFixedCashCouponsService {

	/**
	 * 设置用户定期红包过期
	 * 
	 * @param userid
	 */
	void reviseExpireCashCoupon(Long userid);

	/**
	 * 分页获取用户所有定期红包
	 * 
	 * @param currPage
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	Pagination selectCashCouponWithPage(Integer currPage, Integer pageSize, Long userid);

	/**
	 * 获取用户某状态的所有活期定期现金红包
	 * 
	 * @param userid
	 * @param status
	 * @return
	 */
	List<CouponsFixedCashCoupons> selectAvailableCashCouponByUserIdAndStatus(Long userid, String status);

	/**
	 * 获取用户下指定定期现金红包ID的定期现金红包
	 * 
	 * @param couponId
	 * @param userid
	 * @return
	 */
	CouponsFixedCashCoupons selectCashCouponByIdAndUserId(Integer couponId, Long userid);

	/**
	 * 获取指定用户ID的定期现金红包并按过期日期日期排序
	 * 
	 * @param couponId
	 * @param userid
	 * @param condition
	 * @param orderDeadline
	 * @return
	 */
	CouponsFixedCashCoupons selectCashCouponsByIdUserIdAndLessThanConditionOrderByDeadline(Integer couponId,
			Long userid, Long condition, String orderDeadline);

	/**
	 * 向定期现金红包表插入一条记录
	 * 
	 * @param userId
	 * @param value
	 * @param condition
	 * @param status
	 * @param source
	 * @param day
	 * @param startline
	 * @param deadline
	 * @param remark
	 * @return
	 */
	int insertIntoCouponsFixedCashCoupons(Long userId, Long value, Integer condition, String status, String source,
			Integer day, Date startline, Date deadline, String remark);

	/**
	 * 根据用户ID获取指定的定期红包列表
	 * 
	 * @param userid
	 * @return
	 */
	List<CouponsFixedCashCoupons> selectCouponsFromFixedCashCouponsByUserIdForPc(Long userid);

	/**
	 * 根据定期红包ID获取指定的定期红包
	 * 
	 * @param id
	 * @return
	 */
	CouponsFixedCashCoupons selectFixedCashCouponById(Integer id);

	/**
	 * 获取所有的已使用的红包总金额
	 * 
	 * @param userId
	 * @return
	 */
	Long selectSumUsedCashCouponAmountByUserId(Long userId);

	/**
	 * 更新红包
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	int updateCouponsFixedCashCouponsStates(long id, String status);

	/**
	 * 更新
	 */

	int updateCouponsFixedCashCouponsByidAndUserId(Long id, Long user_id, String status);

}
