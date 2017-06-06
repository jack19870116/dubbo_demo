package com.tiancaibao.mapper.notice;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.notice.NoticeSms;
import com.tiancaibao.pojo.notice.NoticeSmsExample;

public interface NoticeSmsMapper {
    int countByExample(NoticeSmsExample example);

    int deleteByExample(NoticeSmsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeSms record);

    int insertSelective(NoticeSms record);

    List<NoticeSms> selectByExample(NoticeSmsExample example);

    NoticeSms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeSms record, @Param("example") NoticeSmsExample example);

    int updateByExample(@Param("record") NoticeSms record, @Param("example") NoticeSmsExample example);

    int updateByPrimaryKeySelective(NoticeSms record);

    int updateByPrimaryKey(NoticeSms record);

	void insertAndReturnId(NoticeSms sms);
}