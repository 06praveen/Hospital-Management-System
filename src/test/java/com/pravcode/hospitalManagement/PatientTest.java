package com.pravcode.hospitalManagement;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pravcode.hospitalManagement.entity.Patient;
import com.pravcode.hospitalManagement.repository.PatientRepository;
import com.pravcode.hospitalManagement.service.PatientService;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientrepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientrepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
        Patient p = patientService.getPatient(1L);

        System.out.println(p);
    }
}
