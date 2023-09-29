package com.example.apicall;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ApicallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicallApplication.class, args);
	}
	@GetMapping("/test")
	public List<Object> getResult(){
		RestTemplate template = new RestTemplate();
		String Url = "http://localhost:8080/employees";
		Object employees = template.getForObject(Url, Object[].class);
	
	return Arrays.asList(employees);
	}
	@GetMapping("/update")
	public void update(){
	RestTemplate template = new RestTemplate();
	String Url = "http://localhost:8080/employees/5";
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Employee updated = null;
	try {
		updated = new Employee("newme5","newme5@mail.com",df.parse("1995-03-03"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	template.put(Url, updated);
	}

}
