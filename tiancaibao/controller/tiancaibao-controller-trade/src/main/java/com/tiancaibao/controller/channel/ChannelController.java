/*package com.tiancaibao.controller.channel;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.pojo.Channels;

*//**
 * 此controller放这不合适
 * 
 * @author Mack
 *
 *//*
@Controller
@RequestMapping("/channel")
public class ChannelController {

	private static Logger logger = Logger.getLogger(ChannelController.class);

	@Resource
	private ChannelService channelService;

	*//**
	 * 渠道链接
	 * 
	 * @param channel_id
	 * @return
	 *//*
	@RequestMapping("/link.do")
	@ResponseBody
	public String channelLink(Integer channel_id) {
		JSONObject json = new JSONObject();
		try {
			if (channel_id == null) {
				channel_id = 0;
			}
			Channels channel = channelService.selectChannelById(channel_id);
			if (channel == null) {
				json.put("success", false);
			} else {
				json.put("success", true);
				json.put("name", channel.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("渠道链接:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 渠道地址下载
	 * 
	 * @param name
	 * @return
	 *//*
	@RequestMapping("/download.do")
	@ResponseBody
	public String download(String name) {
		JSONObject json = new JSONObject();
		try {
			if (StringUtils.isBlank(name)) {
				name = "";
			}
			Channels channel = channelService.selectChannelByName(name);
			if (channel != null && channel.getUrl() != null) {
				Long hits = channel.getHits() + 1;
				channelService.updateChannelHitsById(hits, channel.getId());
				json.put("success", true);
				json.put("url", channel.getUrl());
				return json.toString();
			}
			json.put("success", false);
			json.put("error", "params error");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("渠道地址下载:" + e.getMessage());
		}
		return json.toString();
	}

	*//**
	 * 渠道统计
	 * 
	 * @return
	 *//*
	@RequestMapping("/total.do")
	@ResponseBody
	public String total(String channel) {
		JSONObject json = new JSONObject();
		try {
			if (StringUtils.isBlank(channel)) {
				json.put("success", false);
				json.put("error", "params error");
				return json.toString();
			}
			// 获取渠道信息
			Channels channelData = channelService.selectChannelByName(channel);
			
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("渠道统计:" + e.getMessage());
		}
		return json.toString();
	}

}
*/