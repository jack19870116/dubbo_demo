package com.tiancaibao.service.interfaces.coupons;

import java.util.Date;
import java.util.List;

import com.tiancaibao.pojo.coupons.CouponsCurrentInterestratesCoupons;
import com.tiancaibao.utils.page.Pagination;


public interface ICouponsCurrentInterestCouponsService {
	/**
	 * 设置用户活期加息券过期
	 * @param userid
	 */
	void reviseExpireCoupon(Long userid);
	

	
	/**
	 * 分页获取用户所有活期加息券
	 * @param currPage
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	Pagination selectCouponWithPage(Integer currPage, Integer pageSize, Long userid);


	/**
	 * 获取用户活期加息券总数量
	 * @param userid
	 * @return
	 */
	int selectUsedCouponCountByUsedAtAndUserId(Long userid);

	/**
	 * 根据活期加息券ID返回活期加息券信息
	 * @param id
	 * @return
	 */
	CouponsCurrentInterestratesCoupons selectAddInterestCouponById(Long id);

	/**
	 * 设置活期加息券状态为使用过
	 * @param status
	 * @param id
	 */
	void updateStatusAndUsedAtById(String status, Long id);

	/**
	 * 活期加息券加息百分比
	 * @param inviterid
	 */
	void addAddInterestCouponPercent(Long inviterid);

	/**
	 * 
	 * @param shopTypeId
	 * @param sisshop
	 * @param limitnum
	 * @return
	 */
	CouponsCurrentInterestratesCoupons selectAddInterestCouponByShopClassIdAndSisShopLimitNum(Integer shopTypeId, byte sisshop, int limitnum);


	/**
	 * 获取指定用户和指定来源的活期加息券列表
	 * @param userid
	 * @param source
	 * @return
	 */
	List<CouponsCurrentInterestratesCoupons> selectAddInterestCouponByUserIdAndSource(Long userid, Integer source);

	/**
	 * 获取指定来源的活期加息券总数
	 * @param source
	 * @return
	 */
	int selectAddInterestCouponCountBySource(Integer source);

	/**
	 * 获取来源并在指定时间内的活期加息券列表
	 * @param userid
	 * @param source
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	List<CouponsCurrentInterestratesCoupons> selectAddInterestCouponByUserIdAndSourceAndCreateAtBetween(Long userid, Integer source,
			String startdate, String enddate);

	/**
	 * 获取来源并在指定时间内的所有活期加息券数量
	 * @param source
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	int selectAddInterestCouponCountBySourceAndCreateAtBetween(Integer source,String startdate, String enddate);

	/**
	 * 插入活期加息券
	 * @param userid
	 * @param value
	 * @param status
	 * @param source
	 * @param startline
	 * @param endline
	 */
	void insertAddInterestCouponForAnswer(Long userid, Long value, String status, Integer source, Date startline, Date endline,String remark);

	/**
	 * 根据用户ID获取所有活期加息券
	 * @param userid
	 * @return
	 */
	List<CouponsCurrentInterestratesCoupons> selectAddInterestFromAddInterestCouponsByUserIdForPc(Long userid);



	/**
	 * 返回今天使用的活期加息券
	 * @param userid
	 * @param dayStartDate
	 * @return
	 */
	CouponsCurrentInterestratesCoupons selectAddInterestCouponByUserIdAndUsedAtToday(Long userid, Date dayStartDate);
	
}
