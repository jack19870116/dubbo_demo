package com.tiancaibao.service.interfaces.user.biz;

public interface IUserBizResetPasswordService {
	public String resetPassword(String token, String old_password, String new_password, String repeat_password, String is_encryption);
}
