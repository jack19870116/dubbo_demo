package com.tiancaibao.service.interfaces.user;

public interface IUserFeedBackService {
	/**
	 * 保存用户反馈
	 * @param userid
	 * @param content
	 * @param email
	 */
	public void saveToFeedBack(Integer userid, String content, String email);
}
