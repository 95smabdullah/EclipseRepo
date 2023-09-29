package com.assessment.apiGateway;


import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import com.google.common.net.HttpHeaders;

import java.util.Base64;

import org.slf4j.Logger;

import reactor.core.publisher.Mono;

public class CustomFilter implements GlobalFilter {

	Logger logger = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		ServerHttpRequest request = exchange.getRequest();
		
		String authHeader=request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		 String b64Creds = authHeader.substring("Basic ".length()).trim();
         byte[] decoded = Base64.getDecoder().decode(b64Creds);
         String decodedCreds = new String(decoded);
         String[] creds = decodedCreds.split(":");
         String rxUser = creds[0];
         String rxPass = creds[1];
         System.out.println(rxPass+rxUser);
         if(rxUser.equals("Abzy") && rxPass.equals("1234")) {
        	 logger.info("Authorized Access");
        	 
        	 return chain.filter(exchange);
        	 
         }else {
        	 logger.warn("Unauthorized access");
             exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
             return exchange.getResponse().setComplete();
         }
        
	}
}
