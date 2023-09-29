package com.assessment.countryRestApi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.assessment.countryRestApi.controller", "com.assessment.countryRestApi.service"})
@EntityScan("com.assessment.countryRestApi.entity")
@EnableJpaRepositories("com.assessment.countryRestApi.repository")
public class CountryRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryRestApiApplication.class, args);
	}

}
