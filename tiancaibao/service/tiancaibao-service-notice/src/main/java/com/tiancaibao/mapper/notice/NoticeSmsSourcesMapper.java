package com.tiancaibao.mapper.notice;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.notice.NoticeSmsSources;
import com.tiancaibao.pojo.notice.NoticeSmsSourcesExample;

public interface NoticeSmsSourcesMapper {
    int countByExample(NoticeSmsSourcesExample example);

    int deleteByExample(NoticeSmsSourcesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeSmsSources record);

    int insertSelective(NoticeSmsSources record);

    List<NoticeSmsSources> selectByExample(NoticeSmsSourcesExample example);

    NoticeSmsSources selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeSmsSources record, @Param("example") NoticeSmsSourcesExample example);

    int updateByExample(@Param("record") NoticeSmsSources record, @Param("example") NoticeSmsSourcesExample example);

    int updateByPrimaryKeySelective(NoticeSmsSources record);

    int updateByPrimaryKey(NoticeSmsSources record);
}