package com.ls.hospitalmanagment.service;


import com.ls.hospitalmanagment.entity.Insurance;
import com.ls.hospitalmanagment.entity.Patient;
import com.ls.hospitalmanagment.repository.InsuranceRepository;
import com.ls.hospitalmanagment.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id :"+patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //bidirectional consistancy maintain

        return patient;
    }
    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){

        Patient patient=patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id :"+patientId));
        patient.setInsurance(null);

        return patient;
    }
}
