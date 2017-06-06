package com.tiancaibao.service.interfaces.debt.biz;

import com.alibaba.fastjson.JSONObject;

public interface IDebtBizRedeemMqService {
	public boolean redeemProcessingOperation(Long userId, String serviceName, JSONObject message);
}
