package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.wnxy.hospital.mims.dto.CallIdItemDTO;

public interface CallIdListService {
	void generiteCallIdList(String doctorid);
	List<CallIdItemDTO> getCallIdList(String doctorid);
	void modifiyCallIdList(String calllistid, Integer state);
}
