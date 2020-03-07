package com.wnxy.hospital.mims.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Supplier;
import com.wnxy.hospital.mims.exception.StException;
import com.wnxy.hospital.mims.mapper.SupplierMapper;
import com.wnxy.hospital.mims.service.stock.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	SupplierMapper supplierMapper;
	@Override
	public Supplier selectBySid(String sid) {
		try {
			
		return  supplierMapper.selectByPrimaryKey(sid);
	} catch (Exception e) {
		throw new StException(e);
	}
		
	}

	@Override
	public void insertSupplier(Supplier supplier) {
		try {
		supplierMapper.insert(supplier);
	} catch (Exception e) {
		throw new StException(e);
	}
		
	}

}
