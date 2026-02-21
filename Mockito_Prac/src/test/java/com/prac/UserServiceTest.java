package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
	@Test
	public void testGetTypeOfCustomer()
	{
		UsersDAO userDao = new UsersDAO();
		
		UserService  us = new UserService(userDao);
		String act = us.typeOfUser(150);
		assertEquals("new User",act);
		
	}
	@Test
	public void testDoubleAddition()
	 {
		// Step 1 -:  Create fake method
		 Calculator calmock = mock(Calculator.class);
		 
		 // Step 2 : What mock object should return
		 when(calmock.add(5, 5)).thenReturn(20);
		 
		 //Step 3: Inject the mock reference
		 
		 MathService ser = new MathService(calmock);
		 int res = ser.doubleAddition(5, 5);
		 
		 assertEquals(20,res);
		 
	 }

}
