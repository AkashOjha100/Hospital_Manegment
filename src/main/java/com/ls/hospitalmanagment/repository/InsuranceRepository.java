package com.ls.hospitalmanagment.repository;

import com.ls.hospitalmanagment.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}