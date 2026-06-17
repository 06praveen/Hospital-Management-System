package com.pravcode.hospitalManagement.service;

import com.pravcode.hospitalManagement.entity.Appointment;
import com.pravcode.hospitalManagement.entity.Doctor;
import com.pravcode.hospitalManagement.entity.Patient;
import com.pravcode.hospitalManagement.repository.AppointmentRepository;
import com.pravcode.hospitalManagement.repository.DoctorRepository;
import com.pravcode.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long patientId,Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have ID already");

        //Appointment owns doctor & patient
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);  //to maintain consistency
        return appointmentRepository.save(appointment);

    }

    @Transactional
    public Appointment reAssignAppointmentToDoctor(Long appointmentId,Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment); //To maintain bidirection consistency
        return appointment;
    }
}
