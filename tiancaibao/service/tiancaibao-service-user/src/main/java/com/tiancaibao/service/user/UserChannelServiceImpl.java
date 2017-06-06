package com.tiancaibao.service.user;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.mapper.user.UserChannelsMapper;
import com.tiancaibao.pojo.user.UserChannels;
import com.tiancaibao.pojo.user.UserChannelsExample;
import com.tiancaibao.service.interfaces.user.IUserChannelService;

@Service("channelService")
public class UserChannelServiceImpl implements IUserChannelService{
	
	@Resource
	private UserChannelsMapper channelsMapper;
	

	@Transactional  
	@Override
	public UserChannels selectChannelById(Integer channel_id) {
		UserChannels channel = channelsMapper.selectByPrimaryKey(channel_id);
		return channel;
	}
	
	/**
	 * 使用渠道名称 获得渠道信息
	 */
	@Transactional
	@Override
	public UserChannels selectChannelByName(String channelName) {
		if (StringUtils.isBlank(channelName)) {
			throw new ServiceException("参数异常");
		}
		UserChannelsExample example = new UserChannelsExample();

		example.createCriteria().andNameEqualTo(channelName);
		List<UserChannels> channelsList = channelsMapper.selectByExample(example);
		if (channelsList != null && channelsList.size() == 1) {
			return channelsList.get(0);
		}
		return null;
	}
	
	/**
	 * 保存渠道信息
	 */
	@Transactional
	@Override
	public int saveToChannel(String channelName) {
		UserChannels channels = new UserChannels();
		channels.setName(channelName);
		channels.setHits(0L);
		channels.setCreatedAt(new Date());
		channelsMapper.insertAndReturnId(channels);
		return channels.getId();
	}
	
	public void updateChannelHitsById (Long hits, Integer id){
		
	}
}
