package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemMessages;
import com.tiancaibao.pojo.system.SystemMessagesExample;
import com.tiancaibao.pojo.system.SystemMessagesWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMessagesMapper {
    long countByExample(SystemMessagesExample example);

    int deleteByExample(SystemMessagesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemMessagesWithBLOBs record);

    int insertSelective(SystemMessagesWithBLOBs record);

    List<SystemMessagesWithBLOBs> selectByExampleWithBLOBs(SystemMessagesExample example);

    List<SystemMessages> selectByExample(SystemMessagesExample example);

    SystemMessagesWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemMessagesWithBLOBs record, @Param("example") SystemMessagesExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemMessagesWithBLOBs record, @Param("example") SystemMessagesExample example);

    int updateByExample(@Param("record") SystemMessages record, @Param("example") SystemMessagesExample example);

    int updateByPrimaryKeySelective(SystemMessagesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemMessagesWithBLOBs record);

    int updateByPrimaryKey(SystemMessages record);
}