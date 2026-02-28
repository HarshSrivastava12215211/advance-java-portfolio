package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.entity.MedicalRecord;
import com.dao.JPAUtil;


public class MedicalRecordDAO {

    public void save(MedicalRecord mr) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(mr);
            et.commit();

     
    }


    public MedicalRecord findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        MedicalRecord mr = em.find(MedicalRecord.class, id);

        em.close();

        return mr;
    }
}
