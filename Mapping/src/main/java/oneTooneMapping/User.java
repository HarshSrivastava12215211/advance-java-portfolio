package oneTooneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.*;

import java.util.*;

public class User {
 public static void insertCarandEngine() {
  
  EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
  EntityManager em=emf.createEntityManager();
  EntityTransaction et=em.getTransaction();

  
  Engine e = new Engine();
  e.setId(100);
  e.setType("V8");
  e.setFuelType("Petrol");
  e.setMileage("12");
  e.setCc("3000");
  
  Car c = new Car();
  c.setId(0);
  c.setBrand("Volkswagon");
  c.setModel("Polo  GT10");
  c.setModelYear("2019");
  c.setPrice(1000000);
  c.setEngine(e);
  
  et.begin();
  em.persist(e);
  em.persist(c);
  et.commit();
  
 }
 
 public static void main(String[] args)
 {
//	  findByCarId();
	// insertCarandEngine();
	// findByCarId();
	 
	 deleteEngine();
 }
 
 public static void deleteEngine()
 {
	 EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	 EntityManager em=emf.createEntityManager();
	 EntityTransaction et=em.getTransaction();
	 Engine e = em.find(Engine.class,100);
	 
	 String jql = "Select c from Car c where c.engine.id =?1";
	 
	 Query query = em.createQuery(jql);
	 query.setParameter(1, 100);
	 List<Car> ls = query.getResultList();
	 for(Car c : ls)
	 {
		 c.setEngine(null);
	 }
	 
	 et.begin();
	 em.remove(e);
	 et.commit();
	 
 }
 
 public static void findByCarId()
 {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	 EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  Car c = em.find(Car.class,0);
	  System.out.println(c);
 }
}
