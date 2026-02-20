package com.prac;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String branch;
    private String gender;

    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    // Default Constructor (MANDATORY)
    public Students() {}

    public Students(String name, String branch, String gender) {
        this.name = name;
        this.branch = branch;
        this.gender = gender;
    }

    // Getters & Setters
    public int getId() { return id; }

    public String getName() { return name; }

    public String getBranch() { return branch; }

    public String getGender() { return gender; }

    public Set<Subject> getSubjects() { return subjects; }

    public void setName(String name) { this.name = name; }

    public void setBranch(String branch) { this.branch = branch; }

    public void setGender(String gender) { this.gender = gender; }

    public void setSubjects(Set<Subject> subjects) { this.subjects = subjects; }
}