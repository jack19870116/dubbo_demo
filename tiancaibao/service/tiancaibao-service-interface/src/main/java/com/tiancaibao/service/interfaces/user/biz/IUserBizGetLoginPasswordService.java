package com.tiancaibao.service.interfaces.user.biz;

public interface IUserBizGetLoginPasswordService {
	public String getLoginPassword(String phone, String password,String is_encryption,String phone_code);
}
