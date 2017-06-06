package com.tiancaibao.mapper.activity;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.activity.ActivityLotteryBill;
import com.tiancaibao.pojo.activity.ActivityLotteryBillExample;

public interface ActivityLotteryBillMapper {
    int countByExample(ActivityLotteryBillExample example);

    int deleteByExample(ActivityLotteryBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityLotteryBill record);

    int insertSelective(ActivityLotteryBill record);

    List<ActivityLotteryBill> selectByExample(ActivityLotteryBillExample example);

    ActivityLotteryBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityLotteryBill record, @Param("example") ActivityLotteryBillExample example);

    int updateByExample(@Param("record") ActivityLotteryBill record, @Param("example") ActivityLotteryBillExample example);

    int updateByPrimaryKeySelective(ActivityLotteryBill record);

    int updateByPrimaryKey(ActivityLotteryBill record);
}