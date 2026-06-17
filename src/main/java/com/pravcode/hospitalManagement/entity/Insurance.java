package com.pravcode.hospitalManagement.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable=false,unique=true,length=50)
    private String policyNumber;

    @Column(nullable=false,length=100)
    private String provider;

    @Column(nullable=false)
    private LocalDate validTill;

    @CreationTimestamp
    @Column(nullable=false,updatable=false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy="insurance",cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Patient patient;
}
