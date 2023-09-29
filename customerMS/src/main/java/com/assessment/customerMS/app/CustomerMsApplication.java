package com.assessment.customerMS.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.assessment.customerMS.controller","com.assessment.customerMS.service"})
@EntityScan("com.assessment.customerMS.entity")
@EnableJpaRepositories("com.assessment.customerMS.repository")
@EnableFeignClients("com.assessment.customerMS.feignClient")
public class CustomerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMsApplication.class, args);
	}

}
