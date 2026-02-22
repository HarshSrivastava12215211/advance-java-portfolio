package com.entity;

import java.util.*;

import javax.persistence.*;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private String orderDate;
	
	private double totalAmount;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public java.util.List<Product> getProducts() {
		return products;
	}

	public void setProducts(java.util.List<Product> products) {
		this.products = products;
	}

	public SupportTicket getTicket() {
		return ticket;
	}

	public void setTicket(SupportTicket ticket) {
		this.ticket = ticket;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@ManyToMany
	@JoinTable
	private java.util.List<Product> products;
	
	@OneToOne(mappedBy = "order")
	private SupportTicket ticket;

}
