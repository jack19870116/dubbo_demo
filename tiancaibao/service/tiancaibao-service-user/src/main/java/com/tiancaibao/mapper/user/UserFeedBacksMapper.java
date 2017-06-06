package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserFeedBacks;
import com.tiancaibao.pojo.user.UserFeedBacksExample;

public interface UserFeedBacksMapper {
    int countByExample(UserFeedBacksExample example);

    int deleteByExample(UserFeedBacksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFeedBacks record);

    int insertSelective(UserFeedBacks record);

    List<UserFeedBacks> selectByExampleWithBLOBs(UserFeedBacksExample example);

    List<UserFeedBacks> selectByExample(UserFeedBacksExample example);

    UserFeedBacks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFeedBacks record, @Param("example") UserFeedBacksExample example);

    int updateByExampleWithBLOBs(@Param("record") UserFeedBacks record, @Param("example") UserFeedBacksExample example);

    int updateByExample(@Param("record") UserFeedBacks record, @Param("example") UserFeedBacksExample example);

    int updateByPrimaryKeySelective(UserFeedBacks record);

    int updateByPrimaryKeyWithBLOBs(UserFeedBacks record);

    int updateByPrimaryKey(UserFeedBacks record);
}