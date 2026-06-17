package com.pravcode.hospitalManagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private LocalDateTime appointmentTime;

    @Column(length=500)
    private String reason;

    @ManyToOne  //Owning Side
    @JoinColumn(name="Patient_id",nullable=false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id",nullable=false)
    private Doctor doctor;
}
