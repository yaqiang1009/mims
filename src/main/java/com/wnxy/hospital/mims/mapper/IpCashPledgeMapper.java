package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpCashPledge;
import com.wnxy.hospital.mims.entity.IpCashPledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpCashPledgeMapper {
    int countByExample(IpCashPledgeExample example);

    int deleteByExample(IpCashPledgeExample example);

    int deleteByPrimaryKey(String cashId);

    int insert(IpCashPledge record);

    int insertSelective(IpCashPledge record);

    List<IpCashPledge> selectByExample(IpCashPledgeExample example);

    IpCashPledge selectByPrimaryKey(String cashId);

    int updateByExampleSelective(@Param("record") IpCashPledge record, @Param("example") IpCashPledgeExample example);

    int updateByExample(@Param("record") IpCashPledge record, @Param("example") IpCashPledgeExample example);

    int updateByPrimaryKeySelective(IpCashPledge record);

    int updateByPrimaryKey(IpCashPledge record);
}