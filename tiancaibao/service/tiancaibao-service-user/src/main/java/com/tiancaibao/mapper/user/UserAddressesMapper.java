package com.tiancaibao.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.tiancaibao.pojo.user.UserAddresses;
import com.tiancaibao.pojo.user.UserAddressesExample;

public interface UserAddressesMapper {
    int countByExample(UserAddressesExample example);

    int deleteByExample(UserAddressesExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(UserAddresses record);

    int insertSelective(UserAddresses record);

    List<UserAddresses> selectByExampleWithBLOBs(UserAddressesExample example);

    List<UserAddresses> selectByExample(UserAddressesExample example);

    UserAddresses selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") UserAddresses record, @Param("example") UserAddressesExample example);

    int updateByExampleWithBLOBs(@Param("record") UserAddresses record, @Param("example") UserAddressesExample example);

    int updateByExample(@Param("record") UserAddresses record, @Param("example") UserAddressesExample example);

    int updateByPrimaryKeySelective(UserAddresses record);

    int updateByPrimaryKeyWithBLOBs(UserAddresses record);

    int updateByPrimaryKey(UserAddresses record);
}