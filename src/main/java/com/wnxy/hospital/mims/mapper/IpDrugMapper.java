package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.entity.IpDrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpDrugMapper {
    int countByExample(IpDrugExample example);

    int deleteByExample(IpDrugExample example);

    int deleteByPrimaryKey(String drugId);

    int insert(IpDrug record);

    int insertSelective(IpDrug record);

    List<IpDrug> selectByExample(IpDrugExample example);

    IpDrug selectByPrimaryKey(String drugId);
    
    IpDrug selectByIllnessId(String illnessId);

    int updateByExampleSelective(@Param("record") IpDrug record, @Param("example") IpDrugExample example);

    int updateByExample(@Param("record") IpDrug record, @Param("example") IpDrugExample example);

    int updateByPrimaryKeySelective(IpDrug record);

    int updateByPrimaryKey(IpDrug record);
}