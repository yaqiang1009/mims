package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.entity.DamagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DamagesMapper {
    int countByExample(DamagesExample example);

    int deleteByExample(DamagesExample example);

    int deleteByPrimaryKey(String damageId);

    int insert(Damages record);

    int insertSelective(Damages record);

    List<Damages> selectByExample(DamagesExample example);

    Damages selectByPrimaryKey(String damageId);

    int updateByExampleSelective(@Param("record") Damages record, @Param("example") DamagesExample example);

    int updateByExample(@Param("record") Damages record, @Param("example") DamagesExample example);

    int updateByPrimaryKeySelective(Damages record);

    int updateByPrimaryKey(Damages record);
}