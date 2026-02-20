package com.hibernate;
import javax.persistence.*;
import java.util.*;
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("postgres");		
		
		EntityManager em = emf.createEntityManager();
		
		
		//Entity Transaction
		
		EntityTransaction et  = em.getTransaction();
		
		String jpql = "Select s from Student s";
		
		Query query = em.createQuery(jpql);
		
		

	}

}
