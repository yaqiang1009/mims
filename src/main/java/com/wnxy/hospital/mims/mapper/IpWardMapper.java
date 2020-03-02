package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpWard;
import com.wnxy.hospital.mims.entity.IpWardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpWardMapper {
    int countByExample(IpWardExample example);

    int deleteByExample(IpWardExample example);

    int deleteByPrimaryKey(String wardId);

    int insert(IpWard record);

    int insertSelective(IpWard record);

    List<IpWard> selectByExample(IpWardExample example);

    IpWard selectByPrimaryKey(String wardId);

    int updateByExampleSelective(@Param("record") IpWard record, @Param("example") IpWardExample example);

    int updateByExample(@Param("record") IpWard record, @Param("example") IpWardExample example);

    int updateByPrimaryKeySelective(IpWard record);

    int updateByPrimaryKey(IpWard record);
}