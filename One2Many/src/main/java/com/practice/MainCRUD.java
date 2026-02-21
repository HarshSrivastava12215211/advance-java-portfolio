package com.practice;

import java.util.List;

public class MainCRUD {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();


        College c = new College();
        c.setCid(1);
        c.setName("LPU");
        c.setLocation("Jalandhar");
        c.setPincode("144411");

        System.out.println(dao.createCollege(c));


        Students s1 = new Students();
        s1.setStudent_id(101);
        s1.setS_name("Harsh");
        s1.setB_name("CSE");
        //s1.setCollege(c);

        System.out.println(dao.createStudent(s1));


        Students s = dao.findStudents(101);

        if (s != null) {
            System.out.println(s.getB_name() + " " + s.getB_name());
        }


        List<Students> list = dao.findAll();

        for (Students st : list) {
            System.out.println(st.getStudent_id() + " " + st.getB_name());
        }


        System.out.println(dao.UpdateStudents(101, "AI-ML"));


        System.out.println(dao.deleteStudents(101));
    }
}