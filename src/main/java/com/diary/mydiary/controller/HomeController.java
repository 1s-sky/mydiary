package com.diary.mydiary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diary.mydiary.model.User;

@Controller
public class HomeController {
	/*@GetMapping("/home")
	public String home() {
		return "home";
	}*/
	
	@GetMapping(value = "/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "login";
	}

}
