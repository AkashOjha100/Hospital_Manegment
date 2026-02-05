package com.ls.hospitalmanagment.repository;

import com.ls.hospitalmanagment.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}