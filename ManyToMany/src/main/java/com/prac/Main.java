package com.prac;

//import com.entity.Student;
//import com.entity.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();

        // Create Subjects
        Subject s1 = new Subject("Maths", 60);
        Subject s2 = new Subject("Java", 90);

        // Create Student
        Students st1 = new Students("Rahul", "Male", "CSE");

        // Set Relationship
        Set<Subject> subjects = new HashSet<>();
        subjects.add(s1);
        subjects.add(s2);

        st1.setSubjects(subjects);

        // Save
        et.begin();
        em.persist(s1);
        em.persist(s2);
        em.persist(st1);

        et.commit();

        em.close();
        emf.close();

        System.out.println("Data Saved Successfully!");
    }
}