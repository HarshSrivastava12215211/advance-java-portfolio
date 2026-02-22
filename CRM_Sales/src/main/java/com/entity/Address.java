package com.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<SalesEmployee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<SalesEmployee> employees) {
		this.employees = employees;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	private String city;
	private String state;
	private String pincode;
	
	@OneToOne(mappedBy = "address")
	private Customer customer;
	
	@OneToMany(mappedBy= "address")
	private List<SalesEmployee> employees;
}