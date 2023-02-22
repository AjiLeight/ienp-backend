package com.degreeproject.IENP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class IenpApplication {

	public static void main(String[] args) {
		SpringApplication.run(IenpApplication.class, args);
	}

}
