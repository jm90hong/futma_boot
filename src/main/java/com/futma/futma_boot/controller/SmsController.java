package com.futma.futma_boot.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futma.futma_boot.service.SmsService;

@RestController
@RequestMapping(value="sms")
public class SmsController {
	
	@Autowired
	SmsService smsService;
	
	
	@GetMapping("sendCode")
	public String send(
				@RequestParam(value="toTel") String toTel
			) {
		
		Random random = new Random();		//랜덤 함수 선언
		int createNum = 0;  			//1자리 난수
		String ranNum = ""; 			//1자리 난수 형변환 변수
        	int letter    = 6;			//난수 자릿수:6
		String resultNum = "";  		//결과 난수
		
		for (int i=0; i<letter; i++) { 
            		
			createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum =  Integer.toString(createNum);  //1자리 난수를 String 으로 형변환
			resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
		}	
		
		
		String message = "[Futma.] 인증코드는 ["+resultNum+"] 입니다.";
		
		boolean chk = smsService.sendSMS(toTel,message);
		
		if(chk){
			return resultNum;
		}else {
			return "fail";
		}
		
		
	}
	
	
	
}
