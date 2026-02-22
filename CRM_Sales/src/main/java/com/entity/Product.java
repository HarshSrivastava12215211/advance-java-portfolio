package com.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String name;
	private double price;
	
	@ManyToMany(mappedBy = "products")
	private List<Order> orders;
	
	@OneToMany(mappedBy = "product")
	private List<SupportTicket> ticket;
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<SupportTicket> getTicket() {
		return ticket;
	}
	public void setTicket(List<SupportTicket> ticket) {
		this.ticket = ticket;
	}
}
