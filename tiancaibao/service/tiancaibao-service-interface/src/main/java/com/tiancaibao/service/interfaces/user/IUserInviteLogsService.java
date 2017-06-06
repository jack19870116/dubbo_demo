package com.tiancaibao.service.interfaces.user;

public interface IUserInviteLogsService {

	/**
	 * 插入用邀请奖励记录
	 * @param inviter_id
	 * @param be_inviter_id
	 * @param name
	 * @param type
	 * @param add_conpons_name
	 * @param add_integral
	 * @param remark
	 * @return
	 */
	public int insertintUserInviteLogs(Long inviter_id, Long be_inviter_id, String name, Integer type,
			String add_conpons_name, Integer add_integral, String remark);
}
