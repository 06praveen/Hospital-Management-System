package com.pravcode.hospitalManagement.service;

import com.pravcode.hospitalManagement.entity.Insurance;
import com.pravcode.hospitalManagement.entity.Patient;
import com.pravcode.hospitalManagement.repository.InsuranceRepository;
import com.pravcode.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID : "+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //not necessary, just to maintain bidirection relation
        return patient;
    }

    @Transactional
    public Patient removeInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not exist with ID : "+patientId));

        patient.setInsurance(null);
        return patient;
    }
}
