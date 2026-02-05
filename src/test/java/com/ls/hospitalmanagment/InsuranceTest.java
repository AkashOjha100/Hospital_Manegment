package com.ls.hospitalmanagment;


import com.ls.hospitalmanagment.entity.Appointment;
import com.ls.hospitalmanagment.entity.Insurance;
import com.ls.hospitalmanagment.entity.Patient;
import com.ls.hospitalmanagment.service.AppointmentService;
import com.ls.hospitalmanagment.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .pollicyNumber("ICICI_2024")
                .provider("ICICI")
                .validUntil(LocalDate.of(2027,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        //var newPatient=insuranceService.disaccociateInsuranceFromPatient(patient.getId());
        //System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointemet(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,1,14,25,50))
                .reason("Dibaties")
                .build();
        Appointment appointment1=Appointment
                .builder().appointmentTime(LocalDateTime.of(2025,11,1,12,05,20))
                .reason("Cancer")
                .build();

        var newAppointment =appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newAppointment);
        var newAppt=appointmentService.createNewAppointment(appointment1,1L,2L);
        System.out.println(newAppt);
        //var updatedAppointment =appointmentService.reAssignToAnotherDoctor(newAppointment.getId(),1L);
        //System.out.println(updatedAppointment);
    }


}
