package com.capgemini.main;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class jpaUtil {
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	

	private EntityManagerFactory emf;
	
	private EntityManager entityManager;
	
	@PostConstruct	
	public void display()
	{
		emf = Persistence.createEntityManagerFactory("postgres");
		
		entityManager = emf.createEntityManager();
		
		System.out.println("Connection");
	}
	
	//@PostConstruct
	@PreDestroy
	public void print()
	{
		entityManager.close();
		emf.close();
		
		System.out.println("closed");
	}

}
