package com.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "student_info") 
public class Students {
    
    @Id
    @Column(name = "id")  // corrected annotation
    private int id;
    
    @Column(name = "Student_Name")
    private String name;
    
    @Column(name = "percentage")
    private double percentage;
    
    @Column(name = "Date of Birth")
    private String DOB;
    
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
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    public String toString()
    {
    	return id+ " "+name+ " "+percentage;
    }
}