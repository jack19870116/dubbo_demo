package com.tiancaibao.service.interfaces.wechat;

import java.util.List;

import com.tiancaibao.pojo.user.Users;
import com.tiancaibao.pojo.wechat.WeixinMenu;

public interface IWechatService {

	/**
	 * 根据用户手机号返回用户信息
	 * 
	 * @param phone
	 * @return
	 */
	public Users selectUserByPhone(String phone);

}
