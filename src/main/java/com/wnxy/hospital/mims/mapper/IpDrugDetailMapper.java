package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpDrugDetail;
import com.wnxy.hospital.mims.entity.IpDrugDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpDrugDetailMapper {
    int countByExample(IpDrugDetailExample example);

    int deleteByExample(IpDrugDetailExample example);

    int deleteByPrimaryKey(String detailId);
    
    int deleteByDrugId(String drugId);

    int insert(IpDrugDetail record);

    int insertSelective(IpDrugDetail record);

    List<IpDrugDetail> selectByExample(IpDrugDetailExample example);

    IpDrugDetail selectByPrimaryKey(String detailId);
    
    List<IpDrugDetail> selectByDrugId(String drugId);

    int updateByExampleSelective(@Param("record") IpDrugDetail record, @Param("example") IpDrugDetailExample example);

    int updateByExample(@Param("record") IpDrugDetail record, @Param("example") IpDrugDetailExample example);

    int updateByPrimaryKeySelective(IpDrugDetail record);

    int updateByPrimaryKey(IpDrugDetail record);
}