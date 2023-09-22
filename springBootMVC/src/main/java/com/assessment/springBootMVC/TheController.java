package com.assessment.springBootMVC;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.assessment.springBootMVC.entities.User;
import com.assessment.springBootMVC.entities.Book;
import com.assessment.springBootMVC.repos.BookRepo;
import com.assessment.springBootMVC.repos.UserRepo;


@Controller
public class TheController {
	@Autowired
    private UserRepo userRepo;
	@Autowired
    private BookRepo bookRepo;

    @GetMapping("/home")
    public String home(Model model) {
    	model.addAttribute("user", new User());
        return "home";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
    	Optional<User> foundUser = userRepo.findByNameAndPass(user.getName(), user.getPass());
    	if(foundUser.isPresent()) {
    		List<Book> books = bookRepo.findAll();
        	System.out.println(books.toString());
            model.addAttribute("books", books);
    		return "books";
    	}
    	else {
    		model.addAttribute("message","User not Found");
    		return "redirect:/home";
    	}
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
    	Optional<User> foundUser = userRepo.findByNameAndPass(user.getName(), user.getPass());
    	if(foundUser.isPresent()) { 
    		model.addAttribute("message","User already exists, please login");
    		return "redirect:/home";
    	}
    	else {
    		userRepo.save(user);
    		model.addAttribute("message","Succesfully Registered, please login");
    		
    		return "redirect:/home";
    }
    }
    
    @GetMapping("/books")
    public String books(Model model) {
    	
    	List<Book> books = bookRepo.findAll();
    	System.out.println(books.toString());
        model.addAttribute("books", books);
        return "books";
    }
    
    @GetMapping("/addBook")
    public String addBookForm(Model model) {
//        Book book = new Book();
        return "addBook";
    }
    
    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
    	bookRepo.save(book);
    	return "redirect:/books";
    }
    
    @GetMapping("books/update/{id}")
    public String updateBookForm(@PathVariable int id, Model model){
    	Book book = bookRepo.findById(id).orElse(null);
    	model.addAttribute(book);
    	return "updateBook";
    }
    
    @PostMapping("/books/update")
    public String updateBook(@ModelAttribute Book book) {
    	bookRepo.save(book);
    	return "redirect:/books";
    }
    
    @GetMapping("books/delete/{id}")
    public String deleteBook(@PathVariable int id){
    	bookRepo.deleteById(id);
    	return "redirect:/books";
    }
}




	

