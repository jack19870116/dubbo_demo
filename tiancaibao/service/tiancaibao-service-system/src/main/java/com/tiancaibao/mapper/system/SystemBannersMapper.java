package com.tiancaibao.mapper.system;

import com.tiancaibao.pojo.system.SystemBanners;
import com.tiancaibao.pojo.system.SystemBannersExample;
import com.tiancaibao.pojo.system.SystemBannersWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemBannersMapper {
    long countByExample(SystemBannersExample example);

    int deleteByExample(SystemBannersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemBannersWithBLOBs record);

    int insertSelective(SystemBannersWithBLOBs record);

    List<SystemBannersWithBLOBs> selectByExampleWithBLOBs(SystemBannersExample example);

    List<SystemBanners> selectByExample(SystemBannersExample example);

    SystemBannersWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemBannersWithBLOBs record, @Param("example") SystemBannersExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemBannersWithBLOBs record, @Param("example") SystemBannersExample example);

    int updateByExample(@Param("record") SystemBanners record, @Param("example") SystemBannersExample example);

    int updateByPrimaryKeySelective(SystemBannersWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemBannersWithBLOBs record);

    int updateByPrimaryKey(SystemBanners record);
}