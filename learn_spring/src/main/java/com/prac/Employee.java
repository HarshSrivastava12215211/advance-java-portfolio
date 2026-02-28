package com.prac;

import org.springframework.beans.factory.annotation.Value;

public class Employee {
	@Value("10")
	private int id;
	@Value("Saras")
	private String name;
	@Value("250000")
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
