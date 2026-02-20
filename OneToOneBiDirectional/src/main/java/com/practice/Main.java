package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Passport p = new Passport();
		p.setId(101);
		p.setName("Miller");
		p.setCitizen("Indian");
		p.setDOB("23-09-2025");
		
		Person p1 = new Person();
		
		p1.setId(102);
		p1.setEmail("srivastavaharsh@gmail.com");
		p1.setName("Harsh");
		p1.setPhone(9554123);
		
		et.begin();
		em.persist(p1);
		et.commit();
		
		
	}

}
