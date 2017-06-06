package com.tiancaibao.mapper.mq;

import com.tiancaibao.pojo.mq.MqMessage;
import com.tiancaibao.pojo.mq.MqMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MqMessageMapper {
    long countByExample(MqMessageExample example);

    int deleteByExample(MqMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MqMessage record);

    int insertSelective(MqMessage record);

    List<MqMessage> selectByExampleWithBLOBs(MqMessageExample example);

    List<MqMessage> selectByExample(MqMessageExample example);

    MqMessage selectByPrimaryKey(@Param("id")Integer id);

    int updateByExampleSelective(@Param("record") MqMessage record, @Param("example") MqMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") MqMessage record, @Param("example") MqMessageExample example);

    int updateByExample(@Param("record") MqMessage record, @Param("example") MqMessageExample example);

    int updateByPrimaryKeySelective(MqMessage record);

    int updateByPrimaryKeyWithBLOBs(MqMessage record);

    int updateByPrimaryKey(MqMessage record);
}