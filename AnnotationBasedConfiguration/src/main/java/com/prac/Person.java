package com.prac;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	//Dependency Injection
	//@Autowired
	private Mobile mobile;// null,  reference is null
	@Autowired
	private Scanner scan;
	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public void message()
	{
		System.out.println("This is the bean");
	}
	
	public Mobile getMobile()
	{
		return mobile;
	}
	//@Autowired
	public void setMobile(Mobile mobile)
	{
		this.mobile = mobile;
	}
	
	
	public Person(Mobile mobile) {
		super();
		this.mobile = mobile;
	}
	@Autowired
	ArrayList<String> items;
	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

}
