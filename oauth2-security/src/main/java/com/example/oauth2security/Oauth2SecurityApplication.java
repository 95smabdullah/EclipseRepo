package com.example.oauth2security;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class Oauth2SecurityApplication {
	
	@GetMapping("/")
	public String message(Principal principle)
	{
		return "Hi " + principle.getName()+ " welcome to OAuth2";
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SecurityApplication.class, args);
	}

}
