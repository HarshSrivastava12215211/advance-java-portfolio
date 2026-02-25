package com.prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("Spring Container Starterd");
		 PaymentProcessor process = ioc.getBean(PaymentProcessor.class);
		 
		 process.makePayment(56444);
		 
		 UPIPayment payment1 = ioc.getBean(UPIPayment.class);
		 UPIPayment payment2 = ioc.getBean(UPIPayment.class);
		 
		 System.out.println("UPI1 Instance : " + payment1);
		 System.out.println("UPI1 Instance : " + payment2);
		 
		// ioc.close();
	}

}
