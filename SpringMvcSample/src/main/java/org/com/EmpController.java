package org.com;

import org.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/empform")
public class EmpController {

	@RequestMapping(method=RequestMethod.GET)
	public String goEmpForm()
	{
		return "emp_form";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView goEmpForm(@RequestParam("Id") int id, @RequestParam("Name") String name){
		ModelAndView v = new ModelAndView("welcome");
		Employee e = new Employee();
		e.setId(id);
		e.setName(name);
		v.addObject(e);
		
	
		return v;
	}

}
