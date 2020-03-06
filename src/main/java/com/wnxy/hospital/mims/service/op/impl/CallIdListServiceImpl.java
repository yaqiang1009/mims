package com.wnxy.hospital.mims.service.op.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.OpCallidlist;
import com.wnxy.hospital.mims.entity.OpCallidlistExample;
import com.wnxy.hospital.mims.entity.OpRegistry;
import com.wnxy.hospital.mims.entity.OpRegistryExample;
import com.wnxy.hospital.mims.mapper.OpCallidlistMapper;
import com.wnxy.hospital.mims.mapper.OpRegistryMapper;
import com.wnxy.hospital.mims.service.op.CallIdListService;


@Service
public class CallIdListServiceImpl implements CallIdListService {

	@Autowired
	OpRegistryMapper oprmapper;
	
	@Autowired
	OpCallidlistMapper opcmapper;
	
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
	public List<OpCallidlist> getCallIdList(String doctorid) {
		try {
			//通过医生编号查询叫号表信息
			OpCallidlistExample example=new OpCallidlistExample();
			example.createCriteria().andStateBetween(0, 1).andEmpIdEqualTo(doctorid);
			return opcmapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
