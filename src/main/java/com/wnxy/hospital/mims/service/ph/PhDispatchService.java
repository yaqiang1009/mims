package com.wnxy.hospital.mims.service.ph;

import java.util.List;
import com.wnxy.hospital.mims.entity.PhDispatch;

public interface PhDispatchService {
	//新增调度单
	int insertPhDispatch(PhDispatch pd);
	//查询单个调度单
	List<PhDispatch> getAllDispatch();
	//根据条件查询调度单
	List<PhDispatch> getDispatchBycondition(PhDispatch pd);
}
