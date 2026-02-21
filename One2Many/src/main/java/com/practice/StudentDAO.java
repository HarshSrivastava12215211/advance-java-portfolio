package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public String createCollege(College c)
	{
		if(c!= null)
		{
			et.begin();
			em.persist(c);
			et.commit();
			
			return "Inserted";
			
		}
		else
		{
			return "null";
		}
		
	}
	
	public String createStudent(Students s)
	{
		if(s != null)
		{
			et.begin();
			em.persist(s);
			et.commit();
			
			return"Inserted";
		}
		
		else
		{
			return "null";
		}
	}
	
	public Students findStudents(int id)
	{
		Students s = em.find(Students.class, id);
		return s;
	}
	
	public List<Students> findAll()
	{
		Query q = em.createQuery("from Students");
		List<Students> list = q.getResultList();
		
		return list;
		
	}
	
	public String UpdateStudents(int id, String branch)
	{
		Students s = em.find(Students.class, id);
		
		if( s != null)
		{
			et.begin();
			s.setB_name(branch);
			et.commit();
			
			return "Inserted";
		}
		else
		{
			return "null";
		}
	}
	
	public String deleteStudents(int id)
	{
		Students s = em.find(Students.class, id);
		
		if(s != null)
		{
			et.begin();
			em.remove(s);
			et.commit();
			
			return "Deleted";
		}
		else
		{
			return "Student not found";
		}
	}

}
