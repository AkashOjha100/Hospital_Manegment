package com.ls.hospitalmanagment.repository;

import com.ls.hospitalmanagment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}