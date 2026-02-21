package com.manyToOne;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();


        Department d = new Department();
        d.setName("IT");
        d.setManager_Name("Rahul");
        d.setTotelEmployees(50);


        Employee e1 = new Employee();
        e1.setName("Amit");
        e1.setSalary(40000);
        e1.setDesignation("Developer");
        e1.setDepartment(d);


        Employee e2 = new Employee();
        e2.setName("Ravi");
        e2.setSalary(45000);
        e2.setDesignation("Tester");
        e2.setDepartment(d);
        
        //e1.setId(1);
        //e1.setId(2);


        et.begin();

        em.persist(d);
        em.persist(e1);
        em.persist(e2);

        et.commit();

        em.close();
        emf.close();
    }
}