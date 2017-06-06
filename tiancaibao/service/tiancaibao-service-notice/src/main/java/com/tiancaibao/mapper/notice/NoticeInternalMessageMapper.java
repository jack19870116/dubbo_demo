package com.tiancaibao.mapper.notice;

import com.tiancaibao.pojo.notice.NoticeInternalMessage;
import com.tiancaibao.pojo.notice.NoticeInternalMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeInternalMessageMapper {
    long countByExample(NoticeInternalMessageExample example);

    int deleteByExample(NoticeInternalMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeInternalMessage record);

    int insertSelective(NoticeInternalMessage record);

    List<NoticeInternalMessage> selectByExampleWithBLOBs(NoticeInternalMessageExample example);

    List<NoticeInternalMessage> selectByExample(NoticeInternalMessageExample example);

    NoticeInternalMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeInternalMessage record, @Param("example") NoticeInternalMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") NoticeInternalMessage record, @Param("example") NoticeInternalMessageExample example);

    int updateByExample(@Param("record") NoticeInternalMessage record, @Param("example") NoticeInternalMessageExample example);

    int updateByPrimaryKeySelective(NoticeInternalMessage record);

    int updateByPrimaryKeyWithBLOBs(NoticeInternalMessage record);

    int updateByPrimaryKey(NoticeInternalMessage record);
    
    
    List<NoticeInternalMessage> selectByall( @Param("record") NoticeInternalMessage record, @Param("record")NoticeInternalMessageExample example);
    
    
}