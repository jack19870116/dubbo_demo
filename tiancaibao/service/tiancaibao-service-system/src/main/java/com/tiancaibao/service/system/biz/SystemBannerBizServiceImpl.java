package com.tiancaibao.service.system.biz;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.system.SystemBanners;
import com.tiancaibao.service.interfaces.system.ISystemBannerService;
import com.tiancaibao.service.interfaces.system.biz.ISystemBannerBizService;

public class SystemBannerBizServiceImpl implements ISystemBannerBizService{
	
	@Resource
	ISystemBannerService  systemBannerService;
	
	public String postBannerInfo(Byte mark, Byte inset){
		JSONObject json = new JSONObject();
		List <SystemBanners> sbList = systemBannerService.selectBannerListByMarkAndInset(mark, inset);
		if(sbList != null){
			json.put("success", "true");
			json.put("data", sbList);
		}else{
			json.put("success", "false");
			json.put("error", "暂无数据");
		}
		
		return json.toString();
	}
	
}
