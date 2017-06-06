package com.tiancaibao.mapper.user;

import com.tiancaibao.pojo.user.UserBbin;
import com.tiancaibao.pojo.user.UserBbinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBbinMapper {
    long countByExample(UserBbinExample example);

    int deleteByExample(UserBbinExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBbin record);

    int insertSelective(UserBbin record);

    List<UserBbin> selectByExample(UserBbinExample example);

    UserBbin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBbin record, @Param("example") UserBbinExample example);

    int updateByExample(@Param("record") UserBbin record, @Param("example") UserBbinExample example);

    int updateByPrimaryKeySelective(UserBbin record);

    int updateByPrimaryKey(UserBbin record);
}