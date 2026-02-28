package com.dao;


import com.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.JPAUtil;

//import jakarta.persistence.*;

public class DepartmentDAO {

    public void save(Department dept) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();
            em.persist(dept);
            et.commit();

    }


    public Department findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        Department d = em.find(Department.class, id);

        em.close();

        return d;
    }


    public void update(Department dept) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {

            et.begin();
            em.merge(dept);
            et.commit();

     
    }


    public void delete(Long id) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

           et.begin();

            Department d = em.find(Department.class, id);

            if (d != null) {
                em.remove(d);
            }

            et.commit();
    }

}