package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entity.*;

import jakarta.persistence.*;

public class AppointmentDAO {

    public void save(Appointment appt) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();
            em.persist(appt);
            et.commit();
    }


    public Appointment findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        Appointment a = em.find(Appointment.class, id);

        em.close();

        return a;
    }


    public void update(Appointment appt) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();

        try {

            et.begin();
            em.merge(appt);
            et.commit();

      
    }


    public void delete(Long id) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();


            et.begin();

            Appointment a = em.find(Appointment.class, id);

            if (a != null) {
                em.remove(a);
            }

            et.commit();
    }
}