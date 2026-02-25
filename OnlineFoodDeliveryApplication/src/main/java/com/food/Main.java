package com.food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrderService services = ioc.getBean(OrderService.class);
		
		services.PlaceOrder();
		
		((AnnotationConfigApplicationContext) ioc).close();
	}

}
