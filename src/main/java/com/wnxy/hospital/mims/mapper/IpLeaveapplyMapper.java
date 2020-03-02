package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpLeaveapplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpLeaveapplyMapper {
    int countByExample(IpLeaveapplyExample example);

    int deleteByExample(IpLeaveapplyExample example);

    int deleteByPrimaryKey(String applyId);

    int insert(IpLeaveapply record);

    int insertSelective(IpLeaveapply record);

    List<IpLeaveapply> selectByExample(IpLeaveapplyExample example);

    IpLeaveapply selectByPrimaryKey(String applyId);

    int updateByExampleSelective(@Param("record") IpLeaveapply record, @Param("example") IpLeaveapplyExample example);

    int updateByExample(@Param("record") IpLeaveapply record, @Param("example") IpLeaveapplyExample example);

    int updateByPrimaryKeySelective(IpLeaveapply record);

    int updateByPrimaryKey(IpLeaveapply record);
}