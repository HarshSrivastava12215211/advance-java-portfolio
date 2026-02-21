package com.practice;
import java.util.*;
import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    private String name;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@ManyToMany
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns= @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
	
}
