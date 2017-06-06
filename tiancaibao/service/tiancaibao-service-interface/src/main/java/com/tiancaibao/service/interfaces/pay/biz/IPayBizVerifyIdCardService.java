package com.tiancaibao.service.interfaces.pay.biz;

public interface IPayBizVerifyIdCardService {
	public String setRealName(String token,String ip,String idcard_number,String idcard_name);
}
