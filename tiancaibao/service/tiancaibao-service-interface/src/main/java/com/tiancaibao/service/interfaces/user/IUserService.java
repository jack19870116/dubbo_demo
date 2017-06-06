package com.tiancaibao.service.interfaces.user;

import com.tiancaibao.pojo.user.Users;

public interface IUserService {
	/**
	 * 清除redis中所有的用户缓存信息
	 * 
	 * @return
	 */
	public Boolean clearAllUserCache();

	/**
	 * 根据用户ID返回用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public Users selectUserById(Long userId);

	/**
	 * 根据用户手机号返回用户信息
	 * 
	 * @param phone
	 * @return
	 */
	public Users selectUserByPhone(String phone);
	
	/**
	 * 根据weixin open_id 返回用户信息
	 * 
	 * @param open_id
	 * @return
	 */
	public Users selectUserByOpenId(String open_id);

	/**
	 * 根据用户手机号返回用户ID
	 * 
	 * @param phone
	 * @return
	 */
	public Long selectUserIdByPhone(String phone);

	/**
	 * 根据用户令牌返回用户ID
	 * 
	 * @param token
	 * @return
	 */
	public Long selectUserIdByToken(String token);

	/**
	 * 根据用户令牌返回用户信息
	 * 
	 * @param token
	 * @return
	 */
	public Users selectUserByToken(String token);

	/**
	 * 根据用户ID更新用户访问令牌
	 * 
	 * @param userId
	 * @param token
	 * @param oldToken
	 * @return
	 */
	public Boolean updateUserRememberTokenById(Long userId, String token, String oldToken);

	/**
	 * 根据用户ID更新用户密码
	 * 
	 * @param userId
	 * @param password
	 * @param oldPassword
	 * @return
	 */
	public Boolean updateUserPasswordById(Long userId, String password, String oldPassword);

	/**
	 * 根据用户ID更新加密后的用户密码
	 * 
	 * @param userId
	 * @param password
	 * @param oldPassword
	 * @param is_encryption
	 * @return
	 */
	public Boolean updateUserPasswordByIdMD5(Long userId, String password, String oldPassword, boolean is_encryption);

	/**
	 * 向用户表插入一条记录
	 * 
	 * @param phone
	 * @param password
	 * @param userinvitedId
	 * @param channelId
	 * @return
	 */
	public Long saveToUsers(String phone, String password, Long userinvitedId, int channelId);

	/**
	 * 向用户表插入一条记录
	 * 
	 * @param users
	 * @return
	 */
	public Long saveToUsers(Users users);

	/**
	 * 根据用户ID更新推荐人
	 * 
	 * @param userid
	 * @param invitedByUserId
	 * @param oldInvitedByUserId
	 * @return
	 */
	public Boolean updateUserSetInvitedById(Long userid, Long invitedByUserId, Long oldInvitedByUserId);

	/**
	 * 根据用户ID更新用户微信OPEN_ID
	 * 
	 * @param userid
	 * @param open_id
	 * @param old_open_id
	 * @return
	 */
	public Boolean updateOpenIdById(Long userid, String open_id, String old_open_id);

	/**
	 * 根据用户ID更新用户
	 * 
	 * @param userid
	 * @param idcard_name
	 * @param idcard_number
	 * @param birthday
	 * @return
	 */
	public Boolean updateUserById(Long userid, String idcard_name, String idcard_number, String birthday);

	/**
	 * 根据用户ID更新天财值
	 * 
	 * @param userid
	 * @param talentValue
	 * @param oldTalentValue
	 * @return
	 */
	public Boolean updateTalentValueById(Long userid, Long talentValue, Long oldTalentValue);

	/**
	 * 根据用户ID更新积分
	 * 
	 * @param userId
	 * @param interest
	 * @param oldInterest
	 * @return
	 */
	public Boolean updateIntegralById(Long userId, Integer interest, Integer oldInterest);

	/**
	 * 根据用户ID更新用户活期金额
	 * 
	 * @param userid
	 * @param curramount
	 * @param oldCurrentAmount
	 * @return
	 */
	public Boolean updateUserCurrentAmountById(Long userid, Long curramount, Long oldCurrentAmount);

	/**
	 * 根据用户ID更新用户定期金额
	 * 
	 * @param userid
	 * @param fixedamount
	 * @param oldFixedAmount
	 * @return
	 */
	public Boolean updateUserFixedAmountById(Long userid, Long fixedamount, Long oldFixedAmount);

	/**
	 * 根据用户ID更新用户信息
	 * 
	 * @param users
	 * @return
	 */
	public Boolean updateUsersById(Users users);

	/*
	 * 返回用户所有的活期帐户余额
	 */
	public Long sumCurrentAmount();

	/**
	 * 返回用户所有的定期帐户余额
	 * 
	 * @return
	 */
	public Long sumFixedAmount();

	/*
	 * 返回总用户注册数
	 */
	public Integer selectRegisterCount();

	/**
	 * 更新单标总额
	 * 
	 * @param userId
	 * @param tenderAmount
	 * @return
	 */
	public int updateUserTenderAmountById(Long userId, Long tenderAmount);

	/**
	 * 更新用户的积分
	 * 
	 * @param id
	 * @param integral
	 * @param signNum
	 * @return
	 */
	public int updateIntegralAndSignNum(Long id, int integral, int signNum);

	/**
	 * 更新余额
	 */
	public int updateUserAmount(Long userId, Long amount);
	
	/**
	 * 清除用户缓存
	 * @param user
	 * @return
	 */
	public Boolean clearUserCache(Users user);
}
