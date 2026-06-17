package com.pravcode.hospitalManagement.repository;

import com.pravcode.hospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
