package com.wnxy.hospital.mims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//读取mapper映射文件

@MapperScan("com.wnxy.hospital.mims.mapper")
@SpringBootApplication
public class MimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MimsApplication.class, args);
	}

}
