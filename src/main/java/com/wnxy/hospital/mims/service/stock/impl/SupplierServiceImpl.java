package com.wnxy.hospital.mims.service.stock.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wnxy.hospital.mims.entity.Supplier;
import com.wnxy.hospital.mims.mapper.SupplierMapper;
import com.wnxy.hospital.mims.service.stock.SupplierService;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	SupplierMapper supplierMapper;
	@Override
	public Supplier selectBySid(String sid) {
		return  supplierMapper.selectByPrimaryKey(sid);
		
	}

	@Override
	public void insertSupplier(Supplier supplier) {
		supplierMapper.insert(supplier);
		
	}

}
