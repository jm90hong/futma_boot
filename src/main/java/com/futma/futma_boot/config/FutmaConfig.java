package com.futma.futma_boot.config;



import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



public class FutmaConfig {
	
	static String AccessKey="e4ETeXNjieofrOS8jMcE";
	static String SecretKey="lnndlpbii9nHlHmLyXGbC8rdOrlwpu6K6iygkZjN";
	
	
	
	//NCloud signature 키 생성.
	static public String makeSignature(String timeStampArg) 
			throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
		
		String space = " ";					// one space
		String newLine = "\n";					// new line
		String method = "GET";					// method
		String url = "/sms/v2";	// /sms/v2 => sms 인증 요청 url.
		String timestamp = timeStampArg;			// current timestamp (epoch)
		String accessKey = AccessKey;			// access key id (from portal or Sub Account)
		String secretKey = SecretKey;

		String message = new StringBuilder()
			.append(method)
			.append(space)
			.append(url)
			.append(newLine)
			.append(timestamp)
			.append(newLine)
			.append(accessKey)
			.toString();
		
		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(signingKey);

		byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
		String encodeBase64String = Base64.encodeBase64String(rawHmac);

	  return encodeBase64String;
	}
}



