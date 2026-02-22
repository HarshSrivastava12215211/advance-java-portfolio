package com.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class SalesEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	private String name;
	
	private String department;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@ManyToOne
	@JoinColumn(name = "addres_id")
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<Lead> leads;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
}
