package com.prac;

import javax.persistence.*;
import java.util.*;


@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@ManyToMany(mappedBy = "subject")
	private List<Students> student;
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
	public List<Students> getStudent() {
		return student;
	}
	public void setStudent(List<Students> student) {
		this.student = student;
	}
	

}
