package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserSignIns;
import com.tiancaibao.pojo.user.UserSignInsExample;

public interface UserSignInsMapper {
    int countByExample(UserSignInsExample example);

    int deleteByExample(UserSignInsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSignIns record);

    int insertSelective(UserSignIns record);

    List<UserSignIns> selectByExample(UserSignInsExample example);

    UserSignIns selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSignIns record, @Param("example") UserSignInsExample example);

    int updateByExample(@Param("record") UserSignIns record, @Param("example") UserSignInsExample example);

    int updateByPrimaryKeySelective(UserSignIns record);

    int updateByPrimaryKey(UserSignIns record);
}