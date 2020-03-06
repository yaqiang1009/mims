package com.wnxy.hospital.mims.service.op;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.OpPrescription;
import com.wnxy.hospital.mims.service.op.impl.PrescriptionServiceImpl;
import com.wnxy.hospital.mims.utils.MyUuid;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PrescriptionServiceTest {

	@Autowired
	PrescriptionServiceImpl prescriptionService;
	
	@Test
	public void testgeneratePrescription() {
		String tmId = "886070a9-5ded-11ea-a024-00ffaca66b24";
		String empId = "6f24ac1b-5d1e-11ea-ba6e-00ffaca66b24";
		OpPrescription prescription = 
				new OpPrescription(MyUuid.getMyUuid(), tmId, empId, new Date(), "多喝岩浆", 123F, 1);
		prescriptionService.generatePrescription(prescription);
	}
	@Test
	public void testgetPrescription() {
		OpPrescription prescription = 
				prescriptionService.getPrescription("3ed6b3ee434a46a5ac4ce81eea43c7cc");
		log.info(prescription.toString());
	}
	@Test
	public void testmodifyPrescription() {
		prescriptionService.modifyPrescription("3ed6b3ee434a46a5ac4ce81eea43c7cc", 0);
	}
}
