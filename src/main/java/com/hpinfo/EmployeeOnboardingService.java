package com.hpinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.reactive.config,com.reactive.controller,com.reactive.model,com.reactive.service,com.reactive.repository,com.reactive.entity"})
public class EmployeeOnboardingService {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeOnboardingService.class, args);
	}

}
