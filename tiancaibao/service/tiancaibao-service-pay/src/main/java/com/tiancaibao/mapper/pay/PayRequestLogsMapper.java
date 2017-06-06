package com.tiancaibao.mapper.pay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.pay.PayRequestLogsWithBLOBs;
import com.tiancaibao.pojo.pay.PayRequestLogs;
import com.tiancaibao.pojo.pay.PayRequestLogsExample;

public interface PayRequestLogsMapper {
    int countByExample(PayRequestLogsExample example);

    int deleteByExample(PayRequestLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PayRequestLogsWithBLOBs record);

    int insertSelective(PayRequestLogsWithBLOBs record);

    List<PayRequestLogsWithBLOBs> selectByExampleWithBLOBs(PayRequestLogsExample example);

    List<PayRequestLogs> selectByExample(PayRequestLogsExample example);

    PayRequestLogsWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PayRequestLogsWithBLOBs record, @Param("example") PayRequestLogsExample example);

    int updateByExampleWithBLOBs(@Param("record") PayRequestLogsWithBLOBs record, @Param("example") PayRequestLogsExample example);

    int updateByExample(@Param("record") PayRequestLogs record, @Param("example") PayRequestLogsExample example);

    int updateByPrimaryKeySelective(PayRequestLogsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PayRequestLogsWithBLOBs record);

    int updateByPrimaryKey(PayRequestLogs record);
}