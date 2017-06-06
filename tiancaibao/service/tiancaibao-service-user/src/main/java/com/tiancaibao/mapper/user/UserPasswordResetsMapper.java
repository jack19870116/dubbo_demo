package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserPasswordResets;
import com.tiancaibao.pojo.user.UserPasswordResetsExample;

public interface UserPasswordResetsMapper {
    int countByExample(UserPasswordResetsExample example);

    int deleteByExample(UserPasswordResetsExample example);

    int insert(UserPasswordResets record);

    int insertSelective(UserPasswordResets record);

    List<UserPasswordResets> selectByExample(UserPasswordResetsExample example);

    int updateByExampleSelective(@Param("record") UserPasswordResets record, @Param("example") UserPasswordResetsExample example);

    int updateByExample(@Param("record") UserPasswordResets record, @Param("example") UserPasswordResetsExample example);
}