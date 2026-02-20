package com.prac;

public class Employee {
	
	int id;
	String name;
	int age;
	String dept;
	
	Employee(int id,String name,int age, String dept)
	{
		this.id = id;
		this.name = name;
		this.age = age;
	    this.dept = dept;
	}
	public boolean  isValidName()
	{
		if(name.matches("^[A-Za-z\\s]+$"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isValidAge()
	{
		if(age>18)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
