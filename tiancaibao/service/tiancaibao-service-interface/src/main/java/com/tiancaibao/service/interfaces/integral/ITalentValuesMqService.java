package com.tiancaibao.service.interfaces.integral;

import com.alibaba.fastjson.JSONObject;

public interface ITalentValuesMqService {
	
	/**
	 * 改动天财值入口
	 * @param userid
	 * @param sourceId
	 * @param oldTalentValue
	 * @param type
	 * @return
	 */
	public boolean changeTalentValue(Long userId, String serviceName, JSONObject message);
	

    
    /**
     * 投资成功
     */
    
    public Long changeTalentValueRecordForInvest(Long userid,Integer sourceId,Long oldTalentValue);


    /**
     * 首次操作，包括实名， 绑卡， 首次投资，首次充值等等
     * @param userid
     * @param sourceId
     * @param oldTalentValue
     * @return
     */
	boolean changeTalentValueRecordForFirstTime(Long userid, Integer sourceId, Long oldTalentValue);
    
    
    
    
}
