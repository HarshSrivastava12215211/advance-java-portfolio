package com.ServiceLayer;
import java.util.*;
import com.entity.*;
import javax.persistence.*;

public class TicketService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	
	public void raiseTicket(long id, String issue)
	{
		EntityTransaction et = em.getTransaction()	;
		
		et.begin();
		
		Order order = em.find(Order.class, id);
		
		SupportTicket ticket = new SupportTicket();
		ticket.setIssue(issue);
		ticket.setOrder(order);
		ticket.setStatus("OPEN");
		
		em.persist(ticket);
		et.commit();
	}

}
