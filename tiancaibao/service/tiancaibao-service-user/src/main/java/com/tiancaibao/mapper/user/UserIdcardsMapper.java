package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserIdcards;
import com.tiancaibao.pojo.user.UserIdcardsExample;

public interface UserIdcardsMapper {
    int countByExample(UserIdcardsExample example);

    int deleteByExample(UserIdcardsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserIdcards record);

    int insertSelective(UserIdcards record);

    List<UserIdcards> selectByExample(UserIdcardsExample example);

    UserIdcards selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserIdcards record, @Param("example") UserIdcardsExample example);

    int updateByExample(@Param("record") UserIdcards record, @Param("example") UserIdcardsExample example);

    int updateByPrimaryKeySelective(UserIdcards record);

    int updateByPrimaryKey(UserIdcards record);
}