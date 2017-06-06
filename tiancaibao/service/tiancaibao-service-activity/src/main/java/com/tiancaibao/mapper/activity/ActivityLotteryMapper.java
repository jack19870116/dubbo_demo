package com.tiancaibao.mapper.activity;

import com.tiancaibao.pojo.activity.ActivityLottery;
import com.tiancaibao.pojo.activity.ActivityLotteryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityLotteryMapper {
    int countByExample(ActivityLotteryExample example);

    int deleteByExample(ActivityLotteryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActivityLottery record);

    int insertSelective(ActivityLottery record);

    List<ActivityLottery> selectByExample(ActivityLotteryExample example);

    ActivityLottery selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActivityLottery record, @Param("example") ActivityLotteryExample example);

    int updateByExample(@Param("record") ActivityLottery record, @Param("example") ActivityLotteryExample example);

    int updateByPrimaryKeySelective(ActivityLottery record);

    int updateByPrimaryKey(ActivityLottery record);
}