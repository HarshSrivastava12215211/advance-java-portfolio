package com.prac;
import java.util.*;

import javax.persistence.*;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String branch;
	
	@ManyToMany
	@JoinTable
	private List<Subject> subject;

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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}	
	
	

}
