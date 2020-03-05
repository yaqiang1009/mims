package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wnxy.hospital.mims.entity.IpLeaveapply;
import com.wnxy.hospital.mims.entity.IpRemedy;
import com.wnxy.hospital.mims.mapper.IpLeaveapplyMapper;
import com.wnxy.hospital.mims.mapper.IpRemedyMapper;
import com.wnxy.hospital.mims.service.ip.Ip_LeaveapplyService;
/**
 * 申请出院单
 * @author Administrator
 *
 */
@Component
public class Ip_LeaveapplyServiceImpl implements Ip_LeaveapplyService {
	@Autowired
	IpLeaveapplyMapper ipLeaveapplyMapper;
	@Autowired
	IpRemedyMapper ipRemedyMapper;
	
	//申请出院单
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String addLeaveapplyOrder(IpLeaveapply ipLeaveapply) {
		try {
			//生成编号主键
			ipLeaveapply.setApplyId(ipLeaveapply.getApplyId());
			//日期
			ipLeaveapply.setApplyDate(new Date());
			//审核结果
			ipLeaveapply.setResult("申请中");
			//只插入不为空的字段
			int count = ipLeaveapplyMapper.insertSelective(ipLeaveapply);
			if(count==0) {
				return "插入失败";
			}
			/*
			 * if(true) { throw new RuntimeException("出错"); }
			 */
			//修改医疗单状态为申请出院中
			IpRemedy ipRemedy = ipRemedyMapper.selectByPrimaryKey(ipLeaveapply.getRemedyId());
			ipRemedy.setRemedyStatus("申请出院中");
			ipRemedyMapper.updateByPrimaryKeySelective(ipRemedy);
			return "插入成功";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错");
		}
	}

}
