package com.prac;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.*;
@Entity
public class Payment {
	@Id
	@Column(name = "Transaction_ID")
	private int id;
	@Column(name = "mode")
	private String mode;
	@Column(name = "Amount")
	private int amounbt;
	@ManyToOne
	private PurchaseOrder order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getAmounbt() {
		return amounbt;
	}
	public void setAmounbt(int amounbt) {
		this.amounbt = amounbt;
	}
	public PurchaseOrder getOrder() {
		return order;
	}
	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}


}
