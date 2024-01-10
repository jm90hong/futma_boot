package com.futma.futma_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.service.SmsService;

@RestController
@RequestMapping(value="sms")
public class SmsController {
	
	@Autowired
	SmsService smsService;
	
	
	@GetMapping("send")
	public String send(
				
			) {
		
		
		smsService.send();
		
		return "ok";
	}
}
