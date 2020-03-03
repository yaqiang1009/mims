package com.wnxy.hospital.mims.service.ip.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.IpHospitalized;
import com.wnxy.hospital.mims.entity.IpHospitalizedExample;
import com.wnxy.hospital.mims.entity.IpIllness;
import com.wnxy.hospital.mims.entity.IpIllnessExample;
import com.wnxy.hospital.mims.mapper.IpIllnessMapper;
import com.wnxy.hospital.mims.service.ip.Ip_IllnessService;
/**
 * 住院就诊病情单相关
 * @author Administrator
 *
 */
@Component
public class Ip_IllnessServiceImpl implements Ip_IllnessService {
	@Autowired
	IpIllnessMapper ipIllnessMapper;
	
	//开具病情单
	@Override
	public String addIllnessOrder(IpIllness ipIllness) {
		//接收页面传的对象
		//生成主键
		ipIllness.setIllnessId(ipIllness.getIllnessId());
		//插入时日期
		ipIllness.setIllnessDate(new Date());
		try {
			ipIllnessMapper.insert(ipIllness);
			return "插入成功";
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return "插入失败";
		}
	}

	//修改开具的病情单，但是时间应该是不能修改的
	@Override
	public String updateIllnessOrder(IpIllness ipIllness) {
		try {
			//方法为只修改参数不为空的字段，网页传过来时不把日期传过来就可以
			int updateCount = ipIllnessMapper.updateByPrimaryKeySelective(ipIllness);
			//没有异常也要判断数据库是否真的被修改
			if(updateCount==0) {
				return "修改失败";
			}
			return "修改成功";
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return "修改失败";
		}
	}

	//查询病情单，可添加条件
	@Override
	public List<IpIllness> selectIpIllnessByExample(IpIllnessExample example) {
		try {
			//方法为只修改参数不为空的字段，网页传过来时不把日期传过来就可以
			List<IpIllness> list = ipIllnessMapper.selectByExample(example);
			//没有异常也要判断数据库是否真的被修改
			return list;
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
			return null;
		}
	}

}
