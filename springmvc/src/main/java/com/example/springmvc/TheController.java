package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Controller
public class TheController {
	@GetMapping("/greeting")
	public String greet(Model model) {
		System.out.println("hi");
		model.addAttribute("greeting", "this is from the greet method");
		return "greeting";
	}
	

}
