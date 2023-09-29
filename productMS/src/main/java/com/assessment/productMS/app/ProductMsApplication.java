package com.assessment.productMS.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.assessment.productMS.controller","com.assessment.productMS.service"})
@EntityScan("com.assessment.productMS.entity")
@EnableJpaRepositories("com.assessment.productMS.repository")
@EnableFeignClients("com.assessment.productMS.feignClient")
public class ProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}

}
