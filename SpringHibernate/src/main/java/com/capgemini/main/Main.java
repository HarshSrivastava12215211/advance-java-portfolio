package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.capgemini.DemoConfiguration;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.Employee;

public class Main {
	
	public static void main(String[] args) {
		//private static final DefaultListableBeanFactory DemoConfiguration.class = null;
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
//		Employee e1 = ioc.getBean(Employee.class);
//		
//		Employee e2 = ioc.getBean(Employee.class);
//		
//		e2.setName("Harsh");
//		
//		e1.setName("Amit");
//		
//		System.out.println(e1);
//		
//		System.out.println(e2);
//		
//		EmployeeDao em1 = ioc.getBean(EmployeeDao.class);
//		
//		em1.insert(e2);
//		em1.insert(e1);
//		em1.findAll().forEach(System.out::println);
		
		((AnnotationConfigApplicationContext)ioc) .close();
		 
		 
		

	}
	
	

}
