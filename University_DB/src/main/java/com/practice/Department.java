package com.practice;
import java.util.*;
import javax.persistence.*;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "university_id")
	private University university;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Professor> prof = new ArrayList<>();
	

}
