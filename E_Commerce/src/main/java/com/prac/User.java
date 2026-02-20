package com.prac;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;
@Entity
@Table(name = "users")
public class User {
	@Id
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "email")
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Profile Profile;
	
	@OneToMany
	private List<PurchaseOrder> list;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Profile getProfile() {
		return Profile;
	}
	public void setProfile(Profile profile) {
		Profile = profile;
	}
	public List<PurchaseOrder> getPurchaseOrder() {
		return list;
	}
	public void setPurchaseOrder(List<PurchaseOrder> purchaseOrder) {
		list = purchaseOrder;
	}
	
	
	
}
