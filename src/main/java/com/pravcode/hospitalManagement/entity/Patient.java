package com.pravcode.hospitalManagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
@Table(
    name = "Patient",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_patient_email",columnNames={"email"}),
        @UniqueConstraint(name="unique_patient_name_dob",columnNames={"name","birthdate"})
    },
    indexes = {
        @Index(name = "idx_patient_birthdate",columnList="birthdate")
    }
)
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate birthdate;
    
    @Column(unique=true,nullable=false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable=false)
    private LocalDateTime createdAt;

    private String bloodGroup;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})   //Owning Side
    @JoinColumn(name="patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy="patient",cascade = {CascadeType.REMOVE},orphanRemoval = true)    //Inverse Side
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();
}
