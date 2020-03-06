package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.wnxy.hospital.mims.entity.OpCasehistory;

public interface CaseHistoryService {

	public void createCaseHistory(OpCasehistory casehistory);
	
	public List<OpCasehistory> getCaseHistory(String patientid);
	
	public void modifyCaseHistoryState(String caseid,Integer state);
}
