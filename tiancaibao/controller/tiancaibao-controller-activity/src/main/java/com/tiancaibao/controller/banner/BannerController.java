package com.tiancaibao.controller.banner;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.Banners;
import com.tiancaibao.service.banner.BannerService;

@Controller
@RequestMapping("/banner")
public class BannerController {

	private static Logger logger = Logger.getLogger(BannerController.class);

	@Resource
	private BannerService bannerService;

	/**
	 * 获取banner详情或列表
	 * 
	 * @return
	 */
	public String bannerInfo(Integer mark) {
		JSONObject json = new JSONObject();
		try {
			List<Banners> bannerlist = null;
			if (mark == 0) {
				// app轮播图
				bannerlist = bannerService.selectBannerListByMarkAndInsetOrderByUpadateAtWithPage(0, 0, "desc", 1, 6);
			}
			if (mark == 1) {
				// 积分商城
				bannerlist = bannerService.selectBannerListByMarkAndInsetOrderByUpadateAtWithPage(1, 0, "desc", 1, 6);
			}
			if (bannerlist == null) {
				json.put("success", false);
				json.put("error", "暂无数据");
				return json.toString();
			}
			for (Banners banners : bannerlist) {
				banners.setImageUrl("http://weixin.51tiancai.com/" + banners.getImageUrl());
			}
			json.put("success", true);
			json.put("banner", bannerlist);
			json.put("data", bannerlist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取banner详情或列表:" + e.getMessage());
		}
		return json.toString();
	}
}
