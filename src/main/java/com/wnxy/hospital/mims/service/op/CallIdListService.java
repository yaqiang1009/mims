package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.wnxy.hospital.mims.entity.OpCallidlist;

public interface CallIdListService {
	void generiteCallIdList(String doctorid);
	List<OpCallidlist> getCallIdList(String doctorid);
	void modifiyCallIdList(String calllistid, Integer state);
}
