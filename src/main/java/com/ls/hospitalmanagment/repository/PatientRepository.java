package com.ls.hospitalmanagment.repository;

import com.ls.hospitalmanagment.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPatients(Pageable pageable);
}
