package com.practice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	private String name;
	
	@OneToOne(mappedBy = "university", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Department> dep = new ArrayList<>();

}
