 package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UsersDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void insertUser()
	{
		Users u = new Users();
		u.setId(150);
		u.setBalance(0);
		u.setName("Naman chudra");
		
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public Users findById(int id)
	{
		Users u = em.find(Users.class, id);
		if(u!= null)
		{
			return u;
		}
		else
		{
			return null;
		}
	}

}
