package com.hibernate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class Demo3 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("postgres");		
		
		EntityManager em = emf.createEntityManager();
		
		
		//Entity Transaction
		
		EntityTransaction et  = em.getTransaction();
		
		Students student = em.find(Students.class, 13);
		
		if(student !=null)
		{
			//student.setDob("45");
		}
		
	}

}
