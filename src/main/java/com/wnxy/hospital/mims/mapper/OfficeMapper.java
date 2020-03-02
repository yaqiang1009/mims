package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OfficeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficeMapper {
    int countByExample(OfficeExample example);

    int deleteByExample(OfficeExample example);

    int deleteByPrimaryKey(String officeId);

    int insert(Office record);

    int insertSelective(Office record);

    List<Office> selectByExample(OfficeExample example);

    Office selectByPrimaryKey(String officeId);

    int updateByExampleSelective(@Param("record") Office record, @Param("example") OfficeExample example);

    int updateByExample(@Param("record") Office record, @Param("example") OfficeExample example);

    int updateByPrimaryKeySelective(Office record);

    int updateByPrimaryKey(Office record);
}