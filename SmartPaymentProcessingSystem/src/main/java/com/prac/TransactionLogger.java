package com.prac;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {
	
	@PostConstruct
	public void init()
	{
		System.out.println("Logger Initialised");
	}
	
	@PreDestroy
	public void destroy()
	{
		
		System.out.println("Lopged Out");
	}
	
	public void Log(String message)
	{
		System.out.println("Log is: "+ message);
	}

}
