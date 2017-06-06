package com.tiancaibao.mapper.user;

import com.tiancaibao.pojo.user.UserTeacher;
import com.tiancaibao.pojo.user.UserTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTeacherMapper {
    int countByExample(UserTeacherExample example);

    int deleteByExample(UserTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTeacher record);

    int insertSelective(UserTeacher record);

    List<UserTeacher> selectByExampleWithBLOBs(UserTeacherExample example);

    List<UserTeacher> selectByExample(UserTeacherExample example);

    UserTeacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    int updateByExampleWithBLOBs(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    int updateByExample(@Param("record") UserTeacher record, @Param("example") UserTeacherExample example);

    int updateByPrimaryKeySelective(UserTeacher record);

    int updateByPrimaryKeyWithBLOBs(UserTeacher record);

    int updateByPrimaryKey(UserTeacher record);
}