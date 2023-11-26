import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDAO ed;

@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
public ModelAndView addEmployee() {
	Employee e = new Employee();
	ModelAndView mv = new ModelAndView("AddEmployee");
	mv.addObject("newEmployee", e);
	return mv;
	
}

@PostMapping("/addEmployee")
public ModelAndView addEmployee(@ModelAttribute("newEmployee") Employee e) {
	ModelAndView mv = new ModelAndView("AddEmployee");
	//call dao for db insert
	
	mv.addObject("successMessage", "Added successfully");
	
	return mv;
	
}

}