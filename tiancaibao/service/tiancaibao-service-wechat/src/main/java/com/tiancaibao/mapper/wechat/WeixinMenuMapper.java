package com.tiancaibao.mapper.wechat;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.wechat.WeixinMenu;
import com.tiancaibao.pojo.wechat.WeixinMenuExample;

public interface WeixinMenuMapper {
    int countByExample(WeixinMenuExample example);

    int deleteByExample(WeixinMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WeixinMenu record);

    int insertSelective(WeixinMenu record);

    List<WeixinMenu> selectByExample(WeixinMenuExample example);

    WeixinMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WeixinMenu record, @Param("example") WeixinMenuExample example);

    int updateByExample(@Param("record") WeixinMenu record, @Param("example") WeixinMenuExample example);

    int updateByPrimaryKeySelective(WeixinMenu record);

    int updateByPrimaryKey(WeixinMenu record);
}