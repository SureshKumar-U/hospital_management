package com.example.hospital_management.dtos;

import com.example.hospital_management.models.AppointMentModel;
import com.example.hospital_management.models.DoctorModel;
import com.example.hospital_management.models.PatientModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AppointmentResponseDto  {
    Long appointment_id;
    PatientModel patient;
    DoctorModel doctor;
}
