package com.exercise.mvclogin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TheController {
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
