package com.wnxy.hospital.mims.utils;

import java.util.UUID;

public class MyUuid {

	public static String getMyUuid() {
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
}
