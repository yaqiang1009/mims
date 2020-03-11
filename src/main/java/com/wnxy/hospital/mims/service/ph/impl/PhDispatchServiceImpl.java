package com.wnxy.hospital.mims.service.ph.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.PhDispatch;
import com.wnxy.hospital.mims.entity.PhDispatchExample;
import com.wnxy.hospital.mims.entity.PhDispatchExample.Criteria;
import com.wnxy.hospital.mims.exception.PhMedicineException;
import com.wnxy.hospital.mims.mapper.PhDispatchMapper;
import com.wnxy.hospital.mims.service.ph.PhDispatchService;
@Service
public class PhDispatchServiceImpl implements PhDispatchService {
	@Autowired
	private PhDispatchMapper phDispatchMapper;
	//新增调度单
	@Override
	public int insertPhDispatch(PhDispatch pd) {
		try {
			int num = phDispatchMapper.insertSelective(pd);
			return num;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}
	
	//查询全部调拨单
	@Override
	public List<PhDispatch> getAllDispatch() {
		try {
			PhDispatchExample pde = new PhDispatchExample();
			List<PhDispatch> pds = phDispatchMapper.selectByExample(pde);
			return pds;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}
	//根据条件查询调度单
	@Override
	public List<PhDispatch> getDispatchBycondition(PhDispatch pd) {
		PhDispatchExample pde = new PhDispatchExample();
		Criteria cc = pde.createCriteria();
		//根据药品名称查询
		cc.andMedicineNameLike("%"+pd.getMedicineName()+"%");
		//根据状态查询
		cc.andStatusEqualTo(pd.getStatus());
		//根据调用数量查询,小于等于输入数量
		//cc.andDispatchCountLessThanOrEqualTo(pd.getDispatchCount());
		//根据包装类型查询
		cc.andMedicineTypeLike("%"+pd.getMedicineType()+"%");
		//根据调度时间查询
		//cc.andEnterDateEqualTo(pd.getEnterDate());
		//调度时间降序排序
		pde.setOrderByClause("enter_date desc");
		try {
			List<PhDispatch> pds = phDispatchMapper.selectByExample(pde);
			return pds;
		} catch (Exception e) {
			throw new PhMedicineException(e);
		}
	}

}
