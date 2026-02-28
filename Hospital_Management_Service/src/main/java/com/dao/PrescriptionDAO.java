package com.dao;


import com.entity.Prescription;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.JPAUtil;

public class PrescriptionDAO {

    public void save(Prescription p) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

      

           et.begin();
          em.persist(p);
            et.commit();

    
    }


    public Prescription findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();
        Prescription p = em.find(Prescription.class, id);
        em.close();
        return p;
    }
}