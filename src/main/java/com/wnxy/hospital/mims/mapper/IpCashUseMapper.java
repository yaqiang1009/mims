package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpCashUse;
import com.wnxy.hospital.mims.entity.IpCashUseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpCashUseMapper {
    int countByExample(IpCashUseExample example);

    int deleteByExample(IpCashUseExample example);

    int deleteByPrimaryKey(String cashUseId);

    int insert(IpCashUse record);

    int insertSelective(IpCashUse record);

    List<IpCashUse> selectByExample(IpCashUseExample example);

    IpCashUse selectByPrimaryKey(String cashUseId);

    int updateByExampleSelective(@Param("record") IpCashUse record, @Param("example") IpCashUseExample example);

    int updateByExample(@Param("record") IpCashUse record, @Param("example") IpCashUseExample example);

    int updateByPrimaryKeySelective(IpCashUse record);

    int updateByPrimaryKey(IpCashUse record);
}