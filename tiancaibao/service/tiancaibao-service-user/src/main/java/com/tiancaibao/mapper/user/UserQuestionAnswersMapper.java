package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserQuestionAnswers;
import com.tiancaibao.pojo.user.UserQuestionAnswersExample;

public interface UserQuestionAnswersMapper {
    int countByExample(UserQuestionAnswersExample example);

    int deleteByExample(UserQuestionAnswersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserQuestionAnswers record);

    int insertSelective(UserQuestionAnswers record);

    List<UserQuestionAnswers> selectByExample(UserQuestionAnswersExample example);

    UserQuestionAnswers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserQuestionAnswers record, @Param("example") UserQuestionAnswersExample example);

    int updateByExample(@Param("record") UserQuestionAnswers record, @Param("example") UserQuestionAnswersExample example);

    int updateByPrimaryKeySelective(UserQuestionAnswers record);

    int updateByPrimaryKey(UserQuestionAnswers record);
}