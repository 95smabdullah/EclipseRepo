package com.company.employee.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.company.employee.controller","com.company.employee.services"})
@EntityScan("com.company.employee.entity")
@EnableJpaRepositories("com.company.employee.repository")
@EnableFeignClients("com.company.employee.feignclient")

public class EmployeeApplication {
	
	@Value("${department.service.url}")
	private String departmentServiceUrl;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
	public WebClient webClient() {
		WebClient webClient =WebClient.builder().baseUrl(departmentServiceUrl).build();
		return webClient;
	}
}
