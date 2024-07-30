package com.futma.futma_boot.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
	
	
	
   	
    @PostConstruct
    public void init() throws Exception{
        try{
        	System.out.println("Firebase app has been initialized");
        	File file = ResourceUtils.getFile("classpath:firebaseServiceAccountKey.json");
            InputStream serviceAccount = new FileInputStream(file);;
            @SuppressWarnings("deprecation")
			FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("futma-74ce5")
                    .setStorageBucket("futma-74ce5.appspot.com")
                    .build();
            
            if(FirebaseApp.getApps().isEmpty()) {
            	FirebaseApp.initializeApp(options);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }  
}
