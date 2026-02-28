package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entity.*;

public class DoctorDAO {

    public void save(Doctor doctor) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();
            em.persist(doctor);
            et.commit();

      
    }


    public Doctor findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        Doctor d = em.find(Doctor.class, id);

        em.close();

        return d;
    }


    public void update(Doctor doctor) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();
            em.merge(doctor);
            et.commit();

       
    }


    public void delete(Long id) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();

            Doctor d = em.find(Doctor.class, id);

            if (d != null) {
                em.remove(d);
            }

            et.commit();

}
