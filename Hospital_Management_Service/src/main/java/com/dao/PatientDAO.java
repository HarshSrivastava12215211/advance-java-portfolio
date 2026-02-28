package com.dao;


import com.entity.Patient;
import com.dao.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PatientDAO {

    public void save(Patient patient) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

       
            et.begin();
            em.persist(patient);
            et.commit();

       
    }


    public Patient findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        Patient patient = em.find(Patient.class, id);

        em.close();

        return patient;
    }


    public void update(Patient patient) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();
            em.merge(patient);
            et.commit();
    }


    public void delete(Long id) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        

            et.begin();

            Patient p = em.find(Patient.class, id);

            if (p != null) {
                em.remove(p);
            }

            et.commit();

    }
}