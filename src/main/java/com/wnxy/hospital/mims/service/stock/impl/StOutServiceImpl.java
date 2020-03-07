package com.wnxy.hospital.mims.service.stock.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StInExample;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.StOutExample;
import com.wnxy.hospital.mims.exception.StException;
import com.wnxy.hospital.mims.mapper.StOutMapper;
import com.wnxy.hospital.mims.service.stock.StOutService;

@Service
public class StOutServiceImpl implements StOutService {
	@Autowired
	StOutMapper stOutMapper;

	@Override
	public StOut selectBySid(String sid) {
		try {
			return stOutMapper.selectByPrimaryKey(sid);
		} catch (Exception e) {
			throw new StException(e);
		}

	}

	/**
	 * 新增出库单时，要与新增条目表一起使用，因为在数据库中有外键存在
	 */
	@Override
	public void insertStOut(StOut stOut) {
		try {

			stOutMapper.insert(stOut);
		} catch (Exception e) {
			throw new StException(e);
		}
	}
	/* 
	 * 通过条目集合查询
	 */
	@Override
	public List<StOut> selectByItems(List<StItem> stItems) {
		try {
			List<StOut> list =new ArrayList<StOut>();
			List<StOut> found=new ArrayList<StOut>();
			for(StItem s:stItems) {
				StOutExample example=new StOutExample();
				example.createCriteria().andItemIdEqualTo(s.getItemId());
				found = stOutMapper.selectByExample(example);
				//进行非空判断，避免报错
				if(found.size()!=0) {
					list.add(found.get(0));
				}
				
			}
			return list;
		}catch (Exception e) {
			throw new StException("Impl错误");
		}
	}
	/* (non-Javadoc)
	 * @see com.wnxy.hospital.mims.service.stock.StOutService#selectYueBaoBiao(java.lang.String)
	 */
	@Override
	public List<StOut> selectYueBaoBiao(String yue) {
		return stOutMapper.selectYueBaoBiao(yue);
		 
	}

}
