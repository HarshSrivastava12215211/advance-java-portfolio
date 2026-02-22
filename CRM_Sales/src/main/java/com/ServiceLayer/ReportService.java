package com.ServiceLayer;
import java.util.*;
import com.entity.*;
import javax.persistence.*;

public class ReportService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void getEmployeePerformance(long empId)
	{
		
		EntityTransaction et = em.getTransaction();
		
		String jpql =  "SELECT COUNT(l) FROM Lead l WHERE l.employee.empId = :id";
		long count = em.createQuery(jpql, long.class).setParameter("id", empId).getSingleResult();
	
		System.out.println("Total count :" + count);
		
	}
	

}
