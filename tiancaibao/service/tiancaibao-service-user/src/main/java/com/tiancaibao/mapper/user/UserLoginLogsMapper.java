package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserLoginLogs;
import com.tiancaibao.pojo.user.UserLoginLogsExample;

public interface UserLoginLogsMapper {
    int countByExample(UserLoginLogsExample example);

    int deleteByExample(UserLoginLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserLoginLogs record);

    int insertSelective(UserLoginLogs record);

    List<UserLoginLogs> selectByExample(UserLoginLogsExample example);

    UserLoginLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserLoginLogs record, @Param("example") UserLoginLogsExample example);

    int updateByExample(@Param("record") UserLoginLogs record, @Param("example") UserLoginLogsExample example);

    int updateByPrimaryKeySelective(UserLoginLogs record);

    int updateByPrimaryKey(UserLoginLogs record);
}