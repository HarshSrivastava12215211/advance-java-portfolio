package com.capgemini.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
public class Employee {
	
	@Id
	private int id;
	private String name;
	private double Salary;
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
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Salary=" + Salary + "]";
	}

}
