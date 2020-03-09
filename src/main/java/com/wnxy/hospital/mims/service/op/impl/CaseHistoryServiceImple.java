package com.wnxy.hospital.mims.service.op.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wnxy.hospital.mims.entity.OpCasehistory;
import com.wnxy.hospital.mims.entity.OpCasehistoryExample;
import com.wnxy.hospital.mims.mapper.OpCasehistoryMapper;
import com.wnxy.hospital.mims.service.op.CaseHistoryService;

@Service
public class CaseHistoryServiceImple implements CaseHistoryService {

	@Autowired
	OpCasehistoryMapper chmapper;

	@Override
	public String createCaseHistory(OpCasehistory casehistory) {
		// 生辰新病历
		try {
			chmapper.insert(casehistory);
			return casehistory.getCaseId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OpCasehistory> getCaseHistory(String patientid) {
		try {
			// 通过病人id查询病历。
			OpCasehistoryExample example = new OpCasehistoryExample();
			example.createCriteria().andPtIdEqualTo(patientid);
			PageHelper.orderBy("date desc");
			return chmapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modifyCaseHistoryState(String caseid, Integer state) {
		try {
			// 查询病历编号，修改状态
			OpCasehistory casehistory = chmapper.selectByPrimaryKey(caseid);
			casehistory.setState(state);
			chmapper.updateByPrimaryKey(casehistory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}