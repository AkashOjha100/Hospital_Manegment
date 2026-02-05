package com.ls.hospitalmanagment.service;


import com.ls.hospitalmanagment.entity.Appointment;
import com.ls.hospitalmanagment.entity.Doctor;
import com.ls.hospitalmanagment.entity.Patient;
import com.ls.hospitalmanagment.repository.AppointmentRepository;
import com.ls.hospitalmanagment.repository.DoctorRepository;
import com.ls.hospitalmanagment.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()!=null)throw new IllegalArgumentException("Appointment should not have by id : "+patientId);

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);//to maintain consistancy
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);//this will automatically update , because it is dirty.
        return appointment;
    }


}
