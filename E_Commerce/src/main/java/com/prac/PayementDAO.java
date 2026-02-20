package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PayementDAO {
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void savePayement(Payment p)
	{
		if(p != null)
		{
			et.begin();
			em.persist(p);
			et.commit();
		}
	}
	
	public void updatePayment(Payment p)
	{
		if(p != null)
		{
			et.begin();
			em.merge(p);
			et.commit();
			
		}
	}
	
	public Payment findPayment(long id)
	{
		Payment p = em.find(Payment.class, id);
		em.close();
		return p;
	}
	
	

}
