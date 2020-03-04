package com.wnxy.hospital.mims.service.stock;

import com.wnxy.hospital.mims.entity.Supplier;

public interface SupplierService {
	Supplier selectBySid(String sid);
	void insertSupplier(Supplier supplier);
}
