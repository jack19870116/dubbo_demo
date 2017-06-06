package com.tiancaibao.service.interfaces.user;

import com.tiancaibao.pojo.user.UserBlackLists;
public interface IUserBlackListService {
	/**
	 * 	检查指定用户ID的黑名单锁定金额
	 */
	public Long selectUserLockAmount(Long userId, Byte blacklistType);
	
	/**
	 * 根据用户ID和锁定类型查询用户黑名单表，返回一条记录
	 * @param userid
	 * @param blacklist_type
	 * @return
	 */
	public UserBlackLists selectBlackListsByUserIdAndBlacklistType(Long userid, Integer blacklist_type);
	/**
	 * 插入一条指定用户的黑名单信息
	 * 传入对象
	 */
	public Integer insertUserBlackLists(UserBlackLists userBlackLists);
   /**
    * 逻辑删除一条记录
    */
	public Integer delectUserBlackLists(Integer userBlackLists_id);
}
