package com.ServiceLayer;
import com.entity.*;

import java.util.*;

import javax.persistence.*;
public class OrderService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void OrderPlacement(long customerId, List<Long> productId)
	{
		EntityTransaction et = em.getTransaction();
		Customer c = em.find(Customer.class, customerId);
		
		Order order = new Order();
		order.setCustomer(c);
		
		List<Product> product = new ArrayList<>();
		double total = 0;
		
		for(long id: productId)
		{
			Product p = em.find(Product.class, productId);
			product.add(p);
			total += p.getPrice();
		}
		
		order.setProducts(product);
		order.setTotalAmount(total);
		
		em.persist(order);
		et.commit();
		
	}
}
