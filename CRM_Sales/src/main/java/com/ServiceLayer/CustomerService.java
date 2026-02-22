package com.ServiceLayer;
import com.entity.*;

import javax.persistence.*;
public class CustomerService {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void registerCustomer(String name, String email, String phone)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction() ;
		Customer c = new Customer();
		c.setEmail("srivastavaharsh148@gmail.com");
		c.setName("Harsh Srivastava");
		c.setPhone("8090374077");
		
		et.begin();
		em.persist(c);
		et.commit();
	}
	
	public void addAddress(long customerId, Address address)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction() ;
		Customer c = em.find(Customer.class, customerId);
		
		et.begin();
		
		c.setAddress(address);
		
		em.merge(c);
		et.commit();
	}

}
