package com.wnxy.hospital.mims.service.op.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.dto.CallIdItemDTO;
import com.wnxy.hospital.mims.dto.DocterLevelDTO;
import com.wnxy.hospital.mims.dto.EmpDTO;
import com.wnxy.hospital.mims.dto.RegistryDTO;
import com.wnxy.hospital.mims.entity.Emp;
import com.wnxy.hospital.mims.entity.Office;
import com.wnxy.hospital.mims.entity.OpCallidlist;
import com.wnxy.hospital.mims.entity.OpCallidlistExample;
import com.wnxy.hospital.mims.entity.OpDep;
import com.wnxy.hospital.mims.entity.OpDoclevel;
import com.wnxy.hospital.mims.entity.OpPatientinfo;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.entity.OpRegistryExample;
import com.wnxy.hospital.mims.mapper.EmpMapper;
import com.wnxy.hospital.mims.mapper.OfficeMapper;
import com.wnxy.hospital.mims.mapper.OpCallidlistMapper;
import com.wnxy.hospital.mims.mapper.OpDepMapper;
import com.wnxy.hospital.mims.mapper.OpDoclevelMapper;
import com.wnxy.hospital.mims.mapper.OpPatientinfoMapper;
import com.wnxy.hospital.mims.mapper.OpRegistryMapper;
import com.wnxy.hospital.mims.service.op.CallIdListService;


@Service
public class CallIdListServiceImpl implements CallIdListService {

	@Autowired
	OpRegistryMapper oprmapper;
	
	@Autowired
	OpCallidlistMapper opcmapper;
	
	@Autowired
	EmpMapper empmapper;
	
	@Autowired
	OpPatientinfoMapper patientmapper;
	
	@Autowired
	OpDoclevelMapper doctorlevelmapper;
	
	@Autowired
	OfficeMapper officemapper;
	
	@Autowired
	OpDepMapper depmapper;
	
	@Override
	public void generiteCallIdList(String doctorid) {
		try {
			// 查询挂号单，医生号为doctorid状态为1已支付的。
			OpRegistryExample example = new OpRegistryExample();
			example.createCriteria().andStateEqualTo(1).andEmpIdEqualTo(doctorid);
			List<OpRegistry> payedregistrylist = oprmapper.selectByExample(example);
			// 添加到callidlist中。
			for(OpRegistry re:payedregistrylist) {
				OpCallidlistExample example2 = new OpCallidlistExample();
				example2.createCriteria().andRsIdEqualTo(re.getRsId());
				List<OpCallidlist> callid = opcmapper.selectByExample(example2);
				//判断挂号单是否已经添加过了
				if(callid==null||callid.isEmpty()) {
					String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
					//状态state为0没有就诊		
					OpCallidlist record = new OpCallidlist(uuid, re.getRsId(), re.getEmpId(), 0, new Date());
					opcmapper.insert(record);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifiyCallIdList(String calllistid, Integer state) {
		try {
			//查询该号，并修改状态（0未就诊、1正在就诊、2已就诊完毕）
			OpCallidlistExample example = new OpCallidlistExample();
			example.createCriteria().andClIdEqualTo(calllistid);
			List<OpCallidlist> call = opcmapper.selectByExample(example);
			call.get(0).setState(state);
			opcmapper.updateByPrimaryKey(call.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CallIdItemDTO> getCallIdList(String doctorid) {
		try {
			//通过医生编号查询叫号表所有报到的号信息
			OpCallidlistExample example=new OpCallidlistExample();
			example.createCriteria().andStateBetween(0, 1).andEmpIdEqualTo(doctorid);
			List<OpCallidlist> result = opcmapper.selectByExample(example);
			List<CallIdItemDTO> calList = new ArrayList<CallIdItemDTO>();
			if(!result.isEmpty()) {
				for(OpCallidlist callitem:result) {
					OpRegistry opregitsty = oprmapper.selectByPrimaryKey(callitem.getRsId());
					//病人详情对象
					OpPatientinfo patient = patientmapper.selectByPrimaryKey(opregitsty.getPtId());
					OpDoclevel doctorlevel = doctorlevelmapper.selectByPrimaryKey(opregitsty.getDlId());
					Emp emp = empmapper.selectByPrimaryKey(callitem.getEmpId());
					//部门信息
					Office office = officemapper.selectByPrimaryKey(emp.getOfficeId());
					//科室信息
					OpDep dep = depmapper.selectByPrimaryKey(emp.getDepId());
					//医生信息
					EmpDTO doctor = 
							new EmpDTO(emp.getEmpId(), office , dep, emp.getEmpName()
									, emp.getEmpIdentity(), emp.getEmpSex(), emp.getEmpAddress(), 
									emp.getEmpEmail(), emp.getEmpBirth(), emp.getEmpNation()
									, emp.getEmpHireday(), emp.getEmpPhoto(), emp.getEmpPhone());
					DocterLevelDTO docterleveldto = new DocterLevelDTO(doctorlevel.getDlId(), doctor, doctorlevel.getLevel(), doctorlevel.getPrice());
					//挂号单
					RegistryDTO registrydto = 
							new RegistryDTO(opregitsty.getRsId(), patient, docterleveldto, opregitsty.getState(), opregitsty.getDate(), doctorlevel.getPrice(), doctor);
					// 叫号信息
					CallIdItemDTO calliditem = 
							new CallIdItemDTO(callitem.getClId(), registrydto, doctor, callitem.getDate(), callitem.getState());
					calList.add(calliditem);
				}
			}
			return calList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getdatanum(String doctorid) {
		try {
			OpCallidlistExample example = new OpCallidlistExample();
			example.createCriteria().andStateBetween(0, 1).andEmpIdEqualTo(doctorid);
			return opcmapper.countByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
