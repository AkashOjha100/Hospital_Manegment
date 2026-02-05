package com.ls.hospitalmanagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Service
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length=500)
    private String reason;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false) //Patient is required and not nullable
    private Patient patient; //Many appointment to One Patient

    @ManyToOne
    @JoinColumn(name="doctor_id",nullable = false)//Owner Side
    private Doctor doctor;
}
