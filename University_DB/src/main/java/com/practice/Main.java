package com.practice;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

        EntityManager em =
            emf.createEntityManager();

        EnrollmentService service =
            new EnrollmentService();

        try {

            service.enroll(1L, 2L, em);

            System.out.println("Done");

        } finally {

            em.close();
            emf.close();
        }
    }
}