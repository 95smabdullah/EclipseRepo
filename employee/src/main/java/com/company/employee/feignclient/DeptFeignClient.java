package com.company.employee.feignclient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.employee.response.DeptResponse;

//@FeignClient(url="${department.service.url}", value="DEPARTMENT-SERVICE",path="/")
@FeignClient( value="DEPARTMENT-SERVICE",path="/api/department")
public interface DeptFeignClient {
	@GetMapping("/getById/{id}")
	public DeptResponse getById(@PathVariable int id);

}
