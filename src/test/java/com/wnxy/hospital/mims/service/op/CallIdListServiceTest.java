package com.wnxy.hospital.mims.service.op;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.OpCallidlist;
import com.wnxy.hospital.mims.service.op.impl.CallIdListServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallIdListServiceTest {
	@Autowired
	CallIdListServiceImpl callIdListService;
	
	@Test
	public void testgeneriteCallIdList() {
		String doctorid = "6f24ac1b-5d1e-11ea-ba6e-00ffaca66b24";
		callIdListService.generiteCallIdList(doctorid);
	}
	
	@Test
	public void testgetCallIdList() {
		String doctorid = "6f24ac1b-5d1e-11ea-ba6e-00ffaca66b24";
		List<OpCallidlist> list = callIdListService.getCallIdList(doctorid);
		for(OpCallidlist s:list) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testmodifiyCallIdList() {
		String calllistid = "6c200ed412974d14aebe6fb174d03c60";
		callIdListService.modifiyCallIdList(calllistid , 0);
	}
}
