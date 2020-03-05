package com.wnxy.hospital.mims.service.op.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpCardExample;
import com.wnxy.hospital.mims.entity.OpCardExample.Criteria;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpDoclevelExample;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.mapper.OpCardMapper;
import com.wnxy.hospital.mims.mapper.OpDoclevelMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.mapper.OpRegistryMapper;
import com.wnxy.hospital.mims.service.op.Op_RegistryService;

@Component
public class Op_RegistryServiceImpl implements Op_RegistryService {
	@Autowired
	OpCardMapper opCardMapper;
	@Autowired
	OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	OpRegistryMapper opRegistryMapper;
	@Autowired
	OpDoclevelMapper opDoclevelMapper;

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
	public OpCard newCard(String pt_id) throws RuntimeException {// 新办就诊卡
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
			return tempOpCard;
		}
		return null;

	}

	@Override
	public void rebondCard(OpCard opCard) {// 就诊卡挂失

		List<OpCard> verifyCards = queryCardBycardIdAndpt_id(opCard.getCardId(), opCard.getPtId());// 存储通过身份证号查询的卡记录集合用于验证
		try {
			if (verifyCards.size() == 1) {// 有效卡号有且只能有一个，否则抛异常
				// 将卡表中对应的卡号状态设为2不可用
				OpCard tempCard = new OpCard(opCard.getCardId(), opCard.getPtId(), 2);
				opCardMapper.updateByPrimaryKey(tempCard);
				System.out.println("老卡状态已修改");
				System.out.println("验证卡集合长度：" + verifyCards.size());
				// 再将对应身份号的患者身份证与新卡号绑定
				newCard(opCard.getPtId());

			} else {

				throw new RuntimeException("挂失失败，卡号有误或重复挂失");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("挂失失败");
		}
	}

	@Override
	public List<OpCard> queryCardBypt_id(String pt_id) {// 根据身份证号查有效就诊卡
		OpCardExample example = new OpCardExample();

		Criteria criteria = example.createCriteria();

		criteria.andPtIdEqualTo(pt_id);// 根据身份证查
		criteria.andStateEqualTo(1);// 根据有效状态查

		List<OpCard> tempOpCards = (List<OpCard>) opCardMapper.selectByExample(example);
		System.out.println("根据身份证号查有效就诊卡：" + tempOpCards);
		return tempOpCards;
	}

	@Override
	public List<OpCard> queryCardBycardIdAndpt_id(String cardId, String pt_id) {// 根据卡号，身份证号查有效就诊卡
		OpCardExample example = new OpCardExample();

		Criteria criteria = example.createCriteria();
		criteria.andCardIdEqualTo(cardId);// 根据卡号查
		criteria.andPtIdEqualTo(pt_id);// 根据身份证查
		criteria.andStateEqualTo(1);// 根据有效状态查

		List<OpCard> tempOpCards = (List<OpCard>) opCardMapper.selectByExample(example);
		System.out.println("根据卡号，身份证号查有效就诊卡：" + tempOpCards);
		return tempOpCards;
	}

	@Override
	public List<OpCard> queryCardBycardId(String cardId) {// 根据卡号查有效就诊卡
		OpCardExample example = new OpCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andCardIdEqualTo(cardId);// 根据卡号查
		criteria.andStateEqualTo(1);// 根据有效状态查
		List<OpCard> tempOpCards = (List<OpCard>) opCardMapper.selectByExample(example);
		System.out.println("根据卡号查有效就诊卡：" + tempOpCards);
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
	public List<OpDoclevel> queryOpDoclevelByLevel(Integer level) {// 根据医生等级查医生编号和收费标准
		OpDoclevelExample example = new OpDoclevelExample();
		com.wnxy.hospital.mims.entity.OpDoclevelExample.Criteria criteria = example.createCriteria();
		criteria.andLevelEqualTo(level);
		List<OpDoclevel> opDoclevels = opDoclevelMapper.selectByExample(example);
		return opDoclevels;

	}

	@Override
	public List<Integer> queryAllOpDoclevel() {// 查询所有医生等级
		OpDoclevelExample example = new OpDoclevelExample();
		com.wnxy.hospital.mims.entity.OpDoclevelExample.Criteria criteria = example.createCriteria();
		criteria.andLevelIsNotNull();// 查出所有非空的等级
		List<OpDoclevel> oPDoclevels = opDoclevelMapper.selectByExample(example);// 得到所有收费等级的集合
		List<Integer> levels = new ArrayList<Integer>();
		for (int i = 0; i < oPDoclevels.size(); i++) {// 遍历收费等级集合，只将等级存入集合
			levels.add(i, (oPDoclevels.get(i).getLevel()));
		}

		return levels;// 返回所有等级集合
	}

	@Override
	public OpRegistry newOpRegistry(String dlId, String empId, String cardId) {
				
				List<OpCard> verifyCards = queryCardBycardId(cardId);
				if (verifyCards.size() == 1) {
					// 挂号单号
					String rs_Id = UUID.randomUUID().toString().replace("-", "").trim().toString();
					// 病人身份证号
					String pt_Id = verifyCards.get(0).getPtId();
					// 医生等级编号
					String tempDlId=dlId;
					// 挂号单状态,1待支付
					Integer state=1;
					// 挂号日期
					Date date=new Date();
					// 挂号价格
					
					//Float regprice=new BigDecimal(val)
					// 医生员工号private String empId;
					// opRegistry = new OpRegistry(rs_Id,);
					// opRegistryMapper.insert(opRegistry);
				}

				return null;
	}

}
