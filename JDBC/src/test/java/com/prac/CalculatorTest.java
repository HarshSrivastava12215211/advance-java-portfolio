package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTest {

	
//	public void addTest()
//	{
//		int res = Calculator.add(20,30);
//		
//	}
	
	//@Test
//	public void reverseTest() {
//		// TODO Auto-generated method stub
//		
//		String act_res = Calculator.reverseString("data");
//		
//		assertEquals("atad",act_res);
//
//	}
	
//	public void reverseTestNull()
//	{
//		String act_res = Calculator.reverseString(null);
//		assertEquals("llun",act_res);
//	}
	
//	public void FactorialTest()
//	{
//		int res = Factorial.factorial(7);
//		assertEquals(5040, res);
//	}
	@Test
	public void isValidnameTest()
	{
		Employee emp = new Employee(1, " Harsh Srivastava", 56, "Teacher");
		
		boolean res = emp.isValidName();
		assertEquals(true, res);
	    assertTrue(emp.isValidName());
	}
	
	@Test
	public void isValidAgeTest()
	{
		Employee emp = new Employee(1, " Harsh Srivastava", 56, "Teacher");
		
		boolean res = emp.isValidAge();
		assertEquals(true, res);
	}
	@Test
	public void TestArithmeticException()
	{
		Calculator c = new Calculator();
		assertThrows(ArithmeticException.class,() -> {
            c.div(10, 0);});
	}

}

