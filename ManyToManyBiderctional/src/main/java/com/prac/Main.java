package com.prac;

import java.util.*;
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {

            et.begin();

            // Create Subjects
            Subject sub1 = new Subject();
            sub1.setName("Maths");

            Subject sub2 = new Subject();
            sub2.setName("AI");

            // Save Subjects first
            em.persist(sub1);
            em.persist(sub2);

            // Create Student
            Students st = new Students();
            st.setName("Saras");
            st.setBranch("AI-ML");

            // Attach subjects to student
            List<Subject> subjects = new ArrayList<>();
            subjects.add(sub1);
            subjects.add(sub2);

            st.setSubject(subjects);

            // Save Student
            em.persist(st);

            et.commit();

            System.out.println("Inserted Successfully ✅");

        }
        catch (Exception e) {

            if (et.isActive()) {
                et.rollback();
            }

            e.printStackTrace();

        }
        finally {

            em.close();
            emf.close();
        }
    }
}