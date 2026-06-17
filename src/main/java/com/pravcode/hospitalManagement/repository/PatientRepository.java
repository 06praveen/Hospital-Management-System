package com.pravcode.hospitalManagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pravcode.hospitalManagement.entity.Patient;

//Interface is automatically called because of Spring data jpa, no need to create object of it
@Repository //It is optional
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
