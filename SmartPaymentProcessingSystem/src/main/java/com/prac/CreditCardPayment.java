package com.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditCardPayment implements PaymentServices {
	
	private TransactionLogger logger;
	
	public CreditCardPayment(TransactionLogger logger)
	{
		this.logger = logger;
	}
	
	

	@Override
	public void ProcessPayment(double amount) {
		System.out.println("Processing Credit Card Payment");
		logger.Log("Transaction of amount "+amount+" is succesfull");
		
	}

}
