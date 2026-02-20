package com.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub4
		
		EntityManagerFactory emf=  Persistence.createEntityManagerFactory("Postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql1 = "update Employee set dept_id = null where dept_id = ?1";
		
		String sql2 = "delete department where id = ?1";
		
		Query updateQuery = 
		

	}

}
