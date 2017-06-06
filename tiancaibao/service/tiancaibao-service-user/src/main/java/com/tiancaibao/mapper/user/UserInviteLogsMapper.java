package com.tiancaibao.mapper.user;

import com.tiancaibao.pojo.user.UserInviteLogs;
import com.tiancaibao.pojo.user.UserInviteLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInviteLogsMapper {
    long countByExample(UserInviteLogsExample example);

    int deleteByExample(UserInviteLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInviteLogs record);

    int insertSelective(UserInviteLogs record);

    List<UserInviteLogs> selectByExample(UserInviteLogsExample example);

    UserInviteLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInviteLogs record, @Param("example") UserInviteLogsExample example);

    int updateByExample(@Param("record") UserInviteLogs record, @Param("example") UserInviteLogsExample example);

    int updateByPrimaryKeySelective(UserInviteLogs record);

    int updateByPrimaryKey(UserInviteLogs record);
}