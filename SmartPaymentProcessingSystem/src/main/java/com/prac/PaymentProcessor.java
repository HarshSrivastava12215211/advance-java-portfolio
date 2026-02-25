package com.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("UPIPayment")
public class PaymentProcessor {
	
	private PaymentServices paymentServices;
	
	@Autowired
	private TransactionLogger logger;
	
	
	public PaymentProcessor(PaymentServices paymentServices)
	{
		this.paymentServices = paymentServices;
	}
	
	public void makePayment(double amount)
	{
		logger.Log("Processing payment");
		paymentServices.ProcessPayment(amount);
		logger.Log("Paymnet completed");
		
	}
	
	

}
