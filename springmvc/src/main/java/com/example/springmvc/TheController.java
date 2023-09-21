package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;



@Controller
public class TheController {
	@GetMapping("/greeting")
	public String greet(Model model) {
		System.out.println("hi");
		model.addAttribute("greeting", "this is from the greet method");
		return "greeting";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
	@PostMapping("/logged_in")
	public String displayDeets(@RequestParam("userID") String id, @RequestParam("password") String pass, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pass", pass);
		return "display";
	}
	

}
