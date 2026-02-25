package com.food;

import org.springframework.stereotype.Component;

@Component
public class RestaruntService {
	
    private DeliveryService deliveryService;
	
	public void setDeliveryService(DeliveryService deliveryService)
	{
		this.deliveryService = deliveryService;
	}
	
	public void PrepareOrder()
	{
		System.out.println("This order is preparing");
		deliveryService.orderDelivered();
	}

}
