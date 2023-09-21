package com.org;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/empform")
public class EmployeeController {

	@RequestMapping(method=RequestMethod.GET)
	public String goEmpForm()
	{
		return "emp_form";
	}
	


}
