package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserSign;
import com.tiancaibao.pojo.user.UserSignExample;

public interface UserSignMapper {
    int countByExample(UserSignExample example);

    int deleteByExample(UserSignExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSign record);

    int insertSelective(UserSign record);

    List<UserSign> selectByExample(UserSignExample example);

    UserSign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSign record, @Param("example") UserSignExample example);

    int updateByExample(@Param("record") UserSign record, @Param("example") UserSignExample example);

    int updateByPrimaryKeySelective(UserSign record);

    int updateByPrimaryKey(UserSign record);
}