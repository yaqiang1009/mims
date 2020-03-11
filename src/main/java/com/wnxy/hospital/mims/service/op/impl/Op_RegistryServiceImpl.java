package com.wnxy.hospital.mims.service.op.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.wnxy.hospital.mims.entity.OpCard;
import com.wnxy.hospital.mims.entity.OpCardExample;
import com.wnxy.hospital.mims.entity.OpCardExample.Criteria;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpDoclevelExample;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.entity.OpRegistryExample;
import com.wnxy.hospital.mims.mapper.OpCardMapper;
import com.wnxy.hospital.mims.mapper.OpDoclevelMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.mapper.OpRegistryMapper;
import com.wnxy.hospital.mims.service.op.Op_RegistryService;

@Service
public class Op_RegistryServiceImpl implements Op_RegistryService {
	@Autowired
	OpCardMapper opCardMapper;
	@Autowired
	OpPatientinfoMapper opPatientinfoMapper;
	@Autowired
	OpRegistryMapper opRegistryMapper;
	@Autowired
	OpDoclevelMapper opDoclevelMapper;
	@Autowired
	Op_InfoManagementServiceImpl op_InfoManagementServiceImpl;// 调用另一个实现类的方法前要注入对象，否则报空指针

	@Override
	public void newPatientInfo(OpPatientinfo opPatientinfo) throws RuntimeException {// 录入病人基本信息
		List<OpCard> verifyCards = queryCardBypt_id(opPatientinfo.getPtId());// 存储通过身份证号查询的卡记录集合用于验证
		if (verifyCards.size() != 0) {// 如果有身份证号对应的有效就诊卡则抛异常

			System.out.println("不允许重复办卡");
			throw new RuntimeException("该身份证号有可用就诊卡，如需办卡请挂失");

		} else {
			opPatientinfoMapper.insert(opPatientinfo);

			System.out.println("病人基本信息录入成功");
		}

	}

