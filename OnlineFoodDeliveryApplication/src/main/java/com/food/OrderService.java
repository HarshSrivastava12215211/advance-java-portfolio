package com.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SMSNotificationService")
public class OrderService {
	
	private NotificationService notificationService;
	
	@Autowired
	private RestaruntService restaruntService;
	
	public OrderService(NotificationService notificationService)
	{
		this.notificationService = notificationService;
	}
	
	public void PlaceOrder()
	{
		System.out.println("Order Placed");
		restaruntService.PrepareOrder();
		System.out.println("Order Preapred");
	}
	
	

}
