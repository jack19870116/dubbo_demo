package com.tiancaibao.service.interfaces.user;

import com.tiancaibao.pojo.user.UserLoginLogs;

public interface IUserLoginLogsService {
	/**
	 * 使用用户ID 设备号查询登陆记录 更新用户密码
	 * @param userid
	 * @param agent_num
	 * @return
	 */
	public UserLoginLogs selectUserLoginLogsByuserIdAndAgentNum(Long userid, String agent_num);
	
	/**
	 * 保存用户登陆信息
	 * @param userid
	 * @param agent_num
	 * @param source
	 * @param system
	 * @param token
	 */
	public void saveUserLoginLogs(Long userid, String agent_num, String source, String system, String token);
	
	/**
	 * 更新用户登陆信息
	 * @param token
	 * @param system
	 * @param id
	 */
	public void updateUserLoginLogsById(String token, String system, Long id);
	
	
}
