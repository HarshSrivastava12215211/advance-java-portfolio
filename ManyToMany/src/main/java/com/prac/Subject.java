package com.prac;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int number_of_days;

    @ManyToMany(mappedBy = "subjects")
    private Set<Students> students;

    // Default Constructor (MANDATORY)
    public Subject() {}

    public Subject(String name, int number_of_days) {
        this.name = name;
        this.number_of_days = number_of_days;
    }

    // Getters & Setters
    public int getId() { return id; }

    public String getName() { return name; }

    public int getNumber_of_days() { return number_of_days; }

    public Set<Students> getStudents() { return students; }

    public void setName(String name) { this.name = name; }

    public void setNumber_of_days(int number_of_days) {
        this.number_of_days = number_of_days;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}