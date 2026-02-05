package com.ls.hospitalmanagment.repository;

import com.ls.hospitalmanagment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}