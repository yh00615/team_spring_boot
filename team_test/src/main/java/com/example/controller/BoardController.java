package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	String s3Path = System.getenv("S3_PATH");

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("s3Path", s3Path);
		return "home";
	}

	public void setAz(Model model) {
		String awsWeb = System.getenv("AWS_WEB");
		String availabilityZone = "";
		if (awsWeb != "local") {
			String metadataUrl = "http://169.254.169.254/latest/meta-data/placement/availability-zone";

			// RestTemplate을 사용하여 메타데이터 엔드포인트에 GET 요청을 보냄
			RestTemplate restTemplate = new RestTemplate();
			availabilityZone = restTemplate.getForObject(metadataUrl, String.class);
//			System.out.println(availabilityZone);
			model.addAttribute("availabilityZone", availabilityZone);
		}
		model.addAttribute("availabilityZone", availabilityZone);
	}

	@GetMapping("/boardlist")
	public String boardlist(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
		return "boardlist";
	}

	@GetMapping("/boardwrite")
	public String boardWriteForm(HttpSession session, Model model) {
		System.out.println("boardwrite");
		return "boardwrite";
	}
	
}
