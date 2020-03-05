package com.wnxy.hospital.mims.service.op;

import java.util.Date;
import java.util.List;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;

public interface Op_RegistryService {// 诊卡，挂号

	public OpCard newCard(String pt_id) throws RuntimeException;// 新办就诊卡

	public void rebondCard(OpCard opCard);// 挂失原就诊卡，将身份证和就诊卡号绑定关系解除，将对应卡号状态改为不可用

	public void cardRebondForPage(String pt_id);// 挂失就诊卡，给页面用的，只输入身份证号，将根据身份证号查有效就诊卡和挂失二合一

	public void newPatientInfo(OpPatientinfo opPatientinfo);// 新建病人基本信息

	public OpPatientinfo queryPatientBypt_id(String pt_id);// 根据病人身份证号查病人基本信息

	List<OpCard> queryCardBypt_id(String pt_id);// 根据病人身份证号查就诊卡

	List<OpCard> queryCardBycardIdAndpt_id(String cardId, String pt_id);// 根据卡号和身份证号查就诊卡

	List<OpCard> queryCardBycardId(String cardId);// 根据就诊卡号查有效就诊卡

	public void cardIssuingForPage(OpPatientinfo opPatientinfo);// 发卡，给页面用的，录入病人基本信息建卡表记录二合一

	public List<OpDoclevel> queryOpDoclevelByLevel(Integer level);// 根据医生等级查医生编号和收费标准

	public List<Integer> queryAllOpDoclevel();// 查询所有医生等级

	OpRegistry newOpRegistry(String empId, String cardId);// 新建挂号单

	List<OpRegistry> availableOpRegistry(String empId, String pt_id, Date date,Integer state);// 查有效挂号单，同一天，同一患者，只能挂同一医生一次号

}
