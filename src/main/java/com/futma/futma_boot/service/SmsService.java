package com.futma.futma_boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Service
public class SmsService {
	
	static String ADMIN_TEL_NUMBER = "01099361422";

	
	
	 @Value("${coolsms.api.key}")
	 private String apiKey;
	 
	 
	 @Value("${coolsms.api.secret}")
	  private String secretKey;
	
	
	public boolean sendSMS(String toTelNumber, String m) {
		DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize(apiKey, secretKey, "https://api.coolsms.co.kr");
		// Message 패키지가 중복될 경우 net.nurigo.sdk.message.model.Message로 치환하여 주세요
		Message message = new Message();
		message.setFrom(ADMIN_TEL_NUMBER);
		message.setTo(toTelNumber);
		message.setText(m);

		try {
		  // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
		  messageService.send(message);
		  return true;
		} catch (NurigoMessageNotReceivedException exception) {
		  // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
//		  System.out.println(exception.getFailedMessageList());
//		  System.out.println(exception.getMessage());
		  return false;
		} catch (Exception exception) {
//		  System.out.println(exception.getMessage());
		  return false;
		}
	}
	
}
