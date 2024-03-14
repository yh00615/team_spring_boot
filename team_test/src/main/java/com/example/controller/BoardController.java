package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {
	
	@GetMapping("/")
	public String home(Model model) {
		
		return "home";
	}

}
