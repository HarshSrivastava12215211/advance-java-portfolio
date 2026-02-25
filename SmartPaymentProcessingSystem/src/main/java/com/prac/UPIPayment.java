package com.prac;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UPIPayment implements PaymentServices {
	
	
	private TransactionLogger logger;
	
	public UPIPayment(TransactionLogger logger)
	{
		this.logger = logger;
	}

	@Override
	public void ProcessPayment(double amount) {
		
		System.out.println("Payment done through UPI");
		logger.Log("Transaction of amount "+amount+" is succesfull");
		
		
	}

}
