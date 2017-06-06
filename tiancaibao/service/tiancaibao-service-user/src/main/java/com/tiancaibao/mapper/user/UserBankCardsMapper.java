package com.tiancaibao.mapper.user;

import com.tiancaibao.pojo.user.UserBankCards;
import com.tiancaibao.pojo.user.UserBankCardsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBankCardsMapper {
    long countByExample(UserBankCardsExample example);

    int deleteByExample(UserBankCardsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBankCards record);

    int insertSelective(UserBankCards record);

    List<UserBankCards> selectByExample(UserBankCardsExample example);

    UserBankCards selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBankCards record, @Param("example") UserBankCardsExample example);

    int updateByExample(@Param("record") UserBankCards record, @Param("example") UserBankCardsExample example);

    int updateByPrimaryKeySelective(UserBankCards record);

    int updateByPrimaryKey(UserBankCards record);
}