package com.exercise.userTable;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TheController {
	@Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public String home(Model model) {
    	System.out.println("hi");
    	List<User> users = userRepo.findAll();
    	System.out.println(users.toString());
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        userRepo.save(user);
        return "redirect:/users";
    }
    
//    @GetMapping("/addUser")
//    public String addUser(Model model) {
//        model.addAttribute("users", userRepo.findAll());
//        return "add";
//    }
    
}




	

