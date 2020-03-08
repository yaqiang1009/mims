package com.wnxy.hospital.mims.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Damages;
import com.wnxy.hospital.mims.exception.StException;
import com.wnxy.hospital.mims.mapper.DamagesMapper;
import com.wnxy.hospital.mims.service.stock.StDamagesService;
@Service
public class StDamagesServiceImpl implements StDamagesService{
	@Autowired
	DamagesMapper stDamagesMapper;

	/* (non-Javadoc)
	 * 药库处理来自药房的报损
	 * @see com.wnxy.hospital.mims.service.stock.StDamagesService#frmLoss(com.wnxy.hospital.mims.entity.Damages)
	 */
	@Override
	public void frmLoss(Damages damages)  {

			try {
				damages.setStatus(1);
				//表示由药库提交
				damages.setSource("1");
				stDamagesMapper.insert(damages);
			} catch (Exception e) {
				throw new StException(e);
			}
		
	}
	
	

}
