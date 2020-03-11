package com.wnxy.hospital.mims.service.op;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.OpDruglist;
import com.wnxy.hospital.mims.service.op.impl.DrugListServiceImpl;
import com.wnxy.hospital.mims.utils.MyUuid;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DrugListServiceTest {

	@Autowired
	DrugListServiceImpl drugListService;
	
	@Test
	public void testgenerateDrugList() {
		List<OpDruglist> druglist = new ArrayList<OpDruglist>();
		String ptId = "3ed6b3ee434a46a5ac4ce81eea43c7cc";
		druglist.add(new OpDruglist(MyUuid.getMyUuid(), ptId, "1231", 5, 3.5F));
		druglist.add(new OpDruglist(MyUuid.getMyUuid(), ptId, "1232", 5, 3.5F));
		drugListService.generateDrugList(druglist);
	}
	@Test
	public void testgetDrugList() {
		String prescriptionid="3ed6b3ee434a46a5ac4ce81eea43c7cc";
		List<OpDruglist> drugList = drugListService.getDrugList(prescriptionid);
		for(OpDruglist s:drugList) {
			log.info(s.toString());
		}
	}
	@Test
	public void testmodifyDrugList() {
		String prescriptionid="3ed6b3ee434a46a5ac4ce81eea43c7cc";
		String medicineid="1231";
		drugListService.modifyDrugList(prescriptionid,medicineid, 2);
	}
	
	
}
