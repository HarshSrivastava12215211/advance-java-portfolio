package com.prac;

import javax.persistence.*;
import java.util.*;
import java.sql.*;

@Entity
@Table(name = "users")
public class Users {
	@Id
	public int id;
	@Column(name = "Name")
	public String name;
	@Column(name = "balance")
	public double balance;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString()
	{
		return "id : "+getId() + " Name : " + getName() + " Balance : "+getBalance();
	}
}
