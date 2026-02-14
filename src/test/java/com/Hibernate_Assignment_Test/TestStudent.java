package com.Hibernate_Assignment_Test;

import org.junit.jupiter.api.*;

import com.Hibernate_Assignment.Student;
import com.Hibernate_Assignment.StudentDAO;

import javax.persistence.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudent {

    EntityManagerFactory emf;
    EntityManager em;

    @BeforeAll
    public void setupFactory() {

        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @AfterAll
    public void closeFactory() {

        emf.close();
    }

    @BeforeEach
    public void setupManager() {

        em = emf.createEntityManager();
    }

    @AfterEach
    public void closeManager() {

        em.close();
    }

    @Test
    public void testSaveStudent() {

        Student s = new Student();
        s.setName("Amit");
        s.setEmail("amit@gmail.com");
        s.setMarks(78);

        StudentDAO.saveStudent(s);

        assertTrue(s.getId() > 0);
    }

    @Test
    public void testFindStudentById() {

        Student s = StudentDAO.findStudentById(1);

        assertNotNull(s);
    }

    @Test
    public void testFindAllStudents() {

        List<Student> list =
                StudentDAO.findAllStudents();

        assertTrue(list.size() >= 0);
    }

    @Test
    public void testUpdateStudent() {

        Student s = StudentDAO.findStudentById(1);

        if (s != null) {
            s.setMarks(95);
            StudentDAO.updateStudent(s);

            Student updated =
                    StudentDAO.findStudentById(1);

            assertEquals(95, updated.getMarks());
        }
    }

    @Test
    public void testDeleteStudent() {

        Student s = new Student();
        s.setName("Temp");
        s.setEmail("temp@gmail.com");
        s.setMarks(60);

        StudentDAO.saveStudent(s);

        int id = s.getId();

        StudentDAO.deleteStudent(id);

        Student deleted =
                StudentDAO.findStudentById(id);

        assertNull(deleted);
    }

    @Test
    public void testStudentCount() {

        long count =
                StudentDAO.getStudentCount();

        assertTrue(count >= 0);
    }

    @Test
    public void testFindStudentsAbove80() {

        List<Student> list =
                StudentDAO.findStudentsAbove80();

        for (Student s : list) {
            assertTrue(s.getMarks() > 80);
        }
    }
}
