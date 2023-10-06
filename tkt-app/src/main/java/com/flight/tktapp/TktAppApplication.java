package com.flight.tktapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.flight.controller","com.flight.service"})
@EntityScan("com.flight.entity")
@EnableJpaRepositories("com.flight.repository")

public class TktAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TktAppApplication.class, args);
	}

}
