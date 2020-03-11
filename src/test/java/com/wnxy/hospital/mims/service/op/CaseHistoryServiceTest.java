package com.wnxy.hospital.mims.service.op;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.OpCasehistory;
import com.wnxy.hospital.mims.service.op.impl.CaseHistoryServiceImple;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CaseHistoryServiceTest {

	@Autowired
	CaseHistoryServiceImple caseHistoryServiceImple;
	
	@Test
	public void testcreateCaseHistory() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		  OpCasehistory casehistory = new OpCasehistory(uuid,
		  "136bca00-5d1b-11ea-ba6e-00ffaca66b24" ,
		  "886070a9-5ded-11ea-a024-00ffaca66b24", "肩关节脱臼发炎", new Date(), 0);
		  caseHistoryServiceImple.createCaseHistory(casehistory);
	}
	@Test
	public void testgetCaseHistory() {
		String patientid = "136bca00-5d1b-11ea-ba6e-00ffaca66b24";
		List<OpCasehistory> list = caseHistoryServiceImple.getCaseHistory(patientid);
		for(OpCasehistory oc:list) {
			log.info(oc.toString());
		}
	}
	@Test
	public void testmodifyCaseHistoryState() {
		String caseid = "0b145f944cf340fd9b971767e42c4a13";
		caseHistoryServiceImple.modifyCaseHistoryState(caseid, 1);
	}
	
	@Test
	public void testmodifyCaseHistoryTreatment() {
		caseHistoryServiceImple.modifyCaseHistoryTreatment("0b145f944cf340fd9b971767e42c4a13", 0);
	}
}
