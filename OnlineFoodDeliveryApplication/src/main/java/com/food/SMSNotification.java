package com.food;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SMSNotification implements NotificationService {
	

	@Override
	public void sendNotification(String message) {
		// TODO Auto-generated method stub
		
		System.out.println("SMS message :"+message);
		
	}

}
