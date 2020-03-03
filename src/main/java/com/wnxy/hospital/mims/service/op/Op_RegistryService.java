package com.wnxy.hospital.mims.service.op;

import java.util.List;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;

public interface Op_RegistryService {// 新办就诊卡，挂号

	public void newCard(String pt_id) throws RuntimeException;// 新办就诊卡

	public void rebondCard(OpCard opCard);// 挂失原就诊卡，将身份证和就诊卡号绑定关系解除，将对应卡号状态改为不可用

	public void newPatientInfo(OpPatientinfo opPatientinfo);// 新建病人基本信息

	public OpPatientinfo queryPatientBypt_id(String pt_id);// 根据病人身份证号查病人基本信息


	public void newOpRegistry(OpRegistry opRegistry);// 新建挂号单

	List<OpCard> queryCardBypt_id(String pt_id);//根据病人身份证号查就诊卡

}
