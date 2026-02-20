package com.college.product;
import javax.persistence.*;
import java.util.*;
public class ProductDao {

	public static void insert()
	{
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter the id");
		int id = sc.nextInt();
		
		System.out.println("Enter the name");
		String name  = sc.next();
		
		
		System.out.println("Enter the Quantity");;
		int quant = sc.nextInt();
		
		System.out.println("Enter the price");
		int price = sc.nextInt();
		
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setQuantity(quant);
		p.setPrice(price);
		
		
		et.begin();
		em.persist(p);
		et.commit();
		
		emf.close();
		
	}
	public static void delete()
	{
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter the id whose data you want to remove");
		int id = sc.nextInt();
		
		Product p = new Product();
		if(p!= null)
		{
			et.begin();
			em.remove(p);
			et.commit();
			emf.close();
		}
		
	}
	
	public static void updateUser()
	{
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter the id whose data you want to remove");
		int id = sc.nextInt();
		
		Product p = new Product();
		if(p!= null)
		{
			System.out.println("Enter the Quantity you want to update");
			int quantity = sc.nextInt();
			p.setQuantity(quantity);
			et.begin();
			em.merge(p);
			et.commit();
			emf.close();
			
		}
	}
	
	public static void find(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        Product p = em.find(Product.class, id);
        if (p != null) {
            System.out.println("Product found: " + p.getName() + " | Qty: " + p.getQuantity() + " | Price: " + p.getPrice());
        } else {
            System.out.println("Product not found!");
        }

        em.close();
        emf.close();
        //return id;
    }

	
	public static void main(String[] args)
	{
		//insert();
		delete();
		updateUser();
		find(1);
		
	}

}


