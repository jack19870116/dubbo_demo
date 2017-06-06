package com.tiancaibao.service.interfaces.user;

import com.tiancaibao.pojo.user.UserChannels;

public interface IUserChannelService {
	
	UserChannels selectChannelById(Integer channel_id);

	UserChannels selectChannelByName(String name);

	void updateChannelHitsById(Long hits, Integer id);

	int saveToChannel(String channelName);
}
