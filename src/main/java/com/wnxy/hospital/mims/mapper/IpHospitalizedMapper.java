package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpHospitalizedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpHospitalizedMapper {
    int countByExample(IpHospitalizedExample example);

    int deleteByExample(IpHospitalizedExample example);

    int deleteByPrimaryKey(String hospitalizedId);

    int insert(IpHospitalized record);

    int insertSelective(IpHospitalized record);

    List<IpHospitalized> selectByExample(IpHospitalizedExample example);

    IpHospitalized selectByPrimaryKey(String hospitalizedId);

    int updateByExampleSelective(@Param("record") IpHospitalized record, @Param("example") IpHospitalizedExample example);

    int updateByExample(@Param("record") IpHospitalized record, @Param("example") IpHospitalizedExample example);

    int updateByPrimaryKeySelective(IpHospitalized record);

    int updateByPrimaryKey(IpHospitalized record);
}