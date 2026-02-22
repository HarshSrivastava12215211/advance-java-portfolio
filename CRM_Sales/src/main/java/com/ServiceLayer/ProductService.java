package com.ServiceLayer;
import com.entity.*;
import javax.persistence.*;
import java.util.*;
public class ProductService {
	

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void addProduct(String name, double price)
	{
		EntityTransaction et  = em.getTransaction();
		
		et.begin();
		
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		
		em.persist(p);
		et.commit();
	}

}
