package com.prac;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	
	private String collegeName;
	
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Students> getStud() {
		return stud;
	}
	public void setStud(List<Students> stud) {
		this.stud = stud;
	}
	@Id
	private int id;
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="stud")
	private List<Students> stud;
	

}
