package com.pravcode.hospitalManagement.service;

import org.springframework.stereotype.Service;

import com.pravcode.hospitalManagement.entity.Patient;
import com.pravcode.hospitalManagement.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    
    @Transactional //works same as used in DBMS, if data is ok then commit else roll back 
    public Patient getPatient(Long Id){
        Patient p1 = patientRepository.findById(Id).orElseThrow();
        Patient p2 = patientRepository.findById(Id).orElseThrow();
        return p1;
    }

}
