package com.Hibernate_Assignment;
import javax.persistence.*;
import java.util.*;

public class StudentDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public static void saveStudent(Student s) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(s);
        et.commit();
        em.close();
    }

    public static Student findStudentById(int id) {

        EntityManager em = emf.createEntityManager();

        Student s = em.find(Student.class, id);

        em.close();
        return s;
    }

    public static List<Student> findAllStudents() {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("Select s from Student s");

        List<Student> list = q.getResultList();

        em.close();

        return list;
    }

    public static void updateStudent(Student s) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(s);
        et.commit();

        em.close();
    }

    public static void deleteStudent(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Student s = em.find(Student.class, id);

        if (s != null) {
            et.begin();
            em.remove(s);
            et.commit();
        }

        em.close();
    }

    public static long getStudentCount() {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("select count(s) from Student s");

        long count = (long) q.getSingleResult();

        em.close();

        return count;
    }

    public static List<Student> findStudentsAbove80() {

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery(
                "from Student s where s.marks > 80"
        );

        List<Student> list = q.getResultList();

        em.close();

        return list;
    }
}
