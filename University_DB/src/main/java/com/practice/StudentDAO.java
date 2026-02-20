package com.practice;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO {

    // Save student
    public void save(EntityManager em, Student student) {
        em.persist(student);
    }

    // Get student by ID
    public Student findById(EntityManager em, Long id) {
        return em.find(Student.class, id);
    }

    // Update student
    public Student update(EntityManager em, Student student) {
        return em.merge(student);
    }

    // Delete student
    public void delete(EntityManager em, Long id) {

        Student student = em.find(Student.class, id);

        if (student != null) {
            em.remove(student);
        }
    }

    // Get all students (HQL / JPQL)
    public List<Student> findAll(EntityManager em) {

        String jpql = "SELECT s FROM Student s";

        TypedQuery<Student> query =
                em.createQuery(jpql, Student.class);

        return query.getResultList();
    }

    // Pagination
    public List<Student> findWithPagination(EntityManager em,
                                            int page,
                                            int size) {

        String jpql = "SELECT s FROM Student s ORDER BY s.id";

        TypedQuery<Student> query =
                em.createQuery(jpql, Student.class);

        query.setFirstResult((page - 1) * size); // offset
        query.setMaxResults(size);              // limit

        return query.getResultList();
    }

    // Count students (Useful for pagination UI)
    public Long count(EntityManager em) {

        String jpql = "SELECT COUNT(s) FROM Student s";

        return em.createQuery(jpql, Long.class)
                 .getSingleResult();
    }
}