package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.UserPsd;
import com.wnxy.hospital.mims.entity.UserPsdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPsdMapper {
    int countByExample(UserPsdExample example);

    int deleteByExample(UserPsdExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserPsd record);

    int insertSelective(UserPsd record);

    List<UserPsd> selectByExample(UserPsdExample example);

    UserPsd selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserPsd record, @Param("example") UserPsdExample example);

    int updateByExample(@Param("record") UserPsd record, @Param("example") UserPsdExample example);

    int updateByPrimaryKeySelective(UserPsd record);

    int updateByPrimaryKey(UserPsd record);
}