package com.wnxy.hospital.mims.service.ip.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpDrug;
import com.wnxy.hospital.mims.mapper.IpDrugMapper;
import com.wnxy.hospital.mims.service.ip.Ph_Ip_OderStatus;
/**
 * 药房取药完成修改住院处药单状态方法
 * @author Administrator
 *
 */
@Component
public class Ph_Ip_OderStatusImpl implements Ph_Ip_OderStatus {
	@Autowired
	IpDrugMapper ipDrugMapper;
	
	//提供给药房修改状态的方法——取药成功调用，传住院药单id
	@Override
	public String updateDrugStatusToPh(String drugId) {
		try {
			IpDrug ipDrug = new IpDrug();
			//对象赋值
			ipDrug.setDrugId(drugId);
			ipDrug.setDrugStatus("已取药");
			//先去数据库中查找
			IpDrug selectIpDrug = ipDrugMapper.selectByPrimaryKey(ipDrug .getDrugId());
			//多加层保险，除了待取药其余状态订单按逻辑应该发不到药房，但是加一个判断，只能修改待取药订单
			if(!selectIpDrug.getDrugStatus().equals("待取药")) {
				throw new RuntimeException("无法对该订单操作");
			}
			//修改状态
			int count = ipDrugMapper.updateByPrimaryKeySelective(ipDrug);
			//判断数据库中语句执行成功否
			if(count==0) {
				return "修改失败";
			}
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败";
		}
	}

}
