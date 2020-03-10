package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.wnxy.hospital.mims.entity.OpCasehistory;

public interface CaseHistoryService {

	String createCaseHistory(OpCasehistory casehistory);

	List<OpCasehistory> getCaseHistory(String patientid);

	void modifyCaseHistoryState(String caseid, Integer state);
	
	void modifyCaseHistoryTreatment(String caseid,Integer scheme);
}
