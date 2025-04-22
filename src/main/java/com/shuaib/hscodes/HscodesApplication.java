package com.shuaib.hscodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HscodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HscodesApplication.class, args);
	}

}
