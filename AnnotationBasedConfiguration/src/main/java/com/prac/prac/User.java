package com.prac.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;
import org.springframework.stereotype.Component;
import com.prac.*;
@Component
public class User {
	@Autowired
	@Qualifier("UPI")
	private Payment payment;
	
	void display()
	{
		payment.send();
	}
	
	public static void main(String[] args) {
		
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DempConfiguration.class);
		//System.out.println(ioc.getBean(Payment.class));
		
		User u = ioc.getBean(User.class);
		
		System.out.println(u);
		
		u.display();
	}

}
