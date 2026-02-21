package com.prac;
import javax.persistence.*;
public class UserDAO {
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveUser(User u)
	{
		if(u!=null)
		{
			et.begin();
			em.persist(u);
			et.commit();		
			
		}
	}
	
	public void updateUser(User u)
	{
		em.merge(u);
	}
	
	public User findUser(int id)
	{
		User u = em.find(User.class, id);
		return u;
	}
	
	public String deleteUser(long id)
	{
		User u = em.find(User.class, id);
		if(u != null)
		{
			et.begin();
			em.remove(u);
			et.commit();
			
			return "Deleted";
			
		}
		
		return "Not found";
	}
	
	public String  UpdateUser(int id, String email, String name)
	{
		User u = em.find(User.class, id);
		
		if(u != null)
		{
			et.begin();
			u.setName(name);
			u.setEmail(email);
			et.commit();
			
			return "User Updated";
		}
		
		return "User Not Found";
	}

}
