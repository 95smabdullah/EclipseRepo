package com.example.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(SpringBootDemoApplication.class, args);
		HelloService helloMessage = ctx.getBean(HelloService.class);
        String message = helloMessage.HelloMessage();
        System.out.println(message);
    }


}
