package com.example.hospital_management.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class AppointmentRequestDto {
    Long patientId;
    Long  doctorId;
    LocalDateTime appointmentTime;
}
