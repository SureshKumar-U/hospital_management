package com.example.hospital_management.services;

import com.example.hospital_management.dtos.AppointmentRequestDto;
import com.example.hospital_management.dtos.AppointmentResponseDto;

public interface IAppointmentService {
    AppointmentResponseDto createAppointment(AppointmentRequestDto requestDto);
    AppointmentResponseDto getAppointmentById(Long appointmentId);
}
