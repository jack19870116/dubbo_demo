package com.tiancaibao.service.interfaces.user;

import java.util.List;

import com.tiancaibao.pojo.user.UserSignIns;

public interface IUserSignInService {
	
	/**
	 * 按签到日期排序返回指定用户ID的签到记录
	 * @param userid
	 * @param order
	 * @param month
	 * @return
	 */
	List<UserSignIns> selectSignInListByUserIdAndCreateAtOrderByCreateAt(Long userid, String order, String month);

	/**
	 * 按签到日期排序返回指定用户ID的最近一条签到记录
	 * @param userid
	 * @param order
	 * @return
	 */
	UserSignIns selectSignInByUserIdAndOrderByCreateAtFirst(Long userid, String orderBy);

	/**
	 * 返回指定ID连续签到的天数
	 * @param userId
	 * @return
	 */
	Integer selectSignInCountByUserId(Long userId);

	/**
	 * 查询用户今日是否已签到
	 * @param userId
	 * @return
	 */
	public  Boolean selectUserIsSignInByUserId(Long userId);

	/**
	 * 签到成功后，向signIns表插入一条记录
	 * @param userId
	 */
	void insertTableSignIns(Long userId);

	/**
	 * 更新用户表积分记录
	 * @param userId
	 * @param integralrecordIntegral
	 * @param userIntegral
	 * @param signNum
	 */
	void updateUserForUserSignIn(Long userId, Integer integralrecordIntegral, Integer userIntegral, Integer signNum);
}
