package com.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    // Create EMF only once (Singleton)
    static {
            emf = Persistence.createEntityManagerFactory("postgres");
       
    }

    // Give new EntityManager
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Close factory on shutdown
    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}