package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserBlackLists;
import com.tiancaibao.pojo.user.UserBlackListsExample;

public interface UserBlackListsMapper {
    int countByExample(UserBlackListsExample example);

    int deleteByExample(UserBlackListsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserBlackLists record);

    int insertSelective(UserBlackLists record);

    List<UserBlackLists> selectByExample(UserBlackListsExample example);

    UserBlackLists selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserBlackLists record, @Param("example") UserBlackListsExample example);

    int updateByExample(@Param("record") UserBlackLists record, @Param("example") UserBlackListsExample example);

    int updateByPrimaryKeySelective(UserBlackLists record);

    int updateByPrimaryKey(UserBlackLists record);

	Long selectByUserIdAndBlacklistType(@Param("userid")Long userid,@Param("blacklist_type") int blacklist_type);
}