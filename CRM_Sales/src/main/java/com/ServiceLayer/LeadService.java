package com.ServiceLayer;

import javax.persistence.*;

import com.entity.*;

public class LeadService {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	public void createLead(String name, String source, String contact)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Lead l = new Lead();
		l.setContactInfo(contact);
		l.setSource(source);
		l.setName(name);
		
		em.persist(l);
		et.commit();
	}
	
	public void AssignLead(long leadId, long empId )
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Lead l = em.find(Lead.class, leadId);
		SalesEmployee emp = em.find(SalesEmployee.class, empId);
		
		l.setSalesEmployee(emp);
		em.merge(l);
		
		et.commit();
		
	}
	
	public void convertLead(long id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Lead l = em.find(Lead.class, id);
		
		Customer c = new Customer();
		c.setName(l.getName());
		c.setEmail(l.getContactInfo());
		
		em.persist(c);
		em.remove(l);
		
		et.commit();
	}

}
