package com.wnxy.hospital.mims.service.op.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpCardExample;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.mapper.OpCardMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.service.op.Op_RegistryService;

@Component
public class Op_RegistryServiceImpl implements Op_RegistryService {
	@Autowired
	OpCardMapper opCardMapper;
	@Autowired
	OpPatientinfoMapper opPatientinfoMapper;

	@Override
	public void newPatientInfo(OpPatientinfo opPatientinfo) {// 录入病人基本信息
		try {
			opPatientinfoMapper.insert(opPatientinfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加病人信息失败，请勿重复添加");

		}
	}

	@Override
	public void newCard(String pt_id) throws RuntimeException {// 新办就诊卡
		List<OpCard> verifyCards = queryCardBypt_id(pt_id);// 存储通过身份证号查询的卡记录集合用于验证
		if (verifyCards.size() != 0) {// 如果有身份证号对应的有效就诊卡则抛异常
			try {
				{
					throw new RuntimeException("该身份证号有可用就诊卡，如需办卡请挂失");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("不允许重复办卡");
			}
		} else {// 生成就诊卡号，存入病人身份证号，将卡的状态标记为1可用
			OpCard tempOpCard = new OpCard(UUID.randomUUID().toString().replace("-", "").trim().toString(), pt_id, 1);
			opCardMapper.insert(tempOpCard);
			System.out.println("办卡成功");
		}

	}

	@Override
	public void rebondCard(OpCard opCard) {// 就诊卡挂失
		// 将卡表中对应的卡号状态设为2不可用
		OpCard tempCard = new OpCard(opCard.getCardId(), opCard.getPtId(), 2);
		opCardMapper.updateByPrimaryKey(tempCard);

		// 再将对应身份号的患者身份证与新卡号绑定
		tempCard = new OpCard(UUID.randomUUID().toString().replace("-", "").trim().toString(), opCard.getPtId(), 1);
		opCardMapper.insert(tempCard);
	}

	@Override
	public List<OpCard> queryCardBypt_id(String pt_id) {// 根据身份证号查有效就诊卡
		OpCardExample example = new OpCardExample();
		example.createCriteria().andPtIdEqualTo(pt_id);// 根据身份证查
		example.createCriteria().andStateEqualTo(1);// 根据有效状态查
		List<OpCard> tempOpCards = (List<OpCard>) opCardMapper.selectByExample(example);
		return tempOpCards;
	}

	@Override
	public OpPatientinfo queryPatientBypt_id(String pt_id) {// 根据病人身份证号查询病人基本信息
		if (opPatientinfoMapper.selectByPrimaryKey(pt_id) == null) {
			throw new RuntimeException("未查到该病人基本信息");

		}
		return opPatientinfoMapper.selectByPrimaryKey(pt_id);
	}

	@Override
	public void newOpRegistry(OpRegistry opRegistry) {
		// TODO Auto-generated method stub

	}

}
