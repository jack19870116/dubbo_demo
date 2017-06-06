package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserChannels;
import com.tiancaibao.pojo.user.UserChannelsExample;

public interface UserChannelsMapper {
    int countByExample(UserChannelsExample example);

    int deleteByExample(UserChannelsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserChannels record);

    int insertSelective(UserChannels record);

    List<UserChannels> selectByExample(UserChannelsExample example);

    UserChannels selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserChannels record, @Param("example") UserChannelsExample example);

    int updateByExample(@Param("record") UserChannels record, @Param("example") UserChannelsExample example);

    int updateByPrimaryKeySelective(UserChannels record);

    int updateByPrimaryKey(UserChannels record);

	int insertAndReturnId(UserChannels UserChannels);
}