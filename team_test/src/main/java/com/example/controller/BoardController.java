package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {
	
@Controller
public class BoardController {
	String s3Path = System.getenv("S3_PATH");
	
	@GetMapping("/")
	public String home(Model model) {
		
		return "home";
	}
	
}
