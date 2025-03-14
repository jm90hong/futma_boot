package com.futma.futma_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	//http://43.201.51.210:8080/futma_boot/
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
}