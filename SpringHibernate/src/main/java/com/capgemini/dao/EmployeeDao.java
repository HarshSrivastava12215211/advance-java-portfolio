package com.capgemini.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.jpaUtil;
@Repository
public class EmployeeDao {
	
	@Autowired
	jpaUtil jpa;
	
	private EntityManager em;
	
	@PostConstruct
	public void init()
	{
		em = jpa.getEntityManager();
	}
	
	

	
	public void insert(Employee e)
	{
		
		em.getTransaction().begin();
		Employee employee = find(e.getId());
		if(employee ==null)
		{
			em.persist(e);
		}
		else
		{
			System.out.println("Data Exist");
		}
		em.getTransaction().commit();
	}
	
	public Employee find(int id)
	{
		return em.find(Employee.class, id);
	}
	
	public void UpdateEmployee(Employee e)
	{
		em.merge(e);
		
	}
	
	public void deleteEmployee(int id)
	{
		//Employee e;
		Employee emp = find(id);
		if(emp != null)
		{
			em.remove(id);
			
		}
		
		else
		{
			System.out.println("Employee Not Found");
		}	
		
	}
	
	public List<Employee> findAll()
	{
		return em.createQuery("Select e from Employee e", Employee.class).getResultList();
	}

}
