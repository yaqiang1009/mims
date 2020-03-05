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
    
    IpCashPledge selectByPtId(String ptId);

    int addRemainingByExampleSelective(@Param("record") IpCashPledge record, @Param("example") IpCashPledgeExample example);

    int subRemainingByExampleSelective(@Param("record") IpCashPledge record, @Param("example") IpCashPledgeExample example);
    
    int addRemainingByExample(@Param("record") IpCashPledge record, @Param("example") IpCashPledgeExample example);
    
    int subRemainingByExample(@Param("record") IpCashPledge record, @Param("example") IpCashPledgeExample example);

    int addRemainingByPrimaryKeySelective(IpCashPledge record);

    int subRemainingByPrimaryKeySelective(IpCashPledge record);

    int addRemainingByPrimaryKey(IpCashPledge record);
    
    int subRemainingByPrimaryKey(IpCashPledge record);
}