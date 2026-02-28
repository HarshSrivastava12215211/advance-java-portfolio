package com.main;

package com.hospital.main;

import com.dao.AppointmentDAO;
import com.dao.DepartmentDAO;
import com.dao.DoctorDAO;
import com.dao.PatientDAO;
import com.entity.Department;
import com.entity.Doctor;
import com.entity.MedicalRecord;
import com.entity.Patient;
import com.entity.Prescription;
import com.hospital.dao.*;
import com.hospital.entity.*;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Create EntityManagerFactory (ONLY ONCE)
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hospitalPU");

        // 2️⃣ Create DAO Objects
        PatientDAO patientDAO = new PatientDAO(emf);
        DoctorDAO doctorDAO = new DoctorDAO(emf);
        DepartmentDAO departmentDAO = new DepartmentDAO(emf);
        AppointmentDAO appointmentDAO = new AppointmentDAO(emf);


            MedicalRecord record = new MedicalRecord();
            record.setDiagnosis("Viral Fever");
            record.setNotes("Rest for 5 days");
            record.setRecordDate(LocalDate.now());

            Patient patient = new Patient();
            patient.setName("Rahul Sharma");
            patient.setDob(LocalDate.of(2001, 5, 10));
            patient.setBloodGroup("O+");
            patient.setPhone("9999999999");
            patient.setMedicalRecord(record);

            patientDAO.save(patient);

            System.out.println("Patient saved");

            Department department = new Department();
            department.setName("Cardiology");
            department.setLocation("Block A");
            department.setHeadDoctorName("Dr. Mehta");

            Doctor doctor1 = new Doctor();
            doctor1.setName("Dr. Roy");
            doctor1.setSpecialization("Heart Specialist");
            doctor1.setLicenseNo("LIC101");

            Doctor doctor2 = new Doctor();
            doctor2.setName("Dr. Singh");
            doctor2.setSpecialization("Heart Surgeon");
            doctor2.setLicenseNo("LIC102");

            department.addDoctor(doctor1);
            department.addDoctor(doctor2);

            departmentDAO.save(department);

            System.out.println("Department and Doctors saved");


      
            Appointment appointment1 = new Appointment();
            appointment1.setAppointDate(LocalDateTime.now().plusDays(1));
            appointment1.setStatus("SCHEDULED");
            appointment1.setReason("Heart Checkup");

            Appointment appointment2 = new Appointment();
            appointment2.setAppointDate(LocalDateTime.now().plusDays(2));
            appointment2.setStatus("SCHEDULED");
            appointment2.setReason("ECG Test");

            doctor1.getAppointments().add(appointment1);
            doctor1.getAppointments().add(appointment2);

            doctorDAO.update(doctor1);

            System.out.println("Appointments added");



            Prescription prescription = new Prescription();
            prescription.setMedicines("Aspirin");
            prescription.setDosage("Twice a day");
            prescription.setIssuedDate(LocalDate.now());
            prescription.setActive(true);

            appointment1.setPrescription(prescription);

            appointmentDAO.update(appointment1);

            System.out.println("Prescription added");


            doctor1.addPatient(patient);

            doctorDAO.update(doctor1);

            System.out.println("✅ Doctor assigned to Patient");

            Patient fetchedPatient = patientDAO.findById(patient.getId());

            System.out.println(" FETCHED DATA ");
            System.out.println("Patient Name: " + fetchedPatient.getName());
            System.out.println("Diagnosis: " +
                    fetchedPatient.getMedicalRecord().getDiagnosis());

            System.out.println("Doctors treating patient:");
            fetchedPatient.getDoctors().forEach(d ->
                    System.out.println(" - " + d.getName())
            );

            System.out.println("");


       
    }
}