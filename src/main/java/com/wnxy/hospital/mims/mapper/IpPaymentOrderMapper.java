package com.wnxy.hospital.mims.mapper;

import com.wnxy.hospital.mims.entity.IpPaymentOrder;
import com.wnxy.hospital.mims.entity.IpPaymentOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IpPaymentOrderMapper {
    int countByExample(IpPaymentOrderExample example);

    int deleteByExample(IpPaymentOrderExample example);

    int deleteByPrimaryKey(String paymentId);

    int insert(IpPaymentOrder record);

    int insertSelective(IpPaymentOrder record);

    List<IpPaymentOrder> selectByExample(IpPaymentOrderExample example);

    IpPaymentOrder selectByPrimaryKey(String paymentId);

    int updateByExampleSelective(@Param("record") IpPaymentOrder record, @Param("example") IpPaymentOrderExample example);

    int updateByExample(@Param("record") IpPaymentOrder record, @Param("example") IpPaymentOrderExample example);

    int updateByPrimaryKeySelective(IpPaymentOrder record);

    int updateByPrimaryKey(IpPaymentOrder record);
}