package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Prescription {
	private int id;
	private String medicine;
	private String dosage;
	private LocalDate IssueDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public LocalDate getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}
}