	@Override
	public OpCard newCard(String pt_id) throws RuntimeException {// 新办就诊卡
		List<OpCard> verifyCards = queryCardBypt_id(pt_id);// 存储通过身份证号查询的卡记录集合用于验证
		if (verifyCards.size() != 0) {// 如果有身份证号对应的有效就诊卡则抛异常

			{
				System.out.println("不允许重复办卡");
				throw new RuntimeException("该身份证号有可用就诊卡，如需办卡请挂失");

			}

		} else {// 生成就诊卡号，存入病人身份证号，将卡的状态标记为1可用
			OpCard tempOpCard = new OpCard(UUID.randomUUID().toString().replace("-", "").trim().toString(), pt_id, 1);
			opCardMapper.insert(tempOpCard);
			System.out.println("办卡成功");
			return tempOpCard;
		}

	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	@Override // 病人信息录入、卡表建档必须一起完成，否则回滚
	public void cardIssuingForPage(OpPatientinfo opPatientinfo) {// 给发卡页面用的，病人基本信息录入，建卡表记录二合一
		newPatientInfo(opPatientinfo);
		newCard(opPatientinfo.getPtId());
	}



	@Override
	public void rebondCard(OpCard opCard) throws RuntimeException {// 就诊卡挂失

		List<OpCard> verifyCards = queryCardBycardIdAndpt_id(opCard.getCardId(), opCard.getPtId());// 存储通过身份证号查询的卡记录集合用于验证

		if (verifyCards.size() == 1) {// 有效卡号有且只能有一个，否则抛异常
			// 将卡表中对应的卡号状态设为2不可用
			OpCard tempCard = new OpCard(opCard.getCardId(), opCard.getPtId(), 2);
			opCardMapper.updateByPrimaryKey(tempCard);
			System.out.println("老卡状态已修改");
			System.out.println("验证卡集合长度：" + verifyCards.size());
			// 再将对应身份号的患者身份证与新卡号绑定
			newCard(opCard.getPtId());

		} else {

			throw new RuntimeException("挂失失败，身份证号有误或重复挂失");
		}

	}

	@Override
	public void cardRebondForPage(String pt_id) throws RuntimeException {// 给页面用的就诊卡挂失，只用输入身份证号，查卡号挂失二合一
		List<OpCard> opCards = queryCardBypt_id(pt_id);
		if (opCards.size() == 1) {
			rebondCard(opCards.get(0));
		} else {
			throw new RuntimeException("挂失失败，无此身份证号或身份证号有误");
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
	public OpRegistry newOpRegistry(String empId, String cardId) {// 新建挂号单

		List<OpCard> verifyCards = queryCardBycardId(cardId);// 查就诊卡是否有效
		// 此处要用到信息管理类的方法，先获取该类对象
		List<OpDoclevel> opDoclevels = op_InfoManagementServiceImpl.queryOpDoclevelByEmpId(empId);// 根据医生员工号，查收费等级信息

		System.out.println("此处应该有收费信息：" + opDoclevels);

		if (verifyCards.size() == 1 && opDoclevels.size() == 1) {// 患者就诊卡号有效，并且有对应的科室信息
			List<OpRegistry> opRegistrys = availableOpRegistry(empId, verifyCards.get(0).getPtId(), new Date(), 0);// 查有效挂号单，同一天，同一患者，只能挂同一医生一次号
			if (opRegistrys.size() == 0) {
				// 挂号单号
				String rs_Id = UUID.randomUUID().toString().replace("-", "").trim().toString();
				// 病人身份证号
				String pt_Id = verifyCards.get(0).getPtId();
				// 医生等级编号
				String tempDlId = opDoclevels.get(0).getDlId();
				// 挂号单状态,0待支付
				Integer state = 0;
				// 挂号日期
				Date date = new Date();
				// 挂号价格
				Float regprice = opDoclevels.get(0).getPrice();
				// 医生员工号empId
				OpRegistry opRegistry = new OpRegistry(rs_Id, pt_Id, tempDlId, state, date, regprice, empId);
				opRegistryMapper.insert(opRegistry);
				System.out.println("挂号成功");
				return opRegistry;
			} else {
				throw new RuntimeException("挂号失败，请勿重复挂号");
			}
		} else {
			throw new RuntimeException("挂号失败，就诊卡无效或科室不存在");
		}

	}

	@Override
	public List<OpRegistry> availableOpRegistry(String empId, String pt_id, Date date, Integer state) {// 查有效挂号单，同一天，同一患者，只能挂同一医生一次号
		OpRegistryExample example = new OpRegistryExample();
		com.wnxy.hospital.mims.entity.OpRegistryExample.Criteria criteria = example.createCriteria();
		criteria.andEmpIdEqualTo(empId);
		criteria.andPtIdEqualTo(pt_id);
		criteria.andDateEqualTo(date);
		criteria.andStateEqualTo(state);
		return opRegistryMapper.selectByExample(example);

	}

	@Override
	public List<OpRegistry> AllAvailableOpRegistry(Integer state) {// 查全部有效挂号单
		OpRegistryExample example = new OpRegistryExample();
		com.wnxy.hospital.mims.entity.OpRegistryExample.Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(state);
		return opRegistryMapper.selectByExample(example);

	}

	@Override
	public List<OpRegistry> selectOpRegistryByCondition(String rsId, String ptId, String dlId, Integer state, Date date,
			float regprice, String empId) {// 多条件模糊查询挂号单
		OpRegistryExample example = new OpRegistryExample();
		com.wnxy.hospital.mims.entity.OpRegistryExample.Criteria criteria = example.createCriteria();
		if (rsId != null) {
			criteria.andRsIdLike("%" + rsId + "%");
		}

		if (ptId != null) {
			criteria.andPtIdLike("%" + ptId + "%");
		}

		if (dlId != null) {
			criteria.andDlIdLike("%" + dlId + "%");
		}

		if (state != null) {
			criteria.andStateEqualTo(state);
		}

		if (date != null) {
			criteria.andDateEqualTo(date);
		}

		if (regprice != 0.0f) {
			criteria.andRegpriceEqualTo(regprice);
		}

		if (empId != null) {
			criteria.andEmpIdLike("%" + empId + "%");
		}

		return opRegistryMapper.selectByExample(example);
	}

}
