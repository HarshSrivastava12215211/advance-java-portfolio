package com.hibernate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("postgres");		
		
		EntityManager em = emf.createEntityManager();
		
		
		//Entity Transaction
		
		EntityTransaction et  = em.getTransaction();
		
		Students s = new Students();
		s.setId(13);
		s.setName("Virat");
		s.setPercentage(95);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		emf.close();
		
		
	}
}
