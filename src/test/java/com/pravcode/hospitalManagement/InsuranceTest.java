package com.pravcode.hospitalManagement;

import com.pravcode.hospitalManagement.entity.Appointment;
import com.pravcode.hospitalManagement.entity.Insurance;
import com.pravcode.hospitalManagement.entity.Patient;
import com.pravcode.hospitalManagement.service.AppointmentService;
import com.pravcode.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("POL123")
                .provider("Star Health")
                .validTill(LocalDate.of(2027, 12, 31))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        var newPatient = insuranceService.removeInsuranceFromPatient(patient.getId());
    }

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,6,16,10,0,0))
                .reason("Health checkup")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment,2L,1L);
        System.out.println(newAppointment);

        var reAssignAppointment = appointmentService.reAssignAppointmentToDoctor(newAppointment.getId(),4L);
        System.out.println(reAssignAppointment);
    }
}
