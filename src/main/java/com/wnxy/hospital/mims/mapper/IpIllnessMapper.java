package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpIllnessMapper {
    int countByExample(IpIllnessExample example);

    int deleteByExample(IpIllnessExample example);

    int deleteByPrimaryKey(String illnessId);

    int insert(IpIllness record);

    int insertSelective(IpIllness record);

    List<IpIllness> selectByExample(IpIllnessExample example);

    IpIllness selectByPrimaryKey(String illnessId);

    int updateByExampleSelective(@Param("record") IpIllness record, @Param("example") IpIllnessExample example);

    int updateByExample(@Param("record") IpIllness record, @Param("example") IpIllnessExample example);

    int updateByPrimaryKeySelective(IpIllness record);

    int updateByPrimaryKey(IpIllness record);
}