package com.food;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("Sigelton")
public class DeliveryService {
	
	@PostConstruct
	public void init()
	{
		System.out.println("Delivery Service ready");
	}
	@PreDestroy
	public void destroy()
	{
		System.out.println("Delivery Service closed");
	}
	
	public void orderDelivered()
	{
		System.out.println("Ordered is delivered");
	}

}
