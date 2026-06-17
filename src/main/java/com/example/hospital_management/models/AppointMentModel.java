package com.example.hospital_management.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "appointments")
public class AppointMentModel extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private DoctorModel doctor;

    private LocalDateTime appointmentDateTime;


}
