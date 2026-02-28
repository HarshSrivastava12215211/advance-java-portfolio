package com.prac;

import java.util.*;
import java.util.List;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prac.prac.Payment;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ioc =new AnnotationConfigApplicationContext(DempConfiguration.class);
		
//		Employee e = ioc.getBean(Employee.class);
//		System.out.println(e);
//		System.out.println(e.getId());
//		System.out.println(e.getName());
		
		Person person = ioc.getBean(Person.class);
		System.out.println(person);
		System.out.println(person.getMobile());
		
		System.out.println(ioc.getBean(Mobile.class));
		
		//System.out.println(person.getScan());
		//System.out.println(person.getItems());
		
		System.out.println(ioc.getBean(List.class));
		
		System.out.println(ioc.getBean(HashMap.class));
		
		System.out.println(ioc.getBean(Payment.class));
		
	}

}
