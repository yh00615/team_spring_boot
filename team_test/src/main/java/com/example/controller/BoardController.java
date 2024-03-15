package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	String s3Path = System.getenv("S3_PATH");

	@GetMapping("/")
	public String home(Model model) {

		return "home";
	}

	@GetMapping("/boardlist")
	public String boardlist(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
		return "boardlist";
	}

}
