package com.prac;
import java.util.*;
public class Factorial {
	
	public static int factorial(int num) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 1;
		for(int i = num; i>0; i-- )
		{
			sum = i * sum;
		}
		System.out.println("Factorial is = " + sum);
		return sum;
		
	}

}
