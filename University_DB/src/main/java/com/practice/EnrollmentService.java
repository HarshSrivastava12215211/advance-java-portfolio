package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EnrollmentService {

    private StudentDAO studentDAO = new StudentDAO();

    public void enroll(Long studentId,
                       Long courseId,
                       EntityManager em) {

        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Student student =
                studentDAO.findById(em, studentId);

            Course course =
                em.find(Course.class, courseId);

            if (student.getCourses().size() >= 5) {
                throw new CourseLimitExceed(
                    "Max 5 courses allowed"
                );
            }

            student.getCourses().add(course);
            course.getStudents().add(student);

            // No explicit update needed (dirty checking)

            tx.commit();

        } catch (Exception e) {

            tx.rollback();
            throw e;
        }
    }
}