package com.prac.prac;

import org.springframework.stereotype.Component;

@Component
public class UPI implements Payment {

	@Override
	public void send() {
		
		System.out.println("Money is send through UPI");
	}

}
