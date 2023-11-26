package com.assessment.apiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {
	
	@Bean
    public GlobalFilter customFilter() {
        return new CustomFilter();
    }

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
