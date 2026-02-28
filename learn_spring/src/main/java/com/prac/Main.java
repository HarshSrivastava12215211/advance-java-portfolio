package com.prac;
import org.springframework.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
//		Person person = ioc.getBean("person", Person.class);
//		
//		System.out.println(person);
//		
//		person.message();
		
		ApplicationContext ioc =  new ClassPathXmlApplicationContext("config.xml");
		
		Employee employee = ioc.getBean("employee", Employee.class);
		
		System.out.println(employee);
		
		//employee.setName("Harsh");
		
		System.out.println(employee.getName());
		System.out.println(employee.getId());
		System.out.println(employee.getSalary());

	}
	
}
