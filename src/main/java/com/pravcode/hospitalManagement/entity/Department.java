package com.pravcode.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique=true)
    private String name;

    @OneToOne
    @JoinColumn(name="headDoctor_id")
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name="My_dept_doctor",
            joinColumns = @JoinColumn(name="dept_id"),
            inverseJoinColumns = @JoinColumn(name="doctor_id")
    )
    private Set<Doctor> doctorSet =new HashSet<>();
}
