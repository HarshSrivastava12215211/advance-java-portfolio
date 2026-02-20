package com.prac;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void SaveOrder(PurchaseOrder o)
	{
		if(o !=null)
		{
			et.begin();
			em.merge(o);
			et.commit();
		}
	}
	
	public void UpdateOrder(PurchaseOrder p)
	{
		 em.merge(p);
	}
	
	public PurchaseOrder findOrder(long id)
	{
		PurchaseOrder o = em.find(PurchaseOrder.class, id);
		return o;
	}
	
	public List<PurchaseOrder> findOrderByUser(long id)
	{
		User u = em.find(User.class, id);
		if(u == null )
		{
			return Collections.emptyList();
		}
		List<PurchaseOrder> list = u.getPurchaseOrder();
		em.close();
		return list;
	}
	

}
