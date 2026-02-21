package com.practice;
import java.util.*;
import javax.persistence.*;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name  = "department_id")
	private Department department;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
}
