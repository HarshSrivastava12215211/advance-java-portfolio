package com.Hibernate_Assignment;

import java.util.*;

public class Main {
	public static void main(String[] args) {

        Student s1 = new Student();
        s1.setName("Ravi");
        s1.setEmail("ravi@gmail.com");
        s1.setMarks(85);
        
        StudentDAO s2 = new StudentDAO();
        s2.saveStudent(s1);

        Student s = s2.findStudentById(1);
        System.out.println(s);

        List<Student> list = s2.findAllStudents();

        for (Student st : list) {
            System.out.println(st);
        }

        if (s != null) {
            s.setMarks(90);
            s2.updateStudent(s);
        }

        s2.deleteStudent(1);

        System.out.println(s2.getStudentCount());
    }
}
